package com.ayokoding.cookbook.data_types;

public class PrimitiveByteOperations {
  public static void main(String[] args) {
    // Arithmetic Operations
    byte a = 10;
    byte b = 20;
    byte c;

    c = (byte) (a + b);
    System.out.println(c); // 30

    c = (byte) (b - a);
    System.out.println(c); // 10

    c = (byte) (a * b);
    System.out.println(c); // -56

    c = (byte) (b / a);
    System.out.println(c); // 2

    c = (byte) (b % a);
    System.out.println(c); // 0

    // Relational Operations
    System.out.println(a == b); // false
    System.out.println(a != b); // true
    System.out.println(a > b); // false
    System.out.println(a < b); // true
    System.out.println(a >= b); // false
    System.out.println(a <= b); // true

    // Bitwise Operations
    c = (byte) (a & b);
    System.out.println(c); // 0

    c = (byte) (a | b);
    System.out.println(c); // 30

    c = (byte) (a ^ b);
    System.out.println(c); // 30

    c = (byte) ~a;
    System.out.println(c); // -11

    c = (byte) (a << 2);
    System.out.println(c); // 40

    c = (byte) (a >> 2);
    System.out.println(c); // 2

    c = (byte) (a >>> 2);
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
    c = (byte) +a;
    System.out.println(c); // 10

    c = (byte) -a;
    System.out.println(c); // -10

    a++;
    System.out.println(a); // 11

    a--;
    System.out.println(a); // 10
  }
}
