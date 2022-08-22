package com.leetcode.problems.easy;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TrafficLight {
    private final ReentrantReadWriteLock lock;
    private volatile int greenLight;

    public TrafficLight() {
        this.lock = new ReentrantReadWriteLock(true);
        this.greenLight = 1;
    }

    // the current version is rejected, but this passes:
    //
    //        lock.writeLock().lock();
    //
    //        if(roadId != greenLight) {
    //            toggleLight();
    //            turnGreen.run();
    //        }
    //
    //        crossCar.run();
    //        lock.writeLock().unlock();
    //
    public void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) {

        lock.readLock().lock();

        if(roadId != greenLight) {
            lock.readLock().unlock();
            lock.writeLock().lock();

            if(roadId != greenLight) {
                toggleLight();
                turnGreen.run();
            }

            lock.readLock().lock();
            lock.writeLock().unlock();
        }

        crossCar.run();
        lock.readLock().unlock();
    }

    private void toggleLight() {
        if(greenLight == 1) {
            greenLight = 2;
        } else {
            greenLight = 1;
        }
    }
}
