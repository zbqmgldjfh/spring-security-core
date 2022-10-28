package shine.me.springsecuritycore.controller.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {
	
	@GetMapping(value="/messages")
	public String messages() throws Exception {
		return "user/messages";
	}

	@ResponseBody
	@GetMapping("/api/messages")
	public String apiMessage() {
		return "messages ok";
	}
}
