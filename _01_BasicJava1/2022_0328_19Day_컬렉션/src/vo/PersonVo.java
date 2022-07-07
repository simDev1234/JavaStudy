package vo;

/*
   VO(value object)
   1. �����͸� ��������ϴ� ��ü  
   2. getter/setter�����س��� �Ѵ�. 
   
   cf)DTO or TO 
      Data Transfer OBject(���������� ��ü)
 *
 */

public class PersonVo {
	private String name;
	private int age;
	private String addr;
	
	public PersonVo() {
		
	}
	
	public PersonVo(String name, int age, String addr) {
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
