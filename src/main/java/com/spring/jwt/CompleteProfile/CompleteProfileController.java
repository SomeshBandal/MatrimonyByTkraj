package com.spring.jwt.CompleteProfile;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/completeProfile")
@RequiredArgsConstructor
public class CompleteProfileController {

    private final CompleteProfileService service;

    @GetMapping("/get/{userId}")
    public ResponseEntity<CompleteProfileDTO> getFullProfile(@PathVariable Integer userId) {
        return ResponseEntity.ok(service.getByUserId(userId));
    }

    @GetMapping("/check/{userId}")
    public ResponseEntity<MissingProfileDTO> checkMissing(@PathVariable Integer userId) {
        return ResponseEntity.ok(service.checkMissingSections(userId));
    }
}
