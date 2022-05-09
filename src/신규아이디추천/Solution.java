package 신규아이디추천;

public class Solution {
    /*

new_id는 알파벳 대문자, 알파벳 소문자, 숫자, 특수문자로 구성되어 있습니다.
new_id에 나타날 수 있는 특수문자는 -_.~!@#$%^&*()=+[{]}:?,<>/ 로 한정됩니다.

3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

    * */

    public String solution(String new_id) {
        String answer = "";
        System.out.println("new_id : "+new_id);




        return step1(new_id);
    }

    public String step1(String inputId){
        /*1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.*/
        String outputId = "";
        outputId = inputId.toLowerCase();
        System.out.println("outputId_step1 : "+outputId);
        return outputId;
    }

    public String step2(String inputId){
        /*2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.*/
        /* 들어갈 수 있는 문자열 -_.~!@#$%^&*()=+[{]}:?,<>/ */
        String outputId = "";
        String[] whiteList = {"-","_","."};
        inputId.replaceAll("!","");

        return outputId;
    }
}