package com.sorting;

/**
 * Created by xiexiaodong02 on 2016/8/13.
 */
public class Qsort {

    public static int partition(int[] arr, int start, int end){
        if (start >= end)
            return start;

        int i = start;
        int j = end;

        while (i < j){
            //有两点：
            //1. 因为中轴在start，要先从j开始：否则相遇点肯定是大于中轴值的(这时是不能直接跟start处交换的)
            //2. 为防止本来就是有序或者在中间有跟中轴相同的值，导致j可能越过i到左边，需检查 i<j
            while (arr[j] >= arr[start] && i < j)
                j--;
            while (arr[i] <= arr[start] && i < j)
                i++;
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[start];
        arr[start] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void qSort(int[] arr, int start, int end){
        if (start >= end)
            return;

        int pos = partition(arr, start, end);
        if (start < pos)
            qSort(arr, start, pos-1);
        if (end > pos)
            qSort(arr, pos+1, end);
    }

    public static void main(String[] args){
        int[] arr = new int[]{6, 1, 2, 3, 4, 5, 7, 8, 9, 10};
        qSort(arr, 0, arr.length-1);
        System.out.print(arr);
    }

}
