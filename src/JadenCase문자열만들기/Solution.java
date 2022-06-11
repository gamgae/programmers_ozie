package JadenCase문자열만들기;
/*
function solution(s) {
    return s.split(' ').map(word => {
        if (!word[0]) return;
        return word[0].toUpperCase() + word.slice(1).toLowerCase()
    }).join(' ');
}
* */
public class Solution {

    public static String solution(String s) {

        String answer = "";
        String[] temp = s.split(" ");

        for(int i=0; i<temp.length; i++){

//            System.out.println(i+" : "+temp[i]);

            if("".equals(temp[i])){
                answer +=" ";
            }else{
                String firstLetter = String.valueOf(temp[i].charAt(0));
                boolean isNumeric =  firstLetter.matches("[+-]?\\d*(\\.\\d+)?");
                if(isNumeric){
                    if(i!=0){
                        answer += " ";
                    }
                    answer += temp[i].toLowerCase();
                }else{
                    String upperFirstLetter = firstLetter.toUpperCase();
                    String last = temp[i].substring(1).toLowerCase();
                    if(i!=0){
                        answer += " ";
                    }
                    answer += upperFirstLetter+last;
                }

            }
        }

        if(s.length() != answer.length()){
            int a = s.length() - answer.length();
            for(int i=0;i<a; i++){
                answer+=" ";
            }
        }

        return answer;
    }

    public static void main(String[] args){

        String s = "3PEOPLE 4unFollowed me      ";
        //"3people Unfollowed Me"
        String r = solution(s);
        System.out.println(r);
        System.out.println("##############");

    }

}
