/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package autosnake;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MengYe
 */
public enum Direction {
UP(0),DOWN(1),LEFT(2),RIGHT(3);
    int num;

    Direction(int num){
        this.num=num;
    }

    public int value() {
        return num;
    }

    private static final Map<Integer, Direction> lookup = new HashMap<Integer, Direction>();

    static {
          for(Direction s : EnumSet.allOf(Direction.class))
               lookup.put(s.value(), s);
     }

    //reverse lookup
    public static Direction get(int num) {
        return lookup.get(num);
    }
}
