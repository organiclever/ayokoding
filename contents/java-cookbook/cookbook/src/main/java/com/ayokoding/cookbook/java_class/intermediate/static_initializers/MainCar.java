package com.ayokoding.cookbook.java_class.intermediate.static_initializers;

public class MainCar {
  public static void main(String[] args) {
    Car car = new Car();
    // Output:
    // Instance initializer block executed.
    // Constructor executed. Brand: Unknown

    System.out.println(car); // Output: something like
                             // com.ayokoding.cookbook.java_class.intermediate.instance_initializers.Car@5e91993f
  }
}