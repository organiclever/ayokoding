package com.ayokoding.cookbook.class_intermediate.inner_nested_class;

public class Main {
  public static void main(String[] args) {
    Animal animal = new Animal("Lion");
    Animal.Inner inner = animal.new Inner();

    animal.eat(); // Output: Lion is eating.
    inner.innerMethod(); // Output: Inner method. Name: Lion
  }
}