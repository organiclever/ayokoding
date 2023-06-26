package com.ayokoding.cookbook.class_intermediate.inheritance;

class Animal {
  protected String name;

  public Animal(String name) {
    this.name = name;
  }

  public void eat() {
    System.out.println(name + " is eating.");
  }
}

class Dog extends Animal {
  public Dog(String name) {
    super(name);
  }

  public void bark() {
    System.out.println(name + " is barking.");
  }
}