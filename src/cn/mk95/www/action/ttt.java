package cn.mk95.www.action;

import cn.mk95.www.service.NoteService;
import org.junit.Test;

import java.io.*;
import java.sql.Timestamp;

import static java.lang.System.out;

/**
 * Created by 睡意朦胧 on 2017/4/16.
 */
public class ttt  {
   @Test
    public  void one() throws IOException {
       String albumurl="WEB-INF/userData/Album"+"/1";
       File file=new File(albumurl);
       if(!file.isDirectory()){
           file.mkdir();
       }
       else if (file.isDirectory()) {
           File[] fList = file.listFiles();
           for (int j = 0; j < fList.length; j++) {
               File afile = fList[j];
               if (file.isFile()) {
                   System.out.println(albumurl + "/" + afile.getName());
               }
           }
       }
   }
}
