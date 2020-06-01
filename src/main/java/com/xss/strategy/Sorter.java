package com.xss.strategy;

/**
 * @ClassName Sorter
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/5/27 8:24 PM
 * @Return
 */
public class Sorter<T> {

    /*如果用double排序还需要再写一个方法,但是如果是Cat呢?*/
    public void sort(T[] arr,Comparator<T>comparator){
//        for (int i = 0; i < arr.length-1; i++) {
//            int minPos = i;
//            for (int j = i+1; j < arr.length; j++) {
//                minPos = arr[j].compareTo(arr[minPos])== -1  ? j : minPos;
//            }
//
//            swap(arr,i,minPos);
//        }
        for (int i = 0; i < arr.length-1; i++) {
            int minPos = i;
            for (int j = i+1; j < arr.length; j++) {
                minPos = comparator.compare(arr[j],arr[minPos])== -1  ? j : minPos;
            }

            swap(arr,i,minPos);
        }
    }

    void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
