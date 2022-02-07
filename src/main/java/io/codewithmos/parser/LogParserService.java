package io.codewithmos.parser;

import io.codewithmos.data.model.LogEntry;

public interface LogParserService {
	


	public LogEntry parserLogEntry(String logEntryLine);

}
