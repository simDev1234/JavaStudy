package mymain;

import java.util.ArrayList;
import java.util.List;

import myutil.MyArrayList;

public class _02_ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> sido_list = new ArrayList<String>();
		sido_list.add("제일");
		sido_list.add("발일");
		sido_list.add("순일");
		sido_list.add("알일");
		sido_list.add("하나");
		sido_list.add("두도");
		sido_list.add("님하");
		sido_list.add("하겠");
		sido_list.add("습다");
		
		System.out.println(sido_list);
		
		System.out.println("----[개선 Loop]----");
		for(String sido : sido_list) {
			System.out.println(sido);
		}
		
		System.out.println("----[첨자]----");
		for(int i = 0; i < sido_list.size(); i++) {
			String s = sido_list.get(i);
			System.out.printf("%d:%s%n",i,s);
		}
		
		//---내가 만든 제네릭
		//클래스 내부의 Generic Type은 객체 생성할 때 형성됨
		MyArrayList<String> fruit_list = new MyArrayList<String>();
		fruit_list.add("사과");
		fruit_list.add("참외");
		fruit_list.add("포도");
		fruit_list.add("수박");
		fruit_list.add("딸기");
		
		MyArrayList<Integer> su_list = new MyArrayList<Integer>();
		
	}

}
