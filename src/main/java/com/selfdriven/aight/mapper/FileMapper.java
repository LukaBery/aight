package com.selfdriven.aight.mapper;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FileMapper {

	String saveFile(MultipartFile file);

	byte[] downloadFile(String filelname);

	String deleteFile(String filename);

	List<String> listAllFiles();
}
