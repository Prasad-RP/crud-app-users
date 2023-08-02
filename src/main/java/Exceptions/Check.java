package Exceptions;

public class Check {

	public static void main(String[] args) {
		
		String name="prp";String email="prp@gmail.com";String add="pune";
		String pass="prp";
		
		String sql="update user set name='"+name+"',email='"+email+"',add='"+add+"',pass='"+pass+"';";

		System.out.println(sql);
		
	}

}
