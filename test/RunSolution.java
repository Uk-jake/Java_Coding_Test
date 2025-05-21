package test;

import java.io.*;
import java.util.*;

public class RunSolution {
    public static void main(String[] args){

        int[] org = {4,2,3,1,5};
        System.out.println("org : " + Arrays.toString(org));

        System.out.println("solutions");

        int[] sorted = solutions(org);
        System.out.println("org :" + Arrays.toString(org));
        System.out.println("sorted :" + Arrays.toString(sorted));
    }

    private static int[] solutions(int[] arr){
        int[] clone = arr.clone();
        Arrays.sort(clone);

        return clone;
    }

}
