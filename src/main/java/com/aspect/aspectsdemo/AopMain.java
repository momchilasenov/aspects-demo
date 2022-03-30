package com.aspect.aspectsdemo;

import com.aspect.aspectsdemo.service.ShapeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class AopMain
{
  public static void main(String[] args)
  {
//    SpringApplication.run(AspectsDemoApplication.class, args);

    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
    System.out.println(shapeService.getCircle().getName()); //getCircle() and getName() both call the aspect
//    System.out.println(shapeService.getTriangle().getName());
  }
}