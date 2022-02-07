package io.codewithmos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import io.codewithmos.data.model.LogEntry;
import io.codewithmos.data.model.LogFrequencyService;
import io.codewithmos.data.service.LogEntryService;
import io.codewithmos.file.service.FileReaderService;
import io.codewithmos.file.service.StorageService;

@RestController
@RequestMapping("/log/analyser/v1")
 
public class FileUploadController {
	private final  StorageService storageService;
	private final  LogEntryService logEntryService;
	private final  FileReaderService fileReaderService;
	
	@Autowired
	public FileUploadController(StorageService storageService, 
								LogEntryService logEntryService,
								FileReaderService fileReaderService) {
		this.storageService = storageService;
		this.logEntryService = logEntryService;
		this.fileReaderService = fileReaderService;
	}
	
	@PostMapping("/upload")
	public ResponseEntity<HttpStatus> handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {	
		Optional.ofNullable(file).orElseThrow(()-> new IllegalArgumentException("File Cannot be null"));
		fileReaderService.fileProcessor(storageService.store(file));
		return ResponseEntity.ok(HttpStatus.CREATED);
		
	}
	
	  @GetMapping("/frequency/{log_type}")
	  public List<LogFrequencyService> sortByLogTypeFrequency(@PathVariable("log_type") String logType) {
		return logEntryService.sortByLogTypeFrequency(logType);
	  }
	  
	  @GetMapping("/disctinct/{log_type}")
	  public List<LogEntry> findByLogType(@PathVariable("log_type") String logType) {
		return logEntryService.findByLogType(logType);
	  }
	  
	  @GetMapping("/all")
	  public List<LogEntry> findAll() {
		return logEntryService.findAllLogEntries();
	  }
	  
}
