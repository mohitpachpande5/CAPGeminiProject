package com.example.DonorCRUD;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonorService {
    
    private static final Logger logger = LoggerFactory.getLogger(DonorService.class);

    @Autowired
    private DonorRepository repository;

    // Create Donor
    public Donor saveDonor(Donor donor) {
        logger.debug("Attempting to save donor with email: {}", donor.getEmail());
        Donor savedDonor = repository.save(donor);
        logger.debug("Successfully saved donor with ID: {}", savedDonor.getDonId());
        return savedDonor;
    }

    // Get All Donors
    public List<Donor> getAllDonors() {
        logger.debug("Retrieving all donors");
        List<Donor> donors = repository.findAll();
        logger.debug("Found {} donors", donors.size());
        return donors;
    }

    // Get Donor by ID
    public Optional<Donor> getDonorById(Integer id) {
        logger.debug("Retrieving employee with ID: {}", id);
        Optional<Donor> donor = repository.findById(id);
        if (donor.isPresent()) {
            logger.debug("Found donor with ID: {}", id);
        } else {
            logger.debug("No donor found with ID: {}", id);
        }
        return donor;
    }

    // Get Donor by Email
    public Optional<Donor> getDonorByEmail(String email) {
        logger.debug("Retrieving donor with email: {}", email);
        Optional<Donor> donor = repository.findByEmail(email);
        if (donor.isPresent()) {
            logger.debug("Found donor with email: {}", email);
        } else {
            logger.debug("No donor found with email: {}", email);
        }
        return donor;
    }

    // Update Donor
    public Donor updateDonor(Integer id, Donor updatedDonor) {
        logger.debug("Attempting to update Donor with ID: {}", id);
        return repository.findById(id)
                .map(donor -> {
                    logger.debug("Found donor with ID: {}, updating details", id);
                    donor.setFirstName(updatedDonor.getFirstName());
                    donor.setLastName(updatedDonor.getLastName());
                    donor.setEmail(updatedDonor.getEmail());
                    donor.setMobileNumber(updatedDonor.getMobileNumber());
                    donor.setEvent(updatedDonor.getEvent());
                    donor.setAmount(updatedDonor.getAmount());
                    Donor savedDonor = repository.save(donor);
                    logger.debug("Successfully updated donor with ID: {}", id);
                    return savedDonor;
                })
                .orElseThrow(() -> {
                    logger.debug("Failed to update - donor not found with ID: {}", id);
                    return new RuntimeException("Donor not found with ID: " + id);
                });
    }

    // Delete Donor
    public void deleteDonor(Integer id) {
        logger.debug("Attempting to delete donor with ID: {}", id);
        repository.deleteById(id);
        logger.debug("Successfully deleted donor with ID: {}", id);
    }
}