package com.example.vincent.yuejian.Bean;

/**
 * Created by Administrator on 2017/10/5 0005.
 */

public class Actbean {


    /**
     * actid : 1
     * aname : 约健僵尸跑
     * actaddress : 大连东软三期16号楼
     * actp : 4441
     * actpic : 81503885806.png
     * actpone : 19865423471
     * actintro : 非常的好玩
     * actdata : 2017-08-10
     * clubid : 1
     */

    private String actid;
    private String aname;
    private String actaddress;
    private String actp;
    private String actpic;
    private String actpone;
    private String actintro;
    private String actdata;
    private String clubid;

    public Actbean(){};

    public Actbean(String actid, String aname){
        this.actid = actid;
        this.aname = aname;
    }

    public void setActid(String actid) {
        this.actid = actid;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public void setActaddress(String actaddress) {
        this.actaddress = actaddress;
    }

    public void setActp(String actp) {
        this.actp = actp;
    }

    public void setActpic(String actpic) {
        this.actpic = actpic;
    }

    public void setActpone(String actpone) {
        this.actpone = actpone;
    }

    public void setActintro(String actintro) {
        this.actintro = actintro;
    }

    public void setActdata(String actdata) {
        this.actdata = actdata;
    }

    public void setClubid(String clubid) {
        this.clubid = clubid;
    }

    public String getActid() {
        return actid;
    }

    public String getAname() {
        return aname;
    }

    public String getActaddress() {
        return actaddress;
    }

    public String getActp() {
        return actp;
    }

    public String getActpic() {
        return actpic;
    }

    public String getActpone() {
        return actpone;
    }

    public String getActintro() {
        return actintro;
    }

    public String getActdata() {
        return actdata;
    }

    public String getClubid() {
        return clubid;
    }
}
