package mymain;

import java.util.Scanner;

public class Q3_Bmi {

	public static void main(String[] args) {
		//BMI(체질량 지수) = 몸무게/(키)^2(m)
		//20미만 : 저체중
		//20-24 : 정상
		//25-29 : 과체중
		//30 이상 : 비만
		
		double weight;
		double height;
		double height_m;
		double bmi;
		
		//사용자 입력
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("신장 : ");
		height = scanner.nextDouble();
		height_m = height/100.0; //cm -> m
		
		System.out.print("체중 : ");
		weight = scanner.nextDouble(); //kg
		
		//bmi지수에 따라 결과 출력
		bmi = weight/(height_m*height_m);
		/* bmi = weight/height_m*height_m 으로 할 경우, 
		   계ㅌ산 오류 나타남
		*/
		
		if(bmi < 20) {
			System.out.printf("BMI : %.4f [저체중]\n",bmi);
		} else if ( bmi > 20 &&  bmi <= 24) {
			System.out.printf("BMI : %.4f [정상]\n",bmi);
		} else if ( bmi > 24 &&  bmi <= 29) {
			System.out.printf("BMI : %.4f [과체중]\n",bmi);
		}else {
			System.out.printf("BMI : %.4f [비만]\n",bmi);
		}
		
		scanner.close();
		
	}

}
