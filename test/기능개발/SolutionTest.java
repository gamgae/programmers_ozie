package 기능개발;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static 기능개발.Solution.solution;

public class SolutionTest {

    Solution solution = new Solution();

    @Test
    void solution결과확인1(){
        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};
        int[] result1 = solution(progresses1, speeds1);
        int[] answer1 = {2,1};
        assertEquals(Arrays.toString(answer1),Arrays.toString(result1));
    }

    @Test
    void solution결과확인2(){
        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};
        int[] result2 = solution(progresses2, speeds2);
        int[] answer2 = {1,3,2};
        assertEquals(Arrays.toString(answer2),Arrays.toString(result2));
    }
}
