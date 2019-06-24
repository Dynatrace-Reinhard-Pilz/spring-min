package springmin;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @RequestMapping("/")
    public String index() {
    	StringBuilder sb = new StringBuilder();
        sb.append("Greetings from Spring Boot (2)!").append("\n");
        File dir = new File("/opt/dynatrace");
        File[] files = dir.listFiles();
        for (File file : files) {
        	sb.append(file.getAbsolutePath()).append("\n");
		}
        return sb.toString();
    }

}
