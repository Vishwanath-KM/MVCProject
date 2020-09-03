package com.vishu.mvc;

import java.io.Serializable;

public class RegBean implements Serializable{
	private String uname,email,pass,rpass;
	
	public RegBean() {
	
	}
	
	public String validate() {
		String msg="";
		StringBuilder sb = new StringBuilder();
		if(uname==null||uname.trim().equals("")) {
			sb.append("<br/>Name Should not be empty<br/>");
		}
		if(email==null||email.trim().equals("")) {
			sb.append("Email should not be empty<br/>");
		}
		else {
		if(!email.contains("@gmail.com"))
			sb.append("Enter the valid Email id<br/>");
		}
		if(pass==null||pass.trim().equals("")) {
			sb.append("Password should not be empty<br/>");
		}
		else
			if(!pass.equals(rpass))
		    sb.append("pass not equal to rpass,if u dont repeat pass correctly what you will do in life!<br/>");
	    msg=sb.toString();
		if(msg.equals(""))
		{
			return Constants.SUCCESS;
		}
		else
			return msg;
	
	}

	@Override
	public String toString() {
		return "RegBean [uname=" + uname + ", email=" + email + ", pass=" + pass + ", rpass=" + rpass + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((rpass == null) ? 0 : rpass.hashCode());
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
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
		RegBean other = (RegBean) obj;
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
		if (rpass == null) {
			if (other.rpass != null)
				return false;
		} else if (!rpass.equals(other.rpass))
			return false;
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		return true;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
		System.out.println("inside setUname() : "+uname);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		System.out.println("inside setEmail() : "+email);
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
		System.out.println("inside setPass() : "+pass);
	}

	public String getRpass() {
		return rpass;
	}

	public void setRpass(String rpass) {
		this.rpass = rpass;
		System.out.println("inside setRpass() : "+rpass);
	}
	

}
