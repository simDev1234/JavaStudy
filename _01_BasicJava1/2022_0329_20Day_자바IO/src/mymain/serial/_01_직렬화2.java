package mymain.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

import vo.PersonVo;

public class _01_����ȭ2 {

	public static void main(String[] args) throws Exception {
		/*
		PersonVo[] p = {
				new PersonVo("1�浿",20,"����� ������ ������"),
				new PersonVo("2�浿",20,"����� ������ ������"),
				new PersonVo("3�浿",20,"����� ������ ������"),
				new PersonVo("4�浿",20,"����� ������ ������"),
				new PersonVo("5�浿",20,"����� ������ ������")
		};
		
		OutputStream os = new FileOutputStream("person_array.dat");
		
		//����ȭ ó�� ��ü�� ����(����)
		ObjectOutputStream oos = new ObjectOutputStream(os);
		
		//����ȭ
		oos.writeObject(p);
		
		//�ݱ�(��������)
		oos.close();
		os.close();
		*/
		
		//������ȭ->�б�(����)
		InputStream is = new FileInputStream("person_array.dat");
		//������ȭ ��ü�� ����
		ObjectInputStream ois = new ObjectInputStream(is);
		
		//ȭ�� ������ �о�ͼ� ����(������ȭ : ��ü�� ����)
		PersonVo[] p_array1 = (PersonVo[])ois.readObject();
		System.out.println("----------[������ȭ(����)�� �迭----------");
		for(PersonVo p : p_array1) {
			System.out.println(p);
		}
		
		//�ݱ�
		ois.close();
		is.close();
		
	}

}
