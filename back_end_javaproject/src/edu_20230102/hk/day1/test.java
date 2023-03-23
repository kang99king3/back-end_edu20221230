package edu_20230102.hk.day1;

import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		solution("1two34");
	}
	public static int solution(String s) {
        int answer = 0;
        String[] array= {"zero","one","two","three","four","five","six","seven","eight","nine"};
        if((s.indexOf("0")!=0||s.indexOf("zero")!=0 )&& (s.length()>=1&&s.length()<=50)) {
        	for (int i = 0; i < array.length; i++) {
        		s=s.replaceAll(array[i], i+"");
        	}
        	answer=Integer.parseInt(s);
        }
        return answer;
    }

}
