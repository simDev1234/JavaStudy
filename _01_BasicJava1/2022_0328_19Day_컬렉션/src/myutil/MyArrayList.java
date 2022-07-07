package myutil;

//Generic지정
//<E> : Element Type
public class MyArrayList<E> {
	E[] data = null; //자바의 모든 객체 저장 가능
	
	public int size() {
		return (data==null)? 0 : data.length; 
	}
	
	public void add(E o) {
		E[] tmpArr = (E[])(new Object[size()+1]);
		
		try {
			System.arraycopy(data, 0, tmpArr, 0, size());
		} catch (Exception e) {
			
		}finally{
			tmpArr[size()]=o;
			this.data = tmpArr;
		}
		
	}//end add()
	
	//get메소드 내에서 던져진 예외에 대한 처리는 
	//해당 메소드를 사용하는 측에서 처리해라.(예외처리 양도)
	public E get(int index) throws Exception{
		//매개변수 유효성 검사
		if(index < 0 || index >= size()) {
			String message = String.format("사용범위:0~%d, index:%d%n",size()==0?0:size()-1,index);
			throw new Exception(message);
		}
		
		return data[index];
	}//end get()
	
	public void remove(int index) throws Exception{
		//매개변수 유효성 검사
		if(index < 0 || index >= size()) {
			String message = String.format("사용범위:0~%d, index:%d%n",size()==0?0:size()-1,index);
			throw new Exception(message);
		}
		
		//데이터가 한 개만 있을 경우 : null
		if(size()==1) {
			data = null;
			return;
		}
		
		//데이터가 2 개 이상인 경우, 배열 갯수 -1
		E[] tmpArr = (E[])new Object[size()-1];
		for(int i = 0; i < tmpArr.length; i++) {
			if(i < index)
				tmpArr[i] = data[i];
			else
				tmpArr[i] = data[i+1];
		}
		data = tmpArr;
	}
}
