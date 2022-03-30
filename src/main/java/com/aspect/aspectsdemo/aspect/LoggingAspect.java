package com.aspect.aspectsdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect
{
  @Before("execution(public * get*(..))")
  //any method that starts with 'get' and returns any object and has 0 or more arguments
  public void LoggingAdvice()
  {
    System.out.println("First Advice executed");
  }

//  @Before("execution(public  com.aspect.aspectsdemo.service.model.*.get*(..))")
//  @Before("execution(* * *())")

  @Before("execution(* get*())")
  public void secondAdvice()
  {
    System.out.println("Second Advice executed");
  }

  @Before("allGettersPointcut()")
  public void thirdAdvice()
  {
    System.out.println("Third Advice executed");
  }


  @Pointcut("execution(* get*())")
  public void allGettersPointcut(){} //dummy method that holds the pointcut expression
}
