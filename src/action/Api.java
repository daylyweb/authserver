package action;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;
import entity.User;
import util.AesUtil;

public class Api extends ActionSupport {
	
	public String getGw_address() {
		return gw_address;
	}
	public void setGw_address(String gw_address) {
		this.gw_address = gw_address;
	}
	public String getGw_port() {
		return gw_port;
	}
	public void setGw_port(String gw_port) {
		this.gw_port = gw_port;
	}
	public String getGw_id() {
		return gw_id;
	}
	public void setGw_id(String gw_id) {
		this.gw_id = gw_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getIncoming() {
		return incoming;
	}
	public void setIncoming(String incoming) {
		this.incoming = incoming;
	}
	public String getOutgoing() {
		return outgoing;
	}
	public void setOutgoing(String outgoing) {
		this.outgoing = outgoing;
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
	private String gw_address;
	private String gw_port;
	private String gw_id;
	private String url;
	private String stage;
	private String ip;
	private String mac;
	private String token;
	private String incoming;
	private String outgoing;
	private String username;
	private String password;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String message;
	
	public String login(){
		Map temp = (HashMap) ServletActionContext.getRequest().getSession().getAttribute("firstLogin");
		if(username==null && password==null){
			System.out.println("\nlogin:\ngw_address:"+gw_address+"\ngw_port:"+gw_port+"\ngw_id:"+gw_id+"\nurl:"+url);
			Map<String, String> firstLoginMap = new HashMap<String, String>();
			firstLoginMap.put("address", gw_address);
			firstLoginMap.put("port", gw_port);
			firstLoginMap.put("id", gw_id);
			firstLoginMap.put("url", url);
			ServletActionContext.getRequest().getSession().setAttribute("firstLogin",firstLoginMap);
		}else{
 			String tokentemp = AesUtil.encrypt(username+":"+password+":"+new Date().getTime());
			System.out.println("\nredirect:\ngw_address:"+gw_address+"\ngw_port:"+gw_port+"\ngw_id:"+gw_id+"\nusername:"+username+"\npassword:"+password+"\ntoken:"+token);
			try {
				ServletActionContext.getResponse().sendRedirect("http://"+temp.get("address")+":"+temp.get("port")+"/wifidog/auth?token="+tokentemp);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "index";
	}
	public String regist(){
		if(username==null || password==null){
			return "index";
		}else{
			boolean flag = new UserDao().insert(new User(username,password,"","",0,0,0,0,"off"));
			if(flag) return SUCCESS;
			return ERROR;
		}
	}
	public void ping(){
		//System.out.println("\nping:\nstage:"+stage+"\n"+"ip:"+ip+"\n"+"mac:"+mac+"\n"+"token:"+token+"\n"+"incoming:"+incoming+"\n"+"outgoing:"+outgoing+"\n"+"gw_address:"+gw_address+"\n"+"gw_port:"+gw_port+"\n"+"gw_id:"+gw_id);
		writetoweb("Pong");
	}
	public String msg(){
		if("denied".equals(message)){
			return "denied";
		}
		return SUCCESS;
	}
	
	/**
	 * 验证心跳端 
	 * @param stage 请求类型  login-首次登录验证   counters-心跳验证
	 * @param ip 请求源ip
	 * @param mac 请求源mac
	 * @param token 验证令牌token username:password:timestamp
	 * @param incoming 下载流量
	 * @param outgoing 上传流量
	 */
	public void auth(){
		System.out.println("\nauth:\nstage:"+stage+"\n"+"ip:"+ip+"\n"+"mac:"+mac+"\n"+"token:"+token+"\n"+"incoming:"+incoming+"\n"+"outgoing:"+outgoing+"\n"+"gw_address:"+gw_address+"\n"+"gw_port:"+gw_port+"\n"+"gw_id:"+gw_id);
		String tokentmp = AesUtil.decrypt(token);
		String[] spl = tokentmp.split(":", 3);	
		System.out.println("\n解密后token:"+tokentmp);
		//login验证请求
//			if("login".equals(stage)){
				boolean flag = new UserDao().logincheck(spl[0], spl[1]);
				if(flag && (new Date().getTime()-Long.parseLong(spl[2]))<=36000000){
					
					writetoweb("Auth: 1");
				}else{
					writetoweb("Auth: 0");
				}
//			} 
//			//心跳验证请求
//			else if("counters".equals(stage)){
//				writetoweb("Auth: 1");
//			}
//			else{
//				writetoweb("Auth: 0");
//			}
	}
	public String portal(){
		System.out.println("\nportal:\nstage:"+stage+"\n"+"ip:"+ip+"\n"+"mac:"+mac+"\n"+"token:"+token+"\n"+"incoming:"+incoming+"\n"+"outgoing:"+outgoing+"\n"+"gw_address:"+gw_address+"\n"+"gw_port:"+gw_port+"\n"+"gw_id:"+gw_id);
		return SUCCESS;
	}
	
	/**
	 * 向前端输出内容
	 * @param content 需要向前端输出的内容
	 */
	public void writetoweb(String content){
		try {
			ServletActionContext.getResponse().getWriter().write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
