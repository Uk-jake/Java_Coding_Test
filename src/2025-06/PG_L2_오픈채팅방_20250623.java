import java.util.*;

public class PG_L2_오픈채팅방_20250623 {
    public static void main(String[] args) {

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

        System.out.println(Arrays.toString(solution(record)));
    }

    public static String[] solution(String[] record) {

        // 1. Map <id:nickname> + List Map 선언 (입출입 기록)
        HashMap<String, String> nickname = new HashMap<>();
        ArrayList<Map<String, String>> entryList = new ArrayList<>();

        for (String item : record) {
            String[] tmp = item.split(" ");

            if (tmp[0].equals("Enter")) {
                nickname.put(tmp[1], tmp[2]);

                HashMap<String, String> account = new HashMap<>();
                account.put(tmp[1], tmp[0]);
                entryList.add(account);

            } else if (tmp[0].equals("Leave")) {
                HashMap<String, String> account = new HashMap<>();
                account.put(tmp[1], tmp[0]);
                entryList.add(account);

            } else if (tmp[0].equals("Change")) {
                nickname.put(tmp[1], tmp[2]);
            }
        }

        // 2. entryList 대로 출력
        ArrayList<String> answer = new ArrayList<>();

        for (Map<String, String> item : entryList) {

            for (String resultNickname : item.keySet()) {
                String condition = item.get(resultNickname);

                if (condition.equals("Enter")) {
                    String tmp = nickname.get(resultNickname) + "님이 들어왔습니다.";
                    answer.add(tmp);

                } else {
                    String tmp = nickname.get(resultNickname) + "님이 나갔습니다.";
                    answer.add(tmp);

                }
            }
        }

        // List를 String[] 변환 후 출력
        return answer.toArray(new String[0]);
    }
}
