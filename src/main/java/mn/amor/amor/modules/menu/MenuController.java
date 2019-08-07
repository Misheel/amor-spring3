package mn.amor.amor.modules.menu;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import mn.amor.amor.modules.menuCategory.MenuCategory;
import mn.amor.amor.modules.menuCategory.MenuCategoryMapper;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
	
	@Autowired
	private MenuMapper mapper;
	
	@Autowired
	private MenuCategoryMapper categoryMapper;
	
	@GetMapping("/list")
	public List<Menu> list(@RequestParam String categoryName) {		
		return mapper.findAllByCategoryName(categoryName);
	}
	
	@GetMapping("/list2")
	public List<Menu> list2(@RequestParam String categoryName) {
		MenuCategory category = categoryMapper.findByName(categoryName);		
		return mapper.findAllByCategoryId(category.getId());
	}
	
	@GetMapping("/listByCategoryId")
	public List<Menu> listByCategoryId(@RequestParam Integer id) {			
		return mapper.findAllByCategoryId(id);
	}
	
	@GetMapping("/listByParentId")
	public List<Menu> listByParentId(@RequestParam Integer id) {			
		return mapper.findAllByParentId(id);
	}
		
	@PostMapping("/save")	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void save(@RequestBody Menu form) {
		form.setStatus("ENABLED");
		mapper.save(form);
	}
	
	@PostMapping("/update")	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void update(@RequestBody Menu form) {		
		mapper.update(form);
	}
	
	@PostMapping("/sort")	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void sort(@RequestParam Map<String,String> params) {		
		for (Map.Entry<String, String> entry : params.entrySet()) {			
			Integer id = Integer.parseInt(entry.getKey());
			Integer ordering = Integer.parseInt(entry.getValue());
			mapper.changeOrdering(id, ordering);                        
        }
	}
	
	@PostMapping("/delete/{id}")	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id) {		
		mapper.delete(id);
	}
	
	@GetMapping("/read/{id}")		
	public Menu read(@PathVariable Integer id) {		
		return mapper.findById(id);
	}

}
