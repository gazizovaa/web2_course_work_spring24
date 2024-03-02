package az.edu.ada.wm2.springmvc.sessionattributesdemo.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/demo")
@SessionAttributes({"principal"})
public class DemoController {

    @GetMapping("/path1")
    public String redirectTheRequest(Model model){
        System.out.println("----path 1");
        model.addAttribute("principal", "Gulnara");
        return "redirect:/demo/path2";
    }

    @GetMapping("/path2")
    public String showPage(Model model){
         return "demo/list";
    }
}
