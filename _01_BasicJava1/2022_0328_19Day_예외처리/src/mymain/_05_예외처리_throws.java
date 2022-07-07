package mymain;

import java.util.ArrayList;

import myutil.MyArrayList;

public class _05_����ó��_throws {

	public static void main(String[] args) {
		//<<Collection>> : �ڹ��� ��� ��ü�� ������ �� �ִ�.(Object�� ����)
		//��List <- ArrayList
		//ArrayList(���� �迭)
		ArrayList list = new ArrayList(); //ObjectŸ������ ���� (���� �ִ� 10��)
		System.out.printf("list's size()=%d%n",list.size());
		
		list.add(10);
		//list.add(new Integer(10)); *Auto-Boxing
		System.out.printf("list's size()=%d%n",list.size());
		list.add(20);
		System.out.printf("list's size()=%d%n",list.size());
		list.add(30);
		System.out.printf("list's size()=%d%n",list.size());

		//down-casting : ������ Ȯ��
		//int n = (Integer)list.get(1); auto-unboxing
		int n = (int)list.get(1);
		System.out.println(n);
		
		//��ü������ �о����
		for(int i = 0; i < list.size(); i++) {
			int m = (int)list.get(i);
			System.out.printf("index->%d : %d\n",i,m);
		}
		
		//���� : index->1
		list.remove(1);
		System.out.println("--���� �� ������--");
		
		//��ü������ �о����
		for(int i = 0; i < list.size(); i++) {
			int m = (int)list.get(i);
			System.out.printf("index->%d : %d\n",i,m);
		}
		//-------------------------------------------------
		
		//MyArrayList
		System.out.println("-----------MyArrayList---------");
		MyArrayList list1 = new MyArrayList();
		list1.add(10);
		list1.add(20);
		list1.add(30);
		System.out.printf("list1's size()=%d%n",list1.size());
		
		//index 2��°�� ��ü������ ���´�.(get())
		try {
			int index = 2;
			int n1 = (int)list1.get(index);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//index 1��°�� ��ü���� ���� (remove())
		try {
			int index = 1;
			list1.remove(index);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("list1's size()=%d%n",list1.size());
	}

}
