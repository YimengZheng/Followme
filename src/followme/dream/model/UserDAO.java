package followme.dream.model;

import java.util.*;
import java.sql.*;

import followme.dream.bean.User;

public interface UserDAO {
	
	User findUserByName(String name);
	List<User> findFriendByName(String name);
	void updateUser(User user);
	void removeStudentByName(String name);
	void removeUser(User user);
	List<User> getAllUsers();
	List<User> searchUser(String query);
	User findUserByNameAndPass(String name, String password);
	boolean addUser(String username, String email, String password);

}
