package akarte.controllers;

import akarte.dao.Korisnik;
import akarte.dao.util.DB;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    
    @RequestMapping(value = "/registracija", method = RequestMethod.GET)
    public String reg(Model model) {
        
        model.addAttribute("korIme", "");
        model.addAttribute("korPrezime", "");
        model.addAttribute("korEmail", "");
        model.addAttribute("korPassword", "");
        
        return "registracija";
    }
    
    @RequestMapping(value = "/registracija", method = RequestMethod.POST)
    public String registracija(@RequestParam String korIme, 
            @RequestParam String korPrezime,
            @RequestParam String korEmail,
            @RequestParam String korPassword, Model model) {
        
        if (korIme.isEmpty() || korPrezime.isEmpty() || korEmail.isEmpty() || korPassword.isEmpty()) {
            
            model.addAttribute("greska", "Sva polja moraju biti popunjena!");
            
            return "registracija";       
        }
        
        // provera korisnika da li vec postoji sa tom email adresom u bazi
        List<Korisnik> korisnici = DB.query("SELECT k FROM Korisnik k WHERE k.korEmail=?1", korEmail);
        
        if (!korisnici.isEmpty()) {
            model.addAttribute("greska", "Korisnik sa tom email adresom vec postoji registrovan!");
            
            return "registracija";
        }
        
        // najlakse mi je ovako da postavim korTip
        String korTip = "korisn";
        
        Korisnik k = new Korisnik(korIme, korPrezime, korEmail, korPassword, korTip);
        DB.insert(k);
        
        return "uregistracija"; 
    }
    
    
    // logovanje
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model) {
        
        model.addAttribute("email", "");
        model.addAttribute("pass", "");
        
        return "login";
    }
    
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String sLogin(@RequestParam String email,
            @RequestParam String pass, HttpSession session, Model model) {
        
        if (email.isEmpty() || pass.isEmpty()) {
            
            model.addAttribute("logGreska", "Polja ne mogu biti prazna!");
            
            return "login";
        }
        
        List<Korisnik> korisnici = DB.query("SELECT k FROM Korisnik k WHERE k.korEmail=?1 AND k.korPassword=?2", email, pass);
        
        // samo provera, volim sout XD
        for (Korisnik k : korisnici) {
            System.out.println(k);
        }
        
        if (korisnici.isEmpty() || !korisnici.get(0).getKorPassword().equals(pass)) {
            
            model.addAttribute("logGreska", "Greska! Proverite email ili password!");
            
            return "login";
        }
        
        session.setAttribute("korisnik", korisnici.get(0));
        
        return "ulogovanje";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        
        session.invalidate();
        
        return "index";
    }
    
    @RequestMapping(value = "/izmenaKorisnika", method = RequestMethod.POST)
    public String izmenaKorisnika(@RequestParam Integer korId, 
            @RequestParam String korTip, 
            Model model) {
        
        List<Korisnik> korisnici = DB.query("SELECT k FROM Korisnik k WHERE k.korId=?1", korId);
        
        Korisnik korisnik = korisnici.get(0);
        korisnik.setKorTip(korTip);
        
        DB.update(korisnik);
        
        model.addAttribute("izmenaK", "Uspesno izmenjen korisnik");
        
        return "izmenaKorisnika";
    }
}
