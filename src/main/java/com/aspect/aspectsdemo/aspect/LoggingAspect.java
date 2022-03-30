package com.aspect.aspectsdemo.aspect;

import com.aspect.aspectsdemo.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect
{
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

  @Before("args(String)") //apply advice to all method that take a single String argument
  public void stringAdvice()
  {
    System.out.println("A method that takes String arguments");
  }

  @Before("args(name)") //get the argument being passed
  public void stringNameAdvice(String name)
  {
    System.out.println("The argument is " + name);
    System.out.println("A method that takes String arguments");
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
  public void allGettersPointcut()
  {
  } //dummy method that holds the pointcut expression

  @Pointcut("execution(public * com.aspect.aspectsdemo.model.Circle.*(..))") //method names
  public void allPublicCircleMethodsWithZeroOrMoreParams()
  {
  }

  //Pointcut expression
  @Pointcut("within(com.aspect.aspectsdemo.model.Circle)")
  public void allCircleMethods()
  {
  }

  @Pointcut("within(com.aspect.aspectsdemo.model..*)") //class names
  public void allMethodsInPackageModelAndSubpackages()
  {
  }

}
