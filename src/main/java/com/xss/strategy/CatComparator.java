package com.xss.strategy;

/**
 * @ClassName DogComarator
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/5/27 8:58 PM
 * @Return
 */
public class CatComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        if(o1.height < o2.height) return 1 ;
        else if(o1.height > o2.height) return -1;
        else return 0;
    }
}
