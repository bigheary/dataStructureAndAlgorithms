package com.sorting;

/**
 * Created by xiexiaodong02 on 2016/8/14.
 */
public class MergeSort {
    public static void merge(int[] arr, int start, int mid, int end, int[] temp){
        if (start > end)
            return;
        int i = start;
        int j =mid + 1;
        int pos = start;
        while (i < mid+1 && j < end+1){
            if (arr[i] <= arr[j]){
                temp[pos] = arr[i];
                i++;
            }else{
                temp[pos] = arr[j];
                j++;
            }
            pos++;
        }
        while (i < mid+1){
            temp[pos++] = arr[i++];
        }
        while (j < end+1){
            temp[pos++] = arr[j++];
        }

        for(int t = start; t < end+1; t++){
            arr[t] = temp[t];
        }
    }

    public static void mergeSort(int[] arr, int start, int end, int[] temp){
        if(start >= end){
            return ;
        }

        int mid = (start + end)>>1;
        mergeSort(arr, start, mid, temp);
        mergeSort(arr, mid+1, end, temp);
        merge(arr, start, mid, end, temp);
        return;
    }

    public static void main(String[] args){
        int[] arr = new int[]{6, 1, 2, 5, 4, 3, 9, 7, 10, 8};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, temp);
    }

}
