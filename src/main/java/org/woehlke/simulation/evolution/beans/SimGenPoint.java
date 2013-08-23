package org.woehlke.simulation.evolution.beans;

import java.io.Serializable;

/**
 * (C) 2006 - 2008 Thomas Woehlke
 * http://www.thomas-woehlke.de
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 23:47:05
 */
public class SimGenPoint implements Serializable {
    private int x = 0;
    private int y = 0;

    public SimGenPoint(SimGenPoint p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public SimGenPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void killNagative() {
        if (y < 0) {
            y *= -1;
        }
        if (x < 0) {
            x *= -1;
        }
    }

    public void add(SimGenPoint p) {
        this.x += p.getX();
        this.y += p.getY();
    }

    public void normalize(SimGenPoint p) {
        this.x %= p.getX();
        this.y %= p.getY();
    }
}
