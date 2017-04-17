package cn.mk95.www.action;

import org.junit.Test;

import java.io.*;

/**
 * Created by 睡意朦胧 on 2017/4/16.
 */
public class ttt {
    @Test
    public void one() throws IOException {
        File file=new File("web\\WEB-INF\\h_person\\test1.txt");
        String encoding="utf-8";
        if (!file.exists()||file.isDirectory()){
            System.out.print("2-3");
        }else {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String temp = null;
            StringBuffer sb = new StringBuffer();
            temp = br.readLine();
            while (temp != null) {
                sb.append(temp + "-");
                temp = br.readLine();
            }
            System.out.print(sb.toString());
        }
    }
}
