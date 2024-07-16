package betplay.app.Player.infrastructure.adapter.in;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import betplay.app.Player.domain.Player;
import betplay.app.Player.infrastructure.adapter.out.PlayerRepository;



/**
 * PlayerController
 */
@Controller
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;
    @GetMapping("/getPlayer")
    public Optional<Player> getPlayerById() {
        return playerRepository.findById(1L);
    }
    @GetMapping("/hola")
    public String holaAlguien(@RequestParam String nombre) {
        String cadena = "normalito " + nombre;
        return cadena;
    }
    @GetMapping("/detalles")
	public static String vista(Model model) {
		model.addAttribute("profesion", "Desarollador");
		return "detalles";
	}
    @GetMapping("/asdfg")
    @ResponseBody
    public HashMap api(@RequestParam String nombre,@RequestParam  String apellido) {
        HashMap objeto = new HashMap<>();
        objeto.put("nombre", nombre);
        objeto.put("apellido", apellido);
        return objeto;
    }
}