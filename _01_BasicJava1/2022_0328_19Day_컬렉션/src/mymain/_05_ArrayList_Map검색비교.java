package mymain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vo.PersonVo;

public class _05_ArrayList_Map�˻��� {
	public static void main(String[] args) {
		List<PersonVo> p_list = new ArrayList<PersonVo>();
		Map<String, PersonVo> pMap = new HashMap<String, PersonVo>();
		
		for(int i = 1; i <= 100; i++) {
			String name = String.format("�浿%03d",i);
			int age = 20+i%11;
			String addr = String.format("����� ������ ����%d��",i%3+1);
			
			PersonVo  p = new PersonVo(name, age, addr);
			
			//ArrayList�� �������� �߰�
			p_list.add(p);
			
			//HashMap�� key��(�̸�)�� �������� �Բ� �߰�
			pMap.put(name, p);
		}
		
		//�˻��� ������
		String search_name = "�浿001";
		
		//(Linear Search from ArrayList) 
		//���ʷ� �ش� �����͸� �߰��� ������ �˻�Ƚ�� ���� 
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
		System.out.printf("[%s]�� �߰��� �������� �˻�Ƚ�� : %d%n",search_name,count);
		
		//(Linear Search with key from HashMap)
		PersonVo p = pMap.get(search_name);
		System.out.println("-------Map �˻� ���------\nresult : "+p);
	}
}
