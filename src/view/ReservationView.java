package view;

import java.util.Scanner;

import vo.Goods;

public class ReservationView {
	private Scanner sc;	
	
	public ReservationView() {
		sc = new Scanner(System.in);
	}
	
	public int showMenu() {		// 자리 예약 메뉴 보여주고 선택 받기
		System.out.println("\n자리 예약");
		System.out.println("1. 자리 예약하기");
		System.out.println("2. 자리 예약 확인하기");
		System.out.println("3. 자리 예약 취소하기");
		System.out.println("4. 남은 자리 확인하기");
		System.out.println("0. 종료하기");
		System.out.print("선택 > ");
		
		int select = sc.nextInt();		
		return select;					// 선택한 값 반환
	}
	
	public int inputPeopleNum() {	// 자리 예약할 사람 수 입력 받기
		System.out.print("\n몇 명이신가요?(1~6명) : ");
		int peopleNum = sc.nextInt();
		return peopleNum;		// 예약 인원 반환
	}
	public int seatReservation(int i) {		// 자리 예약하기
		System.out.print((i+1) + "번째 손님, 몇 번 자리를 예약하시겠습니까?(1~6번) : ");
		int seatIndex = sc.nextInt();		
		return seatIndex;					// 입력한 자리 번호 반환
	}
	public void showIdSeat(int id, int seatIndex) {		// ID, 예약한 자리 보여주기
		System.out.println("ID : " + id + "님, " + seatIndex + "번째 자리 예약하셨습니다.");
	}
	
	public String goodsSelect(Goods[] goods) {
		System.out.println("상품을 선택하세요.\n");
		
		System.out.println("이름\t가격\t수량\t종류");
		for(int i=0; goods[i] != null; i++) {
			if(goods[i].getKind().equals("식사류")) {
				System.out.printf("%s\t%d\t%d\t%s\n",
						goods[i].getName(), goods[i].getPrice(), goods[i].getCount(), "식사류");
			}
		}
		for(int i=0; goods[i] != null; i++) {
			if(goods[i].getKind().equals("주류")) {
				System.out.printf("%s\t%d\t%d\t%s\n", 
						goods[i].getName(), goods[i].getPrice(), goods[i].getCount(), "주류");
			}
		}
		System.out.print("선택 : ");
		String goodsName = sc.next();
		
		return goodsName;
	}
	
	public int inputCount() {
		System.out.print("몇 개를 구매 하시겠습니까? : ");
		int count = sc.nextInt();
		
		return count;
	}
	
	public void overPeopleNum() {	// 자리가 부족할 경우 메시지 출력
		System.out.println("자리가 부족합니다.");
	}
	public void noReservation() {	// 예약할 수 없을 경우 메시지 출력
		System.out.println("예약할 수 없는 자리입니다.");
	}
	public void noGoods() {
		System.out.println("상품을 찾을 수 없습니다.");
	}
	public void lackGoods() {
		System.out.println("재고가 부족합니다.");
	}
}
