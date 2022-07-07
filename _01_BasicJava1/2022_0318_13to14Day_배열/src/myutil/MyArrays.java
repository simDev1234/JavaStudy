package myutil;

public class MyArrays {
	
	//�迭 ���� ���
	public static void display_array(int[] ar) { 
		//������ ���� �ٲٴ� ����Ű ctrl+1
		System.out.print("[");
		for(int i = 0; i < ar.length; i++) {
			if(i==0) 
				System.out.printf("%d",ar[i]);
			else 
				System.out.printf(" %d",ar[i]);
		}
		System.out.print("]\n");
	}
	
	//ar�迭�� ��� ��ҿ� value������ ä���
	public static void fill(int[] ar, int value) {
		for(int i = 0; i < ar.length; i++) {
			ar[i] = value;
		}
	}
	
	//ar�迭�� beginIndex<= n < endIndex ������ value�� ä���
	public static void fill(int[] ar, int beginIndex, int endIndex, int value) {
		if(endIndex > ar.length) {
			System.out.println("Not Available Index Number");
		}
		for(int i = beginIndex; i < endIndex; i++) {
			ar[i] = value;
		}
	}
	
	/*���� ���� �ǻ� �ڵ�
	  //n = ar.length
	  for i from 0 to n-1 **���⼭ to=less than
	  	(select i'th item)
  		  for j from i+1 to n
  		  	if i'th item is bigger than j'th item
  		  		swap j'th item with i'th item
	 */
	//�������� ����_���� ����(selection sort)
	public static void sort_asc(int[] ar) {
		int tmp = 0;
		//(int min = 0)
		for(int i = 0; i < ar.length-1; i++) {
			//(min = i)
			for(int j = i+1; j < ar.length; j++) {
				if(ar[i]>ar[j]) {
					tmp = ar[i];
					ar[i] = ar[j];
					ar[j] = tmp;
				}
			}
		}
	}
	
	//�������� ����_���� ����(selection sort)
	public static void sort_desc(int[] ar) {
		int tmp = 0;
		for(int i = 0; i < ar.length-1; i++) {
			for(int j = i+1; j < ar.length; j++) {
				if(ar[i]<ar[j]) {
					tmp = ar[j];
					ar[j] = ar[i];
					ar[i] = tmp;
				}
			}
		}
	}
	
	//�������� �κ� ����_���� ����(selection sort) *toIndex ������
	public static void sort_asc(int[] ar, int fromIndex, int toIndex) {
		int tmp = 0;
		for(int i = fromIndex; i < toIndex-1; i++) {
			for(int j = i+1; j < toIndex; j++) {
				if(ar[i]>ar[j]) {
					tmp = ar[i];
					ar[i] = ar[j];
					ar[j] = tmp;
				}
			}
		}
	}
	
	//�������� �κ� ����_���� ����(selection sort) *toIndex ������
	public static void sort_desc(int[] ar, int fromIndex, int toIndex) {
		int tmp = 0;
		for(int i = fromIndex; i < toIndex-1; i++) {
			for(int j = i+1; j < toIndex; j++) {
				if(ar[i]<ar[j]) {
					tmp = ar[j];
					ar[j] = ar[i];
					ar[i] = tmp;
				}
			}
		}
	}
	
	//for��(���� loop) : JDK 5.0 later
	public static void loopAfterJDK5(int[] mr) {
		//÷��(index)�� �̿�
		/*
		for(int i = 0; i < mr.length; i++) {
			System.out.print(mr[0]+" ");
		}
		System.out.println();
		*/
		//�迭 �Ǵ� Collection/Map
		for(int m : mr) {   //�迭�� item�� m�� �ϳ��� ����
			System.out.print(m+" ");
		}
		System.out.println();
	}	
	
}
