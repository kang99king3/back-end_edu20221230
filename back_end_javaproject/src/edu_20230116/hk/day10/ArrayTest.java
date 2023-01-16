package edu_20230116.hk.day10;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

import edu_20230113.hk.day9.AntQuiz;

public class ArrayTest {
	
	public static void main(String[] args) {
		//선언 방법
		//1.변수와 값을 동시에 정의한다.
		int [] a={1,2,3,4,5,6};
		int [] b;//변수만 선언, 자릿수X, 초기값X
		//b= {11,22}; //(X) 리터럴 방식은 선언과 초기화를 따로 진행할 수 없다.
		
		//값을 가져오는 방법: 인덱스를 통해서 가져온다.
		int value=a[0];
		
		//2.변수와 값을 따로 정의할 수 있다.
		int [] b2=null;
		b2=new int [] {1,2,3,4,5,6};
		
		int [] b3=new int[5];
		b3[0]=1; b3[1]=2; b3[2]=4; b3[3]=4; b3[4]=5;
		for (int i = 0; i < b3.length; i++) {
			System.out.print(b3[i]+",");
		}
		System.out.println(b3);
		System.out.println(Arrays.toString(b3));
		
		//shallow copy(얕은 복사)
		//참조타임의 mutable한 특성
		int [] c= {1,2,3,4,5,6};
		int [] d=c;// c-->d 로 주소값이 전달됨
		d[2]=20;//d에서 3을 20으로 바꾸면 c도 바뀐다.
		System.out.println("배열C:"+Arrays.toString(c));
		
		//Deep copy(깊은 복사)
		int [] e=new int [6];
		System.arraycopy(c,0,e,0,e.length);//복사 실행
		e[0]=30;//복사 받은 쪽에서 값을 바꾼다
		System.out.println("배열E:"+Arrays.toString(e));
		
		//2차원 배열 
		int [][] aa = {{1,2,3},{4,5,6},{7,8,9}}; 
		int []aa_2  = aa[0];
		int aa_value= aa_2[1];
		int aa_value2=aa[0][1];
		
		//aa[i][j]=5;//값을 대입한다.
		//aa[i][j];//값을 가져온다.
		for (int i = 0; i < aa.length; i++) {
			for (int j = 0; j < aa.length; j++) {
				aa[i][j]+=10;
				System.out.print(aa[i][j]+",");
			}
			System.out.println();
		}
		
		//2차원 --> 1차원 변환
		//i*col+j = 0*3+0= 0 
		//        = 0*3+1= 1
		//        = 0*3+2= 2
		//        = 1*3+0= 3
		//        = 1*3+1= 4
        //        = 1*3+2= 5
		//--> i (배열의 row 번호) * col (배열의 col 개수) + j (index 번호)

		int [][] cc= {{1,2,3},{4,5,6}};
		int [] dd=new int[cc.length*cc[0].length];
		
		for (int i = 0; i < cc.length; i++) {
			for (int j = 0; j < cc[0].length; j++) {
				dd[i*cc[0].length+j]=cc[i][j];
			}
		}
		System.out.println(Arrays.toString(dd));
		
		//1차원---> 2차원으로 변환
		//[i/col][i%col]
		//[0/3][0%3] = [0][0], [1/3][1%3] = [0][1] ..... [0][2]..[1][0],[1][1]...
		int[] ee= {1,2,3,4,5,6};
		int[][] ff=new int[2][3];
		
		for (int i = 0; i < ee.length; i++) {
			ff[i/ff[0].length][i%ff[0].length]=ee[i];
		}
		for (int i = 0; i < ff.length; i++) {
			System.out.println(Arrays.toString(ff[i]));			
		}
		
	}
	//생성자를 통해 배열 초기화하기
	public int [][] bb;//맴버필드로 정의
	
	public ArrayTest() {//생성자에서 초기화하는 방법
		bb=new int [3][3];
	}
	
	public ArrayTest(int n,int m) {//생성자 오버로딩
		bb=new int [n][m];
	}
}






