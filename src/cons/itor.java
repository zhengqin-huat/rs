package cons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class itor {

    public static void main(String[] args) {
        List<String> lst = new ArrayList<String>();
        lst.add("aaa");
        lst.add("bbb");
        lst.add("ccc");
        lst.add("ddd");
        lst.add("eee");
        lst.add("fff");
        Iterator<String> iterator = lst.iterator();
        //iterator.hasNext()如果存在元素的话返回true
        while (iterator.hasNext()) {
            //iterator.next()返回迭代的下一个元素
            System.out.println(iterator.next());
        }
    }
    //(1) 使用方法iterator()要求容器返回一个Iterator。
    //    第一次调用Iterator的next()方法时，它返回序
    //    列的第一个元素。注意：iterator()方法
    //    是java.lang.Iterable接口,被Collection继承。
    //(2) 使用next()获得序列中的下一个元素。
    //(3) 使用hasNext()检查序列中是否还有元素。
    //(4) 使用remove()将迭代器新返回的元素删除。

}


