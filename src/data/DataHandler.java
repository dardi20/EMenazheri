
package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.JOptionPane;

import core.Admin;
import core.IssueStatus;
import core.Person;
import core.Project;
import core.Task;
import core.User;
import core.Work;

public class DataHandler {

	public static final File USERS_FILE = new File("C:/Users/Dardi/eclipse-workspace/e-menazheri/data/user/data.info");
	public static final File IDS_FILE = new File("C:/Users/Dardi/eclipse-workspace/e-menazheri/data/id/data.info");
	public static DatabaseCON data = null;
	public static User loggedInUser;
//	public static User userDeafault = new User("admin","admin"); 
//	public static ArrayList<User> users = new ArrayList<User>(Arrays.asList(userDeafault));
	public static ArrayList<User> users;

	public static void loadData() {
		if (!USERS_FILE.exists()) {
			try {
				USERS_FILE.createNewFile();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,
						"Skedari i te dhenave " + "	per perdoruesit nuk" + " mund te krijohet!", "Gabim",
						JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
		}
		if (!IDS_FILE.exists()) {
			try {
				IDS_FILE.createNewFile();
				writeIds();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Skedari i te dhenave nuk" + " mund te krijohet!", "Gabim",
						JOptionPane.ERROR_MESSAGE);
				System.exit(2);
			}
		}
		writeObjects(users, USERS_FILE);
		int[] id = readIds();
		Work.setNextId(id[0]);
		Person.setNextId(id[1]);
		users = readObjects(USERS_FILE);
		if (users.size() == 0) {
			Admin superAdm = new Admin();
			superAdm.setUsername("admin");
			superAdm.setPassword("admin");
			users.add(superAdm);
		}
	}

	private static int[] readIds() {
		if (IDS_FILE == null) {
			return new int[] { 1, 2 };
		}
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(IDS_FILE));
			int[] id = (int[]) input.readObject();
			input.close();
			return id;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Skedari i te dhenave nuk" + " mund te krijohet!", "Gabim",
					JOptionPane.ERROR_MESSAGE);
			System.exit(3);
		}
		return null;
	}

	public static void writeIds() {
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(IDS_FILE));
			output.writeObject(new int[] { Work.getNextId(), Person.getNextId() });
			output.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Dicka shkoi keq!", "Gabim", JOptionPane.ERROR_MESSAGE);

		}
	}

	@SuppressWarnings("unchecked")
	public static <E extends Serializable> ArrayList<E> readObjects(File file) {
		if (file == null) {
			return new ArrayList<E>();
		}
		ArrayList<E> list = new ArrayList<E>();
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
			list = (ArrayList<E>) input.readObject();
			input.close();
			return list;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Dicka shkoi keq!");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return list;
	}

	public static <E extends Serializable> void writeObjects(ArrayList<E> list, File file) {
		if (list == null || file == null) {
			return;
		}
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
			output.writeObject(list);
			output.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Dicka shkoi keq!");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static User getValidUser(String username, String password) {
		loadData();
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	public static boolean CreateUser(String username, String password) throws SQLException, ClassNotFoundException {

		DataHandler.data = new DatabaseCON();

		Statement stm = data.connection.createStatement();

		ResultSet rs = stm.executeQuery("SELECT \"UserName\", \"UserPass\"\r\n" + "	FROM public.\"Users\";");
		while (rs.next()) {
			if (username.equals(rs.getString(1))) {
//				JOptionPane.showMessageDialog(null, "Ky username eshte i zene!");
				return false;
			}

		}
		stm.close();
		String insertQuery = "INSERT INTO public.\"Users\"(\"UserName\", \"UserPass\") VALUES (?, ?)";
		PreparedStatement pstmt = data.connection.prepareStatement(insertQuery);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		int rowsAfected = pstmt.executeUpdate();
		System.out.println(rowsAfected);
		pstmt.close();
//		JOptionPane.showMessageDialog(null, "Ky username u shtua!");
		return true;
	}

	public static boolean authUser(String username, String password) throws SQLException, ClassNotFoundException {

		DataHandler.data = new DatabaseCON();

		Statement stm = data.connection.createStatement();

		ResultSet rs = stm.executeQuery("SELECT \"UserName\", \"UserPass\"\r\n" + "	FROM public.\"Users\";");

		while (rs.next()) {

			if (username.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
				stm.close();
				return true;
			}
		}

		stm.close();
		return false;

	}

	public static boolean searchUser(String username) throws SQLException, ClassNotFoundException {

		DataHandler.data = new DatabaseCON();

		Statement stm = data.connection.createStatement();

		ResultSet rs = stm.executeQuery("SELECT \"UserName\"\r\n" + "	FROM public.\"Users\";");

		while (rs.next()) {

			if (username.equals(rs.getString(1))) {
				stm.close();
				return true;
			}
		}

		stm.close();
		return false;
	}

	public static void updatePassword(String username, String newPassword) throws ClassNotFoundException, SQLException {
		DataHandler.data = new DatabaseCON();
		PreparedStatement pstm = data.connection
				.prepareStatement("UPDATE public.\"Users\" SET \"UserPass\" = (?) WHERE \"UserName\" = (?)");
		pstm.setString(1, newPassword);
		pstm.setString(2, username);
		pstm.execute();
		pstm.close();
	}

//	public static void addProject(Project project) {
//		try {
//			DataHandler.data = new DatabaseCON();
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//		PreparedStatement pstm;
//		try {
//			pstm = data.connection.prepareStatement("INSERT INTO public.Projects (State) VALUES (?)");
//			pstm.setString(1, project.getStatus() + "");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}

	public static void addProject(String title, String description, String startDate, String endDate,
			String taskDescription, String taskAssignment, String taskStatus) {
		try {
			DataHandler.data = new DatabaseCON();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		PreparedStatement pstm;
		try {
			pstm = data.connection
					.prepareStatement("INSERT INTO public.\"Projects\" (\"Title\",\"Description\",\"StartDate\","
							+ "\"ClosedDate\") VALUES (?,?,?,?)");
			pstm.setString(1, title);
			pstm.setString(2, description);
			pstm.setString(3, startDate);
			pstm.setString(4, endDate);
			pstm.execute();
			pstm = data.connection.prepareStatement(
					"Select \"Id\" FROM public.\"Projects\" WHERE  \"Title\" = ? AND \"Description\" = ? AND \"StartDate\" = ?"
							+ "AND \"ClosedDate\" = ?");
			pstm.setString(1, title);
			pstm.setString(2, description);
			pstm.setString(3, startDate);
			pstm.setString(4, endDate);
			pstm.execute();
			ResultSet rs = pstm.getResultSet();
			int id = 0;
			while (rs.next()) {
				id = Integer.parseInt(rs.getString(1));
			}
			pstm = data.connection.prepareStatement("INSERT INTO public.\"Tasks\" (\"TaskDesc\","
					+ "\"TaskAssignment\", \"TaskStatus\",\"ProjectId\") VALUES (?,?,?,?)");
			pstm.setString(1, taskDescription);
			pstm.setString(2, taskAssignment);
			pstm.setString(3, taskStatus);
			pstm.setInt(4, id);

			pstm.execute();
			pstm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

	}

//Kthen nje ArrayList me Project nga database.
	public static ArrayList<Project> listProject() {
		ArrayList<Project> projectList = new ArrayList<Project>();
		Project project;
		ArrayList<Task> taskList;
		try {
			DataHandler.data = new DatabaseCON();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		try {
			Statement stm = data.connection.createStatement();

			ResultSet rs = stm.executeQuery(
					"SELECT \"Projects\".\"Id\",\"Projects\".\"Title\",\"Tasks\".\"TaskDesc\",\"Tasks\".\"TaskAssignment\",\"Tasks\".\"TaskStatus\" "
							+ "FROM public.\"Projects\" INNER JOIN public.\"Tasks\" ON \"Projects\".\"Id\" = \"Tasks\".\"ProjectId\" ");
// 
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				project = new Project();
//				ArrayList<String> employeeList = new ArrayList<String>();
				Task task = new Task("", IssueStatus.OPEN, "");
				taskList = new ArrayList<Task>();
//				IssueStatus issueStatus;
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					switch (rsmd.getColumnName(i)) {
					case "Id":
						project.setId(rs.getInt(i));
						break;
					case "Title":
						project.setTitle(rs.getString(i));
						break;
					case "Description":
						project.setDescription(rs.getString(i));
						break;
					case "StartDate":
						project.setStartDate(rs.getString(i));
						break;
					case "EndDate":
						project.setEndDate(rs.getString(i));
						break;
					case "TaskDesc":
						task.setDescription(rs.getString(i));
						break;
					case "TaskAssignment":
						task.setAssignedEmployees(rs.getString(i));
						break;
					case "TaskStatus":
						task.setStatus(generateStatus(rs.getString(i)));
						break;
					}
				}
				taskList.add(task);
				project.setTasks(taskList);
				projectList.add(project);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projectList;
	}

	public static IssueStatus generateStatus(String string) {
		for (IssueStatus issueStatus : IssueStatus.values())
			if (string.equals(issueStatus.name())) {
				return issueStatus;
			}
		return IssueStatus.OPEN;
	}

	public static void addTask(Task task, int projectId) {
		try {
			DataHandler.data = new DatabaseCON();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		try {
			String query = "INSERT INTO public.\"Tasks\" (\"TaskDesc\", \"TaskStatus\", \"ProjectId\", \"TaskAssignment\") VALUES"
					+ "(?,?,?,?)";
			PreparedStatement pstm = data.connection.prepareStatement(query);
			pstm.setString(1, task.getDescription());
			pstm.setString(2, task.getStatus() + "");
			pstm.setInt(3, projectId);
			pstm.setString(4, task.getAssignedEmployees());
			pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<Task> getSelectedTasks(int id) {
		ArrayList<Task> taskList = new ArrayList<Task>();
		try {
			DataHandler.data = new DatabaseCON();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		PreparedStatement pstm;
		try {
			pstm = data.connection.prepareStatement("SELECT * from public.\"Tasks\" WHERE \"ProjectId\" = ?");
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				Task task = new Task();
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {

					switch (rs.getMetaData().getColumnName(i)) {
					case "Id":
						task.setId(rs.getInt(i));
						break;
					case "TaskDesc":
						task.setDescription(rs.getString(i));
						break;
					case "TaskAssignment":
						task.setAssignedEmployees(rs.getString(i));
						break;
					case "TaskStatus":
						task.setStatus(generateStatus(rs.getString(i)));
						break;
					}
				
				}
				taskList.add(task);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return taskList;
	}

	public static void deleteTask(int taskId) {
		try {
			DataHandler.data = new DatabaseCON();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement stm;
			try {
				stm = data.connection.createStatement();
				stm.execute("DELETE FROM public.\"Tasks\" WHERE \"Id\" = " + taskId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
