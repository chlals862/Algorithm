package javaStudy.ch11_컬렉션프레임웍;

public class MyVector {

	Object[] data = null; //객체를 담기 위한 객체배열을 선언
	int capacity = 0; //용량
	int size = 0; //크기
	
	public MyVector(int capacity) {
		if(capacity < 0)
			throw new IllegalArgumentException("유효하지 않은 값" + capacity);
		
		this.capacity  = capacity;
		data = new Object[capacity];
	}
	
	public MyVector() {
		this(10); //크기를 지정하지 않으면 크기를 10으로 함
	}
	
	//최소한의 저장공간을 확보하는 메서드
	public void ensureCapacity(int minCapacity) {
		if(minCapacity - data.length > 0)
			setCapacity(minCapacity);
	}
	
	public boolean add(Object obj) {
		//새로운 객체를 저장하기 전에 저장할 공간 확보하기
		ensureCapacity(size+1);
		data[size++] = obj;
		return true;
	}
	
	public Object get(int index) {
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException("범위를 벗어남");
		return data[index];
	}
	
	public Object remove(int index) {
		Object oldObj = null;
		
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException("범위를 벗어남");
		oldObj = data[index];
		
		//삭제하고자 하는 객체가 마지막 객체가 아니라면, 배열복사를 통해서 빈자리를 채워줘야 함
		if(index != index) {
			System.arraycopy(data, index+1, data, index, size-index-1);
		}
		//마지막 데이터를 null로 한다. 배열은 0부터 시작하므로 마지막 요소 index는 size-1임★★★★★
		data[size-1] = null;
		size--;
		return oldObj;
	}
	
	public boolean remove(Object obj) {
		for(int i=0;i<size;i++) {
			if(obj.equals(data[i])) {
				remove(i);
				return true;
			}
		}//end of for
		return false;
	}
	
	public void trimToSize() {
		setCapacity(size);
	}
	
	private void setCapacity(int capacity) {
		if(this.capacity == capacity) return; //크기가 같으면 변경하지 않음
	
		Object[] tmp = new Object[capacity];
		System.arraycopy(data, 0, tmp, 0, size);
		data = tmp;
		this.capacity = capacity;
	}
	
	public void clear() {
		for(int i=0;i<size;i++)
			data[i] = null;
		size = 0;
	}
	
	public Object[] toArray() {
		Object[] result = new Object[size];
		System.arraycopy(data, 0, result, 0, size);
		return result;
	}
	
	public boolean isEmpty() { return size ==0;}
	public int capacity() {  return capacity; }
	public int size() { return size; }
	


}
