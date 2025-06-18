package test;

import java.io.*;
import java.security.Key;
import java.util.*;

public class RunSolution {
    public static void main(String[] args) {

        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};


        System.out.println(solution(want, number, discount));
    }

    public static int solution(String[] want, int[] number, String[] discount) {

        int availableDay = 0;

        // 1. 정현이가 사야하는 물품 HashMap에 초기화
        HashMap<String, Integer> todoList = new HashMap<>();

        // 정현이가 사고 싶은 물품 : 개수 초기화
        for(int i = 0 ; i < want.length ; i++){
            todoList.put(want[i], number[i]);
        }

        // System.out.println(todoList);

        // 2. 1일~10일 할인 상품 초기화
        HashMap<String, Integer> saleList = new HashMap<>();

        for(int i = 0 ; i <  10; i++){
            saleList.put(discount[i], saleList.getOrDefault(discount[i], 0) + 1);
        }

        // System.out.println(saleList);

        // 3. for문 돌면서 구매할 수 있는 날짜 count
        // 정현이가 사야하는 물품은 무조건 10개 이므로 discount.length - 10까지만 순회
        for(int i = 0; i <= discount.length - 10; i++){

            // 할인 상품 update = 전날 상품 지우고 i + 9 상품 넣고
            if( i != 0 ){
                saleList.put(discount[i - 1], saleList.get(discount[i - 1]) - 1);
                saleList.put(discount[i + 9], saleList.getOrDefault(discount[i + 9], 0) + 1);

            }

            // System.out.println("saleList " + i + " : " + saleList);

            // todoList와 saleList가 동일한지 확인

            int equalCount = 0;
            int itemCount = todoList.size();

            // System.out.println(itemCount);
            for( String item : todoList.keySet()){
                if(todoList.get(item).equals(saleList.get(item))){
                    equalCount++;
                }
            }

            if(equalCount == itemCount){
                availableDay++;
            }

        }

        return availableDay;
    }
}
