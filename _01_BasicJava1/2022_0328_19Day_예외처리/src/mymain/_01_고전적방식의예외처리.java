package mymain;

public class _01_����������ǿ���ó�� {

	public static void main(String[] args) {
		int a = 10;
		int b = 0;
		int res;
		
		if(b!=0) { //�����ڰ� ���� ������ �̸� �����ؼ� ���ذ���
			res = a/b;
		}else {
			System.out.println("0���� ���� �� �����ϴ�.");
		}
		
		String str = null;
		int len = 0;
		if(str!=null) //�������� �̸� ����
			len = str.length();
		else
			System.out.println("str is null");
		
	}//end main()

}
