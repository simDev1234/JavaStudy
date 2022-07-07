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

public class _01_직렬화3 {

	public static void main(String[] args) throws Exception {
		/*
		List<PersonVo> list = new ArrayList<PersonVo>();
		list.add(new PersonVo("1길동",21,"서울시 마포구 서교동"));
		list.add(new PersonVo("2길동",22,"서울시 마포구 서교동"));
		list.add(new PersonVo("3길동",23,"서울시 마포구 서교동"));
		list.add(new PersonVo("4길동",24,"서울시 마포구 서교동"));
		list.add(new PersonVo("5길동",25,"서울시 마포구 서교동"));
		
		
		OutputStream os = new FileOutputStream("person_list.dat");
		
		//직렬화 처리 객체로 연결(필터)
		ObjectOutputStream oos = new ObjectOutputStream(os);
		
		//직렬화
		oos.writeObject(list);
		
		//닫기(열린역순)
		oos.close();
		os.close();
		*/
		
		//역직렬화->읽기(복원)
		InputStream is = new FileInputStream("person_list.dat");
		//역직렬화 객체로 필터
		ObjectInputStream ois = new ObjectInputStream(is);
		
		//화일 내용을 읽어와서 복원(역직렬화 : 객체로 조립)
		PersonVo[] p_array1 = (PersonVo[]) ois.readObject();
		System.out.println("----------[역직렬화(복원)된 배열----------");
		for(PersonVo p : p_array1) {
			System.out.println(p);
		}
		
		//닫기
		ois.close();
		is.close();
		
	}

}
