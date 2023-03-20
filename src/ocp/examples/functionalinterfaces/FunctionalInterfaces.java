package ocp.examples.functionalinterfaces;

import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.UnaryOperator;

public class FunctionalInterfaces {

	/*Use: 
	 * function: Accepts an element and produces a result.
	 * unaryOperator: Accepts an element and produces a result of the same type. specialization of Function.
	 * binaryOperator: Accepts two elements and produces a result of the same type. specialization of BiFunction.
	 * supplier: Accepts no element and returns one result.
	 * consumer: Accepts a single input argument and returns no result.
	 * predicate: Accepts an element and return a boolean.
	 */
	
	void function(Function<String, String> function, DoubleFunction<String> doubleFunction, ToDoubleFunction<String> toDoubleFunction, IntToDoubleFunction intToDoubleFunction) {
		function.apply("ciao");
		doubleFunction.apply(1.0);
		toDoubleFunction.applyAsDouble("ciao");
		intToDoubleFunction.applyAsDouble(1);
	}

	void unaryOperator(UnaryOperator<String> unaryOperator) {
		unaryOperator.apply("ciao");
	}

	void binaryOperator(BinaryOperator<String> binaryOperator, DoubleBinaryOperator doubleBinaryOperator) {
		binaryOperator.apply("ciao", "ciao2");
		doubleBinaryOperator.applyAsDouble(1.0, 2.0);
	}

	void supplier(Supplier<String> supplier, BooleanSupplier booleanSupplier) {
		supplier.get();
		booleanSupplier.getAsBoolean();
	}

	void consumer(Consumer<String> consumer) {
		consumer.accept("ciao");
	}

	void predicate(Predicate<String> predicate, BiPredicate<String, String> biPredicate, DoublePredicate doublePredicate) {
		predicate.test("ciao");
		biPredicate.test("ciao", "ciao2");
		doublePredicate.test(1.0);
	}

	public static void main(String[] screen) {

	}
}