package com.ktdsuniversity.edu.cafe.menu.mgnt.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.ktdsuniversity.edu.cafe.menu.mgnt.vo.MenuMgntVO;

public class MenuMgntDAOImpl implements MenuMgntDAO {

	private Map<String, List<MenuMgntVO>> dataSource;

	public List<MenuMgntVO> getDataSource(String key) {
		return dataSource.get(key);
	}

	public void setDataSource(Map<String, List<MenuMgntVO>> dataSource) {
		this.dataSource = dataSource;
	}

	
	public MenuMgntDAOImpl() {
		dataSource = new HashMap<>();
		dataSource.put("커피", new ArrayList<>());
		dataSource.put("음료", new ArrayList<>());
		dataSource.put("티", new ArrayList<>());
		dataSource.put("디저트", new ArrayList<>());
	}

	@Override
	public int create(String itemType, MenuMgntVO menuMgntVO) {
		dataSource.get(itemType).add(menuMgntVO);
		System.out.println(menuMgntVO.getItemName() + "(이)가 등록되었습니다.");
		return 1;
	}

	@Override
	public int update(String itemType, int itemIdx, MenuMgntVO menuMgntVO) {
		if (itemIdx <= dataSource.get(itemType).size() && dataSource.get(itemType).size() != 0) {
			dataSource.get(itemType).set(itemIdx, menuMgntVO);
			System.out.println(menuMgntVO.getItemName() + "으(로) 수정되었습니다.");
		} else {
			System.out.println("아이템이 존재하지 않습니다.");
		}
		return 1;
	}

	@Override
	public int delete(String itemType, int itemIdx) {
		if (itemIdx <= dataSource.get(itemType).size() && dataSource.get(itemType).size() != 0) {
			dataSource.get(itemType).remove(itemIdx);
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("아이템이 존재하지 않습니다.");
		}
		return 1;
	}

	@Override
	public MenuMgntVO read(String itemType, int itemIdx) {
		if (itemIdx <= dataSource.get(itemType).size() && dataSource.get(itemType).size() != 0) {
			System.out.println(dataSource.get(itemType).get(itemIdx).getItemName());
			return null;
		}
		System.out.println("아이템이 존재하지 않습니다.");
		return null;
	}

	@Override
	public List<MenuMgntVO> readSome(String itemType) {
		return dataSource.get(itemType);
	}

	@Override
	public Map<String, List<MenuMgntVO>> readAll() {
		return dataSource;
	}

}
