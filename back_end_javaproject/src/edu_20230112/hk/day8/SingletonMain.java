package edu_20230112.hk.day8;

import java.util.Iterator;

public class SingletonMain {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			StaticTest st=new StaticTest();
			System.out.println(st);
			Singleton slt=Singleton.getInstance();
			System.out.println(slt);
		}

	}

}
