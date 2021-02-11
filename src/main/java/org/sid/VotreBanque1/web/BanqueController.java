package org.sid.VotreBanque1.web;

import org.sid.VotreBanque1.metier.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.sid.VotreBanque1.entities.Compte;
import org.sid.VotreBanque1.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BanqueController{
    @Autowired
    private IBanqueMetier banqueMetier;
    @RequestMapping(value = "/template",method = RequestMethod.GET)
    public String index(){
        return "template";
    }
    
    @RequestMapping(value = "/consulterCompte", method = RequestMethod.GET)
    public String consulter(Model model, String codeCompte,
            @RequestParam(name = "page", defaultValue = "0")int p,
            @RequestParam(name = "size", defaultValue = "4")int s){
        try {
            Compte cp = banqueMetier.consulterCompte(codeCompte);
            Page<Operation> operations = banqueMetier.listOperation(codeCompte, p, s);
            model.addAttribute("codeCompte", codeCompte);
            model.addAttribute("compte", cp);
            model.addAttribute("listOperation", operations.getContent());
            int pages[] = new int[operations.getTotalPages()];
            model.addAttribute("pages", pages);
            model.addAttribute("size", s);
            model.addAttribute("pageCourante", p);
        } catch (Exception e) {
            model.addAttribute("exception", e);
        }         
        return "comptes";
    }
    
    @RequestMapping(value = "/operation",method = RequestMethod.GET)
    public String compte(Model model){
        return "comptes";
    }
    
     @RequestMapping(value = "/saveOperation",method = RequestMethod.POST)
    public String compte(Model model, String typeOperation, String codeCompte, double montant, String codeCompte2){
         try {
            if(typeOperation.equals("VER"))
                banqueMetier.verser(codeCompte, montant);
            if(typeOperation.equals("RET"))
                banqueMetier.retirer(codeCompte, montant);
            else if(typeOperation.equals("VIR"))
                banqueMetier.virement(codeCompte, codeCompte2, montant);
         } 
         catch (Exception e) {
             model.addAttribute("error", e);
              return "redirect:/consulterCompte?codeCompte="+codeCompte+"&error="+e.getMessage();
         }
        
        return "redirect:/consulterCompte?codeCompte="+codeCompte;
    }
}
