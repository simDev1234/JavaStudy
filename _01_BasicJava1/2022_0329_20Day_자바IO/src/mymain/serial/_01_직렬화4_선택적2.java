package mymain.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import vo.PersonVo;
import vo.PersonVo3;

public class _01_����ȭ4_������2 {

	public static void main(String[] args) throws Exception {
		
		/*
		 Ư�� ��ü�� ���� ����ȭ  
		 - ��ü Ŭ������ ������ transient
		 - ��ü Ŭ�������� Externalizable ����
		   *Externalizable : ������ ����ȭ
		 */
		
//		PersonVo3 p = new PersonVo3("ȫ�浿",20,"����� ������ ������");
//		
//		OutputStream os = new FileOutputStream("person3.dat");
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
		InputStream is = new FileInputStream("person3.dat");
		//������ȭ ��ü�� ����
		ObjectInputStream ois = new ObjectInputStream(is);
		
		//ȭ�� ������ �о�ͼ� ����(������ȭ : ��ü�� ����)
		PersonVo3 p1 = (PersonVo3) ois.readObject();
		System.out.println(p1);
		
		//�ݱ�
		ois.close();
		is.close();
	}

}
