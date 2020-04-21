//template class that stores the information of each user (password and username)
public class User {

	//characteristics of user object
	private String username;
	private String pass;
	
	//constructor calls the setters for username and password
	public User(String username, String pass) {
		
		setUsername(username);
		setPassword(pass);
		
	}

	//following methods are getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return pass;
	}

	public void setPassword(String pass) {
		this.pass = pass;
	}
	
}
