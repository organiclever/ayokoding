package com.ayokoding.cookbook.methods_basics;

public class Animal {
  private String species;
  private String name;

  public Animal(String species, String name) {
    this.species = species;
    this.name = name;
  }

  public void makeSound() {
    System.out.println(species + " makes a sound");
  }

  public String getName() {
    return name;
  }
}