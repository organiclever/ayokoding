package com.ayokoding.cookbook.java_class.intermediate.inheritance;

public class MainCar {
  public static void main(String[] args) {
    SportsCar sportsCar = new SportsCar("Ferrari");
    sportsCar.startEngine(); // Output: Starting the engine of Ferrari.
    sportsCar.accelerate(); // Output: Accelerating the Ferrari sports car.
  }
}