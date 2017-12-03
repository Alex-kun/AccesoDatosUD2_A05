/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alejandroquiros
 */
@Entity
@Table(name = "playerposition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Playerposition.findAll", query = "SELECT p FROM Playerposition p")
    , @NamedQuery(name = "Playerposition.findById", query = "SELECT p FROM Playerposition p WHERE p.id = :id")
    , @NamedQuery(name = "Playerposition.findByNum", query = "SELECT p FROM Playerposition p WHERE p.num = :num")})
public class Playerposition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM")
    private int num;
    @JoinColumn(name = "player", referencedColumnName = "playerId")
    @ManyToOne(optional = false)
    private Player player;
    @JoinColumn(name = "position", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Position position;

    public Playerposition() {
    }

    public Playerposition(Integer id) {
        this.id = id;
    }

    public Playerposition(Integer id, int num) {
        this.id = id;
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Playerposition)) {
            return false;
        }
        Playerposition other = (Playerposition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Playerposition[ id=" + id + " ]";
    }
    
}
