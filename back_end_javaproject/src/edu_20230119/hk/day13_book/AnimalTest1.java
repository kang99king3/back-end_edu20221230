package edu_20230119.hk.day13_book;

public class AnimalTest1{
	
	public static void main(String[] args) {
		AnimalTest1 aTest=new AnimalTest1();
//		aTest.moveAnimal(new Human());
		//1.부모의 타입으로 자식을 생성한다.
		Animal animal1=new Human();
		Animal animal2=new Tiger();
		Animal animal3=new Eagle();
		
		//2.부모의 타입으로 자식을 참조한다.
//		Tiger ti=new Tiger();
//		aTest.moveAnimal(ti);
		
		aTest.moveAnimal(animal1);
		aTest.moveAnimal(animal2);
		aTest.moveAnimal(animal3);
	}
	
	public void moveAnimal(Animal animal) { // Animal animal=new Animal();
		//부모의 메서드를 호출하면 자식의 메서드가 호출된다.
		animal.move();                      //        animal.move();  
	}
	
	
	
}
