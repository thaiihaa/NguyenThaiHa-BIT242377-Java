public class Bai1 {
    // Phuong thuc tinh printArray su dung Generic E
    public static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Mang Integer
        Integer[] intArray = {1, 2, 3, 4, 5};
        // Mang String
        String[] stringArray = {"Java", "Maven", "NetBeans"};

        System.out.print("Mang so nguyen: ");
        printArray(intArray);

        System.out.print("Mang chuoi: ");
        printArray(stringArray);
    }
}