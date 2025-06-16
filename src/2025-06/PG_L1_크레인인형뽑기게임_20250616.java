import java.io.*;
import java.security.Key;
import java.util.*;

public class PG_L1_크레인인형뽑기게임_20250616 {
    public static void main(String[] args) {

        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {

        // 1. 주어진 board를 이용해서 board 길이 만큼 Stack으로 인형 쌓기

        // HashMap을 이용하여 board 길이 만큼 Stack 선언
        HashMap<Integer, ArrayDeque<Integer>> hashMap = new HashMap<>();

        for (int i = 1; i <= board.length; i++) {
            hashMap.put(i, new ArrayDeque<>());
        }

        // 2중 for문 사용해서 해당 Stack에 item 넣기
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int item = board[i][j];

                // 0일 경우 item 존재하지 않음.
                if (item != 0) {
                    hashMap.get(j + 1).addFirst(item);
                }
            }
        }

        // 2. moves 배열대로 크레인 움직여서 Stack에 쌓기
        ArrayDeque<Integer> basket = new ArrayDeque<>();
        int removedCount = 0;

        // for문 사용
        for (int location : moves) {
            // 해당 위치의 Stack이 비어있을 경우 아무 동작 않함.
            if (!hashMap.get(location).isEmpty()) {

                int pickedItem = hashMap.get(location).pollLast();

                // 바구니 stack의 맨위와 뽑은 item이 동일할 경우 삭제
                if (!basket.isEmpty() && basket.peekLast() == pickedItem) {
                    basket.pollLast();
                    removedCount = removedCount + 2;
                } else {
                    basket.addLast(pickedItem);
                }
            }
        }

        return removedCount;
    }
}