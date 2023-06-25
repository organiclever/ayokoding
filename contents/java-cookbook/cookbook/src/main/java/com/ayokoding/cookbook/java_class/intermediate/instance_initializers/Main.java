package com.ayokoding.cookbook.java_class.intermediate.instance_initializers;

public class Main {
  public static void main(String[] args) {
    Animal animal = new Animal();
    // Output:
    // Instance initializer block executed.
    // Constructor executed. Species: Unknown

    System.out.println(animal.getSpecies()); // Output: Unknown
  }
}