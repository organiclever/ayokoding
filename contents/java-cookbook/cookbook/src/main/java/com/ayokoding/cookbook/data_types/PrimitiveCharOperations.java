package com.ayokoding.cookbook.data_types;

public class PrimitiveCharOperations {
  public static void main(String[] args) {
    // Arithmetic Operations
    char a = 'A';
    char b = 'B';
    int c;

    c = a + b;
    System.out.println(c); // 131

    c = b - a;
    System.out.println(c); // 1

    c = a * b;
    System.out.println(c); // 4290

    c = b / a;
    System.out.println(c); // 1

    c = b % a;
    System.out.println(c); // 1

    // Relational Operations
    System.out.println(a == b); // false
    System.out.println(a != b); // true
    System.out.println(a > b); // false
    System.out.println(a < b); // true
    System.out.println(a >= b); // false
    System.out.println(a <= b); // true

    // Bitwise Operations
    c = a & b;
    System.out.println(c); // 64

    c = a | b;
    System.out.println(c); // 67

    c = a ^ b;
    System.out.println(c); // 3

    c = ~a;
    System.out.println(c); // -66

    c = a << 2;
    System.out.println(c); // 260

    c = a >> 2;
    System.out.println(c); // 16

    c = a >>> 2;
    System.out.println(c); // 16

    // Assignment Operations
    a = 'A';
    System.out.println(a); // A

    a += 2;
    System.out.println(a); // C

    a -= 2;
    System.out.println(a); // A

    a *= 2;
    System.out.println(a); // blank => ?

    a /= 2;
    System.out.println(a); // A

    a %= 2;
    System.out.println(a); // blank => ?

    a = 'A';
    a &= 'B';
    System.out.println(a); // @

    a = 'A';
    a |= 'B';
    System.out.println(a); // C

    a = 'A';
    a ^= 'B';
    System.out.println(a); // blank => ?

    a = 'A';
    a <<= 2;
    System.out.println(a); // Ą

    a = 'Ä';
    a >>= 2;
    System.out.println(a); // 1

    a = 'Ä';
    a >>>= 2;
    System.out.println(a); // 1

    // Unary Operations
    a = 'A';
    c = +a;
    System.out.println(c); // 65

    a++;
    System.out.println(a); // B

    a--;
    System.out.println(a); // A
  }
}
