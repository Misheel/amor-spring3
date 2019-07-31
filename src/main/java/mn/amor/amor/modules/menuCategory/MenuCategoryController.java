package mn.amor.amor.modules.menuCategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
