package training.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import training.demo.domain.message;
import training.demo.repository.messageRepo;

import java.util.List;
import java.util.Map;


@Controller
public class MainController {
    @Autowired
    private messageRepo messageRepo;

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        Iterable<message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        message messages = new message(text, tag);
        messageRepo.save(messages);
        model.put("messages", messages);
        return "redirect:/";
    }

    @PostMapping ("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<message> messages;

        if (filter !=null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        }
        else {
            messages = messageRepo.findAll();
        }
            model.put("messages", messages);
        return "main";
    }

}