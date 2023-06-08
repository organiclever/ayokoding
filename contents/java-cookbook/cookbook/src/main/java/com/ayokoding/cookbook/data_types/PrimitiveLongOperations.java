package com.ayokoding.cookbook.data_types;

public class PrimitiveLongOperations {
  public static void main(String[] args) {
    // Arithmetic Operations
    long a = 10L;
    long b = 20L;
    long c;

    c = a + b;
    System.out.println(c); // 30

    c = b - a;
    System.out.println(c); // 10

    c = a * b;
    System.out.println(c); // 200

    c = b / a;
    System.out.println(c); // 2

    c = b % a;
    System.out.println(c); // 0

    // Relational Operations
    System.out.println(a == b); // false
    System.out.println(a != b); // true
    System.out.println(a > b); // false
    System.out.println(a < b); // true
    System.out.println(a >= b); // false
    System.out.println(a <= b); // true

    // Bitwise Operations
    c = a & b;
    System.out.println(c); // 0

    c = a | b;
    System.out.println(c); // 30

    c = a ^ b;
    System.out.println(c); // 30

    c = ~a;
    System.out.println(c); // -11

    c = a << 2;
    System.out.println(c); // 40

    c = a >> 2;
    System.out.println(c); // 2

    c = a >>> 2;
    System.out.println(c); // 2

    // Assignment Operations
    a = 10;
    System.out.println(a); // 10

    a += 2;
    System.out.println(a); // 12

    a -= 2;
    System.out.println(a); // 10

    a *= 2;
    System.out.println(a); // 20

    a /= 2;
    System.out.println(a); // 10

    a %= 2;
    System.out.println(a); // 0

    a = 10;
    a &= 2;
    System.out.println(a); // 2

    a = 10;
    a |= 2;
    System.out.println(a); // 10

    a = 10;
    a ^= 2;
    System.out.println(a); // 8

    a = 10;
    a <<= 2;
    System.out.println(a); // 40

    a = 10;
    a >>= 2;
    System.out.println(a); // 2

    a = 10;
    a >>>= 2;
    System.out.println(a); // 2

    // Unary Operations
    a = 10;
    c = +a;
    System.out.println(c); // 10

    c = -a;
    System.out.println(c); // -10

    a++;
    System.out.println(a); // 11

    a--;
    System.out.println(a); // 10
  }
}
