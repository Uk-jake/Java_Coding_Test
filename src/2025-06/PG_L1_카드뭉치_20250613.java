import java.io.*;
import java.security.Key;
import java.util.*;

public class PG_L1_카드뭉치_20250613 {
    public static void main(String[] args) {

        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        System.out.println(solution(cards1, cards2, goal));
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {

        // 카드 뭉치의 인덱스
        int cards1Index = 0;
        int cards2Index = 0;

        // 반복문을 통해서 원하는 카드 배열을 만들 수 있는 지 확인
        for(int i = 0; i < goal.length; i++){

            // 원하는 카드 배열의 인덱스
            String word = goal[i];

            // 원하는 카드 단어를 2개의 카드 뭉치에서 찾을 수 있는지 확인
            // 카드 뭉치에서 찾았다면 인덱스를 하나 증가 시킴
            // 단, 카드 뭉치의 길이보다 인덱스가 높다면 더 이상 찾을 단어가 없다는 것임
            // 2개의 카드 뭉치에서 원하는 단어가 없다면 "No" return
            if( cards1Index < cards1.length && word.equals(cards1[cards1Index])){
                cards1Index++;

            } else if (cards2Index < cards2.length && word.equals(cards2[cards2Index])) {
                cards2Index++;

            } else{
                return "No";
            }
        }

        // for문을 탈출 했을 경우 원하는 카드 배열을 만들 었다는 것.
        return "Yes";
    }
}
