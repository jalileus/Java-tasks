
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LongestDecreasingSubsequence {

    public static int binarySearch(List<Integer> table, int left, int right, int target) {
        while (right - left > 1) {
            int middle = left + (right - left) / 2;
            if (table.get(middle) > target) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }

    public static void Result(int[] arr, int n) {
        int length = 1;
        List<Integer> indices = new ArrayList<>();
        List<Integer> table = new ArrayList<>();
        int[] parent = new int[n];

        table.add(arr[n - 1]);
        indices.add(n - 1);
        Arrays.fill(parent, -1);

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < table.get(0)) {
                table.set(0, arr[i]);
                indices.set(0, i);
            } else if (arr[i] >= table.get(length - 1)) {
                parent[i] = indices.get(length - 1);
                table.add(arr[i]);
                indices.add(i);
                length++;
            } else {
                int pos = binarySearch(table, -1, length - 1, arr[i]);
                parent[i] = indices.get(pos - 1);
                table.set(pos, arr[i]);
                indices.set(pos, i);
            }
        }
        System.out.println(length);
        int id = indices.get(length - 1);
        while (id != -1) {
            System.out.print(id + 1 + " ");
            id = parent[id];
        }
    }

    public static void main(String[] args) {
        try (Scanner reader = new Scanner(System.in)) {
            int size = reader.nextInt();
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = reader.nextInt();
            }
            Result(array, size);
        }
    }
}
