package com.ktdsuniversity.edu.todo.vo;

public class TodoVO {
	
	private String itemName;
	private Boolean isSuccess;
	
	public TodoVO(String itemName) {
		setItemName(itemName);
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	

}
