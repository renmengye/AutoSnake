package autosnake;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MengYe
 */
public class SCanvas extends Canvas implements ASCommon {

    private float[] x = new float[XNUM + 1];
    private float[] y = new float[YNUM + 1];
    private byte[][] map = new byte[YNUM][XNUM];
    private int i, j;

    public SCanvas() {
        for (j = 0; j <= YNUM; j++) {
            y[j] = SHEIGHT / (float) (YNUM + 1) * j;
        }
        for (i = 0; i <= XNUM; i++) {
            x[i] = SWIDTH / (float) (XNUM + 1) * i;
        }
    }

    @Override
    public void paint(Graphics g) {
        for (j = 0; j < YNUM; j++) {
            for (i = 0; i < XNUM; i++) {
                if (map[j][i] > 0) {
                    g.setColor(Color.BLACK);
                    g.fillRect((int)x[i], (int)y[j], (int)GRIDW, (int)GRIDH);
                } else if (map[j][i] < 0) {
                    g.setColor(Color.RED);
                    g.fillRect((int)x[i], (int)y[j], (int)GRIDW, (int)GRIDH);
                }
            }
        }
    }

    public void setMap(byte[][] m) {
        map = m;
    }
}
