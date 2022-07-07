package mymain;

import java.util.Scanner;

public class _03_Ex_switch1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String fruit; //과일명
		String res = ""; //result
		
		System.out.print("과일명 : ");
		fruit = scanner.next();
		
		
		//if(fruit.equals("포도"))
		switch (fruit) 
		{
			case "포도" : res="달다";     break;
			case "수박" : res="시원하다"; break;
			case "딸기" : res="맛있다";   break;
			case "참외" : res="알아둬";   break;
			default:      res="무슨맛";
			//default는 모든 명령의 끝이라 break 필요 없음
		}
		//위에서 break를 모두 삭제하면 어떤 걸 쳐도 "무슨맛"이 나옴
		//why? 만약 "포도"를 치면 res="달다"하고, res="시원하다"... res="무슨맛"까지 명령수행
		System.out.printf("[%s]는(은) [%s]\n",fruit,res);
		
		scanner.close();
	}

}
