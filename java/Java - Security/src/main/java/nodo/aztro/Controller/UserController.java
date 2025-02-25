package nodo.aztro.Controller;

import nodo.aztro.Models.User;
import nodo.aztro.Services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public ResponseEntity<List<User>> index() {
        List<User> users = userService.index();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        User newUser = userService.saveUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<List<User>> getById(@PathVariable int id) {
        userService.findUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<List<User>> search(@PathVariable String email) {
        userService.findUserByEmail(email);
        return new ResponseEntity<>(HttpStatus.OK);
    } 
}
