package fr.afpa.orm.repositories;

import fr.afpa.orm.entities.Account;

/**
 * TODO implémenter un "repository" (similaire à un DAO) permettant d'interagir avec les données de la BDD
 * Tutoriel -> https://www.geeksforgeeks.org/spring-boot-crudrepository-with-example/
 */
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
// Annotation
@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

}



















// @Repository
// public interface AccountRepository extends JpaRepository<Account, Long> {
    
    // Méthode pour trouver tous les comptes d'un client spécifique
    // List<Account> findByClientId(UUID clientId);
    
    // Méthode pour trouver les comptes avec un solde supérieur à une valeur donnée
    // List<Account> findByBalanceGreaterThan(BigDecimal balance);
    
    // Méthode pour compter le nombre de comptes d'un client
    // long countByClientId(UUID clientId);
// }
