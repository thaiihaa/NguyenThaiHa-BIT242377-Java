import java.util.HashMap;

public class Bai1_HashMap {
    public static void main(String[] args) {
        // Khoi tao HashMap
        HashMap<Integer, String> employeeMap = new HashMap<>();

        // Them nhan vien
        employeeMap.put(101, "Anna");
        employeeMap.put(102, "Peter");
        employeeMap.put(103, "Mary");

        // Lay ten ID 102
        System.out.println("Nhan vien ID 102: " + employeeMap.get(102));

        // Kiem tra 105
        if (!employeeMap.containsKey(105)) {
            employeeMap.put(105, "Unknown");
            System.out.println("Da them ID 105: " + employeeMap.get(105));
        }
    }
}
