package com.drifai.careproject.service;

import com.drifai.careproject.dto.ProviderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * When this class is finished, the data will be coming from an h2 embedded db
 */
@Slf4j
@Service
@ConditionalOnProperty(prefix = "data", name = "type", havingValue = "db")
public class ProviderServiceDataFromDB implements ProviderService {

    public ProviderDTO getProvider(String zipCode) {
        log.info("Database version was invoked");
        log.info("Zip code: " + zipCode);
        ProviderDTO providerDTO = fakeData(zipCode);
        providerDTO.setLastName(obfuscate(providerDTO.getLastName()));

        return providerDTO;
    }

    private ProviderDTO fakeData(String inputZipCode) {
        ProviderDTO providerDTO = ProviderDTO.builder()
                .firstName("Susan")
                .lastName("Woodruff")
                .rate(new BigDecimal(50.00))
                .zipCode(inputZipCode)
                .build();
        return providerDTO;
    }
}
