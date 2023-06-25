package com.ayokoding.cookbook.java_class.intermediate.polymorphism_and_method_overloading;

public class MainAnimal {
  public static void main(String[] args) {
    Animal animal = new Animal();
    Animal dog = new Dog();

    animal.makeSound(); // Output: Animal is making a sound.
    dog.makeSound(); // Output: Dog is barking.
  }
}