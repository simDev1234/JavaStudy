package mymain;

public class _03_����Ʈ������ {

	public static void main(String[] args) {
		// 3. ����Ʈ ������(=2�� ������) : >>, <<, >>>
		// (10/2) == (10 >> 2)
		int n = 10;
		
		System.out.printf("[%32s]\n",Integer.toBinaryString(n));
		
		int m = n >> 2;
		
		System.out.printf("[%32s]\n",Integer.toBinaryString(m));
		
		m = n << 2;
		
		System.out.printf("[%32s]\n",Integer.toBinaryString(m));
		
		n = -1;
		System.out.printf("[%32s]\n",Integer.toBinaryString(n));
		
		m = n >> 4;
		// >> ���� ����� ��ȣ�� ä������.
		System.out.printf("[%32s]\n",Integer.toBinaryString(m));
		
		m = n >>> 4;
		// >>> ���� ����� 0���� ä������.
		System.out.printf("[%32s]\n",Integer.toBinaryString(m));
		
	}

}
