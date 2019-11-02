package basic;

import java.util.Scanner;

/**
 * @author mtreellen
 * @date 2019-10-21-18:55
 */
public class LoopTest {
    public static void main(String[] args) {
//        endlessLoop();
//        printRightTriangle();
//        printRightTriangle1();
//        multiplication();
//        guessTheNumber();
        forLoopTest();
        forLoopTest1();
    }
    public static boolean show(char ch) {
        System.out.print(ch);
        return true;
    }

    public static void forLoopTest() {
        int x = 1;
        for (show('a'); show('b') && x < 3; show('c')) {
            show('d');
            x++;
        }
    }
    public static boolean foo(char c){
        System.out.println(c);
        return true;
    }
    public static void forLoopTest1(){
        int i = 0;
        for (foo('A'); foo('B') && (i < 2); foo('C')) {
            i++;// 1 2
            foo('D');
        }
    }
    public static void endlessLoop(){
        int i = 10;
        while(i > 0){
            i = i + 1;
            if(i == 10){
                break;
            }
        }
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(i);//-2147483648
    }

    public static void printRightTriangle(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input the height of the right triangle > ");
        int height = scanner.nextInt();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("#\t");
            }
            System.out.println();
        }
    }
    public static void printRightTriangle1(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input the height of the right triangle > ");
        int height = scanner.nextInt();
        for (int i = 0; i < height; i++) {
            for (int j = height; j > i ; j--) {
                System.out.print("#\t");
            }
            System.out.println();
        }
    }

    /**
     * Print the multiplication
     */
    public static void multiplication(){
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " * " + i + " = " + i * j + "\t");
            }
            System.out.println();
        }
    }

    /**
     *  Notice users input a number to guess if equals the right key number
     *  give her some tips until she input the right answer.
     */
    public static void guessTheNumber() {
        int key = (int) (Math.random() * 99 + 1);
        int count = 0;
        while(true) {
            System.out.print("请输入您猜的数字[0~100]：");
            Scanner scanner = new Scanner(System.in);
            int guess = scanner.nextInt();
            count++;
            if(guess > key){
                System.out.println("大了");
            }else if( guess < key){
                System.out.println("小了");
            }else{
                break;
            }
        }
        System.out.println("恭喜您，猜对了！！！！\n正确答案为" + key + " " + "您一共猜了" + count + "次。");
    }
}
class Looptest1{
    public static void main(String[] args) {
//        printPerfectNumber();
//        System.out.println(greatestCommonDivisor(4, 13));
//        System.out.println(lowestCommonMultiple(4, 13));
//        test4();
//        test5();
//        test6();
        printPrimeNumber();
//        printNarcissisticNumber();
    }

    /**
     * Print the number from 1 to 1000 that is exactly equal to the sum of its factors : Perfect Number
     */
    public static void printPerfectNumber(){
        for (int i = 1; i <= 1000 ; i++) {
            int sum = 0;
            for (int j = 1; j < i; j++) {
                if(i % j == 0){
                    sum += j;
                }
            }
            if(i == sum){
                System.out.print(i + " ");
            }
        }
    }

    /**
     * Print the greatest common divisor of x and y
     * @param x
     * @param y
     * @return : The greatest common divisor of x and y
     */
    public static int greatestCommonDivisor(int x, int y){
        int min = (int)Math.min(x, y);
        boolean flag = false;
        int res = 0;
        for (int i = min; i >= 1; i--) {
            if(x % i == 0 && y % i == 0){
                flag = true;
                res = i;
                break;
            }
        }
        if(flag){
            return res;
        }else{
            return 1;
        }
    }

    /**
     * Print the lowest common multiple of x and y
     * @param x
     * @param y
     * @return : The lowest common multiple of x and y
     */
    public static int lowestCommonMultiple(int x, int y){
        int max = (int)Math.max(x, y);
        int res = 0;
        for (int i = max;; i++) {
            if (i % x == 0 && i % y == 0) {
                res = i;
                break;
            }
        }
        return res;
    }

    public static void test4(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 2; i >= 0; i--) {
            for (int j = 2 * i + 1; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void test5(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 4; i > 0; i--) {
            for (int j = 0; j <= 4 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void test6(){
        //TODO:
        for (int i = 0; i < 6; i++) {
            System.out.println();
            for (int j = 0; j < 5 - i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < 2 * i; j++) {
                if(i < 5) {
                    System.out.print(" ");
                }
            }
            for (int j = 0; j < 5 - i; j++) {
                System.out.print("*");
            }
//            if(i < 5) {
//                System.out.println();
//            }
        }
        int tmp = 6;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i + 2; j++) {
                System.out.print("*");
            }
            for (int j = 1; j <= tmp; j++) {
                System.out.print(" ");
            }
            tmp -= 2;
            for (int j = 0; j < i + 2; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * Print prime number.
     */
    public static void printPrimeNumber() {
        //Count how many prime numbers between 100 and 200 have.
        int count = 0;
        for (int i = 100; i <= 200; i++) {
            int j = 1;
            for (j = 2; j < i; j++) {
                if (i % j == 0) {
                    break;
                }
            }
            //j == i || i % j == 0
            //There are two situations : first is because j divisible i shows i is not a prime number
            //second is because i can not be divisibled by any numbers between 2 and i - 1, show i is a prime number
            //The second situation is what we are lonking for ,so should print it, in this situation, j equals i.
            if (j >= i) {
                count++;
                System.out.print(i + " ");
            }
        }
        System.out.println("\nThere are " + count + " prime numbers between 100 and 200.");
    }

    /**
     * Optimization the program for print prime number
     */
    public static void printPrimeNumeber1(){
        //Count how many prime numbers between 100 and 200 have.
        int count = 0;
        for (int i = 100; i <= 200; i++) {
            int j = 1;
            //Reduce the number of cycles, the effect is the same as cycle (i - 2) times, but saved time.
            for (j = 2; j < (int)Math.sqrt(i); j++) {
                if (i % j == 0) {
                    break;
                }
            }
            //j == i || i % j == 0
            //There are two situations : first is because j divisible i shows i is not a prime number
            //second is because i can not be divisibled by any numbers between 2 and i - 1, show i is a prime number
            //The second situation is what we are lonking for ,so should print it, in this situation, j equals i.
            if (j >= i) {
                count++;
                System.out.print(i + " ");
            }
        }
        System.out.println("\nThere are " + count + " prime numbers between 100 and 200.");
    }

    /**
     * 吸血鬼数字
     * Print Vampire number.
     * Vampire number refers to the number of even digits,
     * which can be obtained by multiplying a pair of digits.
     * Each pair of digits contains half digits of the product,
     * and the numbers selected from the initial number can be sorted arbitrarily.
     * PS: Numbers ending with two zeros are not allowed.
     * For example : 1260 == 21 * 60; 1827 == 21 * 87
     */
    public static void printVampireNumber(){
        //TODO: print vampire number
    }

    /**
     * Print narcissistic number all three digit number.
     */
    public static void printNarcissisticNumber() {
        for (int i = 100; i < 1000; i++) {
            int a = 0;
            int b = 0;
            int c = 0;
            i /= 100;
            i /= 10 % 10;
            i %= 10;
            // If the number's  equals one digit cube plus ten digit cube plus hundred digit cube.
            // print this number.
            if (i == a * a * a + b * b * b + c * c * c) {
                System.out.print(i + " ");
            }
        }
    }
}
class LoopTest2{
    public static void main(String[] args) {
//        test1();
        countEvenNumberandOddNumber();
        triangle();
    }
    public static void test1(){
        String mark = "690123456789";
        char[] chars = mark.toCharArray();
        int evenNumSum = 0;
        int oddNumSum = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] % 2 == 0){
                evenNumSum += (chars[i] - 48);
            }else{
                oddNumSum += (chars[i] - 48);
            }
        }
        int num1 = oddNumSum + evenNumSum * 3;
        System.out.println(num1);
        int num2 = num1 % 10;
        int key = 0;
        if(num2 != 0){
            key = 10 - num2;
        }
        System.out.println(evenNumSum);
        System.out.println(oddNumSum);
        System.out.println(num2);
        System.out.println(mark + key);
    }
    public static void countEvenNumberandOddNumber(){
        int evenNum = 0;
        int oddNum = 0;
//        char[] chars = new char[4];
        int[] arr = new int[4];
        for (int i = 1000; i < 10000; i++) {
            evenNum = oddNum = 0;
            int a = i / 1000;
            int b = i % 1000 / 100;
            int c = i % 100 / 10;
            int d = i % 10;
            System.out.println(a + "" + b + "" + c + "" + d);
            for (int j = 0; j < arr.length; j++) {
                arr[0] = a;
                arr[1] = b;
                arr[2] = c;
                arr[3] = d;
                if(arr[j] % 2 == 0){
                    evenNum++;
                }else{
                    oddNum++;
                }
            }
            System.out.println(i + "的偶数有" + evenNum + "个，奇数有" + oddNum + "个。");
        }
    }

    public static void triangle(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入第一条边：");
        double length1 = scanner.nextDouble();
        System.out.print("请输入第二条边：");
        double length2 = scanner.nextDouble();
        System.out.print("请输入第三条边：");
        double length3 = scanner.nextDouble();

        if(isTriangle(length1, length2, length3)){
            if(length1 == length2 && length2 == length3){
                System.out.println("等边三角形，面积为：" + findArea(length1, length2, length3));
            }else if(length1 == length2 || length1 == length3 || length2 == length3){
                if(isRightTriangle(length1, length2, length3)){
                    System.out.println("等腰直角三角形，面积为：" + findArea(length1, length2, length3));
                }
                System.out.println("等腰三角形，面积为：" + findArea(length1, length2, length3));
            }else if(isRightTriangle(length1, length2, length3)){
                System.out.println("直角三角形，面积为：" + findArea(length1, length2, length3));
            }else{
                System.out.println("普通三角形，面积为：" + findArea(length1, length2, length3));
            }
        }else{
            System.out.println("不构成三角形");
        }


    }
    public static boolean isTriangle(double x, double y, double z){
        if(x + y > z && x + z > y && y + z > x){
            return true;
        }else{
            return false;
        }
    }
    public static double findArea(double x, double y, double z){
        if(!(isTriangle(x, y, z))){
            throw new RuntimeException("不构成三角形");
        }
        double perimeter = x + y + z;
        double s = perimeter / 2;
        double area = Math.sqrt(s * (s - x) * (s - y) * (s - z));
        return area;
    }
    public static boolean isRightTriangle(double x, double y, double z){
        if(!(isTriangle(x, y, z))){
            throw new RuntimeException("不构成三角形");
        }
        double a = Math.sqrt(x * x + y * y);
        double b = Math.sqrt(x * x + z * z);
        double c = Math.sqrt(z * z + y * y);
        if(x == c || y == b || z == a){
            return true;
        }else{
            return false;
        }
    }
}
