package mymain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _04_MapTest {
	
	/*
	  
	  Map 
	  �� HashMap (Key����(Set) ���� �� �� ���·� �����´�.)
	  �� TreeMap (Key����(Set) �����ؼ� �����´�.)  
	 
	*/
	
	public static void main(String[] args) {
		//    key     value
		Map<Integer, String> telMap = new HashMap<Integer, String>();
		
		telMap.put(1, "010-111-1234");
		telMap.put(2, "010-111-1235");
		telMap.put(3, "010-111-1236");
		telMap.put(4, "010-111-1237");
		telMap.put(5, "010-111-1238");
		
		//�����ȣ1
		int short_num = 1;
		String tel = telMap.get(short_num);
		System.out.printf("�����ȣ : %d -> %s%n",short_num,tel);
		
		//Map -> Key����
		Set<Integer> keySet = telMap.keySet();
		
		System.out.println(keySet);
		
		System.out.println("---[Map��ü]---");
		for(Integer key : keySet) {
			
		}
	}
}
