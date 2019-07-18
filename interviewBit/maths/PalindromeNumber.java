package maths;

public class PalindromeNumber {
    public int isPalindrome(int A) {
        if (A < 0) return 0;
        int dup = A, palindrome= 0;
        while (dup != 0) {
            palindrome = palindrome * 10 + dup % 10;
            dup /= 10;
        }
        return palindrome == A ? 1 : 0;
    }

    public static void main(String args[]) {
        PalindromeNumber obj = new PalindromeNumber();

        System.out.println(obj.isPalindrome(121) == 1 ? "Yes" : "No");
    }
}
