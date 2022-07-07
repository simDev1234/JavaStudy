package mymain;

public class MyMain_Ex_String3_문자열연산 {

	public static void main(String[] args) {
		int count = 0;
		
		//메모리 낭비가 과다하게 발생
		String msg = ++count + "little, " + ++count + "little, " + ++count + "little";
		System.out.println(msg);
		System.out.println(msg.length());
		
		//[해결 방법]
		//방법1) String Buffer 
		//1. 미리 할당
		//2. 데이터를 추가하는 방식 이용
		// StringBuffer sb = new StringBuffer(); //기존적으로 16글자를 위한 메모리공간 확보
		StringBuffer sb = new StringBuffer(40);
		count = 0;
		
		//StringBuffer에 순서대로 추가
		sb.append(++count);
		sb.append("little, ");
		sb.append(++count);
		sb.append("little, ");
		sb.append(++count);
		sb.append("little indian");
		
		//StringBuffer -> String 추출
		String msg1 = sb.toString();
		System.out.println(msg1);
		
		//방법2) String클래스의 format() 사용
		count = 0;
		String mgs2 = String.format("%d liitle, %d little, %d little indian", ++count, ++count, ++count);
		System.out.println(mgs2);
	}

}
