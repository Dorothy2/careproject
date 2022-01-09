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

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/providers")
public class ProviderController {

    private static ObjectMapper mapper = new ObjectMapper();
    private final ProviderService providerService;

    @GetMapping("/{vertical}/{zipCode}")
    public List<String> getProvider(@PathVariable String vertical, @PathVariable String zipCode) {
        // TODO: Zip code and vertical should be validated before being passed to service
        List<ProviderDTO> resultList = providerService.getProvider(vertical, zipCode);
        List<String> jsonList = convertListToJSON(resultList);
        return jsonList;
    }

    private List<String> convertListToJSON(List<ProviderDTO> providers) {
        List<String> jsonList = new ArrayList<>();
        for(ProviderDTO providerDTO : providers) {
            String jsonStr = convertToJSON(providerDTO);
            jsonList.add(jsonStr);
        }
        return jsonList;
    }

    private String convertToJSON(ProviderDTO providerDTO) {
        String jsonStr = "Not populated";
        try {
            jsonStr = mapper.writeValueAsString(providerDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

}
