package com.mycompany.baitapluyen12;

// 1. Định nghĩa Functional Interface
@FunctionalInterface
interface MathOperation {
    int compute(int a, int b);
}

public class MathApp {
    public static void main(String[] args) {
        // 2. Triển khai các phép tính bằng Lambda Expression
        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation division = (a, b) -> (b != 0) ? a / b : 0;

        // 3. Chạy thử và in kết quả
        int num1 = 20;
        int num2 = 5;

        System.out.println("=== KẾT QUẢ BÀI 1 ===");
        System.out.println(num1 + " + " + num2 + " = " + addition.compute(num1, num2));
        System.out.println(num1 + " - " + num2 + " = " + subtraction.compute(num1, num2));
        System.out.println(num1 + " * " + num2 + " = " + multiplication.compute(num1, num2));
        System.out.println(num1 + " / " + num2 + " = " + division.compute(num1, num2));
    }
}
