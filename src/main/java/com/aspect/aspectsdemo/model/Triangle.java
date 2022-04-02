package com.aspect.aspectsdemo.model;

import org.springframework.stereotype.Component;

@Component
public class Triangle
{
  private String name;

  public String getName()
  {
    return name;
  }

  public Triangle setName(String name)
  {
    this.name = name;
    return this;
  }
}
