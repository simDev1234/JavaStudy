package mymain;

public class Q2_FarenToCel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ¿Âµµº¯È¯
		// ¼·¾¾ -> È­¾¾ : F = 9/5 * C + 32;
		// È­¾¾ -> ¼·¾¾ : C = 5/9 *(F-32);
			
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
		
		System.out.printf("¼·¾¾ [%.3f] => È­¾¾ [%.3f]\n",cel,tofar);
		System.out.printf("È­¾¾ [%.3f] => ¼·¾¾ [%.3f]\n",far,tocel);
	}

}
