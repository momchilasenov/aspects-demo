package com.aspect.aspectsdemo.model;

public class Circle
{
  private String name;

  public String getName()
  {
    return name;
  }

  public Circle setName(String name)
  {
    System.out.println("Calling Circle setter method");
    this.name = name;
    return this;
  }

  public String returnString(String name)
  {
    return "The name is " + name;
  }

  public String returnStringNoParams()
  {
    return "The name is blank";
  }
}
