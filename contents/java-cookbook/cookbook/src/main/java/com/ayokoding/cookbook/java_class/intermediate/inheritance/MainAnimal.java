package com.ayokoding.cookbook.java_class.intermediate.inheritance;

public class MainAnimal {
  public static void main(String[] args) {
    Dog dog = new Dog("Buddy");
    dog.eat(); // Output: Buddy is eating.
    dog.bark(); // Output: Buddy is barking.
  }
}