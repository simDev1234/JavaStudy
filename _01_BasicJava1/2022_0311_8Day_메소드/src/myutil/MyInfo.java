package myutil;

import java.util.Calendar;

// 1. 출생년도 주어지면
//    - 나이(getAge() ), 띠(getTti()), 60갑자(getGanji())
// 12지 : "쥐", "소", "호랑이", "토끼", "용", "뱀", "말", "양", "원숭이", "닭", "개", "돼지"
// 60갑자 : (간지)갑을병정무기경신임계 + (십이지)자축인묘진사오미신유술해

public class MyInfo {
	
	//bmi수치를 계산하기 : 체중/키(m)^2 (반환타입 : double)
	public double getBmi(double height, double weight) {
		if(height >= 100) {height = height/100;}
		return weight/Math.pow(height, 2);
	}
	
	//bmi수치에 따른 결과(입력 : double, 반환 타입 : String)
	public String getBmiState(double bmi) {
		if(bmi > 25) {
			return "비만";
		}else if(bmi > 23) {
			return "과체중";
		}else if(bmi > 18.5) {
			return "정상";
		}else {
			return "저체중";
		}
	}
	
	//육십 간지 구하기
	public String getGanji(int year) {
		
		//육십간지 : 십간지+십이간지
		//십간지 : 2022 % 10
		//십이간지 : 2022 % 12
		int gan = year % 10;
		int ji = year % 12;
		String result = "";
		
		switch(gan) {
			case  0 : result = "경"; break;
			case  1 : result = "신"; break;
			case  2 : result = "임"; break;
			case  3 : result = "계"; break;
			case  4 : result = "갑"; break;
			case  5 : result = "을"; break;
			case  6 : result = "병"; break;
			case  7 : result = "정"; break;
			case  8 : result = "무"; break;
			default : result = "기"; break;
		}
		switch(ji) {
			case  0 : result += "신"; break;
			case  1 : result += "유"; break;
			case  2 : result += "술"; break;
			case  3 : result += "해"; break;
			case  4 : result += "자"; break;
			case  5 : result += "축"; break;
			case  6 : result += "인"; break;
			case  7 : result += "묘"; break;
			case  8 : result += "진"; break;
			case  9 : result += "사"; break;
			case 10 : result += "오"; break;
			default : result += "미"; break;
		}
		
		return result+"년";
		
		//방법2_문자열과 문자의 결합 사용
		//String gan10 = "경신임계갑을병정무기";
		//String ji12 = "신유술해자축인묘진사오미";
		//int gan = year % 10;
		//int ji = year % 12;
		//return ""+gan10.charAt(gan)+ji12.charAt(ji)+"년";
	}
	
	//띠 구하기
	public String getTti(int year) {
		//쥐, 소, 범... 원숭이 닭...
		// 4, 5,  6 ... 0       1
		// 0부터 : "원숭이", "닭", "개", "돼지", "쥐", "소", "호랑이", "토끼", "용", "뱀", "말", "양"
		int tti_index = year % 12; //0~11이 나옴
		switch(tti_index) {
			case  0 : return "원숭이";
			case  1 : return "닭";
			case  2 : return "개";
			case  3 : return "돼지";
			case  4 : return "쥐";
			case  5 : return "소";
			case  6 : return "호랑이";
			case  7 : return "토끼";
			case  8 : return "용";
			case  9 : return "뱀";
			case 10 : return "말";
			default : return "양";
		}
	}
	
	//나이 구하기
	public int getAge(int year) {
		//현재 시스템 날짜 구하기
		Calendar c = Calendar.getInstance();
		int current_year = c.get(Calendar.YEAR);
		//월 구할 때 (Calendar의 MONTH : 1월 = 0)
		//int current_month = c.get(Calendar.MONTH) + 1; 
		
		//나이 = 현재년도 - 출생년도 + 1; 
		int age = current_year - year + 1;
		return age;
	}
	/*
	 * public int getTti(int year) { //띠 }
	 */
}
