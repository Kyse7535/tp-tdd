package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DrivingLicenceCreationServiceTest {
    @InjectMocks
    private DrivingLicenceFinderService service;

    @Mock
    private InMemoryDatabase database;

    @Test
    public void verification() {

    }

    @Test
    public void create() {

    }

    @Test
    public void should_not_be_null() {

    }

    @Test
    public void should_contain_only_digits() {

    }

    @Test
    public void should_have_15_digits() {

    }

    @Test
    public void should_raise_exception_if_ss_invalid() {

    }


}
