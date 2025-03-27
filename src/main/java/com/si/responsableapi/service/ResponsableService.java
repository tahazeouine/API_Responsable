package com.si.responsableapi.service;

import com.si.responsableapi.entity.Responsable;
import com.si.responsableapi.repository.ResponsableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsableService {

    private final ResponsableRepository responsableRepository;

    @Autowired
    public ResponsableService(ResponsableRepository responsableRepository) {
        this.responsableRepository = responsableRepository; // Correction ici
    }

    /**
     * Ajouter un responsable.
     *
     * @param responsable Le responsable à créer.
     * @return Le responsable créé.
     * @throws RuntimeException Si l'email est déjà utilisé.
     */
    public Responsable createResponsable(Responsable responsable) {
        // Vérifier si l'email est déjà utilisé
        if (responsableRepository.existsByEmail(responsable.getEmail())) {
            throw new RuntimeException("Email déjà utilisé !");
        }
        // Sauvegarder le responsable
        return responsableRepository.save(responsable);
    }

    /**
     * Obtenir tous les responsables.
     *
     * @return Une liste de tous les responsables.
     */
    public List<Responsable> getAllResponsables() {
        return responsableRepository.findAll();
    }

    /**
     * Obtenir un responsable par son ID.
     *
     * @param id L'ID du responsable à rechercher.
     * @return Le responsable correspondant à l'ID.
     * @throws RuntimeException Si le responsable n'est pas trouvé.
     */
    public Optional<Responsable> getResponsableById(Long id) {
        return responsableRepository.findById(id);
    }

    /**
     * Mettre à jour un responsable.
     *
     * @param id L'ID du responsable à mettre à jour.
     * @param updatedResponsable Les nouvelles informations du responsable.
     * @return Le responsable mis à jour.
     * @throws RuntimeException Si le responsable n'est pas trouvé.
     */
    public Responsable updateResponsable(Long id, Responsable updatedResponsable) {
        return responsableRepository.findById(id).map(responsable -> {
            // Mettre à jour le nom et l'email
            responsable.setNom(updatedResponsable.getNom());
            responsable.setEmail(updatedResponsable.getEmail());
            // Sauvegarder les modifications
            return responsableRepository.save(responsable);
        }).orElseThrow(() -> new RuntimeException("Responsable non trouvé !"));
    }

    /**
     * Supprimer un responsable.
     *
     * @param id L'ID du responsable à supprimer.
     * @throws RuntimeException Si le responsable n'est pas trouvé.
     */
    public void deleteResponsable(Long id) {
        // Vérifier si le responsable existe
        if (!responsableRepository.existsById(id)) {
            throw new RuntimeException("Responsable non trouvé !");
        }
        // Supprimer le responsable
        responsableRepository.deleteById(id);
    }
}