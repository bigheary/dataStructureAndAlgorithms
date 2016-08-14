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
        int[] arr = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        qSort(arr, 0, arr.length-1);
        System.out.print(arr);
    }

}
