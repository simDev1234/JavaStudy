package mymain;

public class MyMain_Ex_���ڿ���� {
	public static void main(String[] args) {
		//�ֹι�ȣ(Resident Regitration number)
		String rrn = "601221-1345222";
		
		//���ڿ� ����
		System.out.println(rrn.length());
		
		//���� ����
		char gender = rrn.charAt(7);
		if(gender == '1' || gender == '3' || gender == '5' || gender =='7') {
			System.out.println("����");
		}else {
			System.out.println("����");
		}
		
		//������/�ܱ���
		//����) ������ : 1800���(9), 1900���(1), 2000���(3)
		//����) �ܱ��� :              1900���(5), 2000���(7)
		//����) ������ : 1800���(0), 1900���(2), 2000���(4)
		//����) ������ :              1900���(6), 2000���(8)
		
		//����⵵ ����
		//String.substring(beginning index, end index) - end index ������
		//end index = begin index+���� �� �ܿ�°� ����
		String rrn_year = rrn.substring(0,2); 
		//Integar.parseInt()   : ���ڿ� --> ����
		//Double.parseDouble() : ���ڿ� --> �Ǽ� 
		int year = Integer.parseInt(rrn_year);
		if(gender == '1' || gender == '2' || gender == '5' || gender =='6') {
			System.out.printf("%d���\n",year+1900);
		}else {
			System.out.printf("%d���\\n",year+2000);
		}
		
		//�ֹι�ȣ ���ڸ� ����
		String rrn_back = rrn.substring(7); //7���� ������ ����
		System.out.println(rrn_back);
		
		//���� �Ǵ� ���ڿ��� ��ġ ã��
		String str = "I am Tom, you are a Jane";
		//1) ������ ��ġ
		int index = str.indexOf('a');
		System.out.println("index : "+index);
		
		//2) ���ڿ��� ��ġ - ���ڿ��� ���� ��ġ
		index = str.indexOf("Tom");
		System.out.println("index : "+index);
		
		//3) ������ ��ġ - ������ �ڿ�������
		index = str.lastIndexOf('a');
		System.out.println("index : "+index);
		
		//���ڿ� �߿� Jane�ܾ �ֳ�?
		boolean bOk = str.contains("Jane");
		System.out.printf("contain? : %b\n",bOk);
		
		//���ξ�� ���̻簡 Ư�� ���ڿ��� �´��� Ȯ��
		String chat = "[ä��] *�浿��, �ȳ�";
		
		bOk = chat.startsWith("[ä��]");
		System.out.printf("starts with \"[ä��]\" ? : %b\n",bOk);
		
		bOk = chat.endsWith(".");
		System.out.printf("ends with \".\" ? : %b\n",bOk);
		
		//���� -> ����
		//'0' = 48, '1' = 49 ... '4' = 52
		//'4' - '0' 
		int num = '4'-'0';
		System.out.println(num);
		
		if((gender-'0')%2 == 1) { //Ȧ��
			
		}
	}	
}
