package cn.mk95.www.action;

import cn.mk95.www.bean.FriendEntity;
import cn.mk95.www.bean.UserEntity;
import cn.mk95.www.interfaces.FriendDao;
import cn.mk95.www.interfaces.UserDao;
import cn.mk95.www.service.H_FileRW;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 睡意朦胧 on 2017/4/16.
 */
public class PersonFriend extends ActionSupport{
    private UserEntity user;
    private UserDao userDao;
    private FriendDao friendDao;
    private FriendEntity friend;
    ArrayList<String> friendNames=null;
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public FriendDao getFriendDao() {
        return friendDao;
    }

    public void setFriendDao(FriendDao friendDao) {
        this.friendDao = friendDao;
    }

    public FriendEntity getFriend() {
        return friend;
    }

    public void setFriend(FriendEntity friend) {
        this.friend = friend;
    }

    /**
     * 查询朋友并显示
     * @return
     */

    public String MyFriend() throws IOException {
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpSession session=request.getSession();
        String MyId=request.getParameter("id");

        /**
         * 查询朋友id文件的url
         */
        if (friendDao.findFriendByUserId(Integer.parseInt(MyId))==null){
            return "NoFriend";
        }else{
            friend=(FriendEntity) friendDao.findFriendByUserId(Integer.parseInt(MyId));
            String friendUrl=friend.getFidurl();
            //System.out.println("检查friend的url"+friend.getFidurl());
            //String friendUrl="test1.txt";
            String friendIds=H_FileRW.CheckId(friendUrl);
            /**
             * 检查friendId
             */
            System.out.println("检查friendids是否读取："+friendIds);
            String[] id=friendIds.split("-");
            for (int i=0;i<id.length;i++){
                user=userDao.findUserById(Integer.parseInt(id[i]));
                String name=user.getUsername();
                friendNames.add(name);
            }
            session.setAttribute("usernames",friendNames);
            return SUCCESS;
        }
    }
}
