package entity;


public class User {

    private int userid;

    private String username;

    private String password;

    private String token;
    /**
     * mac绑定
     */
    private String mac;
    /**
     * 登录请求时间
     */
    private long logintime;
    /**
     * 最后请求时间
     */
    private long lasttime;
    /**
     * 上传流量
     */
    private long uptraffic;
    /**
     * 下载流量
     */
    private long downtraffic;
    /**
     * 在线状态
     */
    private String status;

    public User(int userid,String username,String password,String token,String mac,long logintime,long lasttime,long uptraffic,long downtraffic,String status){
    	this.userid=userid;
    	this.username = username;
    	this.password = password;
    	this.token = token;
    	this.mac = mac;
    	this.logintime = logintime;
    	this.lasttime = lasttime;
    	this.uptraffic = uptraffic;
    	this.downtraffic = downtraffic;
    	this.status = status;
    }
    
    public User(String username,String password,String token,String mac,long logintime,long lasttime,long uptraffic,long downtraffic,String status){
    	this.username = username;
    	this.password = password;
    	this.token = token;
    	this.mac = mac;
    	this.logintime = logintime;
    	this.lasttime = lasttime;
    	this.uptraffic = uptraffic;
    	this.downtraffic = downtraffic;
    	this.status = status;
    }
    
    public User() {
		// TODO 自动生成的构造函数存根
	}

	public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getMac() {
        return mac;
    }
    public void setMac(String mac) {
        this.mac = mac;
    }
    public long getLogintime() {
        return logintime;
    }
    public void setLogintime(long logintime) {
        this.logintime = logintime;
    }
    public long getLasttime() {
        return lasttime;
    }
    public void setLasttime(long lasttime) {
        this.lasttime = lasttime;
    }
    public long getUptraffic() {
        return uptraffic;
    }
    public void setUptraffic(int uptraffic) {
        this.uptraffic = uptraffic;
    }
    public long getDowntraffic() {
        return downtraffic;
    }
    public void setDowntraffic(int downtraffic) {
        this.downtraffic = downtraffic;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}