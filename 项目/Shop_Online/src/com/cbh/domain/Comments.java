package com.cbh.domain;

public class Comments {

	private String id;
	private String uid;
	private String username;
	private String pid;
	private String pname;
	private String datetime;
	private String contents;
	private String reply;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Comments [id=" + id + ", uid=" + uid + ", username=" + username + ", pid=" + pid + ", pname=" + pname
				+ ", datetime=" + datetime + ", contents=" + contents + ", reply=" + reply + "]";
	}
	
}
