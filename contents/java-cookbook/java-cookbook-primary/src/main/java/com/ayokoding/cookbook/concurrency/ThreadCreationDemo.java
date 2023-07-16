package com.ayokoding.cookbook.concurrency;

public class ThreadCreationDemo {
  public static void main(String args[]) {
    ThreadCreation t1 = new ThreadCreation();
    t1.start();
    // Output (similar to):
    // 11 Value 0
    // 11 Value 1
    // 11 Value 2
    // 11 Value 3
    // 11 Value 4
    // 11 Value 5
    // 11 Value 6
    // 11 Value 7
    // 11 Value 8
    // 11 Value 9

    ThreadCreation t2 = new ThreadCreation();
    t2.start();
    // Output (similar to):
    // 12 Value 0
    // 12 Value 1
    // 12 Value 2
    // 12 Value 3
    // 12 Value 4
    // 12 Value 5
    // 12 Value 6
    // 12 Value 7
    // 12 Value 8
    // 12 Value 9
  }
}