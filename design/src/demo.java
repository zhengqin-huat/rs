import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        del del =new del(new ad());
        System.out.println("ad"+del.str("www","www"));


        del dela =new del(new adt());
        System.out.println("adt"+del.str("www","www"));
        Scanner sca = new Scanner(System.in);
        String string =sca.next();
        System.out.println(string);
    }
}
