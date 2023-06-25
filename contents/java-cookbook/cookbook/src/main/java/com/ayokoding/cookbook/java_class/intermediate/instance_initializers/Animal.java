package com.ayokoding.cookbook.java_class.intermediate.instance_initializers;

class Animal {
  private String species;

  {
    // Instance initializer block
    species = "Unknown";
    System.out.println("Instance initializer block executed.");
  }

  public Animal() {
    System.out.println("Constructor executed. Species: " + species);
  }

  public String getSpecies() {
    return species;
  }
}
