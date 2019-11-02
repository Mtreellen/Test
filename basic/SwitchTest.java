package basic;

import java.util.Scanner;
import java.util.Vector;

/**
 * @author mtreellen
 * @date 2019-10-20-9:16
 */
public class SwitchTest {
    public static void main(String[] args) {
//        dayOfTheYear();
//        determineSeason();
//        solutionOfQuadraticEquationOfOneVariable();
    }

    /**
     * Find the maximum of the three numbers.
     * Users input three numbers.
     */
    public static void findMax(){
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("请依次输入三个整数：");
        int i = 1;
        while(i<=3){
            System.out.print("请输入第" + i++ + "个整数：");
            try{
                arr[i - 2] = scanner.nextInt();//i = 2
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        if(arr[0] <= arr[1]){
            if(arr[2] <= arr[0]){
                System.out.println(arr[2] + " " + arr[0] + " " + arr[1]);
            }else if(arr[1] <= arr[2]){
                System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
            }else{
                System.out.println(arr[0] + " " + arr[2] + " " + arr[1]);
            }
        }else{
            if(arr[2] < arr[1]){
                System.out.println(arr[2] + " " + arr[1] + " " + arr[0]);
            }else if(arr[0] < arr[2]){
                System.out.println(arr[1] + " " + arr[0] + " " + arr[2]);
            }else{
                System.out.println(arr[1] + " " + arr[2] + " " + arr[0]);
            }
        }
    }

    public static void dayOfTheYear(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要查询的年份：");
        int year = scanner.nextInt();
        System.out.print("请输入要查询的月份：");
        int month = scanner.nextInt();
        System.out.print("请输入要查询的号数：");
        int day = scanner.nextInt();

        int days = day;
        switch(month){
            case 12:
                days += 30;
            case 11:
                days += 31;
            case 10:
                days += 30;
            case 9:
                days += 31;
            case 8:
                days += 31;
            case 7:
                days += 30;
            case 6:
                days += 31;
            case 5:
                days += 30;
            case 4:
                days += 31;
            case 3:
                if((year % 4 == 0 && year % 100 != 0) || year % 400 ==0){
                    days += 29;
                }else{
                    days += 28;
                }
            case 2:
                days += 31;
//            case 1:
//                days = day;
        }
        System.out.println("今天是" + year + "年的第" + days + "天");
    }
    public static void determineSeason(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入月份：");
        int input = scanner.nextInt();
        switch(input){
            case 3:
            case 4:
            case 5:
                System.out.println("Spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Summer");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Autumn");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println("Winter");
                break;
            default:
                System.out.println("非法月份");
                break;
        }
    }
    public static void solutionOfQuadraticEquationOfOneVariable(int a, int b, int c){
        int value = (int)Math.sqrt(b * b - 4 * a * c);
        if(value >= 0){
            if(value == 0){
                int res = -(b / (2 * a));
                System.out.println("x1 = x2 = " + res);
            }else{
                int x1 = (-b + value)/ (2 * a);
                int x2 = (-b - value)/ (2 * a);
                System.out.println("x1 = " + x1 + ", x2 = " + x2);
            }
        }else{
            System.out.println("实数范围内无解");
        }
    }
}
class ScoreTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector v = new Vector();
        int maxScore = 0;
        for (;;) {
            System.out.println("请输入学生成绩，输入负数表示结束。");
            int score = sc.nextInt();
            if(score < 0){
                break;
            }
            if(score > 100){
                System.out.println("输入非法成绩");
                continue;
            }
            /*
            JDK5.0 之前：
            Integer integer = new Integer(score);
            v.addElement(score);
             */
            //JDK5.0之后，自动装箱
            v.addElement(score);
            if(maxScore < score){
                maxScore = score;
            }
        }

        char level;
        for (int i = 0; i < v.size(); i++) {
            Object obj = v.elementAt(i);
            /*
            JDK5.0 之前：
            Integer inScore = (Integer)obj;
            int score = inScore.intValue();
             */
            //JDK5.0之后
            int score = (int)obj;


            if(maxScore - score <= 10){
                level = 'A';
            }else if(maxScore - score <= 20){
                level = 'B';
            }else if(maxScore - score <= 20){
                level = 'C';
            }else if(maxScore - score <= 20){
                level = 'D';
            }else{
                level = 'E';
            }
            System.out.println("student-" + i + "score is " + score + "level is " + level);
        }
    }
}
class SwitchDemo {
    public static void main(String[] args) {
        show(0);
        show(1);
    }

    public static void show(int i) {
        switch (i) {
            default:
                i += 2;
            case 1:
                i += 1;
            case 4:
                i += 8;
            case 2:
                i += 4;
        }
        System.out.println("i=" + i);
    }
}
