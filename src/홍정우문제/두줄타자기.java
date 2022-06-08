package 홍정우문제;

import java.util.Arrays;
import java.util.HashMap;

public class 두줄타자기 {

    public static void main(String[] args){

        /*
        * Input : "Q4OYPI" Output : [0,0,1,0,1,1]
        * Input2 : "64E2" Output2: [1,1,1,0]
        * */

        String input = "Q4OYPI";
        String[] result = typing(input);
        System.out.println("1번 : "+Arrays.toString(result));

        String input2 = "64E2";
        String[] result2 = typing(input2);
        System.out.println("2번 : "+Arrays.toString(result2));


    }

    public static class KeyInit {
        String key;
        int cell;
        int row;
        int defaultLoc;
        public KeyInit(String key, int cell, int row, int defaultLoc){
            this.key = key;
            this.cell = cell;
            this.row = row;
            this.defaultLoc = defaultLoc;
        };
    }

    public String[][] init(){
        String[][] keyboard = new String[2][10];

        KeyInit keyInit = new KeyInit("1",0,0,0);


        keyboard[0][0] = "1";
        keyboard[0][1] = "2";
        keyboard[0][2] = "3";
        keyboard[0][3] = "4";
        keyboard[0][4] = "5";
        keyboard[0][5] = "6";
        keyboard[0][6] = "7";
        keyboard[0][7] = "8";
        keyboard[0][8] = "9";
        keyboard[0][9] = "0";
        keyboard[1][0] = "Q";
        keyboard[1][1] = "W";
        keyboard[1][2] = "E";
        keyboard[1][3] = "R";
        keyboard[1][4] = "T";
        keyboard[1][5] = "Y";
        keyboard[1][6] = "U";
        keyboard[1][7] = "I";
        keyboard[1][8] = "O";
        keyboard[1][9] = "P";

        return keyboard;
    }

    public static String[] typing(String input){

        String[] result = new String[input.length()];

        /*자판기 - 손*/
        HashMap<String, String> typeMap = new HashMap<>();
        typeMap.put("1","0");
        typeMap.put("2","0");
        typeMap.put("3","0");
        typeMap.put("4","0");
        typeMap.put("5","0");
        typeMap.put("Q","0");
        typeMap.put("W","0");
        typeMap.put("E","0");
        typeMap.put("R","0");
        typeMap.put("T","0");
        typeMap.put("6","1");
        typeMap.put("7","1");
        typeMap.put("8","1");
        typeMap.put("9","1");
        typeMap.put("0","1");
        typeMap.put("Y","1");
        typeMap.put("U","1");
        typeMap.put("I","1");
        typeMap.put("O","1");
        typeMap.put("P","1");

        String[] inputArr = input.split("");

        for(int i=0; i< result.length; i++){
            System.out.println("inputArr[i] : "+inputArr[i]);
            result[i] = typeMap.get(inputArr[i]);
        }




        return result;
    }

}
