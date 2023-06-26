package com.ayokoding.cookbook.control_structure;

public class ControlStructures {
  public static void main(String[] args) {

    // Sequence Structure
    int x = 1;
    int y = x + 2;
    System.out.println("x is " + x + ", y is " + y); // Output: x is 1, y is 3

    // Selection Structures

    // If-then
    if (x > y) {
      System.out.println("x is greater than y"); // This line will not be executed
    }

    // If-then-else
    if (x > y) {
      System.out.println("x is greater than y"); // This line will not be executed
    } else {
      System.out.println("x is not greater than y"); // Output: x is not greater than y
    }

    // If-then-else-if
    if (x > y) {
      System.out.println("x is greater than y"); // This line will not be executed
    } else if (x == y) {
      System.out.println("x is equal to y"); // This line will not be executed
    } else {
      System.out.println("x is less than y"); // Output: x is less than y
    }

    // Switch
    switch (x) {
      case 1:
        System.out.println("x is 1"); // This line will not be executed
        break;
      case 2:
        System.out.println("x is 2"); // Output: x is 2
        break;
      default:
        System.out.println("x is neither 1 nor 2"); // This line will not be executed
        break;
    }

    // Loop Structures

    // While loop
    while (x < 5) {
      System.out.print(x + " - "); // Output: 0 - 1 - 2 - 3 - 4 -
      x++;
    }
    System.out.println(x); // Output: 5

    // Do-while loop
    x = 0;
    do {
      System.out.print(x + " - "); // Output: 0 - 1 - 2 - 3 - 4 -
      x++;
    } while (x < 5);
    System.out.println(x); // Output: 5

    // For loop
    for (int i = 0; i < 5; i++) {
      System.out.print(i + " "); // Output: 0 1 2 3 4
    }
    System.out.println();

    // For-each loop
    int[] arr = { 1, 2, 3, 4, 5 };
    for (int num : arr) {
      System.out.print(num + " "); // Output: 1 2 3 4 5
    }
    System.out.println();

    String str = "HelloWorld!";
    for (String ch : str.split("")) {
      System.out.print(ch + " "); // Output: H e l l o W o r l d !
    }
    System.out.println();
  }
}
