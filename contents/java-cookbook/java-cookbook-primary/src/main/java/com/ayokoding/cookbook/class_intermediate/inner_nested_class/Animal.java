package com.ayokoding.cookbook.class_intermediate.inner_nested_class;

class Animal {
  private String name;

  public Animal(String name) {
    this.name = name;
  }

  public void eat() {
    System.out.println(name + " is eating.");
  }

  class Inner {
    public void innerMethod() {
      System.out.println("Inner method. Name: " + name);
    }
  }
}
