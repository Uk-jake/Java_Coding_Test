package test;

import java.io.*;
import java.security.Key;
import java.util.*;

public class RunSolution {
    public static void main(String[] args) {

        String[] want = {"banana"};
        int[] number = {10};
        String[] discount = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};

        System.out.println(solution(want, number, discount));
    }

    public static int solution(String[] want, int[] number, String[] discount) {

        int availableDay = 0;

        // 1. 정현이가 사야하는 물품 HashMap에 초기화
        HashMap<String, Integer> todoList = new HashMap<>();

        for(int i = 0 ; i < want.length ; i++){
            todoList.put(want[i], number[i]);
        }

        // System.out.println(todoList);

        // 2. 1일차 부터의 할인 상품 초기화
        HashMap<String, Integer> saleList = new HashMap<>();

        for(int i = 0 ; i <  10; i++){
            saleList.put(discount[i], saleList.getOrDefault(discount[i], 0) + 1);
        }


        // 3. for문 돌면서 구매할 수 있는 날짜 count
        for(int i = 0; i < discount.length; i++){

            // 할인 상품 update = 전날 상품 지우고 i + 9 상품 넣고
            if( i != 0 ){
                saleList.put(discount[i - 1], saleList.get(discount[i - 1]) - 1);

                // i + 9 가 discount.length 넘으면 skip
                if( i + 9 < discount.length){
                    saleList.put(discount[i + 9], saleList.getOrDefault(discount[i], 0) + 1);
                }
            }

            // System.out.println(saleList);

            // saleList에서 todoList를 살 수 있은 지 확인
            int itemCount = todoList.size();
            int tmp = 0;

            for(String item : todoList.keySet()){
                if(saleList.containsKey(item) && saleList.get(item) >= todoList.get(item)){
                    tmp++;
                }
            }

            if(itemCount == tmp){
                availableDay++;
            }

        }

        return availableDay;
    }
}
