package cmd_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dos {
    public Dos() {
    }

    public static String getMACAddress(String commands) {

        String address = "";
        //获取系统类型，如：windows、Linux、Unix等；
        String os = System.getProperty("os.name");
        if (os != null && os.startsWith("Windows")) {
            try {
//                String command = "cmd.exe /c ipconfig /all";
                ;
//                commands="cmd.exe /c start C:\\java\\a.bat";

                String command=new String(commands.getBytes(),"GBK");
                Process p = Runtime.getRuntime().exec(command);
                System.out.println("command="+p.getOutputStream().toString());
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),"GBK"));
                String line;
                while ((line = br.readLine()) != null) {
//                    if (line!=null) {
//                        int index = line.indexOf(":");
//                        index += 2;
//                        address = line.substring(index);
//                        break;
//                    }
                    System.out.println(line);
                }
                br.close();
                return address.trim();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return address;
    }





    public static boolean command(String command) {
        boolean err = false;
        try {
            Process process =
                    new ProcessBuilder(command.split(" ")).start();
            process=new ProcessBuilder("/c ipconfig /all").start();
            BufferedReader results = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String s;
            while((s = results.readLine())!= null)
                System.out.println(s);
            BufferedReader errors = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()));
            // Report errors and return nonzero value
            // to calling process if there are problems:
            while((s = errors.readLine())!= null) {
                System.err.println("错误："+s);
                err = true;
                return false;
            }
        } catch(Exception e) {
            // Compensate for Windows 2000, which throws an
            // exception for the default command line:
            if(!command.startsWith("CMD /C"))
                command("CMD /C " + command);
            else
                throw new RuntimeException(e);
        }
        if(err){

        }
        return true;
    }


    public static void main(String[] args) {

//        boolean isOk = Dos.command("svnadmin create d:\\BPMHOME\\B");
//
//        System.out.println(isOk);
        String commands="cmd.exe /c cd cd C:\\Users\\Administrator\\Desktop\\java\\javaspring";
        System.out.println(getMACAddress(commands));
        commands="cmd.exe /c ipconfig /all";
        System.out.println(getMACAddress(commands));
//        command("");
    }
}
