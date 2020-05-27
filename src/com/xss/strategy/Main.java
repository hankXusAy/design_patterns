package com.xss.strategy;

import java.util.Arrays;

/**
 * @ClassName Main
 * @Description 策略模式
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/5/27 8:49 PM
 * @Return
 **/
public class Main {

    public static void main(String[] args) {
        int[] a = {1,3,7,4,54,8,9,2};
        Sorter sorter = new Sorter<Dog>();
        Sorter catSorter = new Sorter<Cat>();
        Cat c1 = new Cat(1,1);
        c1.m();
        Dog dog = new Dog(3);
        dog.m();
        Cat c2 = new Cat(4,4);
        Cat c3 = new Cat(3,3);
        Cat[] cats = new Cat[]{c1,c2,c3};
        //Dog[] dogs = new Dog[]{new Dog(3),new Dog(1),new Dog(8),new Dog(2)};
        sorter.sort(cats,new CatComparator());
        //System.out.println(Arrays.toString(cats));


    }
}
