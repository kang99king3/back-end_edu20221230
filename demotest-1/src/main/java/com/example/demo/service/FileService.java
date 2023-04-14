package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.example.demo.dtos.FileBoardDto;

@Service
public class FileService {

	//파일 하나 업로드 하기
	public FileBoardDto uploadFile(String uploadPath,MultipartFile multipartFile ) 
									throws IllegalStateException, IOException {
		String origin_filename=multipartFile.getOriginalFilename();
		String stored_filename=UUID.randomUUID()
				              +origin_filename.substring(origin_filename.indexOf("."));
		String fileuploadUrl=uploadPath+"/"+stored_filename;
		
		multipartFile.transferTo(new File(fileuploadUrl));//upload가 실행됨
		return new FileBoardDto(0, 0, origin_filename, stored_filename);
	}
	
	//파일 여러개 업로드 하기
	public List<FileBoardDto> uploadFiles(String uploadPath,MultipartRequest multipartRequest ) 
									throws IllegalStateException, IOException {
	    //여러개의 파일들을 List에 담는다
		List<MultipartFile> multipartFiles=multipartRequest.getFiles("filename");
		//업로드된 파일들의 정보(원본,저장본)를 담아줄 LIST
		List<FileBoardDto> uploadFileList=new ArrayList<>();
		
		//향상된 for문  for(변수 선언:List)
		for (MultipartFile multipartFile:multipartFiles) {
			//원본파일명 구하기
			String origin_filename=multipartFile.getOriginalFilename();
			//저장할 파일명 구하기
			String stored_filename=UUID.randomUUID()
					+origin_filename.substring(origin_filename.indexOf("."));
			//파일저장 경로 구하기
			String fileuploadUrl=uploadPath+"/"+stored_filename;
			
			multipartFile.transferTo(new File(fileuploadUrl));//upload가 실행됨			
			uploadFileList.add(new FileBoardDto(0, 0, origin_filename, stored_filename));
		}
		return uploadFileList;
	}
}







