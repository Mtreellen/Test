package arraylist.test;

/**
 * @author ellen
 * @date 2019-11-15 11:55
 * @description
 */
public class Person {
    private String name;
    private String profession;// 职业
    private int age;
    private boolean isBachelorDegree;// 是否为大学学历

    public Person(String name, String profession, int age, boolean isBachelorDegree) {
        this.name = name;
        this.profession = profession;
        this.age = age;
        this.isBachelorDegree = isBachelorDegree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBachelorDegree() {
        return isBachelorDegree;
    }

    public void setBachelorDegree(boolean bachelorDegree) {
        isBachelorDegree = bachelorDegree;
    }

//    @Override
    public String toString1() {
        return "====================人物信息========================" +
                "\n+ name：" + name +
                "\n+ profession：" + profession +
                "\n+ age：" + age +
                "\n+ 是否大学毕业：" + ((isBachelorDegree == true) ? "大学毕业" : "无大学学历");
    }

    @Override
    public String toString() {
        return "Person{" +
                "姓名='" + name + '\'' +
                ", \t职业='" + profession + "\'" +
                ", \t年龄=" + age +
                ", \t学历=" + ((isBachelorDegree == true) ? "本科" : "初中") +
                '}';
    }
}
