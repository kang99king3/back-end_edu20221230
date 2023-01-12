package edu_20230112.hk.day8;

import java.util.Arrays;

//final을 작성하면 상속금지
public class SuperClass {
	
	public void aa() {
		System.out.println("부모에만 작성된 메서드");
	}
	//final을 작성하면 메서드 오버라이딩 금지
    public void Method() {
           System.out.println("난 이제 숨겨지겠지");
    }
}
