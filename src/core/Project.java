package core;

import java.io.File;
import java.util.ArrayList;

public class Project {
	private static final long serialVersionUID = -5741051016568483923L;
	int id;
	String title;
	String description;
	String startDate;
	String endDate;
	private ArrayList<Task> tasks;

	public Project() {
	}

	public Project(ArrayList<Task> tasks) {
		super();
		this.tasks = tasks;
	}

	public Project(int id, String title, String description, String startDate, String endDate, ArrayList<Task> tasks) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.tasks = tasks;
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", title=" + title + ", tasks=" + tasks + "]";
	}

}
