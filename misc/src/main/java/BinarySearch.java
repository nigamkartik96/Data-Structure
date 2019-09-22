public class BinarySearch {
    private int search(int arr[], int num) {
        int end = arr.length - 1, start = 0, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == num) return mid;
            else if (mid + 1 < arr.length && arr[mid + 1] > num) return mid;
            else start = mid + 1;
        }
        return -1;
    }

    private void getResult(int[] healths, int days[], int[] visited) {
        for (int i = 0; i < days.length; i++) {
            int day = days[i], mid = search(healths, day);
            System.out.println(healths[mid] + " " + day + " " + mid);
            for (int j = 0; j <= mid; j++) {
                visited[healths[j]] = visited[healths[j]] != -1 ? visited[healths[j]] : i + 1;
            }
        }
    }

    public static void main(String args[]) {
        BinarySearch obj = new BinarySearch();
        int arr[] = {1, 2, 3};
        int visited[] = {-1, -1, -1, -1};
        int days[] = {2, 2, 3};
        obj.getResult(arr, days, visited);
        for (int i : visited) System.out.println(i);
    }
}
