package CRUDUsers.Users;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired // Autowired is uesd to injecting beans at runtime by dependancy
	// injection so if we dont't use @autowired the it does not help in the storing
	// update and delete

	private Userrepository urs;

	@PostMapping("users")
	public ResponseEntity<?> addusers(@RequestBody Users urUsers) {

		// urUsers.setActive(true);
		// urs.save(urUsers);
		return new ResponseEntity<>(new Successresponce("stored", "Successfull", urs.save(urUsers)), HttpStatus.OK);

	}

	@GetMapping("users")
	public ResponseEntity<?> getalluser() {
		List<Users> list = (List<Users>) urs.findAll();

		if (list.size() <= 0) {
			return new ResponseEntity<>(new Errorresponce("No data", "Insert data first"), HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<>(new Successresponce("Successfull", "All Data show here", list), HttpStatus.OK);

	}

	@GetMapping("user/{id}")

	public ResponseEntity<?> getuserbyid(@PathVariable("id") int id) {
		Optional<Users> usid = urs.findById(id);

		try {
			if (usid.isEmpty()) {
				throw new NotFoundException("User id not found");
			}
			return new ResponseEntity<>(new Successresponce("Data Founded", "Successfull", usid), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new Errorresponce("User not Found", "Id Not Found"), HttpStatus.NOT_FOUND);
		}

	}

	/*
	 * @GetMapping("allusers") public ResponseEntity<?> getallUsers() { List<Users>
	 * list = urs.getalluser();
	 * 
	 * if (list.size() <= 0) { return new ResponseEntity<>(new
	 * errorResponce("Error in data", "Not Found"), HttpStatus.NOT_FOUND); } return
	 * new ResponseEntity<>(new SuccessResponce("Show All Users", "Successfull",
	 * list), HttpStatus.OK); }
	 */

	// @RequestMapping(values="/user/{id}" , method=RequestMapping.Put
	// @ResponceBody

	@PutMapping("users/{id}")
	public ResponseEntity<?> update(@RequestBody Users uid, @PathVariable("id") int id) {
		try {
			if (uid.getId() == id) {
				return new ResponseEntity<>(
						new Successresponce("User data update", "Update successfull", urs.save(uid)), HttpStatus.OK);
			} else {
				throw new NotFoundException("User not Found");
			}

		} catch (Exception e) {

			return new ResponseEntity<>(new Errorresponce("User data not found", "Not found"), HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("user/{id}")

	public String delete(@PathVariable("id") int id) {

		// System.err.println("jjjj");

		urs.deleteById(id);
		return "Data is delete";

		// urs.softdelete(id);

	}

	// @GetMapping("findby/{active}")
	// public List<Users> findyactive(@PathVariable("active") Boolean active) {
	// List<Users> list = urs.findByactive(active);

	// return list;

	// }

	@GetMapping("Users")
	public Stream<Users> findall() {
		// ArrayList<Users> al = new ArrayList<>();
		List<Users> list = urs.findAll();

		// Users us = new Users();
		// if (us.isActive() == true) {
		// al.add(us);
		// }

		return list.stream().filter(ac -> ac.isActive() == true);

	}

	@GetMapping("findall")
	public List<Users> findactive() {
		Users us = new Users();

		List<Users> list = urs.findByactive(us.isActive() == true);

		return list;

	}

}
