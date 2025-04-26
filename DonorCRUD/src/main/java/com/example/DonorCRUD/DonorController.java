package com.example.DonorCRUD;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/donors")
@CrossOrigin(origins = "http://localhost:4200")
public class DonorController {
    
    private static final Logger logger = LoggerFactory.getLogger(DonorController.class);

    @Autowired
    private DonorService service;

    // Register Donor
    @PostMapping("/register")
    public ResponseEntity<Donor> registerDonor(@RequestBody Donor donor) {
        logger.debug("Received request to register employee with email: {}", donor.getEmail());
        Donor savedDonor = service.saveDonor(donor);
        logger.debug("Successfully registered employee with ID: {}", savedDonor.getDonId());
        return ResponseEntity.ok(savedDonor);
    }

    // Get All Donors
    @GetMapping("/all")
    public ResponseEntity<List<Donor>> getAllDonors() {
        logger.debug("Received request to get all donors");
        List<Donor> donors = service.getAllDonors();
        logger.debug("Returning {} donors", donors.size());
        return ResponseEntity.ok(donors);
    }

    // Get Donor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Donor> getDonorById(@PathVariable Integer id) {
        logger.debug("Received request to get employee with ID: {}", id);
        Optional<Donor> donor = service.getDonorById(id);
        if (donor.isPresent()) {
            logger.debug("Returning donor with ID: {}", id);
            return ResponseEntity.ok(donor.get());
        } else {
            logger.debug("Donor with ID: {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Get Donor by Email
    @GetMapping("/email/{email}")
    public ResponseEntity<Donor> getDonorByEmail(@PathVariable String email) {
        logger.debug("Received request to get donor with email: {}", email);
        Optional<Donor> donor = service.getDonorByEmail(email);
        if (donor.isPresent()) {
            logger.debug("Returning donor with email: {}", email);
            return ResponseEntity.ok(donor.get());
        } else {
            logger.debug("Donor with email: {} not found", email);
            return ResponseEntity.notFound().build();
        }
    }

    // Update Donor
    @PutMapping("/update/{id}")
    public ResponseEntity<Donor> updateDonor(@PathVariable Integer id, @RequestBody Donor donor) {
        logger.debug("Received request to update donor with ID: {}", id);
        Donor updatedDonor = service.updateDonor(id, donor);
        logger.debug("Successfully updated donor with ID: {}", id);
        return ResponseEntity.ok(updatedDonor);
    }

    // Delete Donor
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDonor(@PathVariable Integer id) {
        logger.debug("Received request to delete donor with ID: {}", id);
        service.deleteDonor(id);
        logger.debug("Successfully deleted donor with ID: {}", id);
        return ResponseEntity.noContent().build();
    }
}