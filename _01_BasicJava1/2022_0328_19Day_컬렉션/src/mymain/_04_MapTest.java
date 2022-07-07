package mymain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _04_MapTest {
	
	/*
	  
	  Map 
	  ㄴ HashMap (Key집합(Set) 정렬 안 된 상태로 가져온다.)
	  ㄴ TreeMap (Key집합(Set) 정렬해서 가져온다.)  
	 
	*/
	
	public static void main(String[] args) {
		//    key     value
		Map<Integer, String> telMap = new HashMap<Integer, String>();
		
		telMap.put(1, "010-111-1234");
		telMap.put(2, "010-111-1235");
		telMap.put(3, "010-111-1236");
		telMap.put(4, "010-111-1237");
		telMap.put(5, "010-111-1238");
		
		//단축번호1
		int short_num = 1;
		String tel = telMap.get(short_num);
		System.out.printf("단축번호 : %d -> %s%n",short_num,tel);
		
		//Map -> Key집합
		Set<Integer> keySet = telMap.keySet();
		
		System.out.println(keySet);
		
		System.out.println("---[Map전체]---");
		for(Integer key : keySet) {
			
		}
	}
}
