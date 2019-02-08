package application;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Graphics;

abstract class Thing extends Thread {
    MissileCommando parent;
    public int X;
    public int Y;
    Color color;

    abstract void paint(Graphics var1);

    abstract void erase(Graphics var1);

    abstract boolean hit(Missile var1);

    abstract void explode();

    Thing() {
    }
}
