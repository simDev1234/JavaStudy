package mymain.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

import vo.PersonVo;

public class _01_직렬화2 {

	public static void main(String[] args) throws Exception {
		/*
		PersonVo[] p = {
				new PersonVo("1길동",20,"서울시 마포구 서교동"),
				new PersonVo("2길동",20,"서울시 마포구 서교동"),
				new PersonVo("3길동",20,"서울시 마포구 서교동"),
				new PersonVo("4길동",20,"서울시 마포구 서교동"),
				new PersonVo("5길동",20,"서울시 마포구 서교동")
		};
		
		OutputStream os = new FileOutputStream("person_array.dat");
		
		//직렬화 처리 객체로 연결(필터)
		ObjectOutputStream oos = new ObjectOutputStream(os);
		
		//직렬화
		oos.writeObject(p);
		
		//닫기(열린역순)
		oos.close();
		os.close();
		*/
		
		//역직렬화->읽기(복원)
		InputStream is = new FileInputStream("person_array.dat");
		//역직렬화 객체로 필터
		ObjectInputStream ois = new ObjectInputStream(is);
		
		//화일 내용을 읽어와서 복원(역직렬화 : 객체로 조립)
		PersonVo[] p_array1 = (PersonVo[])ois.readObject();
		System.out.println("----------[역직렬화(복원)된 배열----------");
		for(PersonVo p : p_array1) {
			System.out.println(p);
		}
		
		//닫기
		ois.close();
		is.close();
		
	}

}
