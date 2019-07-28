public class PartyToys {

    public int findDamagedToy(int n, int t, int d) {
        if (n == 0 || t == 0) return -1;
        t = t + d - 1;
        t = t % n;
        return t == 0 ? n : t;
    }

    public static void main(String args[]) {
        PartyToys obj = new PartyToys();
        System.out.println(obj.findDamagedToy(5, 9, 5));
    }
}
