package followme.dream.bean;

import java.math.BigInteger;
import java.util.Date;

public class dmessage {
	private BigInteger messageID;
	private String content;
	private String headURL;
	private Date postdate;
	private String username;
	private int sendID;
	private int receiveID;
	
	public BigInteger getMessageID() {
		return messageID;
	}
	public void setMessageID(BigInteger messageID) {
		this.messageID = messageID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getHeadURL() {
		return headURL;
	}
	public void setHeadURL(String headURL) {
		this.headURL = headURL;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	
	public int getSendID() {
		return sendID;
	}
	public void setSendID(int sendID) {
		this.sendID = sendID;
	}
	public int getReceiveID() {
		return receiveID;
	}
	public void setReceiveID(int receiveID) {
		this.receiveID = receiveID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

}
