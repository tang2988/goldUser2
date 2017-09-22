package cn.jbit.entity;

import java.util.Date;

public class Media {
	
	public Long mediaId;
	public String picture;
	public String content;
	public String title;
	public Date time;
	public Media() {
	}
	public Long getMediaId() {
		return mediaId;
	}
	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String toString() {
		return "Media [mediaId=" + mediaId + ", picture=" + picture
				+ ", contentl=" + content + ", title=" + title + ", time="
				+ time + "]";
	}
}
