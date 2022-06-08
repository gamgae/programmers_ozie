package 프린터;

import java.util.ArrayList;
import java.util.LinkedHashMap;

class Solution {
    public static int solution(int[] priorities, int location) {
        int answer = 0;

        LinkedHashMap<Integer,Integer> linkedHashMap = new LinkedHashMap<>();
        for(int i=0; i<priorities.length; i++){
            linkedHashMap.put(i,priorities[i]);
        }

        System.out.println("linkedHashMap ASIS : "+linkedHashMap);

        for(int i=0; i<linkedHashMap.size(); i++){

            for(int j=i; j<linkedHashMap.size(); j++){

                int iKey = (int) getKeyIndex(linkedHashMap,i);
                int iVal = (int) getElementByIndex(linkedHashMap,i);

                int jKey = (int) getKeyIndex(linkedHashMap,j);
                int jVal = (int) getElementByIndex(linkedHashMap,j);

                System.out.println(j+" : "+iKey+", "+iVal+", "+jKey+", "+jVal);

                if(iVal < jVal){
//                    System.out.println(i+" aaaaa");
                    linkedHashMap.remove(iKey);
                    linkedHashMap.put(iKey,iVal);
                    break;
                }
            }

            System.out.println("linkedHashMap TOBE : "+linkedHashMap);

        }


        ArrayList<Integer> tempArr = new ArrayList<>();
        for(int i:linkedHashMap.keySet()){
            int val = linkedHashMap.get(i);
            tempArr.add(val);
        }

        tempArr.get(location);

        return answer;
    }

    public static Object getElementByIndex(LinkedHashMap map, int index){
        return map.get( (map.keySet().toArray())[ index ] );
    }

    public static Object getKeyIndex(LinkedHashMap map, int index){
        Object[] keyArr = map.keySet().toArray();
        return keyArr[index];
    }

    public static void main(String[] args){
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int result = solution(priorities,location);


    }
}