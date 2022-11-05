package core;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Work implements Serializable {
	
	private int id;
	private static int nextId;
	private String title, description;
	private String startDate, endDate;
	private ArrayList<File> documents;
	
	
	public Work() {
		this(0, null, null, "", "", null);
	}
	public Work(int id, String title, String description, String startDate, String endDate,
			ArrayList<File> documents) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.documents = documents;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static int getNextId() {
		return nextId;
	}
	public static void setNextId(int nextId) {
		Work.nextId = nextId;
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
	@Override
	public String toString() {
		return "Work [id=" + id + ", title=" + title + ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", documents=" + documents + "]";
	}
	
}

