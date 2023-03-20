package ocp.examples.generics;

public class GenericsExample {
	public static void main(String[] args) {
		Bottle<Water> bottle1= new Bottle<>(new Water());
		Bottle<Wine>  bottle2= new Bottle<>(new Wine());
		AutomaticArm arm = new AutomaticArm();
		arm.takeBottle(bottle1);
		arm.takeBottle(bottle2);
	}
}

class Water {
	public String toString(){
		return " one bottle of water";
	}
}

class Wine {
	public String toString(){
		return " one bottle of wine";
	}
}

class Bottle<T> {
	private T content;
	public Bottle(T t){
		content=t;
	}
	public T getContent() {
		return content;
	}
}

class AutomaticArm {
	public void takeBottle(Bottle<?> bottle){
		System.out.println("I take"+bottle.getContent());
	}
}
