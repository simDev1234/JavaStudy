package mymain;

import java.util.ArrayList;
import java.util.List;
import vo.PersonVo;

public class _03_ArrayListTest2 {

	public static void main(String[] args) {
		List<PersonVo> p_list = new ArrayList<PersonVo>();
		
		//p_list.add("�ȳ�");
		p_list.add(new PersonVo("�ϱ浿",21,"����� ������ ���Ǳ�"));
		p_list.add(new PersonVo("�̱浿",21,"����� ������ ���Ǳ�"));
		p_list.add(new PersonVo("��浿",21,"����� ������ ���Ǳ�"));
		p_list.add(new PersonVo("��浿",21,"����� ������ ���Ǳ�"));
		p_list.add(new PersonVo("���浿",21,"����� ������ ���Ǳ�"));
		
		//ù��° ��ü
		PersonVo p1 = p_list.get(0);
		System.out.println(p1.toString());
		
		System.out.println("----[÷�� �̿�]----");
		for(int i = 0; i < p_list.size(); i++) {
			PersonVo p = p_list.get(i);
			System.out.println(p);
		}
		
		System.out.println("----[���� ���� �̿�]----");
		for(PersonVo p : p_list) {
			System.out.println(p);
		}
	}

}
