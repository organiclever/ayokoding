package com.ayokoding.cookbook.class_intermediate.static_initializers;

public class Main {
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