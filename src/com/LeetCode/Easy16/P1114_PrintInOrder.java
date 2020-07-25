package com.LeetCode.Easy16;

import java.util.concurrent.CountDownLatch;

public class P1114_PrintInOrder {

    CountDownLatch firstPrinted,secondPrinted;

    public P1114_PrintInOrder() {
        firstPrinted = new CountDownLatch(1);
        secondPrinted = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstPrinted.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        firstPrinted.await();
        printSecond.run();
        secondPrinted.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        secondPrinted.await();
        printThird.run();
    }


}
