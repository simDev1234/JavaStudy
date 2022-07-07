package mymain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class _06_Properties {

	public static void main(String[] args) {
		//�Ӽ��� ��������ϴ� ��ü
		//Properties prop = new Properties();
		/*
		  Map&Properties
		  1. ������� ����(key value)
		  2. Map : ��ü�� �������
		     Properties : ���ڿ� �Ӽ�����
		*/
		//�Ӽ��� ��������ϴ°�ü(DB��������)
		Properties prop = new Properties();
		prop.put("drive", "oracle.jdbc.driver.OracleDriver");
		prop.setProperty("url", "jdbc:oracle:thin:@localhost:1521:xe");
		prop.setProperty("username", "scott");
		prop.setProperty("password", "tiger");
		
		//�� �о����
		String driver = prop.getProperty("driver");
		System.out.printf("driver : %s\n",driver);
		
		try {
			//ȭ�Ϸκ��� DB���������� �о����
			Properties db_prop = new Properties();
			FileReader fr = new FileReader("db properties");
			db_prop.load(fr);
			
			//�� �Ӽ��� �о����
			String driver1 = db_prop.getProperty("driver");
			String url = db_prop.getProperty("url");
			String username = db_prop.getProperty("username");
			String password = db_prop.getProperty("password");
			
			System.out.println("---[ȭ�Ϸκ��� �о�� DB����]---");
			System.out.printf("driver   : %s%n",driver1);
			System.out.printf("url      : %s%n",url);
			System.out.printf("username : %s%n",username);
			System.out.printf("password : %s%n",password);
			
			//�ݱ�
			fr.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
	}

}
