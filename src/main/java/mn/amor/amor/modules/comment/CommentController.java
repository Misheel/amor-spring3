package mn.amor.amor.modules.comment;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

@RestController
@RequestMapping("/api/comment")
public class CommentController {
	
	@Autowired
	private CommentMapper mapper;		
	
	@GetMapping("/listByPostId")
	public List<Comment> listByPostId(@RequestParam Integer id) {			
		return mapper.findAllByPostId(id);
	}
	
	@GetMapping("/listByParentId")
	public List<Comment> listByParentId(@RequestParam Integer id) {			
		return mapper.findAllByParentId(id);
	}
		
	@PostMapping("/save")	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void save(@RequestBody Comment form, HttpServletRequest request) {
		form.setIp(request.getRemoteAddr());		
		mapper.save(form);
	}	
	
	@PostMapping("/delete/{id}")	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id) {		
		mapper.delete(id);
	}
	
	@GetMapping("/read/{id}")		
	public Comment read(@PathVariable Integer id) {		
		return mapper.findById(id);
	}

}
