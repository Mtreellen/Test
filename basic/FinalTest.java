package basic;

public class FinalTest {
    private final int age = 12;
    private final String name;
    private final boolean isGraguate;
    private final Double radius;
    {
        //age = 2;//no
        name = "haha";//ok
    }
    public FinalTest(){
        isGraguate = true;//ok
        radius = 1.2;
    }

    public FinalTest(int age, String name){
        isGraguate = false;
        radius = 3.2;
        //this.age = age;//error
        //this.name = name;//error
    }

    public void fun(final int a){
        System.out.println("局部变量为final");
    }

    public static void main(String[] args) {
        FinalTest test = new FinalTest();

        test.fun(12);
        test.fun(12);
    }
}
