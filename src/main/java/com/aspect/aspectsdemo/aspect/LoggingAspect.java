package com.aspect.aspectsdemo.aspect;

import com.aspect.aspectsdemo.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect
{
  //  @Before("execution(* * *())")

  @Before("execution(public * get*(..))")
  //any method that starts with 'get' and returns any object and has 0 or more arguments
  public void loggingAdvice()
  {
    System.out.println("First Advice executed");
  }

  @Before("allGettersPointcut() && allCircleMethods()")
  public void securityAdvice()
  {
    System.out.println("First Security Advice");
  }

  //JoinPoint - Execute advice based on method being triggered
  @Before("allCircleMethods()")
  public void joinAdvice(JoinPoint joinPoint)
  {
    System.out.println("--------JoinPoint details-------");
    System.out.println(joinPoint.toString());
    System.out.println(joinPoint.getTarget());
    Circle cirlce = (Circle) joinPoint.getTarget();

    System.out.println("-------------");
  }

  @Before("args(String)") //apply advice to all methods that take a single String argument
  public void stringAdvice()
  {
    System.out.println("Advice with String arguments executed");
  }

  @Before("args(name)") //all methods that take in a String argument
  public void stringNameAdvice(String name) //take the argument value
  {
    System.out.println("The argument is " + name);
  }

  @After("args(name)") //run advice after target method
  public void afterMethodAdvice(String name)
  {
    System.out.println("After method advice executed");
  }

  @AfterThrowing(pointcut = "args(name)") //execute advice when exception is thrown
  public void exceptionAdvice(String name)
  {
    System.out.println("Throwing Advice executed");
  }

  @AfterReturning("args(name)") //run only if target method returns (executes ok)
  public void stringArgAdvice(String name)
  {
    System.out.println("The advice accepted parameter " + name);
  }

  @AfterReturning(pointcut = "args(name)", returning = "returnString")
  public void stringArgAdvice2(String name, String returnString)
  {
    System.out.println("The advice returned parameter " + returnString);
  }

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

  @Pointcut("execution(public String getName())")
  public void allGettersPointcut()
  {
  } //dummy method that holds the pointcut expression

  @Pointcut("execution(public String com.aspect.aspectsdemo.model.Circle.*(..))") //method names
  public void allPublicCircleMethodsWithZeroOrMoreParams()
  {
  }

  //Pointcut expression
  @Pointcut("within(com.aspect.aspectsdemo.model.Circle)")
  public void allCircleMethods()
  {
  }

//  @Pointcut("within(com.aspect.aspectsdemo.model..*)") //class names
//  public void allMethodsInPackageModelAndSubpackages()
//  {
//  }

  @Around("execution(public String com.aspect.aspectsdemo.model.*.*(..))")
  public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
  {
    System.out.println("before method execution");
    Object returnValue = proceedingJoinPoint.proceed(); //actual execution of the method this advice is advising (can skip target method call)
    System.out.println("after returning execution");
    return returnValue;
  }

  @Before("allMethodsInAspectsDemoPackage()")
  public void allMethods()
  {
    System.out.println("test");
  }

  @Pointcut("execution(* com.aspect.aspectsdemo.*.*(..))")
  public void allMethodsInAspectsDemoPackage()
  {
    System.out.println("All package methods advice");
  }

  @Before("@annotation(com.aspect.aspectsdemo.aspect.Loggable)") //custom annotation advice
  public void customAnnotationAdvice()
  {
    //methods annotated with @Loggable will trigger the advice
    System.out.println("Custom annotation advice executed");
  }
}
