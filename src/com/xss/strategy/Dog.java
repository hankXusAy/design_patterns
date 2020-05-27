package com.xss.strategy;


/**
 * @ClassName Dog
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/5/27 8:42 PM
 * @Return
 */
public class Dog implements Comparable<Dog>{
    int food;

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }

    @Override
    public int compareTo(Dog o) {
        Dog d = (Dog) o;
        if(this.food < d.food) return -1;
        else if(this.food > d.food) return 1;
        else return 0;
    }
}
