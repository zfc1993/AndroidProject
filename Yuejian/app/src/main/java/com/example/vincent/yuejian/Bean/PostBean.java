package com.example.vincent.yuejian.Bean;

/**
 * Created by Vincent on 2017/10/31.
 */

public class PostBean {
    private String pid;
    private String ptext;
    private String uid;
    private String postfile;
    private String uname;
    private String reply;

    public PostBean(){}

    public PostBean(String pid, String ptext){
        this.pid = pid;
        this.ptext = ptext;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPtext() {
        return ptext;
    }

    public void setPtext(String ptext) {
        this.ptext = ptext;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPostfile() {
        return postfile;
    }

    public void setPostfile(String postfile) {
        this.postfile = postfile;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
