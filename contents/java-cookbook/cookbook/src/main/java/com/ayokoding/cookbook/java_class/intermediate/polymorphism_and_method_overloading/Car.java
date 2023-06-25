package com.ayokoding.cookbook.java_class.intermediate.polymorphism_and_method_overloading;

class Car {
  public void drive() {
    System.out.println("Driving the car.");
  }
}

class SportsCar extends Car {
  @Override
  public void drive() {
    System.out.println("Driving the sports car at high speed.");
  }
}