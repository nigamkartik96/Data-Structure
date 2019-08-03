package backtracking;

public class Factorial {
    public int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    public static void main(String args[]) {
        Factorial obj = new Factorial();
        System.out.println(obj.factorial(5));
    }
}
