package com.ayokoding.cookbook.concurrency;

public class ThreadCreationDemo {
  public static void main(String args[]) {
    ThreadCreation t1 = new ThreadCreation();
    t1.start();

    ThreadCreation t2 = new ThreadCreation();
    t2.start();
  }
}