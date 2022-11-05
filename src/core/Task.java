package core;

import java.util.ArrayList;

public class Task {
	private int id;
	private String description;
	private IssueStatus status;
//	private ArrayList<String> assignedEmployees;
	private String assignedEmployees;

	public Task() {
	}

	public Task(String description, IssueStatus status, String assignedEmployees) {
		super();
		
		this.description = description;
		this.status = status;
		this.assignedEmployees = assignedEmployees;
	}

	public String getDescription() {
		return description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public IssueStatus getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Task [description=" + description + ", status=" + status + ", assignedEmployees=" + assignedEmployees
				+ "]";
	}

	public void setStatus(IssueStatus status) {
		this.status = status;
	}

	public String getAssignedEmployees() {

		return assignedEmployees;
	}

	public void setAssignedEmployees(String assignedEmployees) {
		this.assignedEmployees = assignedEmployees;
	}

}
