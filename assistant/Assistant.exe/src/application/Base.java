package application;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Graphics;

class Base extends Thing {
    private int W;
    private int H;

    Base(MissileCommando var1, Color var2, int var3, int var4, int var5, int var6) {
        super.parent = var1;
        super.X = var3;
        super.Y = var4;
        super.color = var2;
        this.W = var5;
        this.H = var6;
        this.start();
    }

    public void run() {
        Thread.currentThread().setPriority(1);
        this.waitToDie();
    }

    public synchronized void waitToDie() {
        try {
            this.wait();
        } catch (InterruptedException var1) {
            ;
        }
    }

    public synchronized void timeToDie() {
        this.notify();
    }

    public boolean hit(Missile var1) {
        return var1.X >= super.X && var1.X <= super.X + this.W && var1.Y >= super.Y && var1.Y <= super.Y + this.H;
    }

    public void explode() {
        this.timeToDie();
        this.stop();
    }

    public void paint(Graphics var1) {
        var1.setColor(super.color);
        var1.fillRect(super.X, super.Y, this.W, this.H);
    }

    public void erase(Graphics var1) {
        var1.setColor(Color.lightGray);
        var1.fillRect(super.X, super.Y, this.W, this.H);
    }
}
