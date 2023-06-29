package com.ayokoding.cookbook.data_types_primitive;

public class PrimitiveBooleanOperations {
  public static void main(String[] args) {

    // boolean values
    boolean bool1 = true;
    boolean bool2 = false;

    // Logical AND
    boolean result = bool1 && bool2;
    System.out.println(result); // false

    // Logical OR
    result = bool1 || bool2;
    System.out.println(result); // true

    // Logical XOR (exclusive OR)
    result = bool1 ^ bool2;
    System.out.println(result); // true

    // Logical NOT
    result = !bool1;
    System.out.println(result); // false

    // Equality Check
    result = (bool1 == bool2);
    System.out.println(result); // false

    // Inequality Check
    result = (bool1 != bool2);
    System.out.println(result); // true

    // Assignment
    bool1 = false;
    System.out.println(bool1); // false

    bool1 = true;
    System.out.println(bool1); // true

    // Conditional (Ternary) Operator
    result = (bool1 == bool2) ? bool1 : bool2;
    System.out.println(result); // false
  }
}
