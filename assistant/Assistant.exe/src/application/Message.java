package application;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Color;
import java.awt.Graphics;

class Message extends Thing {
    private String message;
    private int blinks;
    private int delay;
    private int blinkCount;

    Message(MissileCommando var1, String var2, int var3, int var4, int var5, int var6) {
        super.parent = var1;
        this.message = var2;
        super.X = var3;
        super.Y = var4;
        this.blinks = var5;
        this.delay = var6;
        super.color = Color.black;
        this.start();
    }

    Message(MissileCommando var1, String var2, int var3, int var4, int var5) {
        this(var1, var2, var3, var4, var5, 500);
    }

    Message(MissileCommando var1, String var2, int var3, int var4) {
        this(var1, var2, var3, var4, 3, 500);
    }

    public void run() {
        Thread.currentThread().setPriority(1);

        for(this.blinkCount = 0; this.blinkCount < 2 * this.blinks; ++this.blinkCount) {
            super.parent.repaint();

            try {
                Thread.sleep((long)this.delay);
            } catch (InterruptedException var1) {
                ;
            }
        }

        super.parent.repaint();
    }

    public void paint(Graphics var1) {
        if (this.blinkCount % 2 == 0) {
            var1.setColor(super.color);
        } else {
            var1.setColor(Color.lightGray);
        }

        var1.drawString(this.message, super.X, super.Y);
    }

    public void erase(Graphics var1) {
        var1.setColor(Color.lightGray);
        var1.drawString(this.message, super.X, super.Y);
    }

    public boolean hit(Missile var1) {
        return false;
    }

    public void explode() {
    }
}
