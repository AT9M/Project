package application;
import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

public class Rotator extends Applet implements Runnable {
    int frameWidth;
    int frameHeight;
    int nColumns = 1;
    int nRows = 1;
    int nFrames = 1;
    int frameInterval = 150;
    int spinFrame;
    boolean suspended = false;
    boolean singleStep = false;
    Thread spinThread;
    Image spinImage;

    public void init() {
        String var1 = this.getParameter("width");
        if (var1 != null) {
            this.frameWidth = Integer.parseInt(var1);
        }

        var1 = this.getParameter("height");
        if (var1 != null) {
            this.frameHeight = Integer.parseInt(var1);
        }

        var1 = this.getParameter("columns");
        if (var1 != null) {
            this.nColumns = Integer.parseInt(var1);
        }

        var1 = this.getParameter("rows");
        if (var1 != null) {
            this.nRows = Integer.parseInt(var1);
        }

        this.nFrames = this.nColumns * this.nRows;
        var1 = this.getParameter("frames");
        if (var1 != null) {
            this.nFrames = Integer.parseInt(var1);
        }

        var1 = this.getParameter("interval");
        if (var1 != null) {
            this.frameInterval = Integer.parseInt(var1);
        }

        this.spinImage = this.getImage(this.getCodeBase(), this.getParameter("image"));
    }

    public void start() {
        if (this.spinThread == null) {
            this.spinThread = new Thread(this, "Spin");
            this.spinThread.start();
        }

    }

    public void run() {
        while(this.spinThread != null) {
            this.repaint();

            try {
                Thread.sleep((long)this.frameInterval);
            } catch (InterruptedException var1) {
                ;
            }
        }

    }

    public void update(Graphics var1) {
        this.paint(var1);
    }

    public void paint(Graphics var1) {
        var1.drawImage(this.spinImage, -this.frameWidth * (this.spinFrame % this.nColumns), -this.frameHeight * (this.spinFrame / this.nColumns % this.nRows), this);
        ++this.spinFrame;
        if (this.spinFrame == this.nFrames) {
            this.spinFrame = 0;
        }

    }

    public boolean mouseDown(Event var1, int var2, int var3) {
        if (this.suspended) {
            this.spinThread.resume();
        } else {
            this.spinThread.suspend();
        }

        this.suspended = !this.suspended;
        return true;
    }

    public void stop() {
        this.spinThread.stop();
        this.spinThread = null;
    }

    public Rotator() {
    }
}