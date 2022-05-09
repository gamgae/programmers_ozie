package 오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;
/*
테스트 1 〉	통과 (11.84ms, 80MB)
테스트 2 〉	통과 (9.99ms, 75MB)
테스트 3 〉	통과 (10.20ms, 81.6MB)
테스트 4 〉	통과 (10.44ms, 82.9MB)
테스트 5 〉	통과 (13.16ms, 76.5MB)
테스트 6 〉	통과 (16.35ms, 84.6MB)
테스트 7 〉	통과 (15.16ms, 95MB)
테스트 8 〉	통과 (15.21ms, 91.5MB)
테스트 9 〉	통과 (14.10ms, 86.7MB)
테스트 10 〉	통과 (14.91ms, 82.2MB)
테스트 11 〉	통과 (14.90ms, 81.1MB)
테스트 12 〉	통과 (14.98ms, 81.8MB)
테스트 13 〉	통과 (13.18ms, 82.7MB)
테스트 14 〉	통과 (14.57ms, 81.5MB)
테스트 15 〉	통과 (10.66ms, 76.4MB)
테스트 16 〉	통과 (9.92ms, 79.8MB)
테스트 17 〉	통과 (10.34ms, 79.5MB)
테스트 18 〉	통과 (11.97ms, 80.9MB)
테스트 19 〉	통과 (16.66ms, 80.1MB)
테스트 20 〉	통과 (13.75ms, 85.3MB)
테스트 21 〉	통과 (12.73ms, 87.5MB)
테스트 22 〉	통과 (13.21ms, 81.6MB)
테스트 23 〉	통과 (14.10ms, 81.5MB)
테스트 24 〉	통과 (14.57ms, 81.7MB)
테스트 25 〉	통과 (109.08ms, 173MB)
테스트 26 〉	통과 (119.12ms, 166MB)
테스트 27 〉	통과 (142.99ms, 184MB)
테스트 28 〉	통과 (154.21ms, 179MB)
테스트 29 〉	통과 (135.96ms, 188MB)
테스트 30 〉	통과 (109.52ms, 179MB)
테스트 31 〉	통과 (144.63ms, 192MB)
테스트 32 〉	통과 (111.30ms, 162MB)
* */

public class Solution2 {
    public String[] solution(String[] record) {
        HashMap<String, String> lastNickNameMap = new HashMap<>();
        for(String raw:record){

            if(raw.startsWith("Enter") || raw.startsWith("Change")){
                String[] temp = raw.split(" ");/*Enter uid1234 Muzi*/
                String uid = temp[1];
                String nickName = temp[2];
                lastNickNameMap.put(uid,nickName);
            }
        }
        ArrayList<String> recordArr = new ArrayList<>();
        for(String raw:record){
            if(raw.startsWith("Enter") || raw.startsWith("Leave")){
                String tempRecord = "";
                String[] temp = raw.split(" ");/*Enter uid1234 Muzi*/
                String flag = temp[0];
                String uid = temp[1];
                String nickName = lastNickNameMap.get(uid);

                if("Enter".equals(flag)){
                    tempRecord+=nickName+"님이 들어왔습니다.";
                } else if ("Leave".equals(flag)) {
                    tempRecord+=nickName+"님이 나갔습니다.";
                }
                recordArr.add(tempRecord);
            }
        }

        String[] answer = recordArr.stream().toArray(String[]::new);
        return answer;

    }
}
