package cn.jbit.base;

public class ResBo {

	private String msg;
	private Object data;
	private boolean isSuccess = false;
	
	public boolean isSuccess() {
		return isSuccess;
	}


	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}


	
	
	
	@Override
	public String toString() {
		return "ResBo [msg=" + msg + ", data=" + data + ", isSuccess=" + isSuccess + "]";
	}


	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
