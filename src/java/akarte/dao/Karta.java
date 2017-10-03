/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akarte.dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sgtulip
 */
@Entity
@Table(name = "karta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Karta.findAll", query = "SELECT k FROM Karta k")
    , @NamedQuery(name = "Karta.findByKarId", query = "SELECT k FROM Karta k WHERE k.karId = :karId")
    , @NamedQuery(name = "Karta.findByKarKolicina", query = "SELECT k FROM Karta k WHERE k.karKolicina = :karKolicina")})
public class Karta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kar_id")
    private Integer karId;
    @Column(name = "kar_kolicina")
    private Integer karKolicina;
    @JoinColumn(name = "let_id", referencedColumnName = "let_id")
    @ManyToOne
    private AvioLet letId;
    @JoinColumn(name = "kor_id", referencedColumnName = "kor_id")
    @ManyToOne
    private Korisnik korId;

    public Karta() {
    }

    public Karta(Integer karId) {
        this.karId = karId;
    }

    public Karta(Integer karKolicina, AvioLet letId, Korisnik korId) {
        this.karKolicina = karKolicina;
        this.letId = letId;
        this.korId = korId;
    }
    
    

    public Integer getKarId() {
        return karId;
    }

    public void setKarId(Integer karId) {
        this.karId = karId;
    }

    public Integer getKarKolicina() {
        return karKolicina;
    }

    public void setKarKolicina(Integer karKolicina) {
        this.karKolicina = karKolicina;
    }

    public AvioLet getLetId() {
        return letId;
    }

    public void setLetId(AvioLet letId) {
        this.letId = letId;
    }

    public Korisnik getKorId() {
        return korId;
    }

    public void setKorId(Korisnik korId) {
        this.korId = korId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (karId != null ? karId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Karta)) {
            return false;
        }
        Karta other = (Karta) object;
        if ((this.karId == null && other.karId != null) || (this.karId != null && !this.karId.equals(other.karId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "akarte.dao.Karta[ karId=" + karId + " ]";
    }
    
}
