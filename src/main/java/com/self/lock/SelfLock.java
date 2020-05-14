package com.self.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 实现类似ReentrantLock
 */
public class SelfLock implements Lock {

    private  class Sycn extends AbstractQueuedSynchronizer{

        @Override
        protected boolean isHeldExclusively() {
            return getState()==1;
        }

        @Override
        protected boolean tryAcquire(int arg) {
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if(getState()==0){
                throw new UnsupportedOperationException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        Condition newCondition(){
           return new ConditionObject();
        }

    }

    private final Sycn sycn = new Sycn();

    @Override
    public void lock() {
        sycn.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sycn.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sycn.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sycn.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sycn.release(1);
    }

    @Override
    public Condition newCondition() {
        return sycn.newCondition();
    }

}
