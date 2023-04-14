package com.example.demo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.example.demo.dtos.FileBoardDto;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

	public void fileDownload(String filePath, 
							String origin_filename, 
							String stored_filename,
							HttpServletRequest request, 
							HttpServletResponse response) throws UnsupportedEncodingException {
	
		
		//다운로드를 위한 준비 작업
		
		//읽어들인 파일 정보를 화면에 다운로드할 수 있게 설정
		response.setContentType("application/octet-stream");
		//다운로드 파일의 저장경로 설정하는 팝업창:attachment, 원본파일명을 지정
		response.setHeader("Content-Disposition",
				"attachment; fileName="
		         +URLEncoder.encode(origin_filename, "UTF-8"));
		response.setHeader("Content-transfer", "binary");
		
		File file=new File(filePath+"/"+stored_filename);
		
		//시스템에 있는 파일을 가져오기 위한 객체
		FileInputStream fs = null;
		//웹 브라우저로 내보내기 위한 객체
		ServletOutputStream out=null;
		try {
			fs = new FileInputStream(file);
			out = response.getOutputStream();
			
			//fs가 가지고 있는 파일을 out에 의해 웹브라우저로 전송하자
			FileCopyUtils.copy(fs, out);//전송
			response.flushBuffer();
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fs!=null) {
				try {
					fs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}







