package serdeser.serdeser;

import java.util.PriorityQueue;

public class TestyIv {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i: nums){
            q.offer(i);

            System.out.println(q.element());
            if(q.size()>k){
                q.poll();
            }
        }

        return q.peek();
    }

    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return null;
        }

        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }


    public boolean sprawdzZlozenie(String word, String[] zbior1, String[] zbior2) {
        boolean result = false;

        for (String word1 : zbior1) {
            for (String word2 : zbior2) {
                if (word1.concat(word2).equals(word)) {
                    result = true;
                }
            }
        }

        return result;
    }

    // Given a center, either one letter or two letter,
// Find longest palindrome
    private String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }

    public static void main(String[] args) {
        TestyIv testyIv = new TestyIv();
        int arr[] = {3,2,1,5,6,4,8};

        int res = testyIv.findKthLargest(arr,2);
        System.out.println("------------");
        System.out.println(res);

        System.out.println("\n\nPALINDROM: " + testyIv.longestPalindrome("srakajak"));

        System.out.println("------------------------------------");
        String word = "cccfff";
        String[] zb1 = {"aaa", "bbb", "ccc"};
        String[] zb2 = {"ddd", "eee", "fff"};

        System.out.println("Zlozenie " + testyIv.sprawdzZlozenie(word, zb1, zb2));
    }
}
