package conding;

import java.io.*;

public class Test {
    final String s1="iso-8859-1";
    final String s2="utf8";
    final String s3="utf16";
    final String s4="utf32";
    public static void main(String[] args) {
        Test test=new Test();
        try {

//            test.t1();
            test.t2();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public void t1() throws Exception{
        System.out.println(new File(".").getAbsolutePath());//这是项目路径，一般看项目文件的路径决定相对路径；


        InputStreamReader in = new InputStreamReader(new FileInputStream("./src/conding/03.txt"),s2);
        OutputStreamWriter out=new OutputStreamWriter(new FileOutputStream("./src/conding/02.txt"),s1);


        int i;
        while ((i=in.read())!=-1){
            System.out.println(i);
            out.write(i);
        }
        in.close();
        out.flush();
        out.close();
    }
    public void t2() throws Exception{
//        InputStreamReader in=new InputStreamReader(new FileInputStream("./src/conding/ai.jpg"),s1);
//        OutputStreamWriter out=new OutputStreamWriter(new FileOutputStream("./src/conding/05.txt"),s2);
//        InputStreamReader in=new InputStreamReader(new FileInputStream("./src/conding/05.txt"),s1);
//        OutputStreamWriter out=new OutputStreamWriter(new FileOutputStream("./src/conding/06.txt"),s3);
//          InputStreamReader in=new InputStreamReader(new FileInputStream("./src/conding/06.txt"),s1);
//          OutputStreamWriter out=new OutputStreamWriter(new FileOutputStream("./src/conding/07.txt"),s4);

        /*以上二进制图片经过-iso-utf8-iso-utf16-iso-utf32变成07.txt。
        转变过程用.jpg或者.txt没区别，但人工修改过会出错（人工修改包括复制字符粘贴，但复制文件不算）
        * 以下07.txt经过反转成为a9.jpg。
        * */

//        InputStreamReader in=new InputStreamReader(new FileInputStream("./src/conding/07.txt"),s4);
//        OutputStreamWriter out=new OutputStreamWriter(new FileOutputStream("./src/conding/08.txt"),s1);
//        InputStreamReader in=new InputStreamReader(new FileInputStream("./src/conding/08.txt"),s3);
//        OutputStreamWriter out=new OutputStreamWriter(new FileOutputStream("./src/conding/07.txt"),s1);
        InputStreamReader in=new InputStreamReader(new FileInputStream("./src/conding/07.txt"),s2);
        OutputStreamWriter out=new OutputStreamWriter(new FileOutputStream("./src/conding/a9.jpg"),s1);
        int i;
        while ((i=in.read())!=-1){
            System.out.println(i);
            out.write(i);
        }

        in.close();
        out.flush();
        out.close();
    }
}
