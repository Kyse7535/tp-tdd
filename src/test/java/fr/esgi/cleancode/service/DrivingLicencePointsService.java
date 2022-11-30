package fr.esgi.cleancode.service;

import fr.esgi.cleancode.database.InMemoryDatabase;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DrivingLicencePointsService {

    @InjectMocks
    private DrivingLicencePointsService service;

    @Mock
    private InMemoryDatabase database;



}
