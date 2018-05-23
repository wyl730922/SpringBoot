package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GreetingController {

/**
 *The @GetMapping annotation ensures that HTTP GET requests to /greeting are mapped to the greeting() method.
 */
    @GetMapping("/greeting")

/**
 *@RequestParam binds the value of the query String parameter name into the name parameter of the greeting() method. 
 *This query String parameter is not required; if it is absent in the request, the defaultValue of "World" is used. 
 *The value of the name parameter is added to a Model object, ultimately making it accessible to the view template.
 */

    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        return "index";
    }


    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirectto(){
        return "redirect:/hello";
    }

}
