package mymain;

public class Q2_FarenToCel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �µ���ȯ
		// ���� -> ȭ�� : F = 9/5 * C + 32;
		// ȭ�� -> ���� : C = 5/9 *(F-32);
			
		double cel = 7.0;
		double tofar;
		double far = 44.6;
		double tocel;
		
		tofar = cel * 9/5 + 32;
		/* (1) cel * (9/5) = double * (int/int) = double * double */
		
		/* 
		    tofar = 9/5 * cel + 32; 
		   
		    (1) 9/5 = int/int = 1
		    (2) 1 * cel = 1 * double 
		 
		 */
		
		tocel = (far-32)*5/9;
		//(double-int) * (int/int) = (double)*(double)
		
		System.out.printf("���� [%.3f] => ȭ�� [%.3f]\n",cel,tofar);
		System.out.printf("ȭ�� [%.3f] => ���� [%.3f]\n",far,tocel);
	}

}
