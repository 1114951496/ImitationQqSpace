package cn.mk95.www.action;

import cn.mk95.www.bean.FriendEntity;
import cn.mk95.www.bean.UserEntity;
import cn.mk95.www.interfaces.FriendDao;
import cn.mk95.www.interfaces.UserDao;
import cn.mk95.www.service.Check_Friends;
import cn.mk95.www.service.Delect_run;
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
    private Check_Friends check_friends;
    ArrayList<UserEntity> friends=new ArrayList<>();
    private Delect_run delect_run;
    private String fname;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

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
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        userDao.init();
        friendDao.init();
        friends= (ArrayList<UserEntity>) session.getAttribute("users");
        session.removeAttribute("selectfriend");
        if(friends==null) {
            friends=check_friends.CheckFriendsById(((UserEntity)session.getAttribute("Muser")).getUserid());
            session.setAttribute("users", friends);
        }
        return SUCCESS;
    }
    /**
     * 删除好友，有待完善。没有实际删除
     */
    public String DelectFriend()  throws IOException {
        userDao.init();
        friendDao.init();
        HttpServletRequest request=ServletActionContext.getRequest();
        String friendid=request.getParameter("friendid");
        HttpSession session=request.getSession();
        friends= (ArrayList<UserEntity>) session.getAttribute("users");
        //friend = (FriendEntity) friendDao.findFriendByUserId(((UserEntity) session.getAttribute("user")).getUserid());
        //String friendUrl = friend.getFidurl();
        String url=NoteService.getWebInfPath() + "/userData/Friend/test1.txt";
        //delect_run.Delect(url,friendid);
        for (int i = friends.size() - 1; i >= 0; i--){
            if (Integer.parseInt(friendid) == friends.get(i).getUserid()){
                friends.remove(friends.get(i));
            }
        }
//        String friendIds=this.H_fileread(((UserEntity)session.getAttribute("user")).getUserid());
//        String _friend="-"+friendid.toString();
//        H_FileRW.DelectFriendId(NoteService.getWebInfPath() + "/userData/Friend/test1.txt",friendIds.replace(_friend,""));
        session.setAttribute("users",friends);
        return SUCCESS;
    }

    /**
     * 进入好友页面
     * @return
     */
    public String InFriend(){
        HttpServletRequest request=ServletActionContext.getRequest();
        HttpSession session=request.getSession();
        String FId=request.getParameter("friendid");
        user=(UserEntity)userDao.findUserById(Integer.parseInt(FId));
        session.setAttribute("Muser",user);
        return SUCCESS;
    }

    /**
     * 查询好友
     * @return
     */
    public String SelectFriend(){
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        user=userDao.findUserById(Integer.parseInt(fname));
        session.setAttribute("selectfriend",user);
        return SUCCESS;
    }
    /**
     * 添加好友,没有实际添加
     */
    public String AddFriend(){
        HttpServletRequest request=ServletActionContext.getRequest();
        HttpSession session=request.getSession();
        String friendid=request.getParameter("friendid");
        friends= (ArrayList<UserEntity>) session.getAttribute("users");
        user=(UserEntity)session.getAttribute("selectfriend");
        friends.add(user);
        session.setAttribute("users",friends);
        session.removeAttribute("selectfriend");
        return SUCCESS;
    }
}
