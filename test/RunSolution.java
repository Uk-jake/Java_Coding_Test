package test;

import java.io.*;
import java.util.*;

public class RunSolution {
    public static void main(String[] args){

        // 1. 정수 배열 받기
        // 2. 배열의 중복 값 제거
        // 배열 데이터를 내림차순으로 정렬해서 반환하는 solution 함수 구현

        // 입력 4,2,2,1,3,4
        // 출력 4,3,2,1

        // 입력 2,1,1,3,2,5,4
        // 출력 5,4,3,2,1

        // 입력 100000 , -100000
        // 예상 출력 -100000, 100000

        int[] arr = {2,1,1,3,2,5,4};

        System.out.println(Arrays.toString(solutions(arr)));
        System.out.println(Arrays.toString(arr));

        // distinct()를 통해서 중복을 없앨 수 있음.
        int[] distinctArr = Arrays.stream(arr).distinct().toArray();
        System.out.println(Arrays.toString(distinctArr));
    }

    private static int[] solutions(int[] arr){
        // 1. 중복 값 제거
        // arr를 stream으로 변환 후 boxed()를 통해 레퍼런스 타입 Integer로 변경
        // distinct() 메서드로 중복 제거 후 Interger형 배열로 데이터 반환
         Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);

        // 2. 내림차순 정렬
        // sort의 두번째 매개변수에 Collections.reversOrder() 추가하면 내림차순으로 정렬 가능
        Arrays.sort(result);

        // Integer타입의 배열을 프리미티브 타입 int 배열로 변환해서 반환
         return Arrays.stream(result).mapToInt(Integer::intValue).toArray();

    }
}
