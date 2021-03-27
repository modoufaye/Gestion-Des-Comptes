package org.sid.VotreBanque1.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ModouFaye
 */
@Controller
public class SecurityController {
    
    @RequestMapping(value ="/login")
    public String login(){
        return "login";
    }
    @RequestMapping(value ="/")
    public String home(){
        return "redirect:/operation";
    }
    
}
