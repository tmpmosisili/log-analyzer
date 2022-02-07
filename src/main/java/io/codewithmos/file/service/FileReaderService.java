package io.codewithmos.file.service;

import java.io.IOException;
import java.nio.file.Path;


public interface FileReaderService {
	public void fileProcessor(Path source) throws IOException;
}
