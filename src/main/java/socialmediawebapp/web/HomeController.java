package socialmediawebapp.web;

import socialmediawebapp.repo.Comment;
import socialmediawebapp.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
	@Autowired
	private CommentRepository repository;

	@GetMapping(value="/")
	public String home(Model model){
		List<Comment> comments = repository.getAllComments();
		model.addAttribute("comments", comments);

		return "home";
	}

	@PostMapping(value="/")
	public String home1(@RequestParam("userName") String userName, @RequestParam("message") String message){
		repository.addNewCommentToDataBase(userName, message);
		return "redirect:/";
	}
}