package fr.esgi.cleancode.service;


import fr.esgi.cleancode.database.InMemoryDatabase;
import fr.esgi.cleancode.exception.InvalidDriverSocialSecurityNumberException;
import fr.esgi.cleancode.model.DrivingLicence;
import lombok.RequiredArgsConstructor;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RequiredArgsConstructor
public class DrivingLicenceCreationService {
    private final InMemoryDatabase database;

    public boolean check_ss(String social_securiy_number) {
        Pattern p = Pattern.compile(social_securiy_number);
        Matcher m = p.matcher("[0-9]{15}");
        if(!m.find()) {
            throw new InvalidDriverSocialSecurityNumberException("taille incorrecte");
        }
        return true;
    }

    public DrivingLicence create(String social_securiy_number)  {
        UUID id = UUID.randomUUID();
        return DrivingLicence.builder().driverSocialSecurityNumber(social_securiy_number).build();
    }

}
