package book;

import java.util.Arrays;
import java.util.List;

public class test2 implements t1{
    public static void main(String[] args) {
        test2 tt=new test2();
//        System.out.println(tt.getClass().getGenericSuperclass());

        try {
            tt.test();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void test(){
        List<String> l1= Arrays.asList("ab","b","c");

//       Stream.of(l1).flatMap(x->x.spilct()).forEach(System.out::println);


        System.out.println(l1);
//        System.out.println(a1);
    }
    class t2 implements t1{}
}
