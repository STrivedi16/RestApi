package CRUDUsers.Users;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // To indicate that class provide mechanism to stored , update ,delete , get the
			// data.
public interface Userrepository extends JpaRepository<Users, Integer> {

	// @Query("select name,city,email from users")
	// public List<Users> getalluser();

	// @Transactional
	// @Modifying
	// @Query(value = "UPDATE users SET is_active=false WHERE id=?", nativeQuery =
	// true)
	// void softdelete(int id);

	// public List<Users> findByactive(Boolean str);

	public List<Users> findAll();

	public List<Users> findByactive(Boolean str);

	// public List<Users> findByactive();

	// public boolean active();

	public List<Users> active(Boolean bool);

	Users obj = new Users();

	public List<Users> findByactive(boolean b);

	// public Boolean findByactive();

	Collection<Users> findByactive(Boolean bool, Class<Users> type);

	// @Query("select * from users where is_active=true")
	// public List<Users> findAll();

	public List<Users> findByActiveTrue();
}
