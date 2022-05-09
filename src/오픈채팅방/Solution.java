package 오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;

/*
테스트 1 〉	통과 (12.99ms, 88.7MB)
테스트 2 〉	실패 (14.39ms, 83.8MB)
테스트 3 〉	실패 (11.23ms, 72.4MB)
테스트 4 〉	실패 (14.28ms, 77.3MB)
테스트 5 〉	실패 (21.14ms, 94.8MB)
테스트 6 〉	실패 (15.09ms, 83.2MB)
테스트 7 〉	실패 (19.01ms, 99.1MB)
테스트 8 〉	실패 (23.02ms, 77.9MB)
테스트 9 〉	실패 (18.51ms, 89.2MB)
테스트 10 〉	실패 (16.14ms, 84.5MB)
테스트 11 〉	실패 (16.60ms, 81.3MB)
테스트 12 〉	실패 (14.35ms, 70.2MB)
테스트 13 〉	실패 (18.83ms, 80.9MB)
테스트 14 〉	실패 (17.36ms, 93.8MB)
테스트 15 〉	실패 (12.00ms, 79.2MB)
테스트 16 〉	통과 (11.90ms, 81.3MB)
테스트 17 〉	실패 (13.27ms, 78.2MB)
테스트 18 〉	실패 (11.80ms, 74.6MB)
테스트 19 〉	실패 (24.58ms, 76.9MB)
테스트 20 〉	실패 (19.31ms, 85.7MB)
테스트 21 〉	실패 (16.95ms, 76.2MB)
테스트 22 〉	실패 (18.78ms, 75.8MB)
테스트 23 〉	실패 (19.09ms, 83.2MB)
테스트 24 〉	실패 (19.28ms, 89.9MB)
테스트 25 〉	실패 (186.05ms, 179MB)
테스트 26 〉	실패 (165.44ms, 177MB)
테스트 27 〉	실패 (143.51ms, 197MB)
테스트 28 〉	실패 (185.76ms, 167MB)
테스트 29 〉	실패 (174.23ms, 177MB)
테스트 30 〉	실패 (164.44ms, 161MB)
테스트 31 〉	실패 (153.26ms, 165MB)
테스트 32 〉	실패 (144.97ms, 175MB)
* */

public class Solution {
    public String[] solution(String[] record) {

        HashMap<String, String> lastNickNameMap = new HashMap<>();
        ArrayList<HashMap<String,String>> uidHistoryArray = new ArrayList<>();
        for(String raw:record){

            String[] temp = raw.split(" ");/*Enter uid1234 Muzi*/
            String flag = temp[0];
            String uid = temp[1];
            String nickName = "";

            if(!raw.startsWith("Leave")){
                nickName = temp[2];
            }
            lastNickNameMap.put(uid,nickName);

            if(!"Change".equals(flag)){
                uidHistoryArray.add(new HashMap<String,String>(){{
                    put(uid, flag);
                }});
            }
        }


        String[] answer = new String[uidHistoryArray.size()];

        for(int i=0; i<uidHistoryArray.size(); i++){

            String temp = "";
            for(String uid :uidHistoryArray.get(i).keySet()){
                String lastNickName = lastNickNameMap.get(uid);
                String historyFlag = uidHistoryArray.get(i).get(uid);
                temp += lastNickName+"님이 ";
                if("Enter".equals(historyFlag)){
                    temp +="들어왔습니다.";
                }else if("Leave".equals(historyFlag)){
                    temp +="나갔습니다.";
                }
                answer[i] = temp;
            }
        }

        return answer;
    }
}
