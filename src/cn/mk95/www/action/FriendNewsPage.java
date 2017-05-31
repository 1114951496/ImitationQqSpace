package cn.mk95.www.action;

import cn.mk95.www.bean.NoteEntity;
import cn.mk95.www.bean.UserEntity;
import cn.mk95.www.interfaces.NoteDao;
import cn.mk95.www.service.FriendsNewsService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by LU on 2017/5/30.
 */
public class FriendNewsPage extends ActionSupport {
    private FriendsNewsService friendsNewsService;
    private Integer pageNo;

    public void setFriendsNewsService(FriendsNewsService friendsNewsService) {
        this.friendsNewsService = friendsNewsService;
    }

    public FriendsNewsService getFriendsNewsService() {
        return friendsNewsService;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    ArrayList<UserEntity> friends=new ArrayList<>();
    ArrayList<NoteEntity> arrayList=new ArrayList<>();
    public String fnews() throws IOException {
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpSession session=request.getSession();
        friends= (ArrayList<UserEntity>) session.getAttribute("users");
        if(pageNo==null){
            pageNo=1;
        }
        arrayList=friendsNewsService.getNewsNote(friends,pageNo);
        session.setAttribute("fnews",arrayList);
        return SUCCESS;
    }

}
