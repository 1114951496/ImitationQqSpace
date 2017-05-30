package cn.mk95.www.service;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.*;

import static java.lang.System.*;

/**
 * Created by 睡意朦胧 on 2017/4/16.
 */
public  class H_FileRW {
    /**
     * 读好友的文件
     * @param Url
     * @return
     * @throws IOException
     */
    @NotNull
    public static String CheckId(String Url) throws IOException {
        File file = new File(Url);
        StringBuilder result = new StringBuilder();
        out.println("检查friend的url"+Url);
        if (!file.exists() && file.isDirectory()) {
            file.createNewFile();
            return "2-3";
        } else {
//            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
//            String s = null;
//            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
//                result.append(System.lineSeparator()+s);
//            }
//            br.close();
//            System.out.println(String.valueOf(result));
//            return String.valueOf(result);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String temp = null;
            StringBuffer sb = new StringBuffer();
            temp = br.readLine();
            while (temp != null) {
                sb.append(temp);
                temp = br.readLine();
            }
            br.close();
            System.out.println(sb);
            return sb.toString();


//            FileInputStream fis=new FileInputStream(file);
//            byte[] a=new byte[1024];
//            fis.read(a);
//            fis.close();
//            return new String(a,"UTF-8");
        }
    }
    /**
     * 删除好友
     */

    @NotNull
    public static synchronized String DelectFriendId(String Url, String friends) throws IOException {
        File file=new File(Url);
        FileOutputStream fos=new FileOutputStream(file);
        System.out.println("sadwr433");
        byte[] a=null;
        a=friends.getBytes();
        fos.write(a);
        fos.close();
        return "ok";
    }
}
