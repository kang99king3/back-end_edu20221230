package edu_20230112.hk.day8;

public class StringTestMain {

	public static void main(String[] args) {
		StringMethodTest smt=new StringMethodTest();
		System.out.println(smt.sTest01("한경닷컴")); 
		System.out.println(smt.sTest2("최강야구"));   
		smt.sTest4();
		System.out.println(smt.sTest05("한경닷컴IT교육센터"));
		System.out.println("=========과제===================");
		smt.search("전기차");
	}

}
