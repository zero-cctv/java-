package cmd_test;

import java.io.*;
import java.util.ArrayList;

public class changmain {

    ArrayList<String> getText(String path) throws Exception {
        File file=new File(path);
        ArrayList<String> aimString=new ArrayList<>();
        String aimline=null;
        if(!file.exists()){throw new RuntimeException();}
        FileReader fileReader=new FileReader(file);
        BufferedReader br=new BufferedReader(fileReader);
        while (true) {
            // 一次读一行
            String line = br.readLine();
            if (null == line)
                break;
            System.out.println(line);
            if(line.contains("missing"))continue;
            aimline=line.substring(14);
            System.out.println("");
            aimString.add(aimline);
        }
        fileReader.close();
        br.close();
        return aimString;
    }
    Boolean runchang(ArrayList<String> arrayList) throws Exception {
        int i=0;
        Process process;
        String commands=null;
        String command=null;
        for (i=0;i<arrayList.size();++i){
            String id=arrayList.get(i);
            creadBat(id);
            commands="cmd.exe /c start /b C:\\java\\b.bat";
            command=new String(commands.getBytes(),"GBK");
            process=Runtime.getRuntime().exec(command);
            Thread.sleep(1000);
        }
        System.out.println("创建的txt数量"+i+"===="+"源头有"+arrayList.size());
        if(i>arrayList.size()){

            return true;}
        return false;
    }
    public void creadBat(String id) throws Exception{
        File file=new File("C:/java/b.bat");
        if (!file.exists()){file.createNewFile();}
        BufferedWriter bw=new BufferedWriter(new FileWriter(file));
        bw.write("cd C:\\Users\\Administrator\\Desktop\\java\\javaspring");
        bw.newLine();
        bw.write("git show "+id+" >"+id+".txt");
        bw.flush();
        bw.close();

    }
    public boolean scanlist(String path) throws Exception{
        File file=new File(path);
        if(!file.exists()||!file.isFile())return false;
        BufferedReader bf=new BufferedReader(new FileReader(file));
        String line;
        while ((line=bf.readLine())!=null){
            if(line.contains("public class")){
                return true;
            };

        }
        return false;
    }
    public boolean changClass() throws Exception{
        String path="C:\\Users\\Administrator\\Desktop\\java\\javaspring";
        File file=new File(path);
        String[] sl =new String[]{};
        ArrayList<String> slist =new ArrayList<>();
        if(!file.exists()||!file.isDirectory()){ return false;}
        sl=file.list();
        for (String s:sl) {
            if(s.contains(".txt")){
                slist.add(s);
            }
            if(s.contains(".txt")&&scanlist(path+s)){
//                reAimname(path+s);
                /*还是算了，改成java不好看*/
            };
        }

        return true;
    }
    public void test1(changmain m){
        String pathage="src/cmd_test/a.txt";

        try {
            ArrayList<String> aimString=new ArrayList<>();
            aimString=  m.getText(pathage);

            if ( m.runchang(aimString)) {
                System.out.println("ok");
            } else {
                System.out.println("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void test2(changmain cm){
        try {
            System.out.println(cm.changClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        changmain cm=new changmain();
//        cm.test1(cm);
        cm.test2(cm);
    }
}
