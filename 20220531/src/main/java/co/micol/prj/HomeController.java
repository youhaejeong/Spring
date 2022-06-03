package co.micol.prj;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("환영합니다. {}.", locale);

		return "home/home";
	}
//메소드 오버로딩(다형성)
	@RequestMapping("/home.do")
	public String home() {
		return "home/home";
	}
	@RequestMapping("/admin.do")
	public String admin() {
		return "admin";
	}

}
