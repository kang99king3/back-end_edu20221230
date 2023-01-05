package edu_20230105.hk.day4;

public class StarView {

	public static void main(String[] args) {
		
//		  0★         --->   1 2 3 4 5
//		  1★★               0 1 2 3 4
//		  2★★★
//		  3★★★★
//		  4★★★★★
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print("★");	//별을 옆으로 출력					
			}
			System.out.println();//줄바뀜
		}
		
//		  0☆☆☆☆★         --->   1 2 3 4 5
//		  1☆☆☆★★               0 1 2 3 4
//		  2☆☆★★★           
//		  3☆★★★★         ---> 4 3 2 1  --> 4+2*-1 = 4-2=2
//		  4★★★★★              0 1 2 3  --> 4+i*-1 = 4-i
		// 공백 " "
		int num=20;
		for (int i = 0; i < num; i++) {
//			for (int j = i; j <num-1; j++) {
//				System.out.print("☆");				
//			}
			for (int j = 0; j < num-1-i; j++) {
				System.out.print("☆");				
			}
			for (int j = 0; j < i+1; j++) {
				System.out.print("★");	//별을 옆으로 출력					
			}
			System.out.println();//줄바뀜
		}
		
		System.out.println("==================");
		System.out.println();
//	      0*****     
//	      1****        5 4 3 2 1   5+n*-1 ---> 5-i
//	      2***         
//	      3**           
//	      4*            
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5-i; j++) {
				System.out.print("★");	//별을 옆으로 출력					
			}
			System.out.println();//줄바뀜
		}
		
		System.out.println("==================");
		System.out.println();
//	      *****       공백 :  0 1 2 3 4   --> 0 + n*1 --> i
//	       ****       별  :   5 4 3 2 1  --> 5 + n*-1 --> 5-i
//	        ***
//	         **
//	          *
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("☆");				
			}
			for (int j = 0; j < 5-i; j++) {
				System.out.print("★");	//별을 옆으로 출력					
			}
			System.out.println();//줄바뀜
		}
		
		
		
//	    *         1     1+n*2 ----> 1+2n ---> 1+2*i 
//	   ***        3
//	  *****       5   
//	 *******      7  
//	*********     9    
	System.out.println("==================");
	System.out.println();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4-i; j++) {
				System.out.print("☆");				
			}
			for (int j = 0; j < 1+2*i; j++) {
				System.out.print("★");	//별을 옆으로 출력					
			}
			System.out.println();//줄바뀜
		}
		
//	     *********     
//	      *******     9 7 5 3 1 --->  9+n*-2 --->  9-2*i
//	       *****        
//	        ***       0 1 2 3 4 ---> 0+n*1 ---> i
//	         *                   	
		System.out.println("==================");
		System.out.println();
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < i; j++) {
					System.out.print("☆");				
				}
				for (int j = 0; j < 9-2*i; j++) {
					System.out.print("★");	//별을 옆으로 출력					
				}
				System.out.println();//줄바뀜
			}
//	    *          
//	   ***         
//	  *****         
//	 *******          
//	*********
//	 *******
//	  *****  
//	   ***     
//	    *      
//	
	System.out.println("==================");
	System.out.println();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4-i; j++) {
				System.out.print("☆");				
			}
			for (int j = 0; j < 1+2*i; j++) {
				System.out.print("★");	//별을 옆으로 출력					
			}
			System.out.println();//줄바뀜
		}	
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < i+1; j++) {   // 0 1 2 3 4 5    i  --> 1 2 3 4 5   1+i 
				System.out.print("☆");				
			}
			for (int j = 0; j < 7-2*i; j++) {
				System.out.print("★");	//별을 옆으로 출력					
			}
			System.out.println();//줄바뀜
		}	
			
//int diamonds=9,k;
//		
//		k=diamonds/2+1;
//		System.out.println("k="+k);
//		System.out.println("diamonds-k*2="+(diamonds-k*2));
//		
//		 for(int i=1;i<diamonds+1;i++){
//
//			 if(i>diamonds/2+1){ k++; }
//			 else{ k--; }
//
//			 System.out.print(k);
//
//			 for(int j=0;j<k;j++)
//			 { System.out.print("◇"); }
//
//			 for(int j=0;j<diamonds-k*2;j++)
//			 { System.out.print("◆"); }
//
//			 for(int j=0;j<k;j++)
//			 { System.out.print("◇"); }
//
//			 System.out.println("");
//
//		 }
		
	}

}
