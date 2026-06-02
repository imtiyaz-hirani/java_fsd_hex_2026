package com.springboot.SupportFlowLite.service;

import com.springboot.SupportFlowLite.execptions.ResourceNotFoundException;
import com.springboot.SupportFlowLite.model.Executive;
import com.springboot.SupportFlowLite.repository.ExecutiveRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExecutiveService {
    private final ExecutiveRepository executiveRepository;

    public Executive getById(int executiveId) {
        return executiveRepository.findById(executiveId)
                .orElseThrow(()-> new ResourceNotFoundException("Executive Id Invalid"));
    }
}
