package de.scheduler.service;

import java.util.List;

import de.scheduler.model.User;
import de.scheduler.model.UserInfo;
import de.scheduler.model.UserRole;

public interface UsrMngmentCRUDServiceIntrface {
	
	public List<UserInfo> getAllUsers(String cUsrName);
	
	public void deleteUsers(Integer usrId);
	
	public User get( Integer id );
	
	public void updateUsers(User user);
	
	public void updateUserRole(UserRole usrRole);
	
	public Integer getRoleId( Integer id );
	
	public UserRole getUserRole( Integer id );
	
	
}
