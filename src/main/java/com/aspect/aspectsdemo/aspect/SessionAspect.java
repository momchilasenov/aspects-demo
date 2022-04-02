package com.aspect.aspectsdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Pointcut;

public class SessionAspect
{
  public void allCircleMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
  {
    System.out.println("Executed SessionAspect");
    proceedingJoinPoint.proceed();
    System.out.println("Executed SessionAspect");
  }
}
