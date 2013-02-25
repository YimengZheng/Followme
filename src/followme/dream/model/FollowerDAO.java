package followme.dream.model;

import java.util.List;

import followme.dream.bean.User;

public interface FollowerDAO {
	List<User> findFollower(int userid);
	int countFollowerByuser(int userid);
}
