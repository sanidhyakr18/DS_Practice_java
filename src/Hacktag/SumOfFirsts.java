package Hacktag;

class Main {

    public static int sumOfFirsts(int arr[]) {
        int i, sum = 0;
        while (true) {
            for (i = 0; i < arr.length; ++i) {
                if (arr[i] != 0)
                    break;
            }
            if (i == arr.length)
                return sum;
            int x = arr[i];
            for (int j = i; j < arr.length; ++j) {
                if (arr[j] < x)
                    break;
                else
                    arr[j] = arr[j] - x;
            }
            sum = sum + x;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {3, 3, 5, 2, 3};

        //function call and print

        System.out.println(sumOfFirsts(numbers));

    }

}