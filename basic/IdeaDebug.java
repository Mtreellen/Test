package basic;

/**
 * @author mtreellen
 * @create 2019-10-09-15:11
 */
public class IdeaDebug {
    public static void main(String[] args) {
        String str = null;
        StringBuilder sb = new StringBuilder();
        sb.append(str);

        System.out.println(sb.length());//4

        System.out.println(sb);//"null"

        StringBuilder sb1 = new StringBuilder(str);//抛出异常: java.lang.NullPointerException
        System.out.println(sb1);
    }
}
