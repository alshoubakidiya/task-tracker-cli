package roadmapProject1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

	public static void main(String args[]) throws IOException {
		//All commands the user might use are added
		if (args.length == 0) {
		    System.out.println("Usage: add, delete, update, mark-in-progress, mark-done, list");
		    return;
		}
		if (args[0].equalsIgnoreCase("add")) {
		    if (args.length < 2) {
		        System.out.println("Usage: add \"<description>\"");
		        return;
		    }
		    TaskManager.addTask(args[1]);
		}else if(args[0].equalsIgnoreCase("delete")) {
		TaskManager.deleteTask(Integer.parseInt(args[1]));
	}else if(args[0].equalsIgnoreCase("update")) {
		TaskManager.updateTask(Integer.parseInt(args[1]), args[2]);
	}else if(args[0].equalsIgnoreCase("mark-in-progress")) {
		TaskManager.markInProgress(Integer.parseInt(args[1]));
	}else if(args[0].equalsIgnoreCase("mark-done")) {
		TaskManager.markDone(Integer.parseInt(args[1]));
	}else if(args[0].equalsIgnoreCase("list") && args.length == 1) {
		TaskManager.listTasks();
	}else if(args[0].equalsIgnoreCase("list") && args.length > 1) {
		TaskManager.listTasksByStatus(args[1]);
	}else {
		System.out.println("Unknown command: "+args[0]);
	}
	
	}
}
