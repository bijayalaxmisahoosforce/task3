package com.example.trades.response;

import org.springframework.stereotype.Component;

@Component
public class CommonResponse {

	private String status;
	private String statusMsg;
	private Object result;

	public CommonResponse() {
		super();
	}

	public CommonResponse(String status, String statusMsg, Object result) {
		super();
		this.status = status;
		this.statusMsg = statusMsg;
		this.result = result;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
