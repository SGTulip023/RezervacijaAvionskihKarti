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
@Table(name = "destinacija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Destinacija.findAll", query = "SELECT d FROM Destinacija d")
    , @NamedQuery(name = "Destinacija.findByDestinacijaId", query = "SELECT d FROM Destinacija d WHERE d.destinacijaId = :destinacijaId")
    , @NamedQuery(name = "Destinacija.findByDestinacijaNaziv", query = "SELECT d FROM Destinacija d WHERE d.destinacijaNaziv = :destinacijaNaziv")})
public class Destinacija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "destinacija_id")
    private Integer destinacijaId;
    @Size(max = 45)
    @Column(name = "destinacija_naziv")
    private String destinacijaNaziv;
    @OneToMany(mappedBy = "destinacijaId")
    private List<AvioLet> avioLetList;

    public Destinacija() {
    }

    public Destinacija(Integer destinacijaId) {
        this.destinacijaId = destinacijaId;
    }

    public Destinacija(String destinacijaNaziv) {
        this.destinacijaNaziv = destinacijaNaziv;
    }
    
    

    public Integer getDestinacijaId() {
        return destinacijaId;
    }

    public void setDestinacijaId(Integer destinacijaId) {
        this.destinacijaId = destinacijaId;
    }

    public String getDestinacijaNaziv() {
        return destinacijaNaziv;
    }

    public void setDestinacijaNaziv(String destinacijaNaziv) {
        this.destinacijaNaziv = destinacijaNaziv;
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
        hash += (destinacijaId != null ? destinacijaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Destinacija)) {
            return false;
        }
        Destinacija other = (Destinacija) object;
        if ((this.destinacijaId == null && other.destinacijaId != null) || (this.destinacijaId != null && !this.destinacijaId.equals(other.destinacijaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "akarte.dao.Destinacija[ destinacijaId=" + destinacijaId + " ]";
    }
    
}
