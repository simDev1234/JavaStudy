package mymain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class _01_SetTest {
	/*
		Set
		1. �������� ����Ǵ� �ڷᱸ��
		2. ���ϰ� ������ �� ��.(unique) 
		
		Set
		 ��HashSet(�������� ���)
		 ��TreeSet(��Ʈ�ż� ���)
	*/
	public static void main(String[] args) {
		//�ڹ��� ��� ��ü ���尡��
		Set set1 = new HashSet();
		set1.add(10);
		set1.add(10.5);
		set1.add(true);
		set1.add(10);
		System.out.println(set1);
		
		//���׸�(generic) : �÷��ǿ� ����� ������Ÿ���� ����
		Set<Integer> set2 = new TreeSet<Integer>();
		set2.add(10);
		//set2.add("�ȳ�");
		//set2.add(10.5);
		set2.add(5);
		set2.add(3);
		set2.add(8);
		System.out.println(set2);
		
		Set<String> set3 = new HashSet<String>();
		set3.add("���");
		set3.add("����");
		set3.add("����");
		set3.add("����");
		set3.add("����");
		
		for(String fruit : set3) {
			System.out.println(fruit);
		}
		
		//Iterator(�ݺ���)
		Iterator<String> it = set3.iterator();
		
		while(it.hasNext()) {
			String fruit = it.next(); 
			System.out.println(fruit);
		}
		
		//�ζǹ�ȣ ����
		Random random = new Random();
		int n = 6;
		Set<Integer> lottoSet = new TreeSet<Integer>();
		while(n>0) {
			int su = random.nextInt(45)+1;
			if(lottoSet.add(su)==false) continue;
			n--;
		}
		System.out.println(lottoSet);
		
		//Collection -> Array����
		Integer[] lotto_array = new Integer[lottoSet.size()];
		lottoSet.toArray(lotto_array);
		
		for(int i = 0; i < lotto_array.length; i++) {
			System.out.printf("%d:%d%n",i,lotto_array[i]);
		}
	}

	
	
}
