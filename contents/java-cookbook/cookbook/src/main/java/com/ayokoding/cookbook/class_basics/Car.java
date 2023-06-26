package com.ayokoding.cookbook.class_basics;

public class Car {
  // Fields (Class Variables)
  private String color;
  private int year;

  // Constructor
  public Car(String color, int year) {
    this.color = color;
    this.year = year;
  }

  // Methods
  public void startEngine() {
    System.out.println("Engine started");
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  public void printCarInfo() {
    System.out.println("Car color: " + color + "; " + "Car year: " + year);
  }

  // Static Variable
  private static int numberOfCars;

  // Static Method
  public static void increaseCount() {
    numberOfCars++;
  }

  // Method Overloading
  public void accelerate() {
    System.out.println("Car is accelerating");
  }

  public void accelerate(int speed) {
    System.out.println("Car is accelerating at " + speed + " mph");
  }

  public static void main(String[] args) {
    // Creating objects of the Car class
    Car myCar = new Car("Red", 2021);
    Car anotherCar = new Car("Blue", 2022);

    // Accessing fields and calling methods
    myCar.startEngine(); // Print: Engine started
    myCar.setColor("Green");
    System.out.println("My car color: " + myCar.getColor()); // Print: My car color: Green
    myCar.printCarInfo(); // Print: Car color: Green; Car year: 2021

    anotherCar.startEngine(); // Print: Engine started
    anotherCar.accelerate(); // Print: Car is accelerating
    anotherCar.accelerate(60); // Print: Car is accelerating at 60 mph

    // Accessing static variable and method
    Car.increaseCount();
    Car.increaseCount();
    System.out.println("Number of cars: " + Car.numberOfCars); // Print: Number of cars: 2
  }
}
