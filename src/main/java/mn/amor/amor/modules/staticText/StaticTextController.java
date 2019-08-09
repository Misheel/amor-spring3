package mn.amor.amor.modules.staticText;

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
@RequestMapping("/api/staticText")
public class StaticTextController {
	
	@Autowired
	private StaticTextMapper mapper;
	
	@GetMapping("/list")
	public List<StaticText> list() {		
		return mapper.findAll();
	}
		
	@PostMapping("/save")	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void save(@RequestBody StaticText form) {		
		mapper.save(form);
	}
	
	@GetMapping("/read/{id}")		
	public StaticText read(@PathVariable Integer id) {		
		return mapper.findById(id);
	}
	
	@GetMapping("/readByName/{name}")		
	public StaticText read(@PathVariable String name) {		
		return mapper.findByName(name);
	}
	
	@PostMapping("/update")	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void update(@RequestBody StaticText form) {		
		mapper.update(form);
	}
	
	@PostMapping("/delete/{id}")	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id) {		
		mapper.delete(id);
	}

}
