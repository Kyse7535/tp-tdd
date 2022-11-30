package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.exception.ResourceNotFoundException;
import fr.esgi.cleancode.model.DrivingLicence;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class DrivingLicencePointsService {
    private final InMemoryDatabase database;

    public void retirer(UUID id, int nbr_points) {
        Optional<DrivingLicence> drivingLicence = database.findById(id);
        if(drivingLicence.isEmpty()) {
            throw new ResourceNotFoundException("permis non trouvé");
        }

    }
}
