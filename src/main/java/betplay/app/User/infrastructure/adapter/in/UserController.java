package betplay.app.User.infrastructure.adapter.in;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import betplay.app.User.application.service.UserService;
import betplay.app.User.domain.Users;

/**
 * UserController
 */
@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    @ResponseBody
    public Optional<Users> getUserById(@RequestParam Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/postUser")
    public ResponseEntity<String> postUser(@RequestParam String name,
                                           @RequestParam String lastname) {
        Users newUser = new Users();
        newUser.setNombre(name);
        newUser.setApellido(lastname);
        try {
            userService.saveUser(newUser);
            return ResponseEntity.ok("Usuario guardado con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el usuario.");
        }

    }
    @GetMapping("/userList")
    @ResponseBody
    public List <Users>  getUserList() {
        List <Users> usersList = userService.getAllUsers();
        usersList.add(new Users(null, "Sebastian", "Rueda"));
        usersList.add(new Users(null, "Alejandro", "Martinez"));
        return usersList;
    }
    @GetMapping("/formulario")
    public String showFormulario() {
        return "/formulario ";
    }
    

    
}