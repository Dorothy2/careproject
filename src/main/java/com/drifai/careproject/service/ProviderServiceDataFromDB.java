package com.drifai.careproject.service;

import com.drifai.careproject.dto.ProviderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * When this class is finished, the data will be coming from an h2 embedded db
 */
@Slf4j
@Service
@ConditionalOnProperty(prefix = "data", name = "type", havingValue = "db")
public class ProviderServiceDataFromDB implements ProviderService {

    public List<ProviderDTO> getProvider(String vertical, String zipCode) {
        log.info("Database version was invoked");
        log.info("Vertical: " + vertical + " Zip code: " + zipCode);
        List<ProviderDTO> resultList = new ArrayList<>();
        ProviderDTO providerDTO = fakeData(vertical, zipCode);
        providerDTO.setLastName(obfuscate(providerDTO.getLastName()));
        resultList.add(providerDTO);

        return resultList;
    }

    private ProviderDTO fakeData(String inputVertical, String inputZipCode) {
        ProviderDTO providerDTO = ProviderDTO.builder()
                .firstName("Susan")
                .lastName("Woodruff")
                .rate(new BigDecimal(50.00))
                .vertical(inputVertical)
                .zipCode(inputZipCode)
                .build();
        return providerDTO;
    }
}
