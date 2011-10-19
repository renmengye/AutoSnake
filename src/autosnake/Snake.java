package autosnake;

import javax.swing.Timer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MengYe
 */
public class Snake implements ASCommon{

    private int x, y, len, i, j, gx, gy;
    private Mapp[][] map;
    private Direction[][] dir;
    private boolean alive, eaten;
    private Timer timer;
    private Router router;

    public Snake(Timer t) {
        timer = t;
        len = 5;
        map = new Mapp[YNUM][XNUM];
        dir = new Direction[YNUM][XNUM];
        //router = new Router();
        alive = true;
        eaten = false;
        for (j = 0; j < YNUM; j++) {
            for (i = 0; i < XNUM; i++) {
                map[j][i] = Mapp.DANGER;
                dir[j][i] = Direction.UP;
                if (j == 0 && i < len) {
                    map[j][i] = Mapp.BODY;
                    dir[j][i] = Direction.RIGHT;
                    if (i == len - 1) {
                        map[j][i] = Mapp.HEAD;
                    } else if (i == 0) {
                        map[j][i] = Mapp.TAIL;
                    }
                }
            }
        }
    }

    public void setGoal(Goal goal) {
        gx = (int) goal.getLocation().getWidth();
        gy = (int) goal.getLocation().getHeight();
        map[gy][gx] = Mapp.GOAL;
        //PrintStream printf = System.out.printf("set %d, %d", gx,gy);
    }

    public void move() {
        Mapp[][] map2 = new Mapp[YNUM][XNUM];
        Direction[][] dir2 = new Direction[YNUM][XNUM];
        byte di = 0, dj = 0;


        for (j = 0; j < YNUM; j++) {
            for (i = 0; i < XNUM; i++) {
                map2[j][i] = Mapp.DANGER;
                dir2[j][i] = Direction.UP;
            }
        }

        outer:
        for (j = 0; j < YNUM; j++) {
            for (i = 0; i < XNUM; i++) {
                switch (dir[j][i]) {
                    case UP:
                        di = 0;
                        dj = -1;
                        break;
                    case DOWN:
                        di = 0;
                        dj = 1;
                        break;
                    case LEFT:
                        di = -1;
                        dj = 0;
                        break;
                    case RIGHT:
                        di = 1;
                        dj = 0;
                        break;
                }
                if (map[j][i].value() > 0) {
                    if (map[j][i] == Mapp.HEAD) {
                        if (j + dj < 0 || j + dj >= YNUM || i + di < 0 || i + di >= XNUM || map[j + dj][i + di] == Mapp.get(1)) {
                            die();
                            break outer;
                        }
                    }
                    map2[j + dj][i + di] = map[j][i];
                    if (map[j + dj][i + di] == Mapp.GOAL) {
                        eaten = true;
                    }
                    if (dir[j + dj][i + di].value() == 0) {
                        dir2[j + dj][i + di] = dir[j][i];
                    } else {
                        dir2[j + dj][i + di] = dir[j + dj][i + di];
                    }
                    if (map[j][i] == Mapp.TAIL && eaten) {
                        map2[j][i] = Mapp.TAIL;
                        map2[j + dj][i + di] = Mapp.BODY;
                        dir2[j][i] = dir[j][i];
                    }
                }else if(map[j][i].value()<0){
                    map2[j][i]=map[j][i];
                }
            }
        }
        map = map2;
        dir = dir2;
    }

    public void turn(Direction turn){

    }

    public void die() {
        alive = false;
        timer.stop();
    }
    
    public void route(){
        
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isEaten() {
        return eaten;
    }

    public Mapp[][] getMap() {
        return map;
    }

    /*public void print() {
        System.out.println("MAP________________________________");
        for (j = 0; j < YNUM; j++) {
            for (i = 0; i < XNUM; i++) {
                System.out.print(map[j][i]);
            }
            System.out.println();
        }
        System.out.println("DIR________________________________");
        for (j = 0; j < YNUM; j++) {
            for (i = 0; i < XNUM; i++) {
                System.out.print(dir[j][i]);
            }
            System.out.println();
        }
    }*/
}
