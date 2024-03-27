package az.edu.ada.wm2.springmvc.sessionattributesdemo.controller;

import az.edu.ada.wm2.springmvc.sessionattributesdemo.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
@SessionAttributes({"cart"})
public class ProductsController {

    @GetMapping({"", "/", "/list"})
    public String displayProducts(Model model, @ModelAttribute("cart") Order cart){
        model.addAttribute("cart",cart == null ? new Order() : cart);
        return "products/list";
    }

    @PostMapping("/addToOrder")
    public String addProduct(@ModelAttribute("cart") Order cart,
                             @RequestParam("product") String prodName){
        System.out.println("Before adding: " + cart);

        if(prodName != null || !prodName.isBlank())
            cart.addProduct(prodName);

        System.out.println("After adding: " + cart);

        return "redirect:/product";
    }

    @ModelAttribute("cart")
    private Order cart(){
        return new Order();
    }

}
