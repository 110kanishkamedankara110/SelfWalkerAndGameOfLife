/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package engine;

import java.util.Vector;

class desc extends Canvas {

    int x = this.getWidth()/2;
    int y = this.getHeight()/2;

    Vector v = new Vector();
    Rect r2;
    int mouseX;
    int mouseY;

    public desc(int height, int weight) {
        super(height, weight);
    }

    public desc(int height, int weight, int x, int y) {
        super(height, weight, x, y);
    }

    public static void main(String[] args) {
        new desc(400, 400).setVisible(true);
    }

    @Override
    public void setup() {
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);

    }

    @Override
    public void update() {

        g.fillRect(x, y, 1, 1);
        int rad = new Double(Math.random() * 4).intValue();
       
        switch (rad) {
            case 0:
                x++;
                break;
            case 1:
                x--;
                break;
            case 2:
                y++;
                break;
            case 3:
                y--;
                break;

        }
    }
}
