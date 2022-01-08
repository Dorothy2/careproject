package com.drifai.careproject.service;

import com.drifai.careproject.dto.ProviderDTO;

public interface ProviderService {

    ProviderDTO getProvider(String zipCode);

    default String obfuscate(String input) {
        return input.substring(0, 1) + ".";
    }
}