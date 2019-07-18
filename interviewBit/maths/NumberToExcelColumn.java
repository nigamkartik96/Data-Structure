package maths;

public class NumberToExcelColumn {
    public String convertToTitle(int A) {
        char arr[] = new char[27];
        for (int i = 0; i < 26; i++) arr[i] = (char) (65 + i);


        String name = "";
        int remainder = 0;
        while (A > 0) {
            remainder = A % 26;
            if (remainder == 0) {
                name = 'Z' + name;
                A = (A / 26) - 1;
            } else {
                name = arr[remainder - 1] + name;
                A /= 26;
            }
        }

        return name;
    }

    public static void main(String args[]) {
        NumberToExcelColumn obj = new NumberToExcelColumn();
        System.out.println(obj.convertToTitle(27));
    }
}
