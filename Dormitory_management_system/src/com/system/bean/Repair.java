package com.system.bean;

public class Repair {
	private String rid;
	private String content;
	private String sid;
	private String time;
	private String situation;
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	@Override
	public String toString() {
		return "Repair [rid=" + rid + ", content=" + content + ", sid=" + sid + ", time=" + time + ", situation="
				+ situation + "]";
	}

	
}
