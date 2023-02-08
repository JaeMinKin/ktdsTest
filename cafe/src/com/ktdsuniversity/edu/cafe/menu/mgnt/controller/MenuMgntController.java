package com.ktdsuniversity.edu.cafe.menu.mgnt.controller;

import java.util.Scanner;

import com.ktdsuniversity.edu.cafe.menu.mgnt.dao.MenuMgntDAOImpl;
import com.ktdsuniversity.edu.cafe.menu.mgnt.service.MenuMgntServiceImpl;
import com.ktdsuniversity.edu.cafe.menu.mgnt.vo.MenuMgntVO;

public class MenuMgntController {

	public void printMenu() {
		System.out.println("\n========================================\r\n"
				+ "1. 등록\r\n" + "2. 수정\r\n" + "3. 삭제\r\n"
				+ "4. 조회(1개)\r\n" + "5. 조회(종목별로)\r\n" + "6. 조회(전체)\r\n" + "7. 종료\r\n"
				+ "========================================\n");
	}

	public void printItemTypeMenu() {
		System.out.println("\n========================================\r\n" 
				+ "1. 커피\r\n" + "2. 음료\r\n" + "3. 티\r\n"
				+ "4. 디저트(1개)\r\n" + "5. 뒤로가기(종목별로)\r\n" 
				+ "========================================\n");
	}

	public String changeItemType(int itemType) {
		if (itemType == 1) {
			return "커피";
		} else if (itemType == 2) {
			return "음료";
		} else if (itemType == 3) {
			return "티";
		} else if (itemType == 4) {
			return "디저트";
		} else {
			return "없음";
		}
	}

	public static void main(String[] args) {

		MenuMgntController controller = new MenuMgntController();
		MenuMgntServiceImpl service = new MenuMgntServiceImpl();
		Scanner scan = new Scanner(System.in);

		int menu;
		int itemIdx;
		String itemName;

		System.out.println("Cafe Menu Management System");

		while (true) {
			controller.printMenu();
			System.out.println("메뉴를 입력하세요(숫자) :");

			menu = scan.nextInt();
			scan.nextLine();

			if (menu == 1) {
				controller.printItemTypeMenu();

				System.out.println("등록할 메뉴 타입을 입력하세요.(숫자) :");
				menu = scan.nextInt();
				scan.nextLine();
				if(menu<0 || menu>=5) continue;
				
				System.out.println("등록할 아이템명을 입력하세요.(문자) :");
				itemName = scan.nextLine();
				MenuMgntVO vo = new MenuMgntVO();
				vo.setItemName(itemName);
				
				service.create(controller.changeItemType(menu), vo);
				
			} else if (menu == 2) {
				controller.printItemTypeMenu();

				System.out.println("수정할 메뉴 타입을 입력하세요.(숫자) :");
				menu = scan.nextInt();
				scan.nextLine();

				System.out.println("수정할 아이템 인덱스를 입력하세요(숫자) :");
				itemIdx = scan.nextInt();
				scan.nextLine();

				System.out.println("수정할 아이템명을 입력하세요(문자) :");
				itemName = scan.nextLine();
				MenuMgntVO vo = new MenuMgntVO();
				vo.setItemName(itemName);
				service.update(controller.changeItemType(menu), itemIdx, vo);
				
			} else if (menu == 3) {
				controller.printItemTypeMenu();

				System.out.println("삭제할 메뉴 타입을 입력하세요(숫자) :");
				menu = scan.nextInt();
				scan.nextLine();

				System.out.println("삭제할 아이템 인덱스를 입력하세요(숫자) :");
				itemIdx = scan.nextInt();
				scan.nextLine();

				service.delete(controller.changeItemType(menu), itemIdx);
				
			} else if (menu == 4) {
				controller.printItemTypeMenu();

				System.out.println("조회할 메뉴 타입을 입력하세요.(숫자) :");
				menu = scan.nextInt();
				scan.nextLine();

				System.out.println("조회할 아이템 인덱스 입력하세요.(숫자) :");
				itemIdx = scan.nextInt();
				scan.nextLine();

				service.read(controller.changeItemType(menu), itemIdx);
				
			} else if (menu == 5) {
				controller.printItemTypeMenu();

				System.out.println("조회할 메뉴 타입을 입력하세요.(숫자) :");
				menu = scan.nextInt();
				scan.nextLine();
				
				service.readSome(controller.changeItemType(menu))
					   .forEach( vo -> System.out.println( vo.getItemName() ) );
				
			} else if (menu == 6) {
				service.readAll()
					   .forEach((k,v)-> {
						   System.out.println(k);
						   v.forEach(vo -> System.out.println(vo.getItemName()));
						   System.out.println();
					   });
				
			} else {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}

	}

}
