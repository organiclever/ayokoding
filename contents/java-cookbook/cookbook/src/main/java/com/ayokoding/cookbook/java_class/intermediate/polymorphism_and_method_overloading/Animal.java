package com.ayokoding.cookbook.java_class.intermediate.polymorphism_and_method_overloading;

class Animal {
  public void makeSound() {
    System.out.println("Animal is making a sound.");
  }
}

class Dog extends Animal {
  @Override
  public void makeSound() {
    System.out.println("Dog is barking.");
  }
}