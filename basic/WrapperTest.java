package basic;
class Student{
    String name;
    Character gender;
    Integer age;
    Boolean isGraduated;
}

public class WrapperTest {
    public static void main(String[] args) {
//        specialSituationOfInteger();
//        specialSituationOfInteger1();
        autoBoxingAndUnbosing();
    }
    /**
     * Special situation of automatic types.
     */
    public static void automaticTypes1(){
        char x = 'x';
        int i = 10;
        double d = 1.2;
        System.out.println(true? x : i);//120
        System.out.println(true? 'x' : i);//120
        System.out.println(true? x : 10);//x
        System.out.println(true? 'x' : 10);//x

        System.out.println(true? x : d);//120.0
        System.out.println(true? 'x' : d);//120.0
        System.out.println(true? x : 1.2);//120.0
        System.out.println(true? 'x' : 1.2);//120.0
    }

    public static void automaticTypes2(){
        double d = 1.23;
        int i = 1;
        System.out.println(true? d : i);//1.23
        System.out.println(true? 1.23 : i);//1.23
        System.out.println(true? d : 1);//1.23
        System.out.println(true? 1.23 : 1);//1.23
        System.out.println(true? i : d);//1.0
        System.out.println(true? 1 : d);//1.0
        System.out.println(true? i : 1.23);//1.0
        System.out.println(true? 1 : 1.23);//1.0
    }
    public static void testBoolean(){
        Boolean bool = new Boolean("True123");
        System.out.println(bool);//false
        Boolean bool1 = new Boolean("TruE");
        System.out.println(bool1);//true
    }
    public static void defaultInitValueOfWrapper(){
        Student student = new Student();
        System.out.println(student.isGraduated);//null
        System.out.println(student.age);//null
        System.out.println(student.name);//null
        System.out.println(student.gender);//null

    }
    public static void autoBoxingAndUnbosing(){
        //TODO:why?
        try {
            Student student = new Student();
            int num = student.age.intValue();
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer in1 = new Integer(123);
        int in2 = in1.intValue();//
        int in3 = in1;//Unboxing
        Integer in4 = 123;//Autoboxing
        System.out.println(in2);
        System.out.println(in3);
        System.out.println(in4);
    }
    public static void specialSituationOfInteger(){
        /**
         * Integer has a inner class called IntegerCatch, this inner class has a array: static final Integer catch[]
         * this array holds numbers from -127 to 128.
         */
        Integer in11 = 128;
        Integer in12 = 128;
        System.out.println(in11 == in12);//false

        Integer in13 = 127;
        Integer in14 = 127;
        System.out.println(in13 == in14);//true

        /**
         * The Integer type variables compares to int type variables, the Integer type Unboxing to a int.
         */
        Integer in1 = new Integer(128);
        int in2 = 128;
        System.out.println(in1 == in2);//true

        Integer in3 = new Integer(45);
        int in4 = 45;
        System.out.println(in3 == in4);//true

        Integer in5 = new Integer(-128);
        int in6 = -128;
        System.out.println(in5 == in6);//true

        /**
         * Two Integer type variables used "==" compared references values.
         */
        Integer in7 = new Integer(129);
        Integer in8 = new Integer(129);
        System.out.println(in7 == in8);//false

        Integer in9 = new Integer(127);
        Integer in10 = new Integer(127);
        System.out.println(in9 == in10);//false

    }
    public static void specialSituationOfInteger1(){
        /**
         * Two variables types of Integer can compared size.
         */
        Integer num = new Integer(1);
        Integer num1 = new Integer(12);

        System.out.println(num < num1);//true
        System.out.println(num > num1);//false
        System.out.println(num == num1);//false

        Integer num3 = new Integer(111);
        Integer num4 = new Integer((111));
        System.out.println(num3 == num4);//false

        Integer num5 = new Integer(129);
        Integer num6 = new Integer((129));
        System.out.println(num5 == num6);//false
    }
}
class WrapperStringBasicType{

}

class WrapperTest1{
    public static void main(String[] args) {
        WrapperTest1 wrapper = new WrapperTest1();

        wrapper.test();
        System.out.println("----------------");
        wrapper.test1();
        System.out.println("----------------");
        wrapper.test2();
        System.out.println("----------------");
        wrapper.test3();
    }

    public void test(){
        Object o1 = true ? new Integer(1) : new Double(2.0);
        //Object o1 = new Integer(1);

        System.out.println(o1);//1.0
        // --三元运算符，数据类型要一致，所以自动类型提升了 Integet --> Double
    }

    public void test1(){
        Object o2;
        if(true){
            o2 = new Integer(1);
        }else
            o2 = new Double(2.0);
        System.out.println(o2);//1
    }

    public void test2(){
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);//false

        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);//true

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);//false
        /*
                Integer中定义了一个内部类IntegerCatch
        --》    里面有一个数组static final Integer catch[];
        --》    存了 -128到127范围的数组  --》  为了提高速度
         */
    }

    public void test3(){
        int[] arr = new int[]{1, 2, 3};
        char[] arr1 = new char[]{'1', '2', '3'};

        System.out.println(arr);//[I@1b6d3586
        System.out.println(arr1);//123
    }
}