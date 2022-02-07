package io.codewithmos.data.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import io.codewithmos.data.model.LogEntry;
import io.codewithmos.data.model.LogFrequencyService;
import io.codewithmos.data.repo.LogEntryRepository;
import io.codewithmos.exception.LogEntryNotFoundException;

 
@Service
@Transactional
public class LogEntryService {
	
	private final LogEntryRepository logEntryRepository;
	
	public LogEntryService( LogEntryRepository logEntryRepository) {
		this.logEntryRepository = logEntryRepository;
	}
	
	public LogEntry findLogEntryById(Long id) {
        return logEntryRepository.findLogEntryById(id)
                .orElseThrow(() -> new LogEntryNotFoundException("Log entry by id " + id + " was not found"));
    }

	  public LogEntry addLogEntry (LogEntry logEntry) {
	        return logEntryRepository.save(logEntry);
	    }

	    public List<LogEntry> findAllLogEntries() {
	        return logEntryRepository.findAll();
	    }
	    
	    public   List<LogFrequencyService> sortByLogTypeFrequency (String errorType){
			  return (List<LogFrequencyService>) logEntryRepository.sortByLogTypeFrequency(errorType);
					//  .orElseThrow(() -> new LogEntryNotFoundException("Log type " + errorType + " was not found"));
	    }
	    
	    public List<LogEntry> findByLogType(String errorType){
	    	 return logEntryRepository.findByLogType(errorType);
	    }
	    
	    @Transactional
		public List<LogEntry> saveAllLogsEntries(List<LogEntry> logEntryList) {
			return logEntryRepository.saveAll(logEntryList);
		}
	    
	    public void save (LogEntry logEntry) {
	    	logEntryRepository.save(logEntry);
	    }
}
