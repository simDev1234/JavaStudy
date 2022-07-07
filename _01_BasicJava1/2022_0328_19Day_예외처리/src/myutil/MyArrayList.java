package myutil;

public class MyArrayList {
	Object[] data = null; //�ڹ��� ��� ��ü ���� ����
	
	public int size() {
		return (data==null)? 0 : data.length; 
	}
	
	public void add(Object o) {
		Object[] tmpArr = new Object[size()+1];
		
		try {
			System.arraycopy(data, 0, tmpArr, 0, size());
		} catch (Exception e) {
			
		}finally{
			tmpArr[size()]=o;
			this.data = tmpArr;
		}
		
	}//end add()
	
	//get�޼ҵ� ������ ������ ���ܿ� ���� ó���� 
	//�ش� �޼ҵ带 ����ϴ� ������ ó���ض�.(����ó�� �絵)
	public Object get(int index) throws Exception{
		//�Ű����� ��ȿ�� �˻�
		if(index < 0 || index >= size()) {
			String message = String.format("������:0~%d, index:%d%n",size()==0?0:size()-1,index);
			throw new Exception(message);
		}
		
		return data[index];
	}//end get()
	
	public void remove(int index) throws Exception{
		//�Ű����� ��ȿ�� �˻�
		if(index < 0 || index >= size()) {
			String message = String.format("������:0~%d, index:%d%n",size()==0?0:size()-1,index);
			throw new Exception(message);
		}
		
		//�����Ͱ� �� ���� ���� ��� : null
		if(size()==1) {
			data = null;
			return;
		}
		
		//�����Ͱ� 2 �� �̻��� ���, �迭 ���� -1
		Object[] tmpArr = new Object[size()-1];
		for(int i = 0; i < tmpArr.length; i++) {
			if(i < index)
				tmpArr[i] = data[i];
			else
				tmpArr[i] = data[i+1];
		}
		data = tmpArr;
	}
}
