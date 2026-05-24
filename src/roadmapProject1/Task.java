package roadmapProject1;
import java.time.LocalDateTime;
public class Task {
		int id;
		String description;
		String status;
		LocalDateTime createdAt;
		LocalDateTime updatedAt;
		
		Task(int id, String description, String status){
			this.id = id;
			this.description = description;
			this.status = status;
			createdAt = LocalDateTime.now();
			updatedAt = LocalDateTime.now();
		}
		Task(int id, String description, String status, LocalDateTime createdAt, LocalDateTime updatedAt){
			this.id = id;
			this.description = description;
			this.status = status;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
		}

		public void setId(int id) {
			this.id = id;
			updatedAt = LocalDateTime.now();
		}

		public void setDescription(String description) {
			this.description = description;
			updatedAt = LocalDateTime.now();
		}

		public void setStatus(String status) {
			this.status = status;
			updatedAt = LocalDateTime.now();
		}
		
}
