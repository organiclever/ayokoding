package com.ayokoding.cookbook.java_class.intermediate.static_initializers;

public class MainAnimal {
  public static void main(String[] args) {
    new Animal();
    new Animal();
    // Output:
    // Static initializer block executed.
    // Constructor executed. Count: 1
    // Constructor executed. Count: 2

    System.out.println(Animal.getCount()); // Output: 2
  }
}