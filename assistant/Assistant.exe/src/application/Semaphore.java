package application;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

class Semaphore {
    private boolean taken;

    Semaphore() {
        this.taken = false;
    }

    Semaphore(boolean var1) {
        this.taken = var1;
    }

    public synchronized void take() {
        while(this.taken) {
            try {
                this.wait();
            } catch (Exception var1) {
                ;
            }
        }

        this.taken = true;
    }

    public synchronized boolean peek() {
        return this.taken;
    }

    public synchronized void give() {
        this.taken = false;
        this.notify();
    }
}
