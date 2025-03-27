package com.si.responsableapi.controller;

import com.si.responsableapi.entity.Responsable;
import com.si.responsableapi.service.ResponsableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/responsables")
public class ResponsableController {

    private final ResponsableService responsableService;

    public ResponsableController(ResponsableService responsableService) {
        this.responsableService = responsableService;
    }

    // Ajouter un responsable
    @PostMapping
    public ResponseEntity<Responsable> createResponsable(@RequestBody Responsable responsable) {
        Responsable savedResponsable = responsableService.createResponsable(responsable);
        return ResponseEntity.ok(savedResponsable);
    }

    // Récupérer tous les responsables
    @GetMapping
    public ResponseEntity<List<Responsable>> getAllResponsables() {
        return ResponseEntity.ok(responsableService.getAllResponsables());
    }

    // Récupérer un responsable par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Responsable> getResponsableById(@PathVariable Long id) {
        Optional<Responsable> responsable = responsableService.getResponsableById(id);
        return responsable.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Modifier un responsable
    @PutMapping("/{id}")
    public ResponseEntity<Responsable> updateResponsable(@PathVariable Long id, @RequestBody Responsable responsable) {
        Responsable updatedResponsable = responsableService.updateResponsable(id, responsable);
        return ResponseEntity.ok(updatedResponsable);
    }

    // Supprimer un responsable
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResponsable(@PathVariable Long id) {
        responsableService.deleteResponsable(id);
        return ResponseEntity.noContent().build();
    }
}
