package basic;

public  class AbstractTest {
    public static void main(String[] args) {
        Cats tiger = new Tiger(12, "Tiger", "Cats");
        tiger.appearance();
        tiger.food();
        System.out.println(tiger.toString());
        Cats cat = new Cats(){
            public void food(){
                System.out.println(this.getName() + " eats fish and cat food.");
            }
            public void appearance(){
                System.out.println(this.getName() + " is so cute with their little cat claw and soft hair.");
            }
        };
        cat.setAge(1);
        cat.setName("Cat");
        cat.food();
        cat.appearance();
        System.out.println(cat.toString());
    }
}

abstract class Cats{
    private Integer age;
    private String name;

    public Cats() {}

    public Cats(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void food();

    public abstract void appearance();

    @Override
    public String toString() {
        return "Cats{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class Tiger extends Cats{
    private String varieties;//品种

    public Tiger(){}

    public Tiger(Integer age, String name, String varieties) {
        super(age, name);
        this.varieties = varieties;
    }

    public String getVarieties() {
        return varieties;
    }

    public void setVarieties(String varieties) {
        this.varieties = varieties;
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "age=" + this.getAge() +
                ", name='" + this.getName() + '\'' +
                ", varieties='" + varieties + '\'' +
                '}';
    }

    @Override
    public void food() {
        System.out.println(this.getName() + " are carnivores, they mainly eats meat.");
    }

    @Override
    public void appearance() {
        System.out.println(this.getName() + " is covered with hair to prevent cold, beard on both sides of nose, and also has sharp teeth to bite their prey");
    }
}