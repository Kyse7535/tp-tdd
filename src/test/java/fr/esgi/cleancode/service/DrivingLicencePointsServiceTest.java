package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DrivingLicencePointsServiceTest {

    @InjectMocks
    private DrivingLicencePointsService service;
    @InjectMocks
    private DrivingLicenceFinderService finderService;

    @Mock
    private InMemoryDatabase database;

    @Test
    public void retirerPoints_for_not_found_drivingLicence() {

        UUID id = UUID.randomUUID();
        int nbr_points = 0;
        when(database.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(ResourceNotFoundException.class,() -> service.retirer(id,nbr_points));
    }


}
