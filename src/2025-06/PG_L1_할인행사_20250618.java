import java.util.*;

public class PG_L1_할인행사_20250618 {
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

        for (int i = 0; i < want.length; i++) {
            todoList.put(want[i], number[i]);
        }

        // 2. 1일 ~ 10일 할인 상품 초기화
        HashMap<String, Integer> saleList = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            saleList.put(discount[i], saleList.getOrDefault(discount[i], 0) + 1);
        }

        if (todoList.equals(saleList))
            availableDay++;

        // 3. for문 돌면서 구매할 수 있는 날짜 count
        // 정현이가 사야하는 물품은 무조건 10개 이므로 discount.length - 10까지만 순회
        for (int i = 1; i <= discount.length - 10; i++) {

            String removeItem = discount[i - 1];
            String addItem = discount[i + 9];

            saleList.put(removeItem, saleList.get(removeItem) - 1);
            if (saleList.get(removeItem) == 0) {
                saleList.remove(removeItem);
            }

            saleList.put(addItem, saleList.getOrDefault(addItem, 0) + 1);

            if (todoList.equals(saleList)) {
                availableDay++;
            }
        }

        return availableDay;
    }
}
