package cn.mk95.www.action;

import cn.mk95.www.bean.AlbumEntity;
import cn.mk95.www.bean.UserEntity;
import cn.mk95.www.interfaces.AlbumDao;
import cn.mk95.www.interfaces.UserDao;
import cn.mk95.www.service.H_FileRW;
import cn.mk95.www.service.NoteService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 睡意朦胧 on 2017/5/24.
 */
public class AlbumManager extends ActionSupport{
    private AlbumEntity album;
    private AlbumDao albumDao;
    private UserEntity user;
    private UserDao userDao;
    private File file; //file控件名

    private String fileContentType;//图片类型

    private String fileFileName; //文件名

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public void setAlbum(AlbumEntity album) {
        this.album = album;
    }


    public void setAlbumDao(AlbumDao albumDao) {
        this.albumDao = albumDao;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 查看相册图片
     * @return
     * @throws IOException
     */
    public String CheckAlbum() throws IOException {
        albumDao.init();
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpSession session=request.getSession();
        user=(UserEntity)session.getAttribute("Muser");
        album=(AlbumEntity)albumDao.findAlbumByUserId(user.getUserid());
        String url=request.getContextPath()+"/WEB-INF/"+album.getPhotourl()+"/"+user.getUserid();
        String Albumurl= NoteService.getWebInfPath()+album.getPhotourl();
        ArrayList<String> PhotoNames= H_FileRW.getAlbumurls(Albumurl,user.getUserid());
        ArrayList<String> PhotoUrls=new ArrayList<>();
        System.out.println(PhotoNames);
        for (int i=0;i<PhotoNames.size();i++){
            String PhotoUrl=url+"/"+ PhotoNames.get(i);
            PhotoUrls.add(PhotoUrl);
        }
        session.setAttribute("albums",PhotoUrls);
        return SUCCESS;
    }
    /**
     * 上传图片
     */
    public String AddPhoto() throws IOException {
        albumDao.init();
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpSession session=request.getSession();
        user=(UserEntity)session.getAttribute("Muser");
        album=(AlbumEntity)albumDao.findAlbumByUserId(user.getUserid());

        String Albumurl= NoteService.getWebInfPath()+album.getPhotourl()+"/"+user.getUserid();
        FileOutputStream fos=new FileOutputStream(Albumurl+"/"+getFileFileName());
        FileInputStream fis=new FileInputStream(getFile());
        byte[] buffer=new byte[1024];
        int len=0;
        while((len=fis.read(buffer))>0){
            fos.write(buffer,0,len);
        }
        ArrayList<String> PhotoUrls= H_FileRW.getAlbumurls(Albumurl,user.getUserid());
        //ArrayList<String> urls=(ArrayList<String>)session.getAttribute("albums");
        //urls.add(Albumurl+"/"+getFileFileName()+getFileContentType());
        session.setAttribute("albums",PhotoUrls);
        return SUCCESS;
    }
}
