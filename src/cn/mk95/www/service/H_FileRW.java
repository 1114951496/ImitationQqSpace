package cn.mk95.www.service;

import org.jetbrains.annotations.NotNull;

import java.io.*;

import static java.lang.System.*;

/**
 * Created by 睡意朦胧 on 2017/4/16.
 */
public  class H_FileRW {

    @NotNull
    public static String CheckId(String Url) throws IOException {
        File file = new File(Url);
        out.println("检查friend的url"+Url);
        String encoding = "utf-8";
        if (file.exists() && !file.isDirectory()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String temp = null;
            StringBuffer sb = new StringBuffer();
            temp = br.readLine();
            while (temp != null) {
                sb.append(temp + "-");
                temp = br.readLine();
            }
            return sb.toString();
        } else {
            return "2-3";
        }
    }
}
