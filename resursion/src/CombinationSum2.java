import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CombinationSum2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- != 0) {
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }
            Collections.sort(arr);
            int value = sc.nextInt();
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            recurse(arr, list, new ArrayList<>(), value, 0);

            //  ArrayList<ArrayList<Integer>> l = new ArrayList<>(list);

            if (list.size() == 0)
                System.out.println("Empty");

            else {
                String s = "";
                for (ArrayList<Integer> sub : list) {
                    String s2 = "";
                    //  ArrayList<Integer> sub = list.get(i);
                    for (int j = 0; j < sub.size(); j++) {
                        if (j != sub.size() - 1) s2 += sub.get(j) + " ";
                        else s2 += sub.get(j);
                    }
                    s += "(" + s2 + ")";
                }
                System.out.println(s);
            }
        }
    }

    public static void recurse(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> sub, int value, int index) {
        if (value == 0) {
            list.add(new ArrayList<>(sub));
            return;
        }
        if (value < 0) return;
        int prev = -1;
        for (int i = index; i < arr.size(); i++) {
            if (prev != arr.get(i)) {
                sub.add(arr.get(i));
                recurse(arr, list, sub, value - arr.get(i), i + 1);
                sub.remove(sub.size() - 1);
                prev = arr.get(i);
            }
        }
    }
}
