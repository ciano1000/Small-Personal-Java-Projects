package com.dictionary;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Arrays;

public class Main {

    private static String S = "abppplee";
    private static  String[] dictionary = new String[]{"able","ale","apple","bale","kangaroo","lesson"};

    public static void main(String[] args) {
        Hashtable hashtable = PreProcess(S);
        String subsequence = GetSubsequence();

        System.out.println(subsequence);
    }

    public static String GetSubsequence()
    {
        Hashtable hashtable = PreProcess(S);

        Arrays.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });

        int lastMatchedIndex = 0;
        int subIndex = 0;
        boolean foundSub = false;

        outerloop:for(int i=dictionary.length-1;i>0;i--)
        {
            for(int j=0;j<dictionary[i].length();j++)
            {

                if(hashtable.containsKey(dictionary[i].charAt(j)))
                {
                    int[] indexes = (int[])hashtable.get(dictionary[i].charAt(j));
                    if(j==1)
                    {
                        lastMatchedIndex = indexes[0];
                        foundSub = true;
                    }
                    else
                    {
                        int nextIndex = NextIndex(indexes,lastMatchedIndex);
                        if(nextIndex ==0)
                        {
                            foundSub = false;
                        }
                        foundSub = true;
                        lastMatchedIndex = nextIndex;
                    }
                }
                else
                {
                    foundSub = false;
                    break;
                }

                if((j == dictionary[i].length()-1)&& foundSub ==true)
                {
                    subIndex = i;
                    break outerloop;
                }

            }
        }
        if (foundSub == true)
            return dictionary[subIndex];

        return  "No subsequence found";
    }

    public static Hashtable PreProcess(String s)
    {
        Hashtable hashtable = new Hashtable();

        String charsFound[] = new String[s.length()];

        for(int i=0;i<s.length();i++)
        {
            if(!hashtable.containsKey(s.charAt(i)))
            {
                hashtable.put(s.charAt(i), new int[]{i});
            }
            else
            {
               int[] oldArray =  (int[])hashtable.get(s.charAt(i));
               int[] newArray = new int[oldArray.length+1];
               int j =0;
               for(j=0;j<newArray.length-1;j++)
               {
                   newArray[j] = oldArray[j];
               }
               newArray[j] = i;
               hashtable.put(s.charAt(i),newArray);
            }
        }
        return hashtable;
    }
    public static  int NextIndex(int[] indexes, int lastIndex)
    {
        for(int i =0;i<indexes.length;i++)
        {
            if(indexes[i]>lastIndex)
            {
                return  indexes[i];
            }
            else if (i == indexes.length-1)
            {
                return 0;
            }

        }
        return  0;
    }
}
