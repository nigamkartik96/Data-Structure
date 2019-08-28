public class HeapSort {
    public static void main(String args[]) {
        HeapSort obj = new HeapSort();
        int arr[] = {5, 4, 3, 2, 1};
        obj.heapSort(arr);
        obj.print(arr);
    }

    public void heapSort(int arr[]) {
        int low = 0, high = arr.length;
        while (low < high) {
            heapify(arr, low, high);
            swap(arr, low, high - 1);
            high--;
        }
    }

    public void heapify(int arr[], int low, int high) {
        for (int i = high; i > low; i--) {
            int left = i * 2, right = i * 2 + 1;
            if (left <= high && right > high) {
                if (arr[left - 1] > arr[i - 1]) swap(arr, i - 1, left - 1);
            } else if (left > high && right <= high) {
                if (arr[right - 1] > arr[i - 1]) swap(arr, i - 1, right - 1);
            } else if (left <= high && right <= high) {
                if (arr[left - 1] > arr[i - 1] || arr[right - 1] > arr[i - 1]) {
                    swap(arr, i - 1, arr[left - 1] > arr[right - 1] ? left - 1 : right - 1);
                }
            }
        }
        return;
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
