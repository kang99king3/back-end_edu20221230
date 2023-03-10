package com.hk.boardmain;

import java.util.List;
import java.util.Scanner;

import com.hk.daos.HkDao;
import com.hk.datasource.DataBase;
import com.hk.dtos.HkDto;

public class MainTest {

	public static void main(String[] args) {
//		DataBase db=new DataBase();
		HkDao db=new HkDao();
		
		Scanner scan=new Scanner(System.in);
		System.out.println("1.글목록 2.글추가 3.글상세조회 ...");
		while(true) {
			int num=scan.nextInt();
			
			if(num==9) {
				break;
			}
			if(num==1) {
				//글목록 조회
				List<HkDto> lists=db.getAllList();
				//출력하기
				System.out.println("==글목록==");
				for (int i = 0; i < lists.size(); i++) {
					System.out.println(
										lists.get(i).getSeq()+"|"
									   +lists.get(i).getId()+"|"
									   +lists.get(i).getTitle()+"|"
									   +lists.get(i).getRegdate()
									  );
				}
			}
			if(num==2) {
				//글추가하기
				db.insertBoard(new HkDto(0, "kbj", "오늘부터웹교육", "JDBC에 대해 교육함", null));
			}
			if(num==3) {
				//글 상세조회
				HkDto dto=db.getBoard(1);
				System.out.println(
										dto.getSeq()+"|"
									   +dto.getId()+"|"
									   +dto.getTitle()+"|"
									   +dto.getContent()+"|"
									   +dto.getRegdate()
							);
			}
			if(num==4) {
				//수정하기
				System.out.println("수정할 글번호를 입력하세요");
				int seq=scan.nextInt();
				System.out.println("수정할 제목 입력하세요");
				String title=scan.next();
				System.out.println("수정할 내용 입력하세요");
				String content=scan.next();
				boolean isS=db.updateBoard(seq, title, content);
				System.out.println(isS);
			}
			if(num==5) {
				//삭제하기
				boolean isS=db.delBoard("2");
				System.out.println(isS);
			}
		}//while

	}//main

}//class






