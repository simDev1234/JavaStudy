package mymain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vo.PersonVo;

public class _05_ArrayList_Map검색비교 {
	public static void main(String[] args) {
		List<PersonVo> p_list = new ArrayList<PersonVo>();
		Map<String, PersonVo> pMap = new HashMap<String, PersonVo>();
		
		for(int i = 1; i <= 100; i++) {
			String name = String.format("길동%03d",i);
			int age = 20+i%11;
			String addr = String.format("서울시 마포구 서교%d동",i%3+1);
			
			PersonVo  p = new PersonVo(name, age, addr);
			
			//ArrayList에 개인정보 추가
			p_list.add(p);
			
			//HashMap에 key값(이름)과 개인정보 함께 추가
			pMap.put(name, p);
		}
		
		//검색할 데이터
		String search_name = "길동001";
		
		//(Linear Search from ArrayList) 
		//최초로 해당 데이터를 발견할 때까지 검색횟수 세기 
		//bigO = n, bitOmega = 1;
		int count = 0; 
		for(int i = 0; i < p_list.size(); i++) {
			count++;
			PersonVo p = p_list.get(i);
			if(search_name.equals(p.getName())) {
				System.out.println(p);
				break;
			}
		}
		System.out.printf("[%s]를 발견할 때까지의 검색횟수 : %d%n",search_name,count);
		
		//(Linear Search with key from HashMap)
		PersonVo p = pMap.get(search_name);
		System.out.println("-------Map 검색 결과------\nresult : "+p);
	}
}
