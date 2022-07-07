package mymain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class _01_SetTest {
	/*
		Set
		1. 순서없이 저장되는 자료구조
		2. 동일값 저장이 안 됨.(unique) 
		
		Set
		 ㄴHashSet(순서없이 출력)
		 ㄴTreeSet(소트돼서 출력)
	*/
	public static void main(String[] args) {
		//자바의 모든 객체 저장가능
		Set set1 = new HashSet();
		set1.add(10);
		set1.add(10.5);
		set1.add(true);
		set1.add(10);
		System.out.println(set1);
		
		//제네릭(generic) : 컬렉션에 저장된 데이터타입을 저장
		Set<Integer> set2 = new TreeSet<Integer>();
		set2.add(10);
		//set2.add("안녕");
		//set2.add(10.5);
		set2.add(5);
		set2.add(3);
		set2.add(8);
		System.out.println(set2);
		
		Set<String> set3 = new HashSet<String>();
		set3.add("사과");
		set3.add("포도");
		set3.add("참외");
		set3.add("수박");
		set3.add("딸기");
		
		for(String fruit : set3) {
			System.out.println(fruit);
		}
		
		//Iterator(반복자)
		Iterator<String> it = set3.iterator();
		
		while(it.hasNext()) {
			String fruit = it.next(); 
			System.out.println(fruit);
		}
		
		//로또번호 생성
		Random random = new Random();
		int n = 6;
		Set<Integer> lottoSet = new TreeSet<Integer>();
		while(n>0) {
			int su = random.nextInt(45)+1;
			if(lottoSet.add(su)==false) continue;
			n--;
		}
		System.out.println(lottoSet);
		
		//Collection -> Array추출
		Integer[] lotto_array = new Integer[lottoSet.size()];
		lottoSet.toArray(lotto_array);
		
		for(int i = 0; i < lotto_array.length; i++) {
			System.out.printf("%d:%d%n",i,lotto_array[i]);
		}
	}

	
	
}
