package com.drifai.careproject.service;

import com.drifai.careproject.dto.ProviderDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@ConditionalOnProperty(prefix = "data", name = "type", havingValue = "faked")
public class ProviderServiceFakeDataImpl implements ProviderService {

    public List<ProviderDTO> getProvider(String vertical, String zipCode) {
        log.info("Zip code: " + zipCode);
        List<ProviderDTO> resultsList = fakeData(vertical, zipCode);
        for(ProviderDTO  providerDTO : resultsList) {
            providerDTO.setLastName(obfuscate(providerDTO.getLastName()));
        }

        return resultsList;
    }

    private List<ProviderDTO> fakeData(String inputVertical, String inputZipCode) {
        List<ProviderDTO> resultList = new ArrayList<>();
        ProviderDTO providerDTO = ProviderDTO.builder()
                .firstName("Susan")
                .lastName("Woodruff")
                .rate(new BigDecimal(50.00))
                .vertical(inputVertical)
                .zipCode(inputZipCode)
                .build();
        resultList.add(providerDTO);

        providerDTO = ProviderDTO.builder()
                .firstName("Marilyn")
                .lastName("Quinn")
                .rate(new BigDecimal(65.00))
                .vertical(inputVertical)
                .zipCode(inputZipCode)
                .build();
        resultList.add(providerDTO);
        return resultList;
    }
}
