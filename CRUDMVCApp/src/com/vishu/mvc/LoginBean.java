package com.vishu.mvc;

public class LoginBean {
	
	private String email,pass;
	
	public LoginBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "LoginBean [email=" + email + ", pass=" + pass + "]";
	}
    
	
	public String validate() {
		String msg="";
		StringBuilder sb = new StringBuilder();
	
		if(email==null||email.trim().equals("")) {
			sb.append("Email should not be empty<br/>");
		}
		else
			if(!email.contains("@gmail.com"))
				sb.append("Enter the valid Email id<br/>");
	
		if(pass==null||pass.trim().equals("")) {
			sb.append("Password should not be empty<br/>");
		}
		
	    msg=sb.toString();
		if(msg.equals(""))
		{
			return Constants.SUCCESS;
		}
		else
			return msg;
	
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginBean other = (LoginBean) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		return true;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
