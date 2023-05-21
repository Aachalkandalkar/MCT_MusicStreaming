package com.geekster.service;

import com.geekster.interfaces.IStatusServiceInterface;
import com.geekster.model.Status;
import com.geekster.repository.IStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService implements IStatusServiceInterface {
    @Autowired
    private IStatusRepository iStatusRepository;
    @Override
    public Status addStatus(Status status) {
        return iStatusRepository.save(status);
    }
}
