package com.dictionary;

import java.util.Arrays;

public class Main {



    public static void main(String[] args) {
	// write your code here
        int[] numbers = {7,17,25,3,12,10,6,13};

        MergeSort(numbers,0,numbers.length-1);
        System.out.println(Arrays.toString(numbers));
    }

    public static void MergeSort(int A[],int lB,int uB)
    {
        int mid;
        if(lB<uB)
        {
            mid = (lB+uB)/2;
            MergeSort(A,lB,mid);
            MergeSort(A,mid+1,uB);
            Merge(A,lB,mid,uB);
        }
    }

    public static void Merge(int A[],int lB, int mid, int uB)
    {
        int l1 ,l2, i;
        int[] b = new int[100];
        for(l1 = lB,l2 = mid+1, i=lB;l1<=mid&&l2<=uB;i++)
        {
            if(A[l1]<=A[l2])
                b[i] = A[l1++];//[i++] increments i but accesses the array value at[i]
            else
                b[i] = A[l2++];
        }

        while(l1<=mid)
            b[i++] = A[l1++];

        while(l2<=uB)
            b[i++] = A[l2++];

        for(i = lB;i<=uB;i++)
            A[i] = b[i];
    }


}
