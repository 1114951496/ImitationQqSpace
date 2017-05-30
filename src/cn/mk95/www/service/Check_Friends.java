package cn.mk95.www.service;

import cn.mk95.www.bean.FriendEntity;
import cn.mk95.www.bean.UserEntity;
import cn.mk95.www.interfaces.FriendDao;
import cn.mk95.www.interfaces.UserDao;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 睡意朦胧 on 2017/4/23.
 */
public class Check_Friends {
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

    public ArrayList CheckFriendsById(int MyId) throws IOException {
        friends.clear();
        userDao.init();
        friendDao.init();
        System.out.print("sds");
        if (friendDao.findFriendByUserId(MyId)==null){
            return friends;
        }else {
            friend = (FriendEntity) friendDao.findFriendByUserId(MyId);
            String friendIds;
            friendIds = H_FileRW.CheckId(NoteService.getWebInfPath() + "/userData/Friend/test1.txt");
            /**
             * 检查friendId:System.out.println("检查friendids是否读取："+friendIds);
             */
            String[] id = friendIds.split("-");
            for (int i = 0; i < id.length; i++) {
                if (id[i].equals("") || id[i] == null) {
                    continue;
                }
                user = userDao.findUserById(Integer.parseInt(id[i]));
                friends.add(user);

            }
            return friends;
        }
    }
}
