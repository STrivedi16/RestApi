package CRUDUsers.Users;

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

}
