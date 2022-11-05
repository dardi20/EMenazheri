package core;

import java.io.File;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Issue extends Work {

	private IssueStatus status;
	private int employeeId;
	private String response;

	public Issue() {

		this(null, 0, null);
	}

	public Issue(IssueStatus status, int employeeId, String response) {
		this.status = status;
		this.employeeId = employeeId;
		this.response = response;
	}

	public Issue(int id, String title, String description, String startDate, String endDate,
			ArrayList<File> documents, IssueStatus status, int employeeId, String response) {
		super(id, title, description, startDate, endDate, documents);
		this.status = status;
		this.employeeId = employeeId;
		this.response = response;
	}

	public IssueStatus getStatus() {
		return status;
	}

	public void setStatus(IssueStatus status) {
		this.status = status;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "Issue [status=" + status + ", employeeId=" + employeeId + ", response=" + response + "]";
	}

}
