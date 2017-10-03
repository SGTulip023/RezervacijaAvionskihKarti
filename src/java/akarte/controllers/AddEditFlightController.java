package akarte.controllers;

import akarte.dao.AvioKompanija;
import akarte.dao.AvioLet;
import akarte.dao.Destinacija;
import akarte.dao.Karta;
import akarte.dao.Korisnik;
import akarte.dao.util.DB;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddEditFlightController {

    @RequestMapping(value = "/dodajLet", method = RequestMethod.GET)
    public String let(HttpSession session) {

        Korisnik k = (Korisnik) session.getAttribute("korisnik");

        if (!k.getKorTip().equals("admin")) {
            return "index";
        }

        return "dodajLet";
    }
    
    //@RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date letDatum,
    @RequestMapping(value = "/dodajLet", method = RequestMethod.POST)
    public String dodajLet(@RequestParam String kompanijaNaziv,
            @RequestParam String destinacijaNaziv,
            
            @RequestParam Double letCena,
            @RequestParam Integer letKapacitet,
            Model model) throws ParseException {

        if (kompanijaNaziv.isEmpty() || destinacijaNaziv.isEmpty()) {
            model.addAttribute("dodavanjeGreska", "Sva polja moraju biti popunjena!");

            return "dodajLet";
        }
        
        Integer letKolicina = 0;
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //LocalDate date = LocalDate.parse(letDatum, formatter);
       /* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = sdf.parse(letDatum);
        System.out.println(letDatum);
        System.out.println(date);*/

        AvioKompanija ak = new AvioKompanija(kompanijaNaziv);
        DB.insert(ak);

        Destinacija d = new Destinacija(destinacijaNaziv);
        DB.insert(d);
        
        Date letDatum = new Date();
        AvioLet al = new AvioLet(letDatum, letCena, letKolicina, letKapacitet, ak, d);
        DB.insert(al);

        model.addAttribute("uspesnoDodavanje", "Uspesno dodavanje novog leta!");

        return "dodajLet";
    }
    
// @RequestParam String letDatum,
    //The request sent by the client was syntactically incorrect
    @RequestMapping(value = "/izmenaLeta", method = RequestMethod.POST)
    public String izmenaLeta(@RequestParam Integer kompanijaId,
            @RequestParam String kompanijaNaziv,
            @RequestParam Integer destinacijaId,
            @RequestParam String destinacijaNaziv,
            @RequestParam Integer letId,
            
            @RequestParam Double letCena,
            @RequestParam Integer letKolicina,
            @RequestParam Integer letKapacitet,
            Model model) throws ParseException {

        List<AvioKompanija> aks = DB.query("SELECT a FROM AvioKompanija a WHERE a.kompanijaId=?1", kompanijaId);
        AvioKompanija ak = aks.get(0);
        ak.setKompanijaNaziv(kompanijaNaziv);
        DB.update(ak);

        List<Destinacija> ds = DB.query("SELECT d FROM Destinacija d WHERE d.destinacijaId=?1", destinacijaId);
        Destinacija d = ds.get(0);
        d.setDestinacijaNaziv(destinacijaNaziv);
        DB.update(d);
        /*
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = sdf.parse(letDatum);
        System.out.println(letDatum);
        System.out.println(date);*/

        Date date = new Date();

        List<AvioLet> als = DB.query("SELECT a FROM AvioLet a WHERE a.letId=?1", letId);
        AvioLet al = als.get(0);
        al.setLetDatum(date);
        al.setLetCena(letCena);
        al.setLetKolicina(letKolicina);
        al.setLetKapacitet(letKapacitet);
        DB.update(al);

        model.addAttribute("uspesnaIzmenaLeta", "Izmena je uspesno izvrsena!");

        return "izmenaLeta";
    }
    
    @RequestMapping(value = "/brisanjeLeta", method = RequestMethod.POST)
    public String brisanjeLeta(@RequestParam Integer letId, Model model) {
        
        List<AvioLet> als = DB.query("SELECT a FROM AvioLet a WHERE a.letId=?1", letId);
        AvioLet al = als.get(0);
        
        List<Karta> karte = DB.query("SELECT k FROM Karta k WHERE k.letId=?1", al);
        
        if (!karte.isEmpty()) {
            model.addAttribute("postojiRezervacija", "Nije moguce brisanje leta, postoje vec rezervacije!");
            
            return "izmenaLeta";
        }
        
        DB.delete(al);
        
        model.addAttribute("brisanje", "Let je uspesno obrisan");
        
        return "izmenaLeta";
    }
/* 
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
*/
    
    
}
