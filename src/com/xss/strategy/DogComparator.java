package com.xss.strategy;

/**
 * @ClassName DogComarator
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/5/27 8:58 PM
 * @Return
 */
public class DogComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        if(o1.food < o2.food) return -1 ;
        else if(o1.food > o2.food) return 1;
        else return 0;
    }
}
