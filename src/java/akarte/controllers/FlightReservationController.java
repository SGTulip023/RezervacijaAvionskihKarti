package akarte.controllers;

import akarte.dao.AvioLet;
import akarte.dao.Karta;
import akarte.dao.Korisnik;
import akarte.dao.util.DB;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FlightReservationController {

    @RequestMapping("/avioLetovi")
    public String avioLetovi(ModelMap model) {

        List<AvioLet> lista = DB.query("SELECT a FROM AvioLet a");
        model.addAttribute("avioLetovi", lista);

        return "avioLetovi";
    }
    
    @RequestMapping("/potvrda")
    public String potvrda(@RequestParam Integer letId,
            @RequestParam Integer kolicina,
            HttpSession session) {
        
        List<AvioLet> letovi = DB.query("SELECT a FROM AvioLet a WHERE a.letId=?1", letId);
        System.out.println(letovi.get(0).toString() + " kolicina " + kolicina);
        
        Korisnik k = (Korisnik) session.getAttribute("korisnik");
        AvioLet avioLet = letovi.get(0);
        
        int ukupnoRezervisanih = avioLet.getLetKolicina() + kolicina;
        avioLet.setLetKolicina(ukupnoRezervisanih);
        DB.update(avioLet);
         
        Karta karta = new Karta(kolicina, avioLet, k);
        
        DB.insert(karta);
        
        return "potvrda";
    }

}
