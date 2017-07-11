package cn.lihao;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	private List<Topic> topics = Arrays.asList( new Topic("asf", "asf", "asdf"), new Topic("456asf", "as345f", "asdf"),new Topic("234", "23", "asdf"),new Topic("asf", "asf", "asdf"));
	
    public Topic getTopic(String id) {
    	return topics.get(1);
    }
}
