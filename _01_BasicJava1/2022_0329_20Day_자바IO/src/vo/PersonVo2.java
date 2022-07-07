package vo;

import java.io.Serializable;

/*
   VO(value object)
   1. �����͸� ��������ϴ� ��ü  
   2. getter/setter�����س��� �Ѵ�. 
   
   cf)DTO or TO 
      Data Transfer OBject(���������� ��ü)
 *
 */

// Serializable : ����ȭ�� ������ ��ü��� �ĺ���
public class PersonVo2 implements Serializable{
	private String name;
	transient private int age; //�ش� �ʵ�� ����ȭ���� ����
	private String addr;
	
	public PersonVo2() {
		
	}
	
	public PersonVo2(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		String str = String.format("[%s-%d-%s]",name,age,addr);
		return str;
	}
}
