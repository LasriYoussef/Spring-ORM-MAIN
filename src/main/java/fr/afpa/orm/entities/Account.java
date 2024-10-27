package fr.afpa.orm.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creation_time", nullable = false)
    private LocalDateTime creationTime;

    @Column(nullable = false)
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    // Constructeur vide obligatoire pour JPA
    public Account() {
    }

    // Constructeur avec paramètres
    public Account(LocalDateTime creationTime, BigDecimal balance) {
        this.creationTime = creationTime;
        this.balance = balance;
        
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    
        public Client getClient() {
            return client;
        }
    
        public void setClient(Client client) {
            this.client = client;
        }

    @Override
    public String toString() {
        return "Account{" +
               "id=" + id +
               ", creationTime=" + creationTime +
               ", balance=" + balance +
               ", clientId=" + (client != null ? client.getId() : null) +
               '}';
    }

}