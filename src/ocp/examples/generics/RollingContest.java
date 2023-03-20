package ocp.examples.generics;

class Roller<E extends Wheel> {
	public void roll(E e) { }
}
class Wheel { }
class CartWheel extends Wheel { }
public class RollingContest {
	Roller<CartWheel> wheel1 = new Roller<CartWheel>();
	Roller<CartWheel> wheel2 = new Roller<CartWheel>(); //deve essere dello stesso tipo su entrambi i lati
	Roller<? extends Wheel> wheel3 = new Roller<CartWheel>();
	Roller<? extends Wheel> wheel4 = new Roller<Wheel>(); //con extends può essere la stessa classe o figlia
	Roller<CartWheel> wheel5 = new Roller<CartWheel>();
	Roller<? super CartWheel> wheel6 = new Roller<Wheel>(); //con super può essere la stessa classe o padre
	
	public static void main(String... args) {
		
	}
}