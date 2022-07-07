package vo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

/*
   VO(value object)
   1. 데이터를 저장관리하는 객체  
   2. getter/setter구현해놔야 한다. 
   
   cf)DTO or TO 
      Data Transfer OBject(데이터전달 객체)
 *
 */

// Serializable : 직렬화가 가능한 객체라는 식별자
public class PersonVo3 implements Externalizable{
	private String name;
	private int age; //해당 필드는 직렬화에서 예외
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
		out.writeObject(name); //작성할때 유의점 : write와 read의 객체순서가 동일해야함
		out.writeObject(age);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		name = (String)in.readObject();
		age = in.readInt();
	}
}
