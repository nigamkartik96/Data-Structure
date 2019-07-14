package interviewBit;

import java.math.BigInteger;
import java.util.ArrayList;

public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {

        System.out.println(A.toString());
        String string = new BigInteger(A.toString().replaceAll("(, |\\[|\\])", "")).add(BigInteger.ONE).toString();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < string.length(); i++)
            result.add(Integer.parseInt(string.charAt(i) + ""));
        return result;
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);list.add(4);list.add(4);list.add(4);list.add(4);list.add(4);list.add(4);list.add(4);
        list.add(4);list.add(4);list.add(4);list.add(4);list.add(4);list.add(4);list.add(4);list.add(4);list.add(4);

        AddOneToNumber obj = new AddOneToNumber();
        System.out.println(obj.plusOne(list));
    }
}
