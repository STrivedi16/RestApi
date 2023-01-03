package CRUDUsers.Users;

import java.util.List;
import java.util.Optional;

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

	@Autowired // Autowired is uesd to injecting beans at runtime by dependancy injection
	private userRepository urs;

	@PostMapping("usersadd")
	public ResponseEntity<?> addusers(@RequestBody Users urUsers) {

		urUsers.setActive(true);
		urs.save(urUsers);
		return new ResponseEntity<>(new SuccessResponce("stored", "Successfull", urs.save(urUsers)), HttpStatus.OK);

	}

	@GetMapping("users")
	public ResponseEntity<?> getalluser() {
		List<Users> list = (List<Users>) urs.findAll();

		if (list.size() <= 0) {
			return new ResponseEntity<>(new errorResponce("No data", "Insert data first"), HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<>(new SuccessResponce("Successfull", "All Data show here", list), HttpStatus.OK);

	}

	@GetMapping("user/{id}")
	public ResponseEntity<?> getuserbyid(@PathVariable("id") int id) {
		Optional<Users> usid = urs.findById(id);

		try {
			if (usid.isEmpty()) {
				throw new Exception("User id not found");
			}
			return new ResponseEntity<>(new SuccessResponce("Data Founded", "Successfull", usid), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new errorResponce("User not Found", "Id Not Found"), HttpStatus.NOT_FOUND);
		}

	}
	// @RequestMapping(values="/user/{id}" , method=RequestMapping.Put
	// @ResponceBody

	@PutMapping("users/{id}")
	public ResponseEntity<?> update(@RequestBody Users uid, @PathVariable("id") int id) {
		try {
			if (uid.getId() == id) {
				return new ResponseEntity<>(
						new SuccessResponce("User data update", "Update successfull", urs.save(uid)), HttpStatus.OK);
			} else {
				throw new Exception("User not Found");
			}

		} catch (Exception e) {

			return new ResponseEntity<>(new errorResponce("User data not found", "Not found"), HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable("id") int id) {

		// System.err.println("jjjjjjjjjjjj");

		urs.deleteById(id);
		return "Data is delete";

	}
}
