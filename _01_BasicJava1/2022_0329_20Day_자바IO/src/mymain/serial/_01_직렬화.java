package mymain.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import vo.PersonVo;

public class _01_����ȭ {

	public static void main(String[] args) throws Exception {
		/*
		PersonVo p = new PersonVo("ȫ�浿",20,"����� ������ ������");
		
		OutputStream os = new FileOutputStream("person.dat");
		
		//����ȭ ó�� ��ü�� ����(����)
		ObjectOutputStream oos = new ObjectOutputStream(os);
		
		//����ȭ
		oos.writeObject(p);
		
		//�ݱ�(��������)
		oos.close();
		os.close();
		*/
		
		//������ȭ->�б�(����)
		InputStream is = new FileInputStream("person.dat");
		//������ȭ ��ü�� ����
		ObjectInputStream ois = new ObjectInputStream(is);
		
		//ȭ�� ������ �о�ͼ� ����(������ȭ : ��ü�� ����)
		PersonVo p1 = (PersonVo)ois.readObject();
		System.out.println(p1);
		
		//�ݱ�
		ois.close();
		is.close();
	}

}
