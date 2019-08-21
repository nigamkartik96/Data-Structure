/**
 * Given a collection of numbers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * [1,2,3] will have the following permutations:
 * <p>
 * [1,2,3]
 * [1,3,2]
 * [2,1,3]
 * [2,3,1]
 * [3,1,2]
 * [3,2,1]
 * NOTE
 * No two entries in the permutation sequence should be the same.
 * For the purpose of this problem, assume that all the numbers in the collection are unique.
 * Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
 * Example : next_permutations in C++ / itertools.permutations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 */
package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Permutation {
    ArrayList<ArrayList<Integer>> ansList;

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ansList = new ArrayList<>();
        permute(A, 0);
        return ansList;
    }

    public void permute(ArrayList<Integer> intArray, int start) {
        Set<Integer> set = new HashSet<>(); // set checks for repeats
        for (int i = start; i < intArray.size(); i++) {
            if (!set.contains(intArray.get(i))) { // checks repeat array values
                swap(intArray, i, start);
                permute(intArray, start + 1);
                swap(intArray, i, start);
            }
            set.add(intArray.get(i)); // add repeat to the set
        }
        if (start == intArray.size() - 1) {
            ansList.add(new ArrayList<>(intArray));
        }
    }

    public void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static void main(String args[]) {
        Permutation obj = new Permutation();
        ArrayList<Integer> list = new ArrayList(Arrays.asList(1, 2, 3));
        System.out.println(obj.permute(list));
    }
}
