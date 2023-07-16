package com.ayokoding.cookbook.concurrency;

class ThreadCreation extends Thread {
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println(Thread.currentThread().getId() + " Value " + i);
    }
  }
}
