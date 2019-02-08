package application;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Enumeration;
import java.util.Vector;

public class MissileCommando extends Applet implements Runnable {
    private final int SCORE_WIDTH = 70;
    private final int WORLD_WIDTH = 430;
    private final int WORLD_HEIGHT = 300;
    private final int BASES = 5;
    private final int BASE_SPACING = 30;
    private final int BASE_WIDTH = 50;
    private final int BASE_HEIGHT = 40;
    private final int POINTS_MISSILE = 100;
    private final int POINTS_EXTRA_SHOTS = 50;
    private final int POINTS_BASE = 100;
    private final int POINTS_NEW_BASE = 5000;
    private final int MAX_SHOTS = 10;
    private int shots;
    private AudioClip startSound;
    private AudioClip applauseSound;
    private AudioClip missileSound;
    private AudioClip shotExplosionSound;
    private AudioClip missileExplosionSound;
    private AudioClip baseExplosionSound;
    private AudioClip music;
    private boolean playing = false;
    private boolean clearScreen = false;
    private boolean loadingSounds = false;
    private int score;
    private int level;
    private int speed;
    private int delay;
    private int missileCount;
    private int shotCount;
    private Semaphore missileSemaphore;
    private Semaphore messageSemaphore;
    private Font font;
    private FontMetrics fontMetrics;
    private String scoreString = "Score";
    private String levelString = "Level";
    private String shotString = "Shots";
    private String welcomeString = "Click to start";
    private String loadingString = "Loading sounds...";
    private Vector things;
    private Thread thread;

    public void init() {
        this.font = new Font("TimesRoman", 1, 24);
        this.fontMetrics = this.getFontMetrics(this.font);
        this.setFont(this.font);
        this.resize(500, 300);
    }

    public synchronized void newGame() {
        this.playing = true;
        this.clearScreen = true;
        this.stopThreads();
        this.thread = new Thread(this);
        this.thread.start();
    }

    public void run() {
        int var2 = 0;
        Thread.currentThread().setPriority(1);
        this.score = 0;
        this.shotCount = 0;
        this.shots = 0;
        this.things = new Vector(32);
        this.missileSemaphore = new Semaphore();
        this.messageSemaphore = new Semaphore();
//        this.getSounds();
        this.createBases();
        if (this.music != null) {
            this.music.loop();
        }

        this.level = 1;

        while(true) {
            if (this.level == 1) {
                if (this.startSound != null) {
                    this.startSound.play();
                }
            } else if (this.applauseSound != null) {
                this.applauseSound.play();
            }

            this.messageSemaphore.take();
            this.createMessage("Level " + this.level);
            this.messageSemaphore.take();
            this.messageSemaphore.give();
            this.speed = 5 + (this.level - 1);
            if (this.speed > 30) {
                this.speed = 30;
            }

            this.delay = 2000 - (this.level - 1) * 200;
            if (this.delay < 500) {
                this.delay = 500;
            }

            this.missileCount = 5 + (this.level - 1) * 5;
            this.shotCount = this.missileCount * 2;
            this.missileSemaphore.take();

            while(this.missileCount > 0) {
                try {
                    Thread.sleep((long)this.delay);
                } catch (InterruptedException var6) {
                    ;
                }

                this.createMissile(this.speed);
                --this.missileCount;
            }

            this.missileSemaphore.take();
            this.missileSemaphore.give();

            int var1;
            for(var1 = this.score - var2 * 5000; this.countBases() < 5 && var1 >= 5000; ++var2) {
                this.createBase();
                var1 -= 5000;
            }

            var1 = this.countBases();
            if (var1 == 0) {
                this.playing = false;
                if (this.music != null) {
                    this.music.stop();
                }

                for(int var3 = 0; var3 < 5; ++var3) {
                    int var4 = (int)(Math.random() * 430.0D);
                    int var5 = (int)(Math.random() * 300.0D);
                    this.things.addElement(new Explosion(this, Color.red, var4, var5, 500));
                }

                this.messageSemaphore.take();
                this.createMessage("GAME OVER");
                this.messageSemaphore.take();
                this.messageSemaphore.give();
                return;
            }

            this.score += var1 * 100;
            ++this.level;
        }
    }

    public void stopThreads() {
        if (this.things != null) {
            Enumeration var1 = this.things.elements();

            while(var1.hasMoreElements()) {
                Thing var2 = (Thing)var1.nextElement();
                var2.explode();
            }
        }

    }

    public void stop() {
        if (this.music != null) {
            this.music.stop();
        }

        this.stopThreads();
        if (this.thread != null) {
            this.thread.stop();
            this.thread = null;
        }

    }

  //  void getSounds() {
      //  this.loadingSounds = true;
     //   this.repaint();
      //  this.startSound = this.getAudioClip(this.getCodeBase(), "sounds/sub_dive_horn.au");
      //  this.applauseSound = this.getAudioClip(this.getCodeBase(), "sounds/applause.au");
      //  this.missileSound = this.getAudioClip(this.getCodeBase(), "sounds/missile.au");
      //  this.shotExplosionSound = this.getAudioClip(this.getCodeBase(), "sounds/shot.au");
      //  this.missileExplosionSound = this.getAudioClip(this.getCodeBase(), "sounds/beep_multi.au");
      //  this.baseExplosionSound = this.getAudioClip(this.getCodeBase(), "sounds/bzzzt.au");
     //   this.music = null;
      //  this.loadingSounds = false;
   // }

    void createBases() {
        for(int var1 = 0; var1 < 5; ++var1) {
            this.createBase();
        }

    }

    void createBase() {
        int var3 = 0;

        for(int var4 = 30; var3 < 5; var4 += 80) {
            boolean var2 = false;
            Enumeration var1 = this.things.elements();

            while(var1.hasMoreElements()) {
                Thing var5 = (Thing)var1.nextElement();
                if (var5 instanceof Base && var5.X == var4) {
                    var2 = true;
                }
            }

            if (!var2) {
                this.things.addElement(new Base(this, Color.blue, var4, 259, 50, 40));
                return;
            }

            ++var3;
        }

    }

    void createShotExplosion(int var1, int var2) {
        if (this.shots <= 10) {
            this.things.addElement(new ShotExplosion(this, var1, var2));
            if (this.shotExplosionSound != null) {
                this.shotExplosionSound.play();
            }

            ++this.shots;
        }
    }

    void createBaseExplosion(int var1, int var2) {
        this.things.addElement(new BaseExplosion(this, var1, var2));
        if (this.baseExplosionSound != null) {
            this.baseExplosionSound.play();
        }

    }

    void createMissile(int var1, int var2, int var3) {
        Color var6 = Color.red;
        int var4 = (int)(Math.random() * 430.0D);
        if (var4 == 0) {
            var4 = 1;
        }

        short var5 = 298;
        this.things.addElement(new Missile(this, var6, var1, var2, var4, var5, var3));
        if (this.missileSound != null) {
            this.missileSound.play();
        }

    }

    void createMissile(int var1) {
        int var2 = (int)(Math.random() * 430.0D);
        if (var2 == 0) {
            var2 = 1;
        }

        byte var3 = 2;
        this.createMissile(var2, var3, var1);
    }

    void createMessage(String var1) {
        int var2 = this.fontMetrics.stringWidth(var1);
        int var3 = 215 - var2 / 2;
        short var4 = 150;
        this.things.addElement(new Message(this, var1, var3, var4));
    }

    public boolean handleEvent(Event var1) {
        if (var1.id != 501) {
            return super.handleEvent(var1);
        } else {
            if (this.playing && this.shotCount > 0 && var1.x >= 0 && var1.x <= 430 && var1.y >= 0 && var1.y <= 300) {
                this.createShotExplosion(var1.x, var1.y);
                --this.shotCount;
            } else if (!this.playing) {
                this.newGame();
            }

            return true;
        }
    }

    public void checkCollision(Missile var1) {
        int var3 = 0;
        int var4 = 0;
        Enumeration var2 = this.things.elements();

        while(var2.hasMoreElements()) {
            Thing var5 = (Thing)var2.nextElement();
            if (var5 != var1 && var5.isAlive() && var5.hit(var1)) {
                var5.explode();
                if (var5 instanceof Base) {
                    ++var3;
                } else if (var5 instanceof ShotExplosion) {
                    ++var4;
                    this.score += 100;
                    if (this.missileExplosionSound != null) {
                        this.missileExplosionSound.play();
                    }
                }
            }
        }

        if (var3 > 0) {
            this.createBaseExplosion(var1.X, var1.Y);
        }

        if (var3 > 0 || var4 > 0) {
            var1.explode();
        }

    }

    public synchronized void updateThings(Graphics var1) {
        Enumeration var2 = this.things.elements();

        while(var2.hasMoreElements()) {
            Thing var3 = (Thing)var2.nextElement();
            if (var3.isAlive()) {
                var3.paint(var1);
                if (var3 instanceof Missile) {
                    this.checkCollision((Missile)var3);
                }
            } else {
                var3.erase(var1);
                this.things.removeElement(var3);
                if (var3 instanceof Message) {
                    this.messageSemaphore.give();
                } else if (var3 instanceof ShotExplosion) {
                    --this.shots;
                }
            }
        }

    }

    public int countMissiles() {
        int var2 = 0;
        Enumeration var1 = this.things.elements();

        while(var1.hasMoreElements()) {
            Thing var3 = (Thing)var1.nextElement();
            if (var3 instanceof Missile && var3.isAlive()) {
                ++var2;
            }
        }

        return var2;
    }

    public int countBases() {
        int var2 = 0;
        Enumeration var1 = this.things.elements();

        while(var1.hasMoreElements()) {
            Thing var3 = (Thing)var1.nextElement();
            if (var3 instanceof Base && var3.isAlive()) {
                ++var2;
            }
        }

        return var2;
    }

    public void updateBorder(Graphics var1) {
        var1.setColor(Color.black);
        var1.drawRect(0, 0, 499, 299);
        var1.drawLine(430, 0, 430, 300);
    }

    String numberToZeroPaddedString(int var1, int var2) {
        StringBuffer var3 = new StringBuffer(Integer.toString(var1));

        while(var3.length() < var2) {
            var3.insert(0, "0");
        }

        return var3.toString();
    }

    public synchronized void updateScore(Graphics var1) {
        int var3 = this.fontMetrics.stringWidth("00000");
        int var2 = this.fontMetrics.getHeight();
        short var4 = 435;
        var1.setColor(Color.black);
        var1.drawString(this.scoreString, var4, var2);
        int var5 = var2 + var2;
        var1.clearRect(var4, var5 - var2, var3, var2);
        var1.drawString(this.numberToZeroPaddedString(this.score, 5), var4, var5);
        var5 += 2 * var2;
        var1.drawString(this.shotString, var4, var5);
        var5 += var2;
        var1.clearRect(var4, var5 - var2, var3, var2);
        var1.drawString(this.numberToZeroPaddedString(this.shotCount, 5), var4, var5);
    }

    public void update(Graphics var1) {
        this.paint(var1);
    }

    public void paint(Graphics var1) {
        if (this.clearScreen) {
            var1.setColor(Color.lightGray);
            var1.fillRect(0, 0, 500, 300);
            this.clearScreen = false;
        }

        int var2;
        int var3;
        short var4;
        if (this.loadingSounds) {
            var2 = this.fontMetrics.stringWidth(this.loadingString);
            var3 = 215 - var2 / 2;
            var4 = 150;
            var1.setColor(Color.black);
            var1.drawString(this.loadingString, var3, var4);
            this.clearScreen = true;
        } else if (!this.playing && (this.things == null || this.things.size() == 0)) {
            var2 = this.fontMetrics.stringWidth(this.welcomeString);
            var3 = 215 - var2 / 2;
            var4 = 150;
            var1.setColor(Color.black);
            var1.drawString(this.welcomeString, var3, var4);
        } else if (this.things != null) {
            Graphics var5 = var1.create(0, 0, 430, 300);
            this.updateThings(var5);
            if (this.missileSemaphore != null && this.countMissiles() == 0 && this.missileCount == 0) {
                this.missileSemaphore.give();
            }
        }

        this.updateBorder(var1);
        this.updateScore(var1);
    }

    public MissileCommando() {
    }
}
