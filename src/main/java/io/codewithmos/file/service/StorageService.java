package io.codewithmos.file.service;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;


public interface StorageService {
	
	void init();
	Path store(MultipartFile file);
	Path load(String filename);
	void deleteAll();


}
