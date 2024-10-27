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