package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
}







