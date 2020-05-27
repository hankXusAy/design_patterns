package com.xss.strategy;


@FunctionalInterface
public interface Comparable<T> {
    int compareTo(T t);
    default void m(){
        System.out.println("m");
    }
}
