package interviewBit.maths;

import java.util.ArrayList;

public class PrimeSum {
    public ArrayList<Integer> primeSum(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean isPrime[] = new boolean[n + 1];
        sieveOfEratosthenes(n, isPrime);

        for (int i = 0; i < n; i++) {
            if (isPrime[i] && isPrime[n - i]) {
                if (list.size() >= 2) {
                    if (list.get(0) <= i && list.get(1) < n - i) {
                        list.set(0, i);
                        list.set(1, n - i);
                    }
                } else {
                    list.add(i);
                    list.add(n - i);
                }
            }
        }

        return list;
    }


    boolean sieveOfEratosthenes(int n, boolean isPrime[]) {
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= n; i++)
            isPrime[i] = true;

        for (int p = 2; p * p <= n; p++) {

            if (isPrime[p] == true) {
                for (int i = p * p; i <= n; i += p)
                    isPrime[i] = false;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        PrimeSum obj = new PrimeSum();
        System.out.println(obj.primeSum(10));
    }
}
