package cn.mk95.www.service;

import java.io.IOException;
/*Alfresco cms*/

/**
 * Created by 睡意朦胧 on 2017/4/20.
 */
public class Delect_run implements Runnable{
    private String url;
    private String friendid;
    public void setUrl(String url) {
        this.url = url;
    }

    public void setFriendid(String friendid) {
        this.friendid = friendid;
    }

    public void Delect(String url, String friendid){
        Delect_run delect_run=new Delect_run();
        delect_run.setFriendid(friendid);
        delect_run.setUrl(url);
        Thread thread=new Thread(delect_run);
        thread.start();
    }
    @Override
    public void run() {
        try {
            H_FileRW.DelectFriendId(url,friendid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
