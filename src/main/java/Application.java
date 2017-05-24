import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@EnableAutoConfiguration
public class Application {
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
	
	@RequestMapping("/yanglihao/")
	List<String> yanglihao() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("123");
		a.add("test");
		return a;
	}
	
	@RequestMapping("/greeting/") 
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, @RequestBody String gent) {
		return name + gent + "hi";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}


/*


import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
public class Application {
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
	
	@RequestMapping("/yanglihao/")
	List<String> yanglihao() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("123");
		a.add("test");
		return a;
	}
	
	@PostMapping("/greeting/")
	public String greetingSubmit(@ModelAttribute String greeting) {
		return "hello" + greeting;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
*/