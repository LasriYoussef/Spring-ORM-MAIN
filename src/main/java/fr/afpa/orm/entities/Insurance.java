package fr.afpa.orm.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "insurance")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "type", nullable = false)
    private String type;  // Par exemple: "vie", "habitation", "automobile"

    @Column(name = "monthly_premium", nullable = false)
    private BigDecimal monthlyPremium;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "coverage_amount", nullable = false)
    private BigDecimal coverageAmount;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;  // Compte utilisé pour les prélèvements

    // Constructeur par défaut
    public Insurance() {
    }

    // Constructeur avec paramètres
    public Insurance(String type, BigDecimal monthlyPremium, LocalDate startDate, 
                    BigDecimal coverageAmount, Client client) {
        this.type = type;
        this.monthlyPremium = monthlyPremium;
        this.startDate = startDate;
        this.coverageAmount = coverageAmount;
        this.client = client;
    }

    // Getters et Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getMonthlyPremium() {
        return monthlyPremium;
    }

    public void setMonthlyPremium(BigDecimal monthlyPremium) {
        this.monthlyPremium = monthlyPremium;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(BigDecimal coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Insurance{" +
               "id=" + id +
               ", type='" + type + '\'' +
               ", monthlyPremium=" + monthlyPremium +
               ", startDate=" + startDate +
               ", endDate=" + endDate +
               ", coverageAmount=" + coverageAmount +
               ", clientId=" + (client != null ? client.getId() : null) +
               ", accountId=" + (account != null ? account.getId() : null) +
               '}';
    }
}