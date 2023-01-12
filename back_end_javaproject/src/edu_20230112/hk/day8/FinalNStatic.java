package edu_20230112.hk.day8;

public class FinalNStatic {

	public static void main(String[] args) {
		StaticTest st=new StaticTest();
		st.Method();

		SuperClass sc=new StaticTest();
		sc.Method();
		
		StaticTest st2=(StaticTest)sc;
		st2.StaticMethod();
		
		int a=4;
		byte b=(byte)a;

		SuperClass sc2=new SuperClass();
		sc2.Method();
		sc2.aa();
		
		
	}
}
