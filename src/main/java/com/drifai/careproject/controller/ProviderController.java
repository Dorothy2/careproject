package com.drifai.careproject.controller;

import com.drifai.careproject.dto.ProviderDTO;
import com.drifai.careproject.service.ProviderService;
import com.drifai.careproject.service.ProviderServiceFakeDataImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/providers")
public class ProviderController {

    private final ProviderService providerService;

    @GetMapping("/{zipCode}")
    public String getProvider(@PathVariable String zipCode) {
        // TODO: Zip code should be validated before being passed to service
        ProviderDTO providerDTO = providerService.getProvider(zipCode);
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = "Not populated";
        try {
            jsonStr = mapper.writeValueAsString(providerDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

}
