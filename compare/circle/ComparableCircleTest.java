package compare.circle;
//TODO:

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle comparableCircle = new ComparableCircle(1.2);
        ComparableCircle comparableCircle1 = new ComparableCircle(2.3);
        int compareValue = comparableCircle.compareTo(comparableCircle1);
        if(compareValue > 0){
            System.out.println("前者大");
        }else if(compareValue < 0){
            System.out.println("后者大");
        }else{
            System.out.println("一样大");
        }
    }
}