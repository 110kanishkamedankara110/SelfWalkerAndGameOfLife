/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package engine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;

/**
 *
 * @author Kanishka
 */
public class GameOfLife extends Canvas {

    static int cellWidth =5;
    static int cellHeight = cellWidth;
    static int mh = cellHeight * 4;
    static int ml = cellWidth * 2;
    static int cols = 600 / cellWidth;
    static int rows = 600 / cellHeight;
    int x = 100;
    int y = 0;
    static GameOfLife gol;
    int grid[][] = new int[cols][rows];

    public GameOfLife(int height, int weight) {
        super(height, weight);
    }

    public GameOfLife(int height, int weight, int x, int y) {
        super(height, weight, x, y);
    }

    public static void main(String[] args) {
        gol = new GameOfLife(600 + (ml * 2), 600 + (mh * 2));
        gol.setVisible(true);
    }

    @Override
    public void setup() {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                grid[i][j] = new Double(Math.floor(Math.random() * 2)).intValue();
            }
        }

    }

    @Override
    public void update() {
        int newGrid[][] = new int[cols][rows];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {

                if (grid[i][j] == 1) {

                    g.fillRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight);

                } else {

                    g.clearRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight);

                }

            }
        }

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                int state = grid[i][j];

                int neb = count(grid, i, j);

                if (state == 0 && (neb == 3)) {
                    newGrid[i][j] = 1;
                } else if (state == 1 && (neb < 2 || neb > 3)) {
                    newGrid[i][j] = 0;

                } else {
                    newGrid[i][j] = state;
                }

            }
        }

        grid = newGrid;
    }

       public int count(int grid[][], int i, int j) {
        int sum = 0;
        int c=0;
        for(int k=-1;k<2;k++){
          for(int l=-1;l<2;l++){
            int col=(k+i+cols)%cols;
            int row=(l+j+rows)%rows;
            
              c++;
              sum+=grid[col][row];
            
          }
        }
        if(grid[i][j]==1){
              sum--;
              c--;
        }
        


        return sum;
    }
}
