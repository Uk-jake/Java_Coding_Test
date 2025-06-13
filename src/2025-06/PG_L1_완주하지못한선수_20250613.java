import java.util.*;

public class PG_L1_완주하지못한선수_20250613 {
    public static void main(String[] args) {

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {

        // 1. HashMap 선언 및 participant 추가
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(String participatedName : participant){

            // hashMap에 이름이 존재하면 동명이인이므로 value 값 1 증가
            // hashMap.put(participatedName, hashMap.getOrDefault(participatedName, 0) + 1);
            if(hashMap.containsKey(participatedName)){
                int number = hashMap.get(participatedName);
                number++;
                hashMap.put(participatedName, number);

                // 이름이 존재하지 않으면 value 값 1로 put
            }else{
                hashMap.put(participatedName, 1);
            }
        }

        System.out.println(hashMap);

        // 2. HashMap에 completion 있는지 확인
        for(String completedName : completion){

            if(hashMap.containsKey(completedName)){
                int value = hashMap.get(completedName);

                if(value == 1){
                    hashMap.remove(completedName);
                }else{
                    value--;
                    hashMap.put(completedName, value);
                }

            }
        }

        for(String name : hashMap.keySet()){
            return name;
        }

        return "";
    }
}
