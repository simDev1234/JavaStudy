package mymain;

import java.util.ArrayList;
import java.util.List;
import vo.PersonVo;

public class _03_ArrayListTest2 {

	public static void main(String[] args) {
		List<PersonVo> p_list = new ArrayList<PersonVo>();
		
		//p_list.add("안녕");
		p_list.add(new PersonVo("일길동",21,"서울시 마포구 관악구"));
		p_list.add(new PersonVo("이길동",21,"서울시 마포구 관악구"));
		p_list.add(new PersonVo("삼길동",21,"서울시 마포구 관악구"));
		p_list.add(new PersonVo("사길동",21,"서울시 마포구 관악구"));
		p_list.add(new PersonVo("오길동",21,"서울시 마포구 관악구"));
		
		//첫번째 객체
		PersonVo p1 = p_list.get(0);
		System.out.println(p1.toString());
		
		System.out.println("----[첨자 이용]----");
		for(int i = 0; i < p_list.size(); i++) {
			PersonVo p = p_list.get(i);
			System.out.println(p);
		}
		
		System.out.println("----[개선 루프 이용]----");
		for(PersonVo p : p_list) {
			System.out.println(p);
		}
	}

}
