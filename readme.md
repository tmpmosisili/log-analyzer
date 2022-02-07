# Log Analyzer
 
The is the backend spring project that analyzes the logs. The project was compile with Java 17. It uses a H2 database to store the log files, but it was
also tested on PostreSQL and it works without any issue.

### Endpoints
There is a endpoint for uploading the log file. The services then writes valid log entries to the database. The user can use other endpoints to interogate the database. Endpoints are as follows:

http://localhost:8080/log/analyser/v1/upload - to upload files
http://localhost:8080/log/analyser/v1/disctinct/DEBUG - to get a log level
http://localhost:8080/log/analyser/v1/frequency/DEBUG - to get the frequency of logs by errors. For example, get frequency of error by description

### Rationale
The reason for dumping the file into a database is for ease of manupilation. Once the files are in a database, then it becomes easy to play with 
the data.



### Test Coverage
Still to do

