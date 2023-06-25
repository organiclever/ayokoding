package com.ayokoding.cookbook.java_class.intermediate.static_initializers;

class Animal {
  private static int count;

  static {
    // Static initializer block
    count = 0;
    System.out.println("Static initializer block executed.");
  }

  public Animal() {
    count++;
    System.out.println("Constructor executed. Count: " + count);
  }

  public static int getCount() {
    return count;
  }
}
