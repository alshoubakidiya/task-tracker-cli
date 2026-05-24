package roadmapProject1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TaskManager {

	static void addTask(String description) throws IOException {
		List<Task> tasks = JsonHandler.readTasks(JsonHandler.loadFromFile());
		
		Task newTask = new Task(tasks.size()+1, description, "todo");
		tasks.add(newTask);
		JsonHandler.saveToFile(tasks);
	}
	static void deleteTask(int id) throws IOException {
		List<Task> tasks = JsonHandler.readTasks(JsonHandler.loadFromFile());
		int index = 0;
		for(int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).id == id) {
				tasks.remove(i);
				index = i;
				for (int j = index; j < tasks.size(); j++) {
					tasks.get(j).setId(tasks.get(j).id-1);
				}
				break;
			}
		}
		JsonHandler.saveToFile(tasks);
	}
	static void updateTask(int id, String description) throws IOException {
		List<Task> tasks = JsonHandler.readTasks(JsonHandler.loadFromFile());
		tasks.get(id-1).setDescription(description);
		JsonHandler.saveToFile(tasks);
	}
	static void markInProgress(int id) throws IOException {
		List<Task> tasks = JsonHandler.readTasks(JsonHandler.loadFromFile());
		tasks.get(id-1).setStatus("in-progress");
		JsonHandler.saveToFile(tasks);
	}
	static void markDone(int id) throws IOException {
		List<Task> tasks = JsonHandler.readTasks(JsonHandler.loadFromFile());
		tasks.get(id-1).setStatus("done");
		JsonHandler.saveToFile(tasks);
	}
	static void listTasks() throws IOException {
		List<Task> tasks = JsonHandler.readTasks(JsonHandler.loadFromFile());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("To-Do List:");
		for (Task t : tasks) {
			System.out.println("Task: "+t.id+" | "+t.description+" | status: "+t.status+" | date created: "+t.createdAt.format(formatter)+" | last updated: "+t.updatedAt.format(formatter));
		}
	}
	static void listTasksByStatus(String status) throws IOException {
		List<Task> tasks = JsonHandler.readTasks(JsonHandler.loadFromFile());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("To-Do List:");
		for (Task t : tasks) {
			if(t.status.equalsIgnoreCase(status)) {
				System.out.println("Task: "+t.id+" | "+t.description+" | status: "+t.status+" | date created: "+t.createdAt.format(formatter)+" | last updated: "+t.updatedAt.format(formatter));
			}
			
		}
	}
}
