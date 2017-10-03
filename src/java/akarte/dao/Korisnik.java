
package akarte.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "korisnik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Korisnik.findAll", query = "SELECT k FROM Korisnik k")
    , @NamedQuery(name = "Korisnik.findByKorId", query = "SELECT k FROM Korisnik k WHERE k.korId = :korId")
    , @NamedQuery(name = "Korisnik.findByKorIme", query = "SELECT k FROM Korisnik k WHERE k.korIme = :korIme")
    , @NamedQuery(name = "Korisnik.findByKorPrezime", query = "SELECT k FROM Korisnik k WHERE k.korPrezime = :korPrezime")
    , @NamedQuery(name = "Korisnik.findByKorEmail", query = "SELECT k FROM Korisnik k WHERE k.korEmail = :korEmail")
    , @NamedQuery(name = "Korisnik.findByKorPassword", query = "SELECT k FROM Korisnik k WHERE k.korPassword = :korPassword")
    , @NamedQuery(name = "Korisnik.findByKorTip", query = "SELECT k FROM Korisnik k WHERE k.korTip = :korTip")})
public class Korisnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kor_id")
    private Integer korId;
    @Size(max = 50)
    @Column(name = "kor_ime")
    private String korIme;
    @Size(max = 50)
    @Column(name = "kor_prezime")
    private String korPrezime;
    @Size(max = 50)
    @Column(name = "kor_email")
    private String korEmail;
    @Size(max = 50)
    @Column(name = "kor_password")
    private String korPassword;
    @Size(max = 50)
    @Column(name = "kor_tip")
    private String korTip;
    @OneToMany(mappedBy = "korId")
    private List<Karta> kartaList;

    public Korisnik() {
    }

    public Korisnik(Integer korId) {
        this.korId = korId;
    }

    public Korisnik(String korIme, String korPrezime, String korEmail, String korPassword, String korTip) {
        this.korIme = korIme;
        this.korPrezime = korPrezime;
        this.korEmail = korEmail;
        this.korPassword = korPassword;
        this.korTip = korTip;
    }   

    public Integer getKorId() {
        return korId;
    }

    public void setKorId(Integer korId) {
        this.korId = korId;
    }

    public String getKorIme() {
        return korIme;
    }

    public void setKorIme(String korIme) {
        this.korIme = korIme;
    }

    public String getKorPrezime() {
        return korPrezime;
    }

    public void setKorPrezime(String korPrezime) {
        this.korPrezime = korPrezime;
    }

    public String getKorEmail() {
        return korEmail;
    }

    public void setKorEmail(String korEmail) {
        this.korEmail = korEmail;
    }

    public String getKorPassword() {
        return korPassword;
    }

    public void setKorPassword(String korPassword) {
        this.korPassword = korPassword;
    }

    public String getKorTip() {
        return korTip;
    }

    public void setKorTip(String korTip) {
        this.korTip = korTip;
    }

    @XmlTransient
    public List<Karta> getKartaList() {
        return kartaList;
    }

    public void setKartaList(List<Karta> kartaList) {
        this.kartaList = kartaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (korId != null ? korId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.korId == null && other.korId != null) || (this.korId != null && !this.korId.equals(other.korId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Korisnik{" + "korId=" + korId + ", korIme=" 
                + korIme + ", korPrezime=" + korPrezime + ", korEmail="
                + korEmail + ", korPassword=" + korPassword + ", korTip=" 
                + korTip + ", kartaList=" + kartaList + '}';
    }

    
    
}
