package com.ayokoding.cookbook.data_types_primitive;

public class PrimitiveDoubleOperations {
  public static void main(String[] args) {
    // Arithmetic Operations
    double a = 10.0;
    double b = 20.0;
    double c;

    c = a + b;
    System.out.println(c); // 30.0

    c = b - a;
    System.out.println(c); // 10.0

    c = a * b;
    System.out.println(c); // 200.0

    c = b / a;
    System.out.println(c); // 2.0

    c = b % a;
    System.out.println(c); // 0.0

    // Relational Operations
    System.out.println(a == b); // false
    System.out.println(a != b); // true
    System.out.println(a > b); // false
    System.out.println(a < b); // true
    System.out.println(a >= b); // false
    System.out.println(a <= b); // true

    // Assignment Operations
    a = 10.0;
    System.out.println(a); // 10.0

    a += 2.0;
    System.out.println(a); // 12.0

    a -= 2.0;
    System.out.println(a); // 10.0

    a *= 2.0;
    System.out.println(a); // 20.0

    a /= 2.0;
    System.out.println(a); // 10.0

    a %= 2.0;
    System.out.println(a); // 0.0

    // Unary Operations
    a = 10.0;
    c = +a;
    System.out.println(c); // 10.0

    c = -a;
    System.out.println(c); // -10.0
  }
}
