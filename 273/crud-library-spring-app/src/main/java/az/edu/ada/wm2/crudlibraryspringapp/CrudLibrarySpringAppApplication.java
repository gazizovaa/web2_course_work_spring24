package az.edu.ada.wm2.crudlibraryspringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class CrudLibrarySpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudLibrarySpringAppApplication.class, args);
		System.out.println("Hello, this is my crud library spring app");
	}

	@RequestMapping("/")
	public List<String> getBooks(){
		return List.of("Atomic Habits", "Peace Like a River","The God of Small Things", "Rich Dad, Poor Dad");
	}

}
