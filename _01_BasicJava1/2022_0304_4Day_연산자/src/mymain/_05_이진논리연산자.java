package mymain;

public class _05_������������ {

	public static void main(String[] args) {
		//5. ������������
		System.out.printf("[%32s]\n",Integer.toBinaryString(7));
		System.out.printf("[%32s]\n",Integer.toBinaryString(5));
		
		System.out.printf("[%32s]\n",Integer.toBinaryString(7&5));
		System.out.printf("[%32s]\n",Integer.toBinaryString(7|5));
		System.out.printf("[%32s]\n",Integer.toBinaryString(7^5));
		
		// & ^ | >>�� Ȱ�� ���
		
		int birthday = 0x19880815; //������ birthday���� �Ⱦ�... 4bit�� 8��.. 32bit --> int ��
		
		System.out.printf("������� : %x\n",birthday); // 19880805 '0805'���� �ϰ�����
		
		  //����⵵ ����
		int year = birthday >>> 16; // 16bit��ŭ �б� (16���� �ϳ��� 4bit * 4), �� ����(��ȣ����) ������ ������� 0���� ä����
		System.out.printf("����⵵ : %x��\n",year);
		
		  //����� ����
		             //0x00198808               
		int month = birthday >>> 8 & 0x000000ff;   //�Ұ�(0�϶� ����, 1�϶� ��. 0&0=0. 1&1=1 >> 1�� �ִ� ���� ��Ƴ�)
		System.out.printf("����� : %02x��\n",month);
		
		  //����� ����
		int day = birthday & 0xff;
		//int day = birthday & 0x000000ff; 
		System.out.printf("����� : %02x��\n",day);
		
		  //������������� ���� ���� - ���� : 0x19980815
		  //1. ���� �ڸ��� �Ұ� (^)  -- ^�� ���� ��Ÿ���� �� ��(1), �׷��� ������ ����(0) >> 1010�� 1010�� ���� --> 0000�� ��
		birthday = birthday ^ 0x0000800;
		System.out.printf("������� : %x\n",birthday);
		
		  //2. �߰��ϰ� ���� �� �� �߰� (���� : 0x19880015)   0 : 0000   5 : 0101
		  //                    |       0x00001100    1 : 0001   0 : 0000
		  //                                              0001       0101
		birthday = birthday | 0x00001100; // |�� �߰�(0 �Ǵ� 1 = 1 >> 1010 �Ǵ� 1001�� 1011) 
		System.out.printf("������� : %x\n",birthday);
	}

}
