package cn.mk95.www.bean;

/**
 * Created by YangYongHao on 2017/4/12.
 * Annotation:
 */
public class HomeDynamic {
    private String userUrl;   //用户主页url
    private String imgUrl;    //用户头像url
    private String id;        //用户id
    private String name;    //用户name
    private String contentUrl;   //当前动态原文链接
    private String dynamicContent;   //当前动态简略内容

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getDynamicContent() {
        return dynamicContent;
    }

    public void setDynamicContent(String dynamicContent) {
        this.dynamicContent = dynamicContent;
    }
}
