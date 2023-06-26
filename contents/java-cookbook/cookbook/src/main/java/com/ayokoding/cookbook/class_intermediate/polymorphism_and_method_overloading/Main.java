package com.ayokoding.cookbook.class_intermediate.polymorphism_and_method_overloading;

public class Main {
  public static void main(String[] args) {
    Animal animal = new Animal();
    Animal dog = new Dog();

    animal.makeSound(); // Output: Animal is making a sound.
    dog.makeSound(); // Output: Dog is barking.
  }
}