package com.xss.strategy;

/**
 * @ClassName Cat
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/5/27 8:33 PM
 * @Return
 */
public class Cat implements Comparable<Cat>{
    int width,height;

    public Cat(int width, int height) {
        this.width = width;
        this.height = height;
    }
//    public int compareTo(Cat c){
//        if(this.width < c.width) return -1;
//        else if(this.width > c.width) return 1;
//        else return 0;
//    }
//
    @Override
    public String toString() {
        return "Cat{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    @Override
    public int compareTo(Cat o) {
        Cat c = (Cat)o;
        if(this.width < c.width) return -1;
        else if(this.width > c.width) return 1;
        else return 0;
    }
}
