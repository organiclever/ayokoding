package com.ayokoding.cookbook.java_class.intermediate.static_initializers;

class Car {
  private String brand;

  {
    // Instance initializer block
    brand = "Unknown";
    System.out.println("Instance initializer block executed.");
  }

  public Car() {
    System.out.println("Constructor executed. Brand: " + brand);
  }
}
