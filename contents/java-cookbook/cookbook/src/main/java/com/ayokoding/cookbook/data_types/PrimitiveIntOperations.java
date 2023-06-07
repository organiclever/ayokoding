package com.ayokoding.cookbook.data_types;

public class IntOperations {
  public static void main(String[] args) {

    // Arithmetic Operations
    int a = 1000;
    int b = 2000;
    int c;

    c = a + b;
    System.out.println(c); // 3000

    c = b - a;
    System.out.println(c); // 1000

    c = a * b;
    System.out.println(c); // 2000000

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
    System.out.println(c); // 960

    c = a | b;
    System.out.println(c); // 2040

    c = a ^ b;
    System.out.println(c); // 1080

    c = ~a;
    System.out.println(c); // -1001

    c = a << 2;
    System.out.println(c); // 4000

    c = a >> 2;
    System.out.println(c); // 250

    c = a >>> 2;
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
    System.out.println(a); // 200

    a = 1000;
    a &= 200;
    System.out.println(a); // 192

    a = 1000;
    a |= 200;
    System.out.println(a); // 1208

    a = 1000;
    a ^= 200;
    System.out.println(a); // 816

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
    c = +a;
    System.out.println(c); // 1000

    c = -a;
    System.out.println(c); // -1000

    a++;
    System.out.println(a); // 1001

    a--;
    System.out.println(a); // 1000
  }
}
