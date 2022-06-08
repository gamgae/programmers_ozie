package 홍정우문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
현재 상태에서 가장 적은 방을 배정받은 사람일 수록 우선순위 높아진다
현재 배정받은 방의 개수가 똑같다면 배정받은 방과 배정할 방의 거리를 계산하여 거리가 가까울 수록 우선순위가 높아진다
만약 한 사람이 배정받은 방이 여러개일 경우, 그 사람이 배정받은 방 중 새롭게 배정할 방과 가장 가까운 곳에 있는 방
을 기준으로 한다.
만약 거리도 동일 할 경우, 이름 기준 사전순으로 우선순위를 부여한다.
단, 만약 새롭게 배정할 방에 이미 존재하는 인원들은 배정 받을 수 없다.
* */
public class 방배정2 {


    public static void main(String[] args){
        String[] input = {"[403]James", "[404]Azad,Louis,Andy", "[101]Azad,Guard"};
        int target = 403;
        String[] result = solution(input, target);
    }

    public static class Member{
        private String name;
        private ArrayList<Integer> rooms;
        private int mainRoomnum;

        public Member(String name){
            this.name = name;
            this.rooms = new ArrayList<>();
            this.mainRoomnum = 0;
        }
        public void setMainRoomnum(int roomnum){
            this.mainRoomnum = roomnum;
        }

        public int getMainRoomnum(){
            return this.mainRoomnum;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setRooms(ArrayList<Integer> rooms) {
            this.rooms = rooms;
        }

        public void setRoom(int room){
            this.rooms.add(room);
        }

        public String getName() {
            return name;
        }

        public ArrayList<Integer> getRooms() {
            return rooms;
        }

        public String toString(){
            return "보유방 : "+getRooms().toString()+" / 메인방 : "+getMainRoomnum()+"\n";
        }
    }
    private static String[] solution(String[] input, int target) {

        HashMap<String, Member> memberHashMap = new HashMap<String, Member>();
        for(String room:input){
            int roomNum = Integer.parseInt(room.substring(room.indexOf("[")+1,room.indexOf("]")));
            String[] members = room.substring(room.indexOf("]")+1).split(",");
            System.out.println("roomNum "+roomNum);
            for(int i=0; i<members.length; i++) {
                String name = members[i];
                Member member = memberHashMap.getOrDefault(name,new Member(name));
                member.setRoom(roomNum);
                if(member.getMainRoomnum()==0){
                    member.setMainRoomnum(roomNum);
                }else{
                    int temp1 = Math.abs(target - member.mainRoomnum);
                    int temp2 = Math.abs(target - roomNum);

                    if(temp1 > temp2){
                        member.setMainRoomnum(roomNum);
                    }

                }
                memberHashMap.put(name,member);
            }
        }


        System.out.println(memberHashMap);

       // Arrays.sort();

        String[] result = null;

        return result;

    }



}
