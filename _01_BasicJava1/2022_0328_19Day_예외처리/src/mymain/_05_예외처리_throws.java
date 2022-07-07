package mymain;

import java.util.ArrayList;

import myutil.MyArrayList;

public class _05_예외처리_throws {

	public static void main(String[] args) {
		//<<Collection>> : 자바의 모든 객체를 저장할 수 있다.(Object로 저장)
		//ㄴList <- ArrayList
		//ArrayList(동적 배열)
		ArrayList list = new ArrayList(); //Object타입으로 저장 (최초 최대 10개)
		System.out.printf("list's size()=%d%n",list.size());
		
		list.add(10);
		//list.add(new Integer(10)); *Auto-Boxing
		System.out.printf("list's size()=%d%n",list.size());
		list.add(20);
		System.out.printf("list's size()=%d%n",list.size());
		list.add(30);
		System.out.printf("list's size()=%d%n",list.size());

		//down-casting : 영역의 확장
		//int n = (Integer)list.get(1); auto-unboxing
		int n = (int)list.get(1);
		System.out.println(n);
		
		//전체데이터 읽어오기
		for(int i = 0; i < list.size(); i++) {
			int m = (int)list.get(i);
			System.out.printf("index->%d : %d\n",i,m);
		}
		
		//삭제 : index->1
		list.remove(1);
		System.out.println("--삭제 후 데이터--");
		
		//전체데이터 읽어오기
		for(int i = 0; i < list.size(); i++) {
			int m = (int)list.get(i);
			System.out.printf("index->%d : %d\n",i,m);
		}
		//-------------------------------------------------
		
		//MyArrayList
		System.out.println("-----------MyArrayList---------");
		MyArrayList list1 = new MyArrayList();
		list1.add(10);
		list1.add(20);
		list1.add(30);
		System.out.printf("list1's size()=%d%n",list1.size());
		
		//index 2번째의 객체정보를 얻어온다.(get())
		try {
			int index = 2;
			int n1 = (int)list1.get(index);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//index 1번째의 객체정보 삭제 (remove())
		try {
			int index = 1;
			list1.remove(index);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("list1's size()=%d%n",list1.size());
	}

}
