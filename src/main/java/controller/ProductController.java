package controller;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.product.IProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("view");
        List<Product> productList = productService.findAll();
        modelAndView.addObject("view", productList);
        return modelAndView;
    }

    //Create
    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("create", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createProduct(@ModelAttribute Product product) {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("create", product);
        int id = productService.findAll().size();
        product.setId(id);
        productService.save(product);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Product product = productService.findById(id);
        modelAndView.addObject("edit", product);
        return modelAndView;

    }

    @PostMapping("/edit/{id}")
    public ModelAndView editProduct(@PathVariable int id, Product product) {
        ModelAndView modelAndView = new ModelAndView("edit");
        product.setId(id);
        productService.update(id, product);
        modelAndView.addObject("edit", productService.findAll());
        return modelAndView;
    }

    //Delete
    @GetMapping("/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable int id) {
        productService.remove(id);
        return new ModelAndView("redirect:/products");
    }

    //Search
    @PostMapping("")
    public ModelAndView modelAndView(@RequestParam("name") String name) {
        ModelAndView modelAndView = new ModelAndView("view");
        List<Product> productList = productService.findByName(name);
        modelAndView.addObject("view", productList);
        return modelAndView;
    }

}
