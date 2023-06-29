package com.ayokoding.cookbook.data_types_primitive;

public class PrimitiveShortOperations {
  public static void main(String[] args) {

    // Arithmetic Operations
    short a = 1000;
    short b = 2000;
    short c;

    c = (short) (a + b);
    System.out.println(c); // 3000

    c = (short) (b - a);
    System.out.println(c); // 1000

    c = (short) (a * b);
    System.out.println(c); // -31616 (overflow occurred)

    c = (short) (b / a);
    System.out.println(c); // 2

    c = (short) (b % a);
    System.out.println(c); // 0

    // Relational Operations
    System.out.println(a == b); // false
    System.out.println(a != b); // true
    System.out.println(a > b); // false
    System.out.println(a < b); // true
    System.out.println(a >= b); // false
    System.out.println(a <= b); // true

    // Bitwise Operations
    c = (short) (a & b);
    System.out.println(c); // 960

    c = (short) (a | b);
    System.out.println(c); // 2040

    c = (short) (a ^ b);
    System.out.println(c); // 1080

    c = (short) ~a;
    System.out.println(c); // -1001

    c = (short) (a << 2);
    System.out.println(c); // 4000

    c = (short) (a >> 2);
    System.out.println(c); // 250

    c = (short) (a >>> 2);
    System.out.println(c); // 250

    // Assignment Operations
    a = 1000;
    System.out.println(a); // 1000

    a += 200;
    System.out.println(a); // 1200

    a -= 200;
    System.out.println(a); // 1000

    a *= 2;
    System.out.println(a); // 2000

    a /= 2;
    System.out.println(a); // 1000

    a %= 200;
    System.out.println(a); // 0

    a = 1000;
    a &= 200;
    System.out.println(a); // 200

    a = 1000;
    a |= 200;
    System.out.println(a); // 1000

    a = 1000;
    a ^= 200;
    System.out.println(a); // 800

    a = 1000;
    a <<= 2;
    System.out.println(a); // 4000

    a = 1000;
    a >>= 2;
    System.out.println(a); // 250

    a = 1000;
    a >>>= 2;
    System.out.println(a); // 250

    // Unary Operations
    a = 1000;
    c = (short) +a;
    System.out.println(c); // 1000

    c = (short) -a;
    System.out.println(c); // -1000

    a++;
    System.out.println(a); // 1001

    a--;
    System.out.println(a); // 1000
  }
}
