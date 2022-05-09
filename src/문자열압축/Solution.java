package 문자열압축;

public class Solution {
    public int solution(String s) {
        int result = 0;
        int nextIdx = 0;
        int corr = 1;

        if(s.length()==1) return 1;

        for(int range=1; range<=s.length()/2; range++){

            String tempStr = "";
            for(int cursorIdx=0; cursorIdx+range<=s.length(); cursorIdx=nextIdx){
                nextIdx = cursorIdx+range;
                String cursorStr = s.substring(cursorIdx,cursorIdx+range);
                String nextStr = s.substring  (nextIdx, Math.min((nextIdx + range), s.length()));

                if(cursorStr.equals(nextStr)){
                    corr ++;
                }else{
                    tempStr += (corr==1?"":corr)+cursorStr;
                    corr = 1;
                }

                if((nextIdx+range)>s.length()){
                    tempStr += nextStr;
                }
            }
            System.out.println("tempStr / range="+range+" / length="+tempStr.length()+" / tempStrRaw="+tempStr);

            if(range==1){
                result = tempStr.length();
            } else if (range!=1 && (result>tempStr.length())) {
                result = tempStr.length();
            }
        }

        System.out.println("+++++++++++++++++++++++++++++++++++++");
        System.out.println(result);
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        return result;
    }
}