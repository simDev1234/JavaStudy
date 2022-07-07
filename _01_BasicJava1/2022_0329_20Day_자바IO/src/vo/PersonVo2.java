package vo;

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
public class PersonVo2 implements Serializable{
	private String name;
	transient private int age; //해당 필드는 직렬화에서 예외
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
