package top100like.top_fast;

/**
 * Created by lanzehao on 2018/3/5.
 * <p>
 * Description：
 * <p>
 * version：1.0
 * version description：
 * update time：2018/3/5 17:41
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        String repStr = s.replaceAll("\\(\\)","A");
        char[] arr = repStr.toCharArray();
        int longest = 0, curr = 0;
        boolean lastIsValid = false;
        for (char c : arr) {
            if(!lastIsValid){
                curr = 0;
            }
            if(c == 'A'){
                curr++;
                lastIsValid = true;
            }else
                lastIsValid = false;
            if(curr > longest)
                longest = curr;
        }
        return 2 * longest;
    }

    public static void main(String[] args) {
        LongestValidParentheses l = new LongestValidParentheses();
        String s = "(())()())";
        System.out.println(l.longestValidParentheses(s));

//        "()(())";
//        "012345";
//        "020026";
    }
}
