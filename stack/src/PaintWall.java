import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class PaintWall {
    class Paint {
        int colorNumber;
        int height;

        Paint(int colorNumber, int height) {
            this.colorNumber = colorNumber;
            this.height = height;
        }
    }

    private int getDistinct(int heights[], int colors[]) {
        Stack<Paint> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && stack.peek().height <= heights[i]) {
                stack.pop();
            }
            stack.push(new Paint(colors[i], heights[i]));
        }

        HashSet<Integer> distinct = new HashSet<>();
        while (!stack.isEmpty()) {
            distinct.add(stack.pop().colorNumber);
        }

        return distinct.size();
    }

    public static void main(String args[]) {
        PaintWall obj = new PaintWall();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            int n = sc.nextInt(), m = sc.nextInt(), heights[] = new int[n], colors[] = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                colors[i] = sc.nextInt();
            }
            System.out.println(obj.getDistinct(heights, colors));
        }
    }

}
