package com.ktdsuniversity.edu.todo.service;

import java.util.List;

import com.ktdsuniversity.edu.todo.dao.TodoDAO;
import com.ktdsuniversity.edu.todo.vo.TodoVO;

//Service : DAO와 Controller 사이의 중계자 역할 (실제로 하는 건 많지 않음)
public class TodoService {
	
	//패키지 달라서 오류 - import 해 줄 것
	private TodoDAO todoDAO;
	
	public TodoService() {
		todoDAO = new TodoDAO();
	}
	
	
	// 등록
	// 서비스는 보통 boolean이나 List 타입을 반환함
	// DAO를 호출만 하는게 역할 (DAO가 가진 변수에는 관심이 없음)
	public boolean create(String itemName) {
		return todoDAO.create(itemName) > 0;
	}
	
	// 조회 (1건)
	//DAO에서 TodoVO타입을 받기 때문에 마찬가지로 TodoVO 사용
	public TodoVO read(int key) {
		return todoDAO.read(key);
	}
	
	// 조회 (모든건)
	public List<TodoVO> readAll() {
		return todoDAO.readAll();
	}
	
	// 수정
	public boolean update(int key, boolean isSuccess) {
		return todoDAO.update(key, isSuccess) > 0;
	}
	
	
	// 삭제 (1건)
	// 모든 건 DAO에 맞춤
	public boolean delete(int key) {
		return todoDAO.delete(key) > 0;
	}
	
	// 삭제 (모든건)
	public boolean deleteAll() {
		return todoDAO.deleteAll() > 0;
	}
	
	
	
	
	
}
