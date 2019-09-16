import java.util.HashMap;

public class NumberOfSteps {
    public static void main(String args[]) {
        System.out.println(getSteps(5, 0));
    }

    static HashMap<Integer, Integer> map = new HashMap<>();

    static int getSteps(int m, int steps) {
        if (m == steps) return 1;
        if (steps > m) return 0;
        if (!map.containsKey(steps + 1)) map.put(steps + 1, getSteps(m, steps + 1));
        if (!map.containsKey(steps + 2)) map.put(steps + 2, getSteps(m, steps + 2));
        if (!map.containsKey(steps + 3)) map.put(steps + 3, getSteps(m, steps + 3));

        return map.get(steps + 1) + map.get(steps + 3) + map.get(steps + 2);
    }
}
