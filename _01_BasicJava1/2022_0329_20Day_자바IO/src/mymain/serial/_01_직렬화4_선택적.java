package mymain.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import vo.PersonVo;
import vo.PersonVo2;

public class _01_����ȭ4_������ {

	public static void main(String[] args) throws Exception {
		
		/*
		 Ư�� ��ü�� ���� ����ȭ  
		 - ��ü Ŭ������ ������ transient
		 - ��ü Ŭ�������� Externalizable ����
		   *Externalizable : ������ ����ȭ
		 */
		
//		PersonVo2 p = new PersonVo2("ȫ�浿",20,"����� ������ ������");
//		
//		OutputStream os = new FileOutputStream("person2.dat");
//		
//		//����ȭ ó�� ��ü�� ����(����)
//		ObjectOutputStream oos = new ObjectOutputStream(os);
//		
//		//����ȭ
//		oos.writeObject(p);
//		
//		//�ݱ�(��������)
//		oos.close();
//		os.close();
		
		
		//������ȭ->�б�(����)
		InputStream is = new FileInputStream("person2.dat");
		//������ȭ ��ü�� ����
		ObjectInputStream ois = new ObjectInputStream(is);
		
		//ȭ�� ������ �о�ͼ� ����(������ȭ : ��ü�� ����)
		PersonVo2 p1 = (PersonVo2)ois.readObject();
		System.out.println(p1);
		
		//�ݱ�
		ois.close();
		is.close();
	}

}
