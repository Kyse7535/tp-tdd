package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.exception.InvalidDriverSocialSecurityNumberException;
import fr.esgi.cleancode.model.DrivingLicence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DrivingLicenceCreationServiceTest {

    @InjectMocks
    private DrivingLicenceCreationService service;

    @Mock
    private InMemoryDatabase database;

    @Test
    public void should_have_valid_social_number() {
        String social_securiy_number = "123456789101111";
        Assertions.assertTrue(() -> service.check_ss(social_securiy_number));
    }

    @Test
    public void create() {
        String social_securiy_number = "123456789101112";
        DrivingLicence drivingLicence = service.create(social_securiy_number);

        Assertions.assertEquals(drivingLicence.getAvailablePoints(), 12);
        Assertions.assertEquals(drivingLicence.getDriverSocialSecurityNumber(), "123456789101112");

    }

    @Test
    public void should_not_be_null() {
        String social_securiy_number = "";
        Assertions.assertThrows(InvalidDriverSocialSecurityNumberException.class,() -> service.check_ss(social_securiy_number));
    }

    @Test
    public void should_contain_only_digits() {
        String social_securiy_number = "aaaaaaaaaaaaaaa";
        Assertions.assertThrows(InvalidDriverSocialSecurityNumberException.class,() -> service.check_ss(social_securiy_number));
    }

    @Test
    public void should_have_15_digits() {
        String social_securiy_number = "11111";
        Assertions.assertThrows(InvalidDriverSocialSecurityNumberException.class,() -> service.check_ss(social_securiy_number));
    }



}
