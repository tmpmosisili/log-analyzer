package io.codewithmos.data.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.codewithmos.data.model.LogEntry;
import io.codewithmos.data.model.LogFrequencyService;

 

@Repository
public interface LogEntryRepository extends JpaRepository<LogEntry, Long> {
	Optional<LogEntry> findLogEntryById(Long id);

	  @Query(value =
	  "SELECT c.date as date, c.type as type, c.description as description, COUNT(*) as occurances, " +
	  "FROM LogEntry AS c WHERE c.type = :logType  GROUP BY c.description ORDER BY occurances DESC"
	  , nativeQuery = true) 
	  List<LogFrequencyService>sortByLogTypeFrequency(@Param("logType") String logType);
	  
	@Query("SELECT c FROM LogEntry c where c.type = :logType")
	List<LogEntry> findByLogType(@Param("logType") String logType);

}
