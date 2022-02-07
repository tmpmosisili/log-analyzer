package io.codewithmos.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.codewithmos.data.model.LogEntry;


@Component
public class LogParser implements LogParserService {
	
	@Value("${log.pattern.matcher}")
	  private String logEntryPattern;

	@Override
	public LogEntry parserLogEntry(String logEntryLine) {
		Pattern p = Pattern.compile(logEntryPattern);
		Matcher matcher = p.matcher(logEntryLine);
		if (!matcher.find() || matcher.groupCount() == 0) {
			return null;
		}
		return new LogEntry(matcher.group(1), matcher.group(3), matcher.group(5), matcher.group(7),
				logEntryLine.substring(matcher.end()));
	}
}
