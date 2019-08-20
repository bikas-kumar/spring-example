package com.wipro.practice.SpringBootPractice.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class AOPClass {
	Logger logger = LoggerFactory.getLogger(AOPClass.class);

	@Pointcut("execution(* com.wipro.practice.SpringBootPractice.controller.*.*(..)) || execution(* com.wipro.practice.SpringBootPractice.services.*.*(..))")
	public void executeAround() {
	}

	@Around("executeAround()")
	public Object loggingAroundController(ProceedingJoinPoint pjp) throws Throwable {

		ObjectMapper mapper = new ObjectMapper();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().getName();
		Object[] arguments = pjp.getArgs();

		logger.info("Class : " + className + " Method : " + methodName + " Arguments : "
				+ mapper.writeValueAsString(arguments));

		Object returnObj = pjp.proceed();
		logger.info("Class : " + className + " Method : " + methodName + " returned value : "
				+ mapper.writeValueAsString(returnObj));
		return returnObj;
	}
	
	@Around("@annotation(com.wipro.practice.SpringBootPractice.customAnnotation.TrackTime)")
	public Object trackTime(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		Object obj= pjp.proceed();
		long end = System.currentTimeMillis();
		logger.info("Time taken by "+pjp.getSignature().getName()+ " in millisecond "+(end-start));
	return obj;
	}

	// @Around("executeAroundServices()")
	// public Object loggingAroundServices(ProceedingJoinPoint pjp) throws Throwable
	// {
	// Logger logger = LoggerFactory.getLogger(LoggingAOP.class);
	// ObjectMapper mapper = new ObjectMapper();
	// logger.info("Class : "+pjp.getTarget().getClass().getName() + " Method :
	// "+pjp.getSignature().getName()
	// + " Arguments : "+mapper.writeValueAsString(pjp.getArgs()) + " returned value
	// : "+mapper.writeValueAsString(pjp.proceed()));
	//
	// return pjp.proceed();
	// }

	/*
	 * @Before("execution(* com.wipro.practice.SpringBootPractice.*.*.*(..))")
	 * public void logging(JoinPoint pjp) throws JsonProcessingException {
	 * logger.info("Class : "+pjp.getTarget().getClass().getName() +
	 * " Method : "+pjp.getSignature().getName()+" Arguments : "+
	 * mapper.writeValueAsString(pjp.getArgs()));
	 * 
	 * 
	 * 
	 * }
	 * 
	 * @After("execution(* com.wipro.practice.SpringBootPractice.*.*.*(..))") public
	 * void loggingAfter(JoinPoint jp) throws JsonProcessingException {
	 * logger.info("Class : "+jp.getTarget().getClass().getName() +
	 * " Method : "+jp.getSignature().getName()+" return object : "+mapper.
	 * writeValueAsString(jp.getArgs()));
	 * 
	 * 
	 * }
	 */

}
