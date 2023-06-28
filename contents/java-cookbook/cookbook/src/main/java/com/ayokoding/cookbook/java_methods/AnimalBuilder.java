package com.ayokoding.cookbook.java_methods;

public class AnimalBuilder {
  private String species;
  private String name;

  public AnimalBuilder setSpecies(String species) {
    this.species = species;
    return this;
  }

  public AnimalBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public Animal build() {
    return new Animal(species, name);
  }
}