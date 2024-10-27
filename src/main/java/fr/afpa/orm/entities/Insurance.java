package fr.afpa.orm.entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "insurance")
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnoreProperties({"accounts", "insurances"})
    @ManyToMany(targetEntity = Client.class)
    @JoinTable(name = "client_insurance",
            joinColumns = @JoinColumn(name = "insurance_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List<Client> clients;  // Utiliser une liste car ManyToMany

    // Constructeur par défaut
    public Insurance() {
    }

    // Constructeur avec paramètres
    public Insurance(List<Client> clients) {  // Liste de clients
        this.clients = clients;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Insurance [id=" + id + ", name=" + name + ", clients=" + clients + "]";
    }

    
    

}
