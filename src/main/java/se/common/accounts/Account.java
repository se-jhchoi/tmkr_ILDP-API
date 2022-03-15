package se.common.accounts;

import java.util.Set;

public class Account {

    private Integer id;
    private String username;
    private String password;
    private Set<AccountRole> roles;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<AccountRole> getRoles() {
		return roles;
	}
	public void setRoles(Set<AccountRole> roles) {
		this.roles = roles;
	}
}
