package mymain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class _06_Properties {

	public static void main(String[] args) {
		//속성을 저장관리하는 객체
		//Properties prop = new Properties();
		/*
		  Map&Properties
		  1. 사용방법이 유사(key value)
		  2. Map : 객체를 저장관리
		     Properties : 문자열 속성관리
		*/
		//속성을 저장관리하는객체(DB접속정보)
		Properties prop = new Properties();
		prop.put("drive", "oracle.jdbc.driver.OracleDriver");
		prop.setProperty("url", "jdbc:oracle:thin:@localhost:1521:xe");
		prop.setProperty("username", "scott");
		prop.setProperty("password", "tiger");
		
		//값 읽어오기
		String driver = prop.getProperty("driver");
		System.out.printf("driver : %s\n",driver);
		
		try {
			//화일로부터 DB접속정보를 읽어오기
			Properties db_prop = new Properties();
			FileReader fr = new FileReader("db properties");
			db_prop.load(fr);
			
			//각 속성값 읽어오기
			String driver1 = db_prop.getProperty("driver");
			String url = db_prop.getProperty("url");
			String username = db_prop.getProperty("username");
			String password = db_prop.getProperty("password");
			
			System.out.println("---[화일로부터 읽어온 DB정보]---");
			System.out.printf("driver   : %s%n",driver1);
			System.out.printf("url      : %s%n",url);
			System.out.printf("username : %s%n",username);
			System.out.printf("password : %s%n",password);
			
			//닫기
			fr.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
	}

}
