package 문자열압축;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    void 문자열압축_테스트() {
        Solution solution = new Solution();
        int result = solution.solution("aabbaccc");
        assertEquals(7,result);
    }

    @Test
    void 문자열압축_테스트_1개짜리문자열() {
        Solution solution = new Solution();
        int result = solution.solution("a");
        assertEquals(1,result);
    }

    @Test
    void 문자열압축_테스트_14개짜리문자열() {
        Solution solution = new Solution();
        int result = solution.solution("abcabcabcabcdededededede");
        assertEquals(14,result);
    }

    @Test
    void 문자열압축_테스트_중복문자열여러개() {
        Solution solution = new Solution();
        int result = solution.solution("aaaaaaaaaaaasss");
        assertEquals(5,result);
    }

}
