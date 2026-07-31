import java.util.Scanner;
public class Ex4 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);


            System.out.print("Enter the number of elements: ");
            int n = scanner.nextInt();

            int[] arr = new int[n];

            System.out.println("Enter the elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            insertionSort(arr);
            System.out.println("Final sorted list: ");
            for (int i : arr) {
                System.out.print(i + " ");
            }
        }

        public static void insertionSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }

                arr[j + 1] = key;

                System.out.println("Step " + i + ": " + arrayToString(arr));
            }
        }

        public static String arrayToString(int[] arr) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
                if (i < arr.length - 1) {
                    sb.append(" ");
                }
            }
            return sb.toString();
        }
    }


