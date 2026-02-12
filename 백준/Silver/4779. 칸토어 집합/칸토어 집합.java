import java.util.Scanner;

class Main {
    static char[] arr;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int size = 1;
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                size = size * 3;
            }
            arr = new char[size];
            for (int i = 0; i < size; i++) {
                arr[i] = '-';
            }
            split(0, size - 1, size);
            System.out.println(arr);
        }
    }
    
    public static void split(int start, int end, int size) {
        int part = size/3;
        if (part == 0) return;
        for (int i = start + part; i <= end - part; i++) {
            arr[i] = ' ';
        }
        split(start, start + part-1, part);
        split(end - part + 1, end, part);
    }
}
//--------- // 0, 8, 9
//---   ---
//- -   - -