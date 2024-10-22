package fr.afpa.orm.repositories;

import org.springframework.stereotype.Repository;

import fr.afpa.orm.entities.Client;

/**
 * TODO implémenter un "repository" (similaire à un DAO) permettant d'interagir avec les données de la BDD
 * Tutoriel -> https://www.geeksforgeeks.org/spring-boot-crudrepository-with-example/
 */
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
 
// Annotation
@Repository
public interface ClientRepository extends CrudRepository<Client, UUID> {

}