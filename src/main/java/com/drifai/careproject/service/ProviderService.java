package com.drifai.careproject.service;

import com.drifai.careproject.dto.ProviderDTO;

import java.util.List;

public interface ProviderService {

    List<ProviderDTO> getProvider(String vertical, String zipCode);

    default String obfuscate(String input) {
        return input.substring(0, 1) + ".";
    }
}