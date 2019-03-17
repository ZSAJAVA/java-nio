package cn.xc;

import java.util.Scanner;

public class Demo5 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("酒店预订系统");
		Hotel h = new Hotel();
		h.print();
		while(true) {
			System.out.println("请输入房间编号:");
			int num = sc.nextInt();
			h.order(num);
			h.print();
		}
	}
}
 
class Room {
	/**
	 * 房间号
	 */
	private int no;
	/**
	 * 房间类型
	 */
	private String type;
	/**
	 * 房间是否被预订
	 */
	private boolean isReserved;
 
	public Room(int no, String type, boolean isReserved) {
		super();
		this.no = no;
		this.type = type;
		this.isReserved = isReserved;
	}
 
	public int getNo() {
		return no;
	}
 
	public void setNo(int no) {
		this.no = no;
	}
 
	public String getType() {
		return type;
	}
 
	public void setType(String type) {
		this.type = type;
	}
 
	public boolean isReserved() {
		return isReserved;
	}
 
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
 
	@Override
	public String toString() {
		return "[" + no + "," + type + "," + (isReserved ? "已被预订" : "空闲")+"]";
	}
}
 
class Hotel {
	Room[][] rooms;
 
	public Hotel() {
		rooms = new Room[6][6];// 酒店有6层,每层有6个房间
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				if (i == 0 || i == 1 || i == 2) {
					rooms[i][j] = new Room((i + 1) * 100 + j + 1, "标准间", false);
				}
				if (i == 3 || i == 4) {
					rooms[i][j] = new Room((i + 1) * 100 + j + 1, "双人间", false);
				}
				if (i == 5) {
					rooms[i][j] = new Room((i + 1) * 100 + j + 1, "豪华间", false);
				}
			}
		}
	}
	/**
	 * 对外提供酒店房间的状态的方法
	 */
	public void print() {
		for (int i = 0; i < rooms.length;i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				System.out.print(rooms[i][j]);
			}
			System.out.println();// 换行
		}
		
	}
	/**
	 * 对外提供酒店预订方式
	 * @param no
	 */
	public void order(int no) {
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				if (no == rooms[i][j].getNo() && rooms[i][j].isReserved() == false) {
					rooms[i][j].setReserved(true);
					System.out.println("恭喜你预订成功");
				}
			}
		}
	}
}
