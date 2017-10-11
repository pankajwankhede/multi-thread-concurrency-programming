package chapter06.c6_1_饿汉模式;

public class Singleton {

	private static Singleton myObject = new Singleton();

	private Singleton() {
	}

	public static Singleton getInstance() {
		return myObject;
	}

}
