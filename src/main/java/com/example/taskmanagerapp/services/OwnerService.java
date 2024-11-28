package com.example.taskmanagerapp.services;

import com.example.taskmanagerapp.entities.Owner;
import com.example.taskmanagerapp.repositories.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Owner createOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public Owner getOwnerById(Long id) {
        return ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("Owner not found"));
    }

    public Owner updateOwner(Long id, Owner updatedOwner) {
        Owner owner = getOwnerById(id);
        owner.setName(updatedOwner.getName());
        return ownerRepository.save(owner);
    }
}
