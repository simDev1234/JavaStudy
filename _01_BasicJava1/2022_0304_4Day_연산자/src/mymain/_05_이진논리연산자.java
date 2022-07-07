package mymain;

public class _05_이진논리연산자 {

	public static void main(String[] args) {
		//5. 이진논리연산자
		System.out.printf("[%32s]\n",Integer.toBinaryString(7));
		System.out.printf("[%32s]\n",Integer.toBinaryString(5));
		
		System.out.printf("[%32s]\n",Integer.toBinaryString(7&5));
		System.out.printf("[%32s]\n",Integer.toBinaryString(7|5));
		System.out.printf("[%32s]\n",Integer.toBinaryString(7^5));
		
		// & ^ | >>의 활용 사례
		
		int birthday = 0x19880815; //실제로 birthday일케 안씀... 4bit가 8개.. 32bit --> int 형
		
		System.out.printf("생년월일 : %x\n",birthday); // 19880805 '0805'제외 하고자함
		
		  //출생년도 추출
		int year = birthday >>> 16; // 16bit만큼 밀기 (16진수 하나당 4bit * 4), 앞 공간(부호영역) 양음수 상관없이 0으로 채워짐
		System.out.printf("출생년도 : %x년\n",year);
		
		  //출생월 추출
		             //0x00198808               
		int month = birthday >>> 8 & 0x000000ff;   //소거(0일때 거짓, 1일때 참. 0&0=0. 1&1=1 >> 1이 있는 쪽은 살아남)
		System.out.printf("출생월 : %02x월\n",month);
		
		  //출생일 추출
		int day = birthday & 0xff;
		//int day = birthday & 0x000000ff; 
		System.out.printf("출생월 : %02x일\n",day);
		
		  //출생연월도에서 월을 수정 - 기존 : 0x19980815
		  //1. 월의 자리를 소거 (^)  -- ^은 서로 배타적일 때 참(1), 그렇지 않으면 거짓(0) >> 1010과 1010은 같음 --> 0000이 됨
		birthday = birthday ^ 0x0000800;
		System.out.printf("생년월일 : %x\n",birthday);
		
		  //2. 추가하고 싶은 월 값 추가 (현재 : 0x19880015)   0 : 0000   5 : 0101
		  //                    |       0x00001100    1 : 0001   0 : 0000
		  //                                              0001       0101
		birthday = birthday | 0x00001100; // |는 추가(0 또는 1 = 1 >> 1010 또는 1001은 1011) 
		System.out.printf("생년월일 : %x\n",birthday);
	}

}
