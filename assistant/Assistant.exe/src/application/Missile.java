package application;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Graphics;

class Missile extends Thing {
    private boolean paintme = false;
    private int X1;
    private int Y1;
    private int X2;
    private int Y2;
    private int V;
    private float m;
    private float b;
    private float x;
    private float y;
    private boolean replicate = false;

    Missile(MissileCommando var1, Color var2, int var3, int var4, int var5, int var6, int var7) {
        super.parent = var1;
        super.X = this.X1;
        super.Y = this.Y1;
        super.color = var2;
        this.X1 = var3;
        this.Y1 = var4;
        this.X2 = var5;
        this.Y2 = var6;
        this.V = var7;
        this.start();
    }

    public void run() {
        Thread.currentThread().setPriority(1);
        this.m = (float)(this.Y2 - this.Y1) / (float)(this.X2 - this.X1);
        this.b = (float)this.Y1 - this.m * (float)this.X1;
        this.x = (float)this.X1;
        this.y = (float)this.Y1;
        this.replicate = Math.random() > 0.9D;
        if (this.replicate) {
            super.color = Color.magenta;
        }

        label41:
        while(this.y <= (float)this.Y2) {
            if (this.replicate && this.y > (float)(this.Y1 + 5 * this.V) && Math.random() > 0.75D) {
                int var1 = 0;

                while(true) {
                    if (var1 >= 3) {
                        break label41;
                    }

                    super.parent.createMissile(super.X, super.Y, this.V);
                    ++var1;
                }
            }

            this.paintme = true;
            super.parent.repaint();

            try {
                Thread.sleep(100L);
            } catch (InterruptedException var2) {
                ;
            }
        }

        this.paintme = true;
        super.parent.repaint();
    }

    public boolean hit(Missile var1) {
        return var1.X == super.X && var1.Y == super.Y;
    }

    public void explode() {
        this.stop();
    }

    public void paint(Graphics var1) {
        if (this.paintme) {
            var1.setColor(Color.lightGray);
            var1.drawLine(this.X1, this.Y1, super.X, super.Y);
            this.y += (float)this.V;
            this.x = (this.y - this.b) / this.m;
            super.X = (int)this.x;
            super.Y = (int)this.y;
            var1.setColor(super.color);
            var1.drawLine(this.X1, this.Y1, super.X, super.Y);
            this.paintme = false;
        }

    }

    public void erase(Graphics var1) {
        var1.setColor(Color.lightGray);
        var1.drawLine(this.X1, this.Y1, super.X, super.Y);
    }
}
