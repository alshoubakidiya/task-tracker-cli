package roadmapProject1;
import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class JsonHandler {

	public static List<Task> readTasks(String raw){
		List<Task> tasks = new ArrayList<>();
		
		int fromIndex = 0;
		int start = raw.indexOf("{", fromIndex);

		while (start != -1) {
		    int end = raw.indexOf("}", fromIndex);
		    String chunk = raw.substring(start, end + 1);
		    
		   int id = idExtractor(chunk);
		   String description = descriptionExtractor(chunk);
		   String status = statusExtractor(chunk);
		   LocalDateTime createdAt = LocalDateTime.parse(createdAtDateExtractor(chunk));
		   LocalDateTime updatedAt = LocalDateTime.parse(updatedAtDateExtractor(chunk));
	
		   Task task = new Task(id, description, status, createdAt, updatedAt);
		   
		    tasks.add(task);// add it to tasks
		    
		    fromIndex = end + 1;
		    start = raw.indexOf("{", fromIndex);
		}

		return tasks;
			
	}
	
	static String taskToJson(Task t) {
	    String idPart        = "\"id\": " + t.id;
	    String descPart      = "\"description\": \"" + t.description + "\"";
	    String statusPart    = "\"status\": \"" + t.status + "\"";
	    String createdPart   = "\"createdAt\": \"" + t.createdAt.toString() + "\"";
	    String updatedPart   = "\"updatedAt\": \"" + t.updatedAt.toString() + "\"";

	    return "{" + String.join(", ", idPart, descPart, statusPart, createdPart, updatedPart) + "}";
	}
	
	static String writeTasks(List<Task> tasks ) {
		List<String> parts = new ArrayList<>();
		for(Task t : tasks) {
		    parts.add(taskToJson(t));
		}
		// now join and wrap
		return "["+String.join(",", parts)+"]";
		
	}
	
	
	
	static String statusExtractor(String chunk) {
		int statusIndex = chunk.indexOf("status");
		int index1 = chunk.indexOf(": ", statusIndex);
		int index2 = chunk.indexOf("\"", index1+4);
		String status = chunk.substring(index1+3, index2);
		return status;
	}
	static String descriptionExtractor(String chunk) {
		int descriptionIndex = chunk.indexOf("description");
		int index1 = chunk.indexOf(": ", descriptionIndex);
		int index2 = chunk.indexOf("\"", index1+4);
		String description = chunk.substring(index1+3, index2);
		return description;
	}
	static int idExtractor(String chunk) {
		int idIndex = chunk.indexOf("id");
		int index1 = chunk.indexOf(": ", idIndex);
		int index2 = chunk.indexOf(",", index1+2);
		int id = Integer.parseInt(chunk.substring(index1+2, index2));
		return id;
	}
	static String createdAtDateExtractor(String chunk) {
		int createdAtDateIndex = chunk.indexOf("createdAt");
		int index1 = chunk.indexOf(": ", createdAtDateIndex);
		int index2 = chunk.indexOf("\"", index1+4);
		String createdAtDate = chunk.substring(index1+3, index2);
		return createdAtDate;
	}
	static String updatedAtDateExtractor(String chunk) {
		int updatedAtDateIndex = chunk.indexOf("updatedAt");
		int index1 = chunk.indexOf(": ", updatedAtDateIndex);
		int index2 = chunk.indexOf("\"", index1+4);
		String updatedAtDate = chunk.substring(index1+3, index2);
		return updatedAtDate;
	}
	static String loadFromFile() throws IOException {
		if(!Files.exists(Path.of("tasks.json"))) {
			return "[]";
		}else {
			String raw = Files.readString(Path.of("tasks.json"));
			return raw;
		}
	}
	static void saveToFile(List<Task> tasks) throws IOException {
		Files.writeString(Path.of("tasks.json"), writeTasks(tasks));
	}
}