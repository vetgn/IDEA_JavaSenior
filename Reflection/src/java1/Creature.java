package java1;

import java.io.Serializable;

/**
 * @author ZJJ
 * #Description Creature
 * #Date: 2022/7/28 20:40
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }
}
