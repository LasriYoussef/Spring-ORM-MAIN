// package fr.afpa.orm.entities;

// import java.util.ArrayList;
// import java.util.List;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToMany;

// @Entity
// public class Insurance {
    
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;

//     @ManyToMany(mappedBy = "insurances")
//     private List<Client> clients = new ArrayList<>();

//     public Long getId() {
//         return id;
//     }

//     public String getName() {
//         return name;
//     }

//     public List<Client> getClients() {
//         return clients;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public void setClients(List<Client> clients) {
//         this.clients = clients;
//     }

   
// }
