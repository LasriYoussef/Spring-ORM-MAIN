package fr.afpa.orm.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * TODO : implémenter un DTO (uniquement à partir de l'implémentation de la
 * relation "OneToMany")
 *
 * Attention : il faudra peut être 1 DTO par classe métier ?
 *
 * Plus d'informations sur la pattern DTO :
 * https://medium.com/@zubeyrdamar/java-spring-boot-handling-infinite-recursion-a95fe5a53c92
 */
public class AccountDto {

    private Long accountId;
    private BigDecimal balance;
    private LocalDateTime creationDate;
    private UUID clientId;

    // Constructeur vide (nécessaire pour certaines opérations comme la sérialisation)
    public AccountDto() {
    }

    // Constructeur prenant une liste de clientIds
    public AccountDto(Long accountId, BigDecimal balance, LocalDateTime creationDate, UUID clientId) {
        this.accountId = accountId;
        this.balance = balance;
        this.creationDate = creationDate;
        this.clientId = clientId;
    }

    // Getters et Setters
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public UUID getclientId() {
        return clientId;
    }

    public void setclientId(UUID clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "AccountDto [accountId=" + accountId + ", balance=" + balance + ", creationDate=" + creationDate + "]";
    }
}
