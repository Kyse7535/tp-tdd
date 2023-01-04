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

    public DrivingLicence retirer(UUID id, int nbr_points) {
        Optional<DrivingLicence> drivingLicence = database.findById(id);
        if(drivingLicence.isEmpty()) {
            throw new ResourceNotFoundException("permis non trouvé");
        }
        DrivingLicence new_licence = drivingLicence.get().withAvailablePoints(drivingLicence.get().getAvailablePoints()-nbr_points);
        if (new_licence.getAvailablePoints() < 0) {
            DrivingLicence new_licence2 = new_licence.withAvailablePoints(0);
            database.save(new_licence2.getId(),new_licence2);
            return new_licence2;
        }
        else {
            database.save(new_licence.getId(),new_licence);
            return new_licence;
        }
    }
}
