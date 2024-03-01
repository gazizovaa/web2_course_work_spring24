package az.edu.ada.wm2.springmvc.sessionattributesdemo.controller;

import az.edu.ada.wm2.springmvc.sessionattributesdemo.model.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
@SessionAttributes({"cart"})
public class ProductsController {

    @GetMapping({"/list", "/"})
    public String listProducts(Model model, @ModelAttribute("cart") Order cart){
        model.addAttribute("cart",cart == null?new Order() : cart);
        return "products/list";
    }

    @PostMapping("addToOrder")
    public String addProductToOrder(@RequestParam("product") String productId,
                                    @ModelAttribute Order order){
        order.addProduct(productId);
        return "redirect:/products/";
    }

    @ModelAttribute("cart")
    public Order order(){
        return new Order();
    }

}
