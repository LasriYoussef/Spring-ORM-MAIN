package fr.afpa.orm.dto;

import java.util.UUID;

import fr.afpa.orm.entities.Client;

/**
 * DTO pour Client
 * Simplifie l'exposition des données d'un client dans le cadre d'un DTO pour Account.
 */
public class ClientDto {

    private UUID clientId;
    private String firstName;
    private String lastName;


    // Constructeur à partir de l'entité Client
    public ClientDto(Client client) {
        this.clientId = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
    }

    // Getters et Setters
    public UUID getClientId() {
        return clientId;
    }
    
    public void setClientId(UUID clientId) {
        this.clientId = clientId;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ClientDto{");
        sb.append("clientId=").append(clientId);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append('}');
        return sb.toString();
    }

    
}
