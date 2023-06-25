package com.ayokoding.cookbook.java_class.intermediate.inheritance;

class Car {
  protected String brand;

  public Car(String brand) {
    this.brand = brand;
  }

  public void startEngine() {
    System.out.println("Starting the engine of " + brand + ".");
  }
}

class SportsCar extends Car {
  public SportsCar(String brand) {
    super(brand);
  }

  public void accelerate() {
    System.out.println("Accelerating the " + brand + " sports car.");
  }
}