package com.ayokoding.cookbook.class_intermediate.polymorphism_and_method_overloading;

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