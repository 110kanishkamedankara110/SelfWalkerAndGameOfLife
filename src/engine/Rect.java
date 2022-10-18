/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package engine;

import java.awt.Graphics;

public class Rect {

    private Graphics g;
    private int x = new Double((Math.random() * 380) + 20).intValue();
    private int y = new Double((Math.random() * 380) + 20).intValue();

    private int speedX = new Double((Math.random() * 1) + 2).intValue();
    private int speedY = new Double((Math.random() * 1) + 2).intValue();

    private int w = 40;
    private int h = 40;

    private void setX(int x) {
        this.x = x;

    }

    public Rect(int x, int y, int spx, int spy) {
        this.speedX = spx;
        this.speedY = spy;
        this.x = x;
        this.y = y;
    }

    public Rect(int x, int y, int w, int h, int spx, int spy) {
        this.w = w;
        this.h = h;
        this.speedX = spx;
        this.speedY = spy;
        this.x = x;
        this.y = y;
    }

    private void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void drow(Graphics g) {
        this.g = g;
        g.fillOval(x, y,w,h);
    }

    public void moveX() {
        x += 3 * speedX;
        this.setX(x);

    }

    public void moveY() {
        y += 5 * speedY;
        this.setY(y);

    }
    public void moveX(double x) {
        
        this.setX(new Double(x).intValue());

    }

    public void moveY(double y) {
        
        this.setY(new Double(y).intValue());

    }

    public void changeXDirection() {
        speedX *= -1;

    }

    public void changeYDirection() {
        speedY *= -1;

    }

    public boolean iscollide(Rect r2) {
        return (((this.h+r2.h)/2) >= Math.sqrt(((this.x - r2.x) * (this.x - r2.x)) + ((this.y - r2.y) * (this.y - r2.y))));
    }

}
