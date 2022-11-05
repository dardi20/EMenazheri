package core;

import java.io.File;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ProjectOriginal {

	private static final long serialVersionUID = -5741051016568483923L;
	int id;
	String title;
	String description;
	String startDate;
	String endDate;
	ArrayList<File> documents;
	private ArrayList<Task> tasks;
	private Status status;

	public ProjectOriginal() {
		this(null, null);
	}

	public ProjectOriginal(ArrayList<Task> tasks, Status status) {
		super();
		this.tasks = tasks;
		this.status = status;
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}

	public ProjectOriginal(int id, String title, String description, String startDate, String endDate,
			ArrayList<File> documents, ArrayList<Task> tasks, Status status) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.documents = documents;
		this.tasks = tasks;
		this.status = status;
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

	public ArrayList<File> getDocuments() {
		return documents;
	}

	public void setDocuments(ArrayList<File> documents) {
		this.documents = documents;
	}

	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", title=" + title + ", tasks=" + tasks + ", status=" + status + "]";
	}

}
