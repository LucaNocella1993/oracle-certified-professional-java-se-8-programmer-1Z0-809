package ocp.examples.generics;
public class PlaceHolder<K, V> {
	private K k;  
	private V v;  

	public PlaceHolder(K k, V v){    
		this.k = k;    
		this.v = v;    
	}

	public K getK() {
		return k; 
	} 

	public static <X> PlaceHolder<X, X> getDuplicateHolder(X x){   
		return new PlaceHolder<X, X>(x, x);    
	}

	public static void main(String[] args) {   
		PlaceHolder<String, String> ph1 = PlaceHolder.getDuplicateHolder("b"); //1        
		PlaceHolder<String, String> ph4 = new PlaceHolder<>("a", "b"); //4 
		PlaceHolder<?, ?> ph5 = new PlaceHolder(10, 10); //5   
	} }