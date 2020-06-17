package book;
//求最长递增子序列长度
public class Test {
    public static int getMaxAscendingLen(String str){
        int i,j;
        int len=str.length();
        int[] maxLen=new int[len];
        maxLen[0]=1;
        int maxAcsendingLen=1;
        for (i=1;i<len;i++){
            maxLen[i]=1;

                if(str.charAt(i-1)<str.charAt(i)&&maxLen[i-1]>maxLen[i]-1){
                    maxLen[i]=maxLen[i-1]+1;
                    maxAcsendingLen=maxLen[i];
                }


        }

        return maxAcsendingLen;
    }
    public static void main(String[] args) {
        String s="xbcdzaefg";
        System.out.println("最长递增子序列长度："+getMaxAscendingLen(s));
    }
}
