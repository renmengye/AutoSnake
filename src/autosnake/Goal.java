/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autosnake;

import java.awt.Dimension;
import java.util.Random;

/**
 *
 * @author MengYe
 */
public class Goal implements ASCommon{

    private int x, y;
    private Random rGen = new Random();

    public Dimension getLocation() {
        return new Dimension(x, y);
    }

    public void generate(Snake snake) {
        do {
            x = rGen.nextInt(XNUM);
            y = rGen.nextInt(YNUM);
        } while (snake.getMap()[y][x] > 0);
    }
}