package fr.afpa.orm.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.afpa.orm.dto.InsuranceDto;
import fr.afpa.orm.entities.Insurance;
import fr.afpa.orm.repositories.InsuranceRepository;

@RestController
@RequestMapping("/api/insurances")
public class InsuranceRestController {

    private final InsuranceRepository insuranceRepository;

    @Autowired
    public InsuranceRestController(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    // Récupérer toutes les assurances
    @GetMapping
    public List<InsuranceDto> getAll() {
        List<InsuranceDto> insuranceList = new ArrayList<>();
        for (Insurance insurance : insuranceRepository.findAll()) {
            insuranceList.add(this.convertToDto(insurance));
        }
        return insuranceList;
    }

    // Récupérer une assurance par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Insurance> getInsuranceById(@PathVariable Long id) {
        Insurance insurance = insuranceRepository.findById(id).orElse(null);

        if (insurance != null) {
            return new ResponseEntity<>(insurance, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Créer une nouvelle assurance
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InsuranceDto create(@RequestBody Insurance insurance) {
        Insurance savedInsurance = insuranceRepository.save(insurance);
        return convertToDto(savedInsurance);
    }

    // Mettre à jour une assurance existante
    @PutMapping("/{id}")
    public ResponseEntity<InsuranceDto> update(@PathVariable Long id, @RequestBody Insurance insurance) {
        if (!insuranceRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        insurance.setId(id);  // Associer l'ID existant à l'entité à mettre à jour
        Insurance updatedInsurance = insuranceRepository.save(insurance);
        return ResponseEntity.ok(convertToDto(updatedInsurance));
    }

    // Supprimer une assurance par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        if (!insuranceRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        insuranceRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Méthode utilitaire pour convertir une entité Insurance en InsuranceDto
    private InsuranceDto convertToDto(Insurance insurance) {
        return new InsuranceDto(insurance);
    }
}
