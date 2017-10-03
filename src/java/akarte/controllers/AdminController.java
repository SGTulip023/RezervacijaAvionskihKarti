
package akarte.controllers;

import akarte.dao.AvioLet;
import akarte.dao.Karta;
import akarte.dao.Korisnik;
import akarte.dao.util.DB;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
    
    /* samo metode za izlistavanje, metode za izmenu su u flightcontroller, usercontroller*/
    
    @RequestMapping(value = "/izmenaLeta", method = RequestMethod.GET)
    public String listaLetova(Model model, HttpSession session) {
        
        Korisnik k = (Korisnik) session.getAttribute("korisnik");
        
        if (!k.getKorTip().equals("admin")) {
            return "index";
        }

        List<AvioLet> letovi = DB.query("SELECT a FROM AvioLet a");
        model.addAttribute("letovi", letovi);
         
        return "izmenaLeta";
    }
    
    @RequestMapping(value = "/izmenaKorisnika", method = RequestMethod.GET)
    public String listaKorisnika(Model model, HttpSession session) {
        
        Korisnik k = (Korisnik) session.getAttribute("korisnik");
        
        if (!k.getKorTip().equals("admin")) {
            return "index";
        }

        List<Korisnik> korisnici = DB.query("SELECT k FROM Korisnik k");
        model.addAttribute("korisnici", korisnici);
        
        return "izmenaKorisnika";
    }
    
    @RequestMapping(value = "/pregledRezervacija", method = RequestMethod.GET)
    public String pregledRezervacija(Model model, HttpSession session) {
        
        Korisnik k = (Korisnik) session.getAttribute("korisnik");
        
        if (!k.getKorTip().equals("admin")) {
            return "index";
        }

        List<Karta> karte = DB.query("SELECT k FROM Karta k");
        model.addAttribute("karte", karte);
        
        return "pregledRezervacija";
    }
    
}
