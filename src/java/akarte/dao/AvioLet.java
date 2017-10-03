/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akarte.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sgtulip
 */
@Entity
@Table(name = "avio_let")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AvioLet.findAll", query = "SELECT a FROM AvioLet a")
    , @NamedQuery(name = "AvioLet.findByLetId", query = "SELECT a FROM AvioLet a WHERE a.letId = :letId")
    , @NamedQuery(name = "AvioLet.findByLetDatum", query = "SELECT a FROM AvioLet a WHERE a.letDatum = :letDatum")
    , @NamedQuery(name = "AvioLet.findByLetCena", query = "SELECT a FROM AvioLet a WHERE a.letCena = :letCena")
    , @NamedQuery(name = "AvioLet.findByLetKolicina", query = "SELECT a FROM AvioLet a WHERE a.letKolicina = :letKolicina")
    , @NamedQuery(name = "AvioLet.findByLetKapacitet", query = "SELECT a FROM AvioLet a WHERE a.letKapacitet = :letKapacitet")})
public class AvioLet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "let_id")
    private Integer letId;
    @Column(name = "let_datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date letDatum;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "let_cena")
    private Double letCena;
    @Column(name = "let_kolicina")
    private Integer letKolicina;
    @Column(name = "let_kapacitet")
    private Integer letKapacitet;
    @JoinColumn(name = "kompanija_id", referencedColumnName = "kompanija_id")
    @ManyToOne
    private AvioKompanija kompanijaId;
    @JoinColumn(name = "destinacija_id", referencedColumnName = "destinacija_id")
    @ManyToOne
    private Destinacija destinacijaId;
    @OneToMany(mappedBy = "letId")
    private List<Karta> kartaList;

    public AvioLet() {
    }

    public AvioLet(Integer letId) {
        this.letId = letId;
    }

    public AvioLet(Date letDatum, Double letCena, Integer letKolicina, Integer letKapacitet, AvioKompanija kompanijaId, Destinacija destinacijaId) {
        this.letDatum = letDatum;
        this.letCena = letCena;
        this.letKolicina = letKolicina;
        this.letKapacitet = letKapacitet;
        this.kompanijaId = kompanijaId;
        this.destinacijaId = destinacijaId;
    }
    
    

    public Integer getLetId() {
        return letId;
    }

    public void setLetId(Integer letId) {
        this.letId = letId;
    }

    public Date getLetDatum() {
        return letDatum;
    }

    public void setLetDatum(Date letDatum) {
        this.letDatum = letDatum;
    }

    public Double getLetCena() {
        return letCena;
    }

    public void setLetCena(Double letCena) {
        this.letCena = letCena;
    }

    public Integer getLetKolicina() {
        return letKolicina;
    }

    public void setLetKolicina(Integer letKolicina) {
        this.letKolicina = letKolicina;
    }

    public Integer getLetKapacitet() {
        return letKapacitet;
    }

    public void setLetKapacitet(Integer letKapacitet) {
        this.letKapacitet = letKapacitet;
    }

    public AvioKompanija getKompanijaId() {
        return kompanijaId;
    }

    public void setKompanijaId(AvioKompanija kompanijaId) {
        this.kompanijaId = kompanijaId;
    }

    public Destinacija getDestinacijaId() {
        return destinacijaId;
    }

    public void setDestinacijaId(Destinacija destinacijaId) {
        this.destinacijaId = destinacijaId;
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
        hash += (letId != null ? letId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvioLet)) {
            return false;
        }
        AvioLet other = (AvioLet) object;
        if ((this.letId == null && other.letId != null) || (this.letId != null && !this.letId.equals(other.letId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AvioLet{" + "letDatum=" + letDatum + ", letCena=" + letCena + ", letKolicina=" + letKolicina + ", letKapacitet=" + letKapacitet + ", kompanijaId=" + kompanijaId + ", destinacijaId=" + destinacijaId + '}';
    }

    
    
}
