/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author sgtulip
 */
@Entity
@Table(name = "avio_kompanija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AvioKompanija.findAll", query = "SELECT a FROM AvioKompanija a")
    , @NamedQuery(name = "AvioKompanija.findByKompanijaId", query = "SELECT a FROM AvioKompanija a WHERE a.kompanijaId = :kompanijaId")
    , @NamedQuery(name = "AvioKompanija.findByKompanijaNaziv", query = "SELECT a FROM AvioKompanija a WHERE a.kompanijaNaziv = :kompanijaNaziv")})
public class AvioKompanija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kompanija_id")
    private Integer kompanijaId;
    @Size(max = 45)
    @Column(name = "kompanija_naziv")
    private String kompanijaNaziv;
    @OneToMany(mappedBy = "kompanijaId")
    private List<AvioLet> avioLetList;

    public AvioKompanija() {
    }

    public AvioKompanija(Integer kompanijaId) {
        this.kompanijaId = kompanijaId;
    }

    public AvioKompanija(String kompanijaNaziv) {
        this.kompanijaNaziv = kompanijaNaziv;
    }
    
    

    public Integer getKompanijaId() {
        return kompanijaId;
    }

    public void setKompanijaId(Integer kompanijaId) {
        this.kompanijaId = kompanijaId;
    }

    public String getKompanijaNaziv() {
        return kompanijaNaziv;
    }

    public void setKompanijaNaziv(String kompanijaNaziv) {
        this.kompanijaNaziv = kompanijaNaziv;
    }

    @XmlTransient
    public List<AvioLet> getAvioLetList() {
        return avioLetList;
    }

    public void setAvioLetList(List<AvioLet> avioLetList) {
        this.avioLetList = avioLetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kompanijaId != null ? kompanijaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvioKompanija)) {
            return false;
        }
        AvioKompanija other = (AvioKompanija) object;
        if ((this.kompanijaId == null && other.kompanijaId != null) || (this.kompanijaId != null && !this.kompanijaId.equals(other.kompanijaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "akarte.dao.AvioKompanija[ kompanijaId=" + kompanijaId + " ]";
    }
    
}
