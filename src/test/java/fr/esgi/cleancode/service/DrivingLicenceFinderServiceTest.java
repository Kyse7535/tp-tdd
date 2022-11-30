package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.model.DrivingLicence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class DrivingLicenceFinderServiceTest {

    @InjectMocks
    private DrivingLicenceFinderService service;

    @Mock
    private InMemoryDatabase database;

    @Test
    void should_find() {
        //BEFORE
        DrivingLicence drivingLicence = DrivingLicence.builder().driverSocialSecurityNumber("111111111111111").build();
        UUID id = drivingLicence.getId();
        database.save(drivingLicence.getId(),drivingLicence);

        // EXECUTE
        Optional<DrivingLicence> opt = service.findById(drivingLicence.getId());

        // ASSERT
        Assertions.assertEquals(opt.get(),drivingLicence);
    }

    @Test
    void should_not_find() {
        // BEFORE
        DrivingLicence drivingLicence = DrivingLicence.builder().driverSocialSecurityNumber("111111111111111").build();
        UUID id = drivingLicence.getId();

        // EXECUTE
        Optional<DrivingLicence> opt = service.findById(id);

        // ASSERT
        Assertions.assertNotEquals(opt.get(),drivingLicence);
    }
}