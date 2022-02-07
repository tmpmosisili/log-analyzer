package io.codewithmos.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "LOGENTRY")
public class LogEntry {
	
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGen")
		@SequenceGenerator(name = "seqGen", sequenceName = "seq", initialValue = 1)
	    private Long id;
		private String date;
	    private String transactionTime;
	    private String type;
	    private String thread;
	    @Column(length = 6000)
	    private String description;
	    
		public LogEntry(String date,String transactionTime, String type, String thread, String description) {
			super();
			this.date = date;
			this.transactionTime = transactionTime;
			this.type = type;
			this.thread = thread;
			this.description = description;
		}
		
		   public LogEntry() {
			   
		   }
		   
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public Long getId() {
			return id;
		}
		public String getTransactionTime() {
			return transactionTime;
		}
		public String getType() {
			return type;
		}
		public String getThread() {
			return thread;
		}
		public String getDescription() {
			return description;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public void setTransactiontime(String time) {
			this.transactionTime = time;
		}
		public void setType(String type) {
			this.type = type;
		}
		public void setThread(String thread) {
			this.thread = thread;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		   @Override
			public String toString() {
				return "LogEntry [date=" + date + ", transactionTime=" + transactionTime + ", type=" + type + ", thread=" + thread
						+ ", description=" + description + "]";
			}
	  	
	    

}
