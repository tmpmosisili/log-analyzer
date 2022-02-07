package io.codewithmos.file.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.codewithmos.data.model.LogEntry;
import io.codewithmos.data.service.LogEntryService;
import io.codewithmos.parser.LogParserService;

 

@Component
public class FileReader implements FileReaderService {

	private final LogEntryService logEntryService;
	private final LogParserService logParserService;
	


	@Autowired
	public FileReader( LogEntryService logEntryService, LogParserService logParserService) {
		this.logEntryService = logEntryService;
		this.logParserService = logParserService;
	}
	
	@Override
	public void fileProcessor(Path source) throws IOException {
		try (InputStream inputStream = Files.newInputStream(source);
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				Stream<String> linesStream = bufferedReader.lines();
				){
				linesStream.forEach( line  -> {
				LogEntry le = logParserService.parserLogEntry(line);
				 Optional <LogEntry> logEntry =	Optional.ofNullable(le);
				 logEntry.ifPresent(entry -> {
					 logEntryService.save(entry);
					 });
				});
			}
			
		}
	
}
