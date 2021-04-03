package com.xrca.huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[]args)throws Exception{
        BufferedReader shuru = new BufferedReader(new InputStreamReader(System.in));
        String s = shuru.readLine();
        int[] a = new int[128];
        int count=0;
        char b;
        for(int i=0;i<s.length();i++){
            b = s.charAt(i);
            if(a[b]==0){
                count++;
                a[b]=1;
            }
        }
        System.out.println(count);
    }
}
