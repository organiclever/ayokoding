package com.ayokoding.cookbook.java_class.intermediate.polymorphism_and_method_overloading;

public class MainCar {
  public static void main(String[] args) {
    Car car = new Car();
    Car sportsCar = new SportsCar();

    car.drive(); // Output: Driving the car.
    sportsCar.drive(); // Output: Driving the sports car at high speed.
  }
}