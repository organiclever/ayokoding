package com.ayokoding.cookbook.data_types_primitive;

public class PrimitiveFloatOperations {
  public static void main(String[] args) {
    // Arithmetic Operations
    float a = 10.5f;
    float b = 20.5f;
    float c;

    c = a + b;
    System.out.println(c); // 31.0

    c = b - a;
    System.out.println(c); // 10.0

    c = a * b;
    System.out.println(c); // 215.25

    c = b / a;
    System.out.println(c); // 1.9523809

    c = b % a;
    System.out.println(c); // 10.0

    // Relational Operations
    System.out.println(a == b); // false
    System.out.println(a != b); // true
    System.out.println(a > b); // false
    System.out.println(a < b); // true
    System.out.println(a >= b); // false
    System.out.println(a <= b); // true

    // Assignment Operations
    a = 10.5f;
    System.out.println(a); // 10.5

    a += 2.5f;
    System.out.println(a); // 13.0

    a -= 2.5f;
    System.out.println(a); // 10.5

    a *= 2.5f;
    System.out.println(a); // 26.25

    a /= 2.5f;
    System.out.println(a); // 10.5

    a %= 2.5f;
    System.out.println(a); // 0.5

    // Unary Operations
    a = 10.5f;
    c = +a;
    System.out.println(c); // 10.5

    c = -a;
    System.out.println(c); // -10.5
  }
}
