/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alejandroquiros
 */
@Entity
@Table(name = "player")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p")
    , @NamedQuery(name = "Player.findByPlayerId", query = "SELECT p FROM Player p WHERE p.playerId = :playerId")
    , @NamedQuery(name = "Player.findByPlayerName", query = "SELECT p FROM Player p WHERE p.playerName = :playerName")
    , @NamedQuery(name = "Player.findByPlayerNumber", query = "SELECT p FROM Player p WHERE p.playerNumber = :playerNumber")})
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "playerId")
    private Integer playerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "playerName")
    private String playerName;
    @Column(name = "playerNumber")
    private Integer playerNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "player")
    private Collection<Playerposition> playerpositionCollection;
    @JoinColumn(name = "idTeamFK", referencedColumnName = "idTeam")
    @ManyToOne(optional = false)
    private Team idTeamFK;

    public Player() {
    }

    public Player(Integer playerId) {
        this.playerId = playerId;
    }

    public Player(Integer playerId, String playerName) {
        this.playerId = playerId;
        this.playerName = playerName;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(Integer playerNumber) {
        this.playerNumber = playerNumber;
    }

    @XmlTransient
    public Collection<Playerposition> getPlayerpositionCollection() {
        return playerpositionCollection;
    }

    public void setPlayerpositionCollection(Collection<Playerposition> playerpositionCollection) {
        this.playerpositionCollection = playerpositionCollection;
    }

    public Team getIdTeamFK() {
        return idTeamFK;
    }

    public void setIdTeamFK(Team idTeamFK) {
        this.idTeamFK = idTeamFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (playerId != null ? playerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Player)) {
            return false;
        }
        Player other = (Player) object;
        if ((this.playerId == null && other.playerId != null) || (this.playerId != null && !this.playerId.equals(other.playerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Player[ playerId=" + playerId + " ]";
    }
    
}
