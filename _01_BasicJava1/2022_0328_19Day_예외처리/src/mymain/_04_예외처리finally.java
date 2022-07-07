package mymain;

import java.io.FileReader;
import java.io.IOException;

public class _04_예외처리finally {
	public static void main(String[] args) {
		
		FileReader fr = null;
		
		try {
			System.out.println("---Try---");
			fr = new FileReader("a.txt");
			//int res = 10/0;
		}catch(Exception e) {
			System.out.println("---Catch---");
		}finally { //예외 발생 여부와 상관없이 무조건 실행
			//System.out.println("---finally---"); 
			
			try {
				//화일이 열려 있으면 닫아라
				if(fr!=null) fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
