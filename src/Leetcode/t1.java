package Leetcode;

import Leetcode.com.Solution;

public class t1 implements  Tshow,lll{


    public static void main(String[] args) {
       t1 tt=new t1();
       tt.test();
//        tt.tese02();
//        Thread
    }
    public void test(){
        String s="{[[{()}]]}";
        Solution sslt=new Solution();
        try {
            for(int i=0;i<1000000;i++){
                new Solution();
            }
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sslt.isValid(s));
    }
    public void test01(Tshow tshow){
        Tshow tshow1=tshow;
        tshow1.show();
        int b;
        int num[]=new int[]{1,2,3,95,12,5,9,4};
        num[2]=100;
        System.out.println("ppt"+c);
//        System.out.println(new Leetcode.com01.Solution().findUnsortedSubarray(num));
    }
    int c;
    public  void tese02(){
        c++;
        if(c==1000000){return;}
        else {tese02();}
        double d1=1.1;
        double d2=1.2;
        char a='0';
        char a1='9';
//        ArrayList<BigInteger> arrayList=new ArrayList<>();
//        BigInteger b=new BigInteger("9999999999");
//        BigInteger i=new BigInteger("1");
//        BigInteger[] big=new BigInteger[]{};
//        while (i.compareTo(b)!=0){
//            BigInteger temp=i.add(new BigInteger("1"));
//           i=temp;
//            arrayList.add(temp);
//
//            System.out.println(temp.intValue());
//            if(arrayList.size()%11==9){
//
//                    arrayList.toArray(big);
//
//            }
//        }
//        System.out.println(arrayList.size());
    }


    public void show() {
        System.out.println("Tshow in t1");
    }


    public void tt() {

    }
}
