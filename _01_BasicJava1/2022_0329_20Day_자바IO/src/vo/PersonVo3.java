package vo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
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
public class PersonVo3 implements Externalizable{
	private String name;
	private int age; //�ش� �ʵ�� ����ȭ���� ����
	private String addr;
	
	public PersonVo3() {
		
	}
	
	public PersonVo3(String name, int age, String addr) {
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

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeObject(name); //�ۼ��Ҷ� ������ : write�� read�� ��ü������ �����ؾ���
		out.writeObject(age);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		name = (String)in.readObject();
		age = in.readInt();
	}
}
