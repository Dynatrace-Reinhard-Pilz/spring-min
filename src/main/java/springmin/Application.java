package springmin;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

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
    	try (StringWriter sw = new StringWriter()) {
        	try (PrintWriter pw = new PrintWriter(sw)) {
        		pw.println("Greetings from Spring Boot (3)!");
                dump(new File("/opt/dynatrace"), pw, "");
                pw.flush();
                sw.flush();
                return sw.getBuffer().toString();
        	}
    	} catch (Throwable t) {
    		// ignore
    		return t.getMessage();
    	}
    }
    
    private static void dump(File file, PrintWriter pw, String indent) {
    	if (file == null) {
    		return;
    	}
    	if (!file.exists()) {
    		pw.println(file.toString() + " does not exist");
    		return;
    	}
    	pw.println(file.getAbsolutePath());
    	if (file.isDirectory()) {
    		File[] files = file.listFiles();
    		if (files != null) {
    			for (File child : files) {
					dump(child, pw, indent + "  ");
				}
    		}
    	}
    }

}
