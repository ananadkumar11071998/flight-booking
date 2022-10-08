package demo.service.userservice.controller;

import demo.service.userservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import demo.service.userservice.service.UserService;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${reservation.url}")
    private String uri;

    @GetMapping("/reservations")
    public Object getReservations(@RequestParam Long personid)
    {
        Object result = restTemplate.getForObject(uri+personid, Object.class);
        return result;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        User responseEntity = userService.getUser(id);
        return ResponseEntity.ok(responseEntity);
    }

    @GetMapping("/allUser")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> responseEntities = userService.getAllUser();
        if (responseEntities.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(responseEntities);
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User responseEntity = userService.createUserAll(user);
        return ResponseEntity.ok(responseEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        User responseEntity = userService.getUser(id);
        userService.deleteUser(id);
        return ResponseEntity.ok(responseEntity);
    }
    
    @GetMapping("/getalllist")
    public ResponseEntity<List<User>> getAllUserlist() {
        List<User> responseEntities = userService.getAllUserlist();
        
        return ResponseEntity.ok(responseEntities);
    }
}
