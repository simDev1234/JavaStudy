package mymain.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vo.PersonVo;

public class _01_����ȭ3 {

	public static void main(String[] args) throws Exception {
		/*
		List<PersonVo> list = new ArrayList<PersonVo>();
		list.add(new PersonVo("1�浿",21,"����� ������ ������"));
		list.add(new PersonVo("2�浿",22,"����� ������ ������"));
		list.add(new PersonVo("3�浿",23,"����� ������ ������"));
		list.add(new PersonVo("4�浿",24,"����� ������ ������"));
		list.add(new PersonVo("5�浿",25,"����� ������ ������"));
		
		
		OutputStream os = new FileOutputStream("person_list.dat");
		
		//����ȭ ó�� ��ü�� ����(����)
		ObjectOutputStream oos = new ObjectOutputStream(os);
		
		//����ȭ
		oos.writeObject(list);
		
		//�ݱ�(��������)
		oos.close();
		os.close();
		*/
		
		//������ȭ->�б�(����)
		InputStream is = new FileInputStream("person_list.dat");
		//������ȭ ��ü�� ����
		ObjectInputStream ois = new ObjectInputStream(is);
		
		//ȭ�� ������ �о�ͼ� ����(������ȭ : ��ü�� ����)
		PersonVo[] p_array1 = (PersonVo[]) ois.readObject();
		System.out.println("----------[������ȭ(����)�� �迭----------");
		for(PersonVo p : p_array1) {
			System.out.println(p);
		}
		
		//�ݱ�
		ois.close();
		is.close();
		
	}

}
