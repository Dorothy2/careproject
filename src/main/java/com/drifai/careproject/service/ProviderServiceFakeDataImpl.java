package com.drifai.careproject.service;

import com.drifai.careproject.dto.ProviderDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@ConditionalOnProperty(prefix = "data", name = "type", havingValue = "faked")
public class ProviderServiceFakeDataImpl implements ProviderService {

    public ProviderDTO getProvider(String zipCode) {
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
