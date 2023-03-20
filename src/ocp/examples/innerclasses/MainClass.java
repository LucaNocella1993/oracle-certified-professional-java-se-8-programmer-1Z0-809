package ocp.examples.innerclasses;

interface AnonymousInterface {
	void anonymousClassMethod();
}

public class MainClass {
	String mainClassString = "mainClass";
	static String staticMainClassString = "staticMainClass";
	public void mainClassMethod() {/*Empty*/}
	public static void staticMainClassMethod() {/*Empty*/}
	public MainClass() {
		System.out.println(InnerClass.STATIC_FINAL_INNER_CLASS_STRING + StaticNestedClass.staticStaticNestedClassString);
	}

	class InnerClass {
		String innerClassString = "innerClass";
		//	static String staticInnerClassString = "staticInnerClassString";
		static final String STATIC_FINAL_INNER_CLASS_STRING = "staticInnerClassString";
		public void InnerClassMethod() {/*Empty*/}
		//	public static void staticInnerClassMethod() {/*Empty*/}

		public InnerClass() {
			System.out.println(staticMainClassString + mainClassString);
		}
	}

	static class StaticNestedClass {
		String staticNestedClassString = "staticInnerClassString";
		static String staticStaticNestedClassString = "staticStaticInnerClassString";
		public void staticNestedClassMethod() {/*Empty*/}
		public static void staticStaticNestedClassMethod() {/*Empty*/}
		public StaticNestedClass() {
			System.out.println(staticMainClassString);
		}
	}

	public static void localClass() {
		class LocalClass {		
			String localClassString = "localClassString";
			//		static String staticLocalClassString = "staticLocalClassString";
			final void localClassMethod() {/*Empty*/}
			//		static void staticMainClassMethod() {/*Empty*/}

			public LocalClass() {
				System.out.println(staticMainClassString);
			}
		}
		LocalClass lc = new LocalClass();
	}

	public static void main (String... args) {
		MainClass mc = new MainClass();

		InnerClass ic = mc.new InnerClass();

		InnerClass ic2 = new MainClass().new InnerClass();

		StaticNestedClass sic = new StaticNestedClass();

		StaticNestedClass sic2 = new MainClass.StaticNestedClass();

		AnonymousInterface anonymousClass = new AnonymousInterface(){
			String anonymousClassString = "anonymousClassString";
			//		static String staticLocalClassString = "staticLocalClassString";
			public final void anonymousClassMethod() {/*Empty*/}
			//		static void staticMainClassMethod() {/*Empty*/}
		};

		anonymousClass.anonymousClassMethod();
	}
}
