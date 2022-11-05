package core;

import java.io.File;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class TaskOriginal extends Work {

	private ArrayList<Employee> employees;
	private ArrayList<TaskOriginal> requiredTasks;
	private ArrayList<Issue> issues;
	private Status status;

	public TaskOriginal() {
		this(null, null, null, null);
	}

	public TaskOriginal(ArrayList<Employee> employees, ArrayList<TaskOriginal> requiredTasks, ArrayList<Issue> issues, Status status) {
		super();
		this.employees = employees;
		this.requiredTasks = requiredTasks;
		this.issues = issues;
		this.status = status;
	}

	public TaskOriginal(int id, String title, String description, String startDate, String endDate,
			ArrayList<File> documents, ArrayList<Employee> employees, ArrayList<TaskOriginal> requiredTasks,
			ArrayList<Issue> issues, Status status) {
		super(id, title, description, startDate, endDate, documents);
		this.employees = employees;
		this.requiredTasks = requiredTasks;
		this.issues = issues;
		this.status = status;
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	public ArrayList<TaskOriginal> getRequiredTasks() {
		return requiredTasks;
	}

	public void setRequiredTasks(ArrayList<TaskOriginal> requiredTasks) {
		this.requiredTasks = requiredTasks;
	}

	public ArrayList<Issue> getIssues() {
		return issues;
	}

	public void setIssues(ArrayList<Issue> issues) {
		this.issues = issues;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Task [employees=" + employees + ", requiredTasks=" + requiredTasks + ", issues=" + issues + ", status="
				+ status + "]";
	}

}
