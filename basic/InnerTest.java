package basic;

public class InnerTest {
    public static void main(String[] args) {
        Person.Hand hand = new Person().new Hand();

    }
}


class Person{
    class Hand{

    }
    public Person(){
        class Shoulder{

        }
    }
    {
        class Brain{

        }
    }

    public void fun(){
        class Foot{

        }
    }

    static class Face{

    }
}