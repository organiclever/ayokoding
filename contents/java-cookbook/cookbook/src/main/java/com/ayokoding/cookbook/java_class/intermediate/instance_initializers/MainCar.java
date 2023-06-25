package com.ayokoding.cookbook.java_class.intermediate.instance_initializers;

public class MainCar {
  public static void main(String[] args) {
    Car car = new Car();
    // Output:
    // Instance initializer block executed.
    // Constructor executed. Brand: Unknown

    System.out.println(car.getBrand()); // Output: Unknown
  }
}