package application;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Graphics;

class Explosion extends Thing {
    private boolean paintme = false;
    private int S;
    public int size;
    private int scale;

    Explosion(MissileCommando var1, Color var2, int var3, int var4, int var5) {
        super.parent = var1;
        super.X = var3;
        super.Y = var4;
        super.color = var2;
        this.S = var5;
        this.start();
    }

    public void run() {
        Thread.currentThread().setPriority(1);
        this.scale = 10;
        this.size = 1;

        do {
            this.paintme = true;
            super.parent.repaint();

            try {
                Thread.sleep(50L);
            } catch (InterruptedException var2) {
                ;
            }
        } while(this.size <= this.S);

        this.scale = -10;

        do {
            this.paintme = true;
            super.parent.repaint();

            try {
                Thread.sleep(100L);
            } catch (InterruptedException var1) {
                ;
            }
        } while(this.size >= 0);

        this.paintme = true;
        super.parent.repaint();
    }

    public boolean hit(Missile var1) {
        return var1.X >= super.X - this.size / 2 && var1.X <= super.X + this.size / 2 && var1.Y >= super.Y - this.size / 2 && var1.Y <= super.Y + this.size / 2;
    }

    public void explode() {
    }

    public void paint(Graphics var1) {
        if (this.paintme) {
            if (this.scale < 0) {
                var1.setColor(Color.lightGray);
                var1.fillOval(super.X - this.size / 2, super.Y - this.size / 2, this.size, this.size);
            }

            this.size += this.scale;
            var1.setColor(super.color);
            var1.fillOval(super.X - this.size / 2, super.Y - this.size / 2, this.size, this.size);
            this.paintme = false;
        }

    }

    public void erase(Graphics var1) {
    }
}
