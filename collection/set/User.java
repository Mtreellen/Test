package collection.set;

/**
 * @author mtreellen
 * @create 2019-10-11-10:10
 */
public class User implements Comparable{
    private String name;
    private int age;

    public User() {
    }
    public User(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        System.out.println("User's equals()...");
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return age == user.age &&
//                Objects.equals(name, user.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public int compareTo(Object obj){
        if(obj instanceof User){
            User user = (User)obj;
            //return -this.name.compareTo(user.name);
            int compare = -this.name.compareTo(user.name);//String类重写compareTo()
            if(compare != 0){
                return compare;
            }else{
                return Integer.compare(this.age, user.age);
            }
        }else{
            throw new RuntimeException("输入类型不匹配");
        }
    }
}
