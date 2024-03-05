package az.edu.ada.wm2.springmvc.sessionattributesdemo.controller;

import az.edu.ada.wm2.springmvc.sessionattributesdemo.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping({"", "/", "/list"})
    public String displayOrders(@SessionAttribute("cart") Order order, Model model){
        System.out.println("-------------->" + order);
        model.addAttribute("order", order);
        return "orders/order_detail";
    }

    @PostMapping("/save")
    public String save(@RequestParam("customerName") String customerName, @SessionAttribute("cart") Order order,
                       //WebRequest webRequest,
                       SessionStatus ss){
        order.setCustomerName(customerName);

        System.out.println("Order is completed, than you for your purchase!");
        System.out.println("--->" + order);
        ss.setComplete();

        //webRequest.removeAttribute("cart", 1);
        return "redirect:/product/list";
    }
}
