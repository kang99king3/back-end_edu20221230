package edu_20230117.hk.day11;

public class Calendar{

	//leap, plain 값들은 고정적으로 변하지않는 값들이여야 함
	private static final int[] leap= {31,29,31,30,31,30,31,31,30,31,30,31};//윤년
	private static final int[] plain= {31,28,31,30,31,30,31,31,30,31,30,31};//평년
//	                          leap=new int[]{4,65,6,7,7};// (X)
	
	
	public static int[] getLeap() {
		return leap;
	}

	public static int[] getPlain() {
		return plain;
	}
	//윤년을 판별하는 메서드 : 윤년이면 true를 아니면 false를 반환해주자
	public boolean isLeapYear(int i) {
		boolean isS=false;
		if((i%4==0&&i%100!=0)||i%400==0) {
			isS=true;//윤년이면 true 대입
		}
		return isS;   
	}
	
	

	//해당 월의 전년도까지 경과일을 구하기(1년도~~~2022년도까지의 경과일을 구하기)
	public  int dates(int year) {
		int tot=0;
		for (int i = 1; i < year; i++) {
			if(isLeapYear(i)) {
				tot+=366;
			}else{
				tot+=365;
			}
		}
		return tot;
	}
	
	//전년도까지의 경과일 + 이번년도에 전 달까지 경과일 구하기
	public int dates(int year, int month) {
		// 전년도까지 경과일 구하는 코드 작성
		int tot=dates(year);
		//달의 마지막 날 : 윤년인 경우  - 31, 29, 31, 30......
		//              윤년이 아닌경우 - 31, 28 , 31, 30 ...
		//윤년인지 아닌지 판별해서 해당 배열의 값을 더해주는 코드 작성

		for (int i = 1; i < month; i++) {
			if(isLeapYear(year)) {//윤년이냐??
				tot+=leap[i-1]; // 1-1 2-1 3-1 4-1  --> 0 1 2 3 
			}else{
				tot+=plain[i-1];
			}
		}
		return tot;
	}
	
	//전년도까지 경과일 + 이번년도 전달까지 경과일 + 해당달의 1일
	public int dates(int year, int month, int day) {
		return dates(year, month)+day;
		//          9797979769769+1
	}
	// dates(year) dates(year,month) dates(year,month,day)
	// 2023.5월 달력 출력 --> (1년1월1일~2023년5월1일의 경과일)%7=공백수 ---> 5월1일의 요일을 알 수 있다.
	// 2023년 기준으로 볼때 2022년까지는 365, 366이라는 값으로 일정한 규칙으로 경과일을 구할 수 있다.
	// 2023년도는 월별로 31,28,31,30.. 이런식으로 달의 일수를 일정한 규칙으로 경과일을 구할 수 있다.
	
	//구하고자 하는 달의 마지막 날을 구하는 기능
	public int lastDay(int year,int month) {
		int last=0;
		if(isLeapYear(year)) {
			last=leap[month-1];
		}else {
			last=plain[month-1];
		}
		return last;
	}
	
	//한달을 출력되는 기능 
	public void calendarPrint(int year, int month) {
		System.out.println("\t\t\t"+year+"년 "+month+"월");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		int dayOfWeek=dates(year, month, 1)%7;// 공백수
		for (int i = 0; i < dayOfWeek; i++) {
			System.out.print("\t");
		}
		for (int i = 1; i <=lastDay(year,month) ; i++) {
			System.out.print(i+"\t");//1 2 3 4 
			if((dayOfWeek+i)%7==0) { // 특정 수에 대해 배수를 구하는 조건--> %
				System.out.println();
			}
		}
		
	}
	
	public static void main(String[] args) {
		Calendar cal=new Calendar();
		cal.calendarPrint(2023, 2);
		
//		int dayOfWeek=cal.dates(2023, 2, 1)%7;// 공백수
//		System.out.println(dayOfWeek);
		
//		System.out.println("\t\t\t"+2023+"년 "+2+"월");
//		System.out.println("일\t월\t화\t수\t목\t금\t토");
//		for (int i = 0; i < dayOfWeek; i++) {
//			System.out.print("\t");
//		}
//		for (int i = 1; i <=cal.lastDay(2023,4) ; i++) {
//			System.out.print(i+"\t");//1 2 3 4 
//			if((dayOfWeek+i)%7==0) { // 특정 수에 대해 배수를 구하는 조건--> %
//				System.out.println();
//			}
//		}
	}
}







