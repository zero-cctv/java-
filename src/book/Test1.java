package book;
//判断字符串是否包含重复字符。
public class Test1 {
    public static boolean isDue(String str){
        int len=str.length();
        int[] flags=new int[8];
        int i;
        for (i=0;i<8;i++){
            flags[i]=0;
        }
        for (i = 0; i <len ; i++) {
            int index=(int)str.charAt(i)/32;
            int shift=(int)str.charAt(i)%32;//shift在1<<shift，左移1的二进制数shift个单位变成0000 0001等等
            if((flags[index]&(1<<shift))!=0)
                return true;
            flags[index]|=(1<<shift);
            //每次存储的十进制换成二进制为0000 0001，0000 0010等等。因为用的是|，所以有可能变成0000 0011.
        }
        return false;
    }
    public static void main(String[] args) {
        String str="abc?";
        System.out.println(isDue(str));
    }
}
