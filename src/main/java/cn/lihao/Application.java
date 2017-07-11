package cn.lihao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.jdbc.core.JdbcTemplate;



import cn.lihao.Topic;
import cn.lihao.TopicService;

@Controller
@SpringBootApplication
//@EnableAutoConfiguration
@EnableAutoConfiguration(exclude={    
        JpaRepositoriesAutoConfiguration.class//禁止springboot自动加载持久化bean  
          })
public class Application {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}
	
	@RequestMapping("/yanglihao/")
	@ResponseBody
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
	
	
	@RequestMapping(value = "/topics/{id}",  method = RequestMethod.POST) 
	@ResponseBody
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic("a");
	}
	
	
	@RequestMapping("/topics") 
	public List<Topic> getTopics(){
		return Arrays.asList(new Topic("", "", ""),
				             new Topic("java", "my java", "this is java description"));
	}
	
	@RequestMapping("/getUsers")
	@ResponseBody
	public List<Map<String, Object>> getDbType() {
		String sql = "select * from book_test_jack";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> map : list) {
			Set<Entry<String, Object>> entries = map.entrySet();
			if (entries != null) {
				Iterator<Entry<String, Object>> iterator = entries.iterator();
				while (iterator.hasNext()) {
					Entry<String, Object> entry = (Entry<String, Object>) iterator.next();
					Object key = entry.getKey();
					Object value = entry.getValue();
					System.out.println(key + ":" + value);
				}
			}
		}
		return list;
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