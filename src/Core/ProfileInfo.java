package Core;

public class ProfileInfo {
    private String fName;
    private String lName;
    private String e_mail;
    private String phoneNum;
    private String gend;
    private String d_o_b;
    private String pic;

    public ProfileInfo(String fName, String lName, String e_mail, String phoneNum, String gend, String d_o_b, String pic) {
        this.fName = fName;
        this.lName = lName;
        this.d_o_b = d_o_b;
        this.e_mail = e_mail;
        this.phoneNum = phoneNum;
        this.gend = gend;
        this.pic = pic;
    }

    public String getFname() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getDob() {
        return d_o_b;
    }

    public String geteMail() {
        return e_mail;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getGend() {
        return gend;
    }

    public String getPic() {
        return pic;
    }


}
