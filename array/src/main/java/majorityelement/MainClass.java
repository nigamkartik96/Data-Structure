package majorityelement;

public class MainClass {
    public static void main(String args[]) {
        MainClass mainClass = new MainClass();
        int a[] = {1, 2, 1, 2};
        System.out.println(mainClass.getMajorityElement(a));
    }

    private int getMajorityElement(int a[]) {

        if (a == null) return -1;
        int majorityElement = a[0], frequency = 1;

        for (int i = 1; i < a.length; i++) {
            if (majorityElement == a[i]) frequency++;
            else if (frequency < 0) {
                majorityElement = a[i];
            } else {
                frequency--;
            }
        }
        if (frequency <= 0) return -1;

        return majorityElement;
    }
}
