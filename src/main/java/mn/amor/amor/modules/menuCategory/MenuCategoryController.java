package mn.amor.amor.modules.menuCategory;

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
@RequestMapping("/api/menuCategory")
public class MenuCategoryController {
	
	@Autowired
	private MenuCategoryMapper mapper;
	
	@GetMapping("/list")
	public List<MenuCategory> list() {		
		return mapper.findAll();
	}
		
	@PostMapping("/save")	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void save(@RequestBody MenuCategory form) {		
		mapper.save(form);
	}
	
	@PostMapping("/update/{id}")	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void update(@RequestBody MenuCategory form, @PathVariable Integer id) {		
		mapper.update(id, form.getName());
	}
	
	@PostMapping("/delete/{id}")	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id) {		
		mapper.delete(id);
	}

}
