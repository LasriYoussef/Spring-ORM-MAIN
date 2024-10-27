package fr.afpa.orm.dto;

import fr.afpa.orm.entities.Insurance;

public class InsuranceDto {

    private Long id;
    private String name;

    // Déclaration d'un constructeur vide possible
    // mais pas trop nécessaire
    // public InsuranceDto() {}
    
    // Constructeur par défaut (nécessaire pour le bon fonctionnement des frameworks)
    public InsuranceDto(Insurance insurance) {
        // Initialisation des attributs à partir d'un objet de la classe "Insurance"
        // permet de transformer un objet de la classe "Insurance" en un "InsuranceDto"
        // ici, l'objet de la classe "InsuranceDto" nouvellement créé est "this"
        // dans un CONSTRUCTEUR "this" fait référence au nouvel objet créé
        this.id = insurance.getId();
        this.name = insurance.getName();
    }

    // Constructeur avec paramètres
    public InsuranceDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Optionnel : méthode toString() pour le débogage
    @Override
    public String toString() {
        return "InsuranceDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
