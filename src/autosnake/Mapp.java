/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package autosnake;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 *Enumerates each different map value;
 */
public enum Mapp {
    BODY(1),HEAD(3),TAIL(2),GOAL(-5),DANGER(0),WAY(-1);
    int num;

    Mapp(int num){
        this.num=num;
    }

    public int value() {
        return num;
    }

    private static final Map<Integer, Mapp> lookup = new HashMap<Integer, Mapp>();

    static {
          for(Mapp s : EnumSet.allOf(Mapp.class))
               lookup.put(s.value(), s);
     }

    //reverse lookup
    public static Mapp get(int num) {
        return lookup.get(num);
    }
}
