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
        dump(new File("/opt/dynatrace"), sb, "");
        return sb.toString();
    }
    
    private static void dump(File file, StringBuilder sb, String indent) {
    	if (file == null) {
    		return;
    	}
    	if (!file.exists()) {
    		sb.append(file.toString()).append(" does not exist").append("\n");
    		return;
    	}
    	sb.append(file.getAbsolutePath()).append("\n");
    	if (file.isDirectory()) {
    		File[] files = file.listFiles();
    		if (files != null) {
    			for (File child : files) {
					dump(child, sb, indent + "  ");
				}
    		}
    	}
    }

}
