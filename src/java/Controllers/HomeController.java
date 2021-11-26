package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Pamela Gariepy
 */
@Controller
public class HomeController {

     @RequestMapping(value="/Home/accueil", method=RequestMethod.GET) 
    public ModelAndView accueil(){
        // Création de l'objet ModelAndView
        ModelAndView modelAndView = new ModelAndView("accueil");
        return modelAndView;  

    }   
}