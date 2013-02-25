/**
 * 
 */
package followme.dream.model;

/**
 * @author Dream
 *
 */
import java.util.*;

import followme.dream.bean.News;

public interface NewsDAO {
	
	News findNewsById(int id);
	boolean addNews(String content, int userid);
	int accountNewsBy(int userid);
	void removeNewsById(int id);
	List<News> getAllNews(int id);
	List<News> getNewsByUser(int id);

}
