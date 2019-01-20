package com.brine.sys;

import com.brine.sys.utils.Pbkdf2Utils;

/**
 * @author: Administrator
 * @date: 2018/12/11 0011 下午 5:34
 */
public class Test {

    @org.junit.Test
    public void testServiceHelloFail() {
   /*     StringBuilder sb = new StringBuilder();
        sb.append("abcdefg");
        sb.insert(3,"杨");
        System.out.println(sb);*/
        try {
            System.out.println("密码:"+Pbkdf2Utils.createHash("adfadsfds"));
        } catch (Pbkdf2Utils.CannotPerformOperationException e) {
            e.printStackTrace();
        }
        String mima = "ya";
        char[] chs = mima.toCharArray();
        chs = jiami(chs,2);
        String str = new String(chs);
        System.out.println(str);
        //解密
        chs = jiemi(chs,2);
        str = new String(chs);
        System.out.println(str.trim());
    }

    public char[] jiami(char[] str,int n){
        int i,len;
        char[] miwen;
        len=str.length;
        if((miwen=new char[len+1])==null){
            System.out.println("申请内存失败!");
            System.exit(1);
        }
        for (i=0;i<len;i++){
            miwen[i]=(char)(str[i]+n);
        }
        miwen[len]='\0';
        return miwen;
    }

    public char[] jiemi(char[] str,int n){
        int i,len;
        char[] miwen;
        len=str.length-1;
        if((miwen=new char[len+1])==null){
            System.out.println("申请内存失败!");
            System.exit(1);
        }
        for (i=0;i<len;i++){
            miwen[i]=(char)(str[i]-n);
        }
        miwen[len]='\0';
        return miwen;
    }

}
