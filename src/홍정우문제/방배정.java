package 홍정우문제;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class 방배정 {

    public static class Member{
        private String name;/*이름*/
        private ArrayList<Integer> myRooms;/*보유한 방*/
        private int suni;/*우선순위*/

        public Member(String name){
            this.name = name;
            this.myRooms = new ArrayList<>();
        }

        public void setMyRooms(int roomNum){
            myRooms.add(roomNum);
        }

        public ArrayList<Integer> getMyRooms(){
            return myRooms;
        }

        public String getName(){
            return name;
        }

        public void downSuni(){
            this.suni = this.suni++;
        }

        public int getSuni(){
            return suni;
        }

        public String toString(){
            return " ["+getSuni()+"] "+myRooms.toString();
        }
    }


    public static String[] solution(String[] input, int target){
        String[] result = null;

        /*방번호 - 입주자 분리 후 human으로 초기화*/
        System.out.println("<input> "+Arrays.toString(input)+", "+target);

        HashMap<String,Member> memberHashMap = new HashMap<String,Member>();
        for(String room:input){
            int roomNum = Integer.parseInt(room.substring(room.indexOf("[")+1,room.indexOf("]")));
            String[] humans = room.substring(room.indexOf("]")+1).split(",");

            for(int i=0; i<humans.length; i++) {
                String name = humans[i];
                Member member = memberHashMap.getOrDefault(name,new Member(name));
                member.setMyRooms(roomNum);
                memberHashMap.put(name,member);
            }
        }

        /*1. 많은 방을 가진 사람의 순위를 낮춘다 */
        System.out.println("memberHashMap : "+memberHashMap);

        HashMap<Integer,ArrayList<String>> memberRooms= new HashMap<>();
        for(String key:memberHashMap.keySet()){
            Member val = memberHashMap.get(key);
            ArrayList<String> hums = memberRooms.getOrDefault(val.getMyRooms().size(),new ArrayList<>());
            hums.add(key);
            memberRooms.put(val.getMyRooms().size(),hums);
        }
        System.out.println("방 보유갯수 : "+memberRooms);

        for(int i:memberRooms.keySet()){
//            System.out.println(memberRooms.get(i).toString());
            for(int j=0; j<memberRooms.get(i).size(); j++){
                System.out.println(memberRooms.get(i).get(j));

              //  memberHashMap.get()

            }
        }

        return result;
    }


    public static void main(String[] args){

        String[] input = {"[403]James", "[404]Azad,Louis,Andy", "[101]Azad,Guard"};
        int target = 403;
        String[] result = solution(input, target);

        /**
         raw [[403]James,Louis, [404]Azad,Louis,Andy, [101]Azad,Guard,Louis]

         1=[James, Guard, Andy, Louis] => 우선순위 높아 (1으ㅟ(
         2=[Azad] => 우선선 (2)

         */
    }
}
