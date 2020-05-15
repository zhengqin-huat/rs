package cons;
import java.util.*;

public class TestergodicArr {


        public static void main(String[] args) {
            List<String> list=new ArrayList<String>();
            list.add("Hello");
            list.add("World");
            list.add("HAHAHAHA");

            for (String str : list) {
                System.out.println(str);
            }


            String[] strArray=new String[list.size()];
            list.toArray(strArray);
            for(int i=0;i<strArray.length;i++)
            {
                System.out.println(strArray[i]);
            }



            Iterator<String> ite=list.iterator();
            while(ite.hasNext())
            {
                System.out.println(ite.next());
            }import java.util.*;

            public class Test{
                public static void main(String[] args) {
                    List<String> list=new ArrayList<String>();
                    list.add("Hello");
                    list.add("World");
                    list.add("HAHAHAHA");
                    //第一种遍历方法使用 For-Each 遍历 List
                    for (String str : list) {
                        System.out.println(str);
                    }


                    String[] strArray=new String[list.size()];
                    list.toArray(strArray);
                    for(int i=0;i<strArray.length;i++)
                    {
                        System.out.println(strArray[i]);
                    }


                    Iterator<String> ite=list.iterator();
                    while(ite.hasNext())
                    {
                        System.out.println(ite.next());
                    }
}