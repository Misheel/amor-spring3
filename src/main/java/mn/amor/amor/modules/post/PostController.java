package mn.amor.amor.modules.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class PostController {
	
	@Autowired
	private PostMapper mapper;
	
	@GetMapping("/list")
	public List<Post> list() {		
		return mapper.findAll();
	}
		
	@PostMapping("/save")	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void save(@RequestBody Post form) {		
		mapper.save(form);
	}
	
	@GetMapping("/read/{id}")		
	public Post read(@PathVariable Integer id) {		
		return mapper.findById(id);
	}
	
	@PostMapping("/update")	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void update(@RequestBody Post form) {		
		mapper.update(form);
	}
	
	@PostMapping("/delete/{id}")	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id) {		
		mapper.delete(id);
	}

}
