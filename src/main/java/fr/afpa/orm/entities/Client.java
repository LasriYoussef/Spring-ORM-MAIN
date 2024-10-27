package fr.afpa.orm.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthdate;

    // Relation OneToMany avec Account (le côté possédant est Account)
    @OneToMany(mappedBy = "client")  // Le champ owner dans Account fait référence à Client
    private List<Account> accounts;

    // Relation ManyToMany avec Insurance
    @JsonIgnoreProperties({"clients"})
    @ManyToMany(targetEntity = Insurance.class)
    @JoinTable(name = "client_insurance",
     joinColumns = @JoinColumn(name = "client_id"),
     inverseJoinColumns = @JoinColumn(name = "insurance_id"))  // Correction ici pour insurance_id
    private List<Insurance> insurances;

    // Constructeur par défaut (nécessaire pour les ORM comme Hibernate)
    public Client() {
    }

    // Getters et Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }

    // Méthode toString pour faciliter le débogage
    @Override
    public String toString() {
        return "Client{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", email='" + email + '\'' +
               ", birthdate=" + birthdate +
               ", accounts=" + (accounts != null ? accounts.size() : null) +
               ", insurances=" + (insurances != null ? insurances.size() : null) +
               '}';
    }
}
