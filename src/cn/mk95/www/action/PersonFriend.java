package cn.mk95.www.action;

import cn.mk95.www.bean.FriendEntity;
import cn.mk95.www.bean.UserEntity;
import cn.mk95.www.interfaces.FriendDao;
import cn.mk95.www.interfaces.UserDao;
import cn.mk95.www.service.H_FileRW;
import cn.mk95.www.service.NoteService;
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
    ArrayList<UserEntity> friends=new ArrayList<>();
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

    public String H_fileread(int MyId) throws IOException {
        friendDao.init();
        if (friendDao.findFriendByUserId(MyId)==null){
            return "NoFriend";
        }else {
            friend = (FriendEntity) friendDao.findFriendByUserId(MyId);
            String friendUrl = friend.getFidurl();
            //System.out.println("检查friend的url"+friend.getFidurl());
            //String friendUrl="test1.txt";
            String friendIds = H_FileRW.CheckId(NoteService.getWebInfPath() + "/userData/Friend/test1.txt");
            /**
             * 检查friendId
             *
             */
            System.out.println("检查friendids是否读取："+friendIds);
            return friendIds;
        }
    }
    /**
     * 查询朋友并显示
     * @return
     */
    public String MyFriend() throws IOException {
        friends.clear();
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpSession session=request.getSession();
        userDao.init();
        friendDao.init();
        /**
         * 查询朋友id文件的url
         */
        String friendIds=this.H_fileread(((UserEntity)session.getAttribute("user")).getUserid());
        System.out.println(friendIds);
        String[] id=friendIds.split("-");
        for (int i=0;i<id.length;i++){
            if(id[i].equals("")||id[i]==null){
                continue;
            }
            user = userDao.findUserById(Integer.parseInt(id[i]));
            friends.add(user);

        }
        session.setAttribute("users",friends);
        return SUCCESS;

    }
    /**
     * 删除好友
     */
    public String DelectFriend() throws IOException {
        userDao.init();
        friendDao.init();
        HttpServletRequest request=ServletActionContext.getRequest();
        String friendid=request.getParameter("id");
        HttpSession session=request.getSession();
        String friendIds=this.H_fileread(((UserEntity)session.getAttribute("user")).getUserid());
        String _friend="-"+friendid.toString();
        H_FileRW.DelectFriendId(NoteService.getWebInfPath() + "/userData/Friend/test1.txt",friendIds.replace(_friend,""));
        return SUCCESS;
    }
}
