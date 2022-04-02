package com.aspect.aspectsdemo.service;

import com.aspect.aspectsdemo.model.Circle;
import com.aspect.aspectsdemo.model.Triangle;
import org.springframework.stereotype.Service;

@Service
public class ShapeService
{
  private Circle   circle;
  private Triangle triangle;

  public Circle getCircle()
  {
    return circle;
  }

  public ShapeService setCircle(Circle circle)
  {
    this.circle = circle;
    return this;
  }

  public Triangle getTriangle()
  {
    return triangle;
  }

  public ShapeService setTriangle(Triangle triangle)
  {
    this.triangle = triangle;
    return this;
  }
}
