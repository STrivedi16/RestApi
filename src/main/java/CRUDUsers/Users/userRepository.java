package CRUDUsers.Users;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository extends JpaRepository<Users, Integer> {

	// @Query("select name,city,email from users")
	// public List<Users> getalluser();

	@Transactional
	@Modifying
	@Query(value = "UPDATE users SET is_active=false WHERE id=?", nativeQuery = true)
	void softdelete(int id);
}
