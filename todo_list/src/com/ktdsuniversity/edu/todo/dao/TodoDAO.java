package com.ktdsuniversity.edu.todo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//* : '전부 다' → 프로그램을 무겁게 만드는 원인 / 왠만해선 쓰지 말 것
//vo 뒤에서 .을 입력하면 가진 기능들이 또 나옴 → 거기서 기능을 찾아서 필요한것만 가져올 것
import com.ktdsuniversity.edu.todo.vo.TodoVO;

public class TodoDAO {
	
	private static int count = 1;
	
	
	//TodoVO는 왜 오류가 나는가? → 이 클래스와 TodoVO의 패키지가 서로 다르기 때문!
	//그렇기에 import가 필요하다 
	private Map<Integer, TodoVO> dataSource;
	
	public TodoDAO() {
		dataSource = new HashMap<>();
	}
	
	//등록
	//1건만 return을 시킬 것임
	public int create(String itemName) {
		//size()는 쓸 수 없음(삭제를 쓰고 나서 덮어씌워질 우려가 있음) → 이럴 때 static을 사용함
		//++은 명령이 끝난 후에 1을 더함 → 다음번에 데이터가 들어올 때는 count가 2가 됨
		dataSource.put(count++, new TodoVO(itemName));
		return 1;
	}
	
	//조회(1건)
	public TodoVO read(int number) {
		//datasource에서 이 number에 대한 값을 가지고 와서 return해라
		return dataSource.get(number);
	}
	
	
	//조회(모든건)
	//람다 할 때 다시 배우게 될 것... 일단 적어만 두기 (함수 지향 언어)
	public List<TodoVO> readAll() {
		return dataSource.entrySet()
						 .stream()
						 .map(entry -> entry.getValue())  // << 함수로 파라미터가 전달되는 부분
						 .collect(Collectors.toList());
	}
	
	//수정
	//몇 번 key에 있는 값을 isSuccess로 바꿔라
	public int update(int key, boolean isSuccess) {
		TodoVO todoVO = dataSource.get(key);
		todoVO.setIsSuccess(isSuccess);
		return 1;
	}
	
	//삭제(1건)
	public int delete(int key) {
		dataSource.remove(key);
		return 1;
	}
	
	//삭제(모든건)
	public int deleteAll() {
		int size = dataSource.size();
		dataSource.clear();
		return size;
	}
	
	

}














