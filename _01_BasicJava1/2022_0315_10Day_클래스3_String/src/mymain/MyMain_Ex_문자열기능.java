package mymain;

public class MyMain_Ex_문자열기능 {
	public static void main(String[] args) {
		//주민번호(Resident Regitration number)
		String rrn = "601221-1345222";
		
		//문자열 길이
		System.out.println(rrn.length());
		
		//성별 추출
		char gender = rrn.charAt(7);
		if(gender == '1' || gender == '3' || gender == '5' || gender =='7') {
			System.out.println("남자");
		}else {
			System.out.println("여자");
		}
		
		//내국인/외국인
		//남자) 내국인 : 1800년대(9), 1900년대(1), 2000년대(3)
		//남자) 외국인 :              1900년대(5), 2000년대(7)
		//여자) 내국인 : 1800년대(0), 1900년대(2), 2000년대(4)
		//여자) 내국인 :              1900년대(6), 2000년대(8)
		
		//출생년도 추출
		//String.substring(beginning index, end index) - end index 전까지
		//end index = begin index+갯수 로 외우는게 쉬움
		String rrn_year = rrn.substring(0,2); 
		//Integar.parseInt()   : 문자열 --> 정수
		//Double.parseDouble() : 문자열 --> 실수 
		int year = Integer.parseInt(rrn_year);
		if(gender == '1' || gender == '2' || gender == '5' || gender =='6') {
			System.out.printf("%d년생\n",year+1900);
		}else {
			System.out.printf("%d년생\\n",year+2000);
		}
		
		//주민번호 뒷자리 추출
		String rrn_back = rrn.substring(7); //7부터 끝까지 추출
		System.out.println(rrn_back);
		
		//문자 또는 문자열의 위치 찾기
		String str = "I am Tom, you are a Jane";
		//1) 문자의 위치
		int index = str.indexOf('a');
		System.out.println("index : "+index);
		
		//2) 문자열의 위치 - 문자열의 시작 위치
		index = str.indexOf("Tom");
		System.out.println("index : "+index);
		
		//3) 문자의 위치 - 지정된 뒤에서부터
		index = str.lastIndexOf('a');
		System.out.println("index : "+index);
		
		//문자열 중에 Jane단어가 있나?
		boolean bOk = str.contains("Jane");
		System.out.printf("contain? : %b\n",bOk);
		
		//접두어와 접미사가 특정 문자열이 맞는지 확인
		String chat = "[채팅] *길동님, 안녕";
		
		bOk = chat.startsWith("[채팅]");
		System.out.printf("starts with \"[채팅]\" ? : %b\n",bOk);
		
		bOk = chat.endsWith(".");
		System.out.printf("ends with \".\" ? : %b\n",bOk);
		
		//문자 -> 정수
		//'0' = 48, '1' = 49 ... '4' = 52
		//'4' - '0' 
		int num = '4'-'0';
		System.out.println(num);
		
		if((gender-'0')%2 == 1) { //홀수
			
		}
	}	
}
