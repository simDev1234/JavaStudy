package mymain;

public class MyMain_Ex_String3_���ڿ����� {

	public static void main(String[] args) {
		int count = 0;
		
		//�޸� ���� �����ϰ� �߻�
		String msg = ++count + "little, " + ++count + "little, " + ++count + "little";
		System.out.println(msg);
		System.out.println(msg.length());
		
		//[�ذ� ���]
		//���1) String Buffer 
		//1. �̸� �Ҵ�
		//2. �����͸� �߰��ϴ� ��� �̿�
		// StringBuffer sb = new StringBuffer(); //���������� 16���ڸ� ���� �޸𸮰��� Ȯ��
		StringBuffer sb = new StringBuffer(40);
		count = 0;
		
		//StringBuffer�� ������� �߰�
		sb.append(++count);
		sb.append("little, ");
		sb.append(++count);
		sb.append("little, ");
		sb.append(++count);
		sb.append("little indian");
		
		//StringBuffer -> String ����
		String msg1 = sb.toString();
		System.out.println(msg1);
		
		//���2) StringŬ������ format() ���
		count = 0;
		String mgs2 = String.format("%d liitle, %d little, %d little indian", ++count, ++count, ++count);
		System.out.println(mgs2);
	}

}
