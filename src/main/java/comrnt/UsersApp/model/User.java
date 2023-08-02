package comrnt.UsersApp.model;

public class User {

	private int id;

	public int getId() {
		return id;
	}

	private String name;
	private String email;
	private String address;
	private String password;

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", password="
				+ password + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
