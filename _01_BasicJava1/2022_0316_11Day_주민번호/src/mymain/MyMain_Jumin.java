package mymain;

import java.util.Scanner;
import myutil.Jumin;

public class MyMain_Jumin {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Jumin jumin = new Jumin();
		
		String jumin_no;
		String yn = "Y";
		
		OUTER_LOOP : 
		while(true) {
			System.out.print("주민번호를 입력하세요(예) 000000-0000000) :");
			jumin_no = scanner.next(); //공백포함 입력 시, nextLine();
			
			//주민번호 관리 객체에게 주민번호 전달(setter에게 전달)
			jumin.setJumin_no(jumin_no);
			
			//부가정보 요청(출생년도, 나이, 띠, 성별, 지역번호, 계절, 간지, 유효성체크)
			boolean valid = jumin.isValid(); //유효성
			if(valid == true) {
				System.out.printf("출생년도 : %d\n",jumin.getYear());
				System.out.printf("성별 : %s\n",jumin.getGender());
				System.out.printf("나이 : %s\n",jumin.getAge());
				System.out.printf("띠 : %s\n",jumin.getTti());
				System.out.printf("성별 : %s\n",jumin.getGender());
				System.out.printf("지역변호 : %s\n",jumin.getLocal());
				System.out.printf("계절 : %s\n",jumin.getSeason());
				System.out.printf("간지 : %s\n",jumin.getGanji());
			}else {
				System.out.println("존재하지 않는 주민번호입니다.");
			}
			
			//재시작여부	
			for(;;) {			
				System.out.print("다시 하시겠습니까?(y/n) : ");
				yn = scanner.next();
				
				if(yn.equalsIgnoreCase("Y")) 
					break;
				else if(yn.equalsIgnoreCase("N"))
					break OUTER_LOOP;
				else {
					System.out.println("무슨 말인지 모르겠어요. Y 또는 N를 적어주세요.");
					continue;
				}
			}
		}
		
		scanner.close();
	}

}
