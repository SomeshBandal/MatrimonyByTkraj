package com.spring.jwt.PartnerPreference;

import com.spring.jwt.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/partnerPreference")
@RequiredArgsConstructor
public class PartnerPreferenceController {

    private final PartnerPreferenceService partnerPreferenceService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto<?>> create(@RequestBody PartnerPreferenceDTO dto) {
        try {
            return ResponseEntity.ok(ResponseDto.success("Created successfully",
                            partnerPreferenceService.create(dto)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    ResponseDto.error("Failed to create", e.getMessage()));
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDto<?>> getById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(
                    ResponseDto.success("Fetched successfully",
                            partnerPreferenceService.getById(id)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    ResponseDto.error("Failed to fetch", e.getMessage()));
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDto<?>> getAll() {
        try {
            return ResponseEntity.ok(
                    ResponseDto.success("Fetched successfully",
                            partnerPreferenceService.getAll()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    ResponseDto.error("Failed to fetch", e.getMessage()));
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ResponseDto<?>> update(@PathVariable Integer id,
                                                 @RequestBody PartnerPreferenceDTO dto) {
        try {
            return ResponseEntity.ok(ResponseDto.success(
                            "Updated successfully", partnerPreferenceService.update(id, dto)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    ResponseDto.error("Failed to update", e.getMessage())
            );
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto<?>> delete(@PathVariable Integer id) {
        try {
            partnerPreferenceService.delete(id);
            return ResponseEntity.ok(ResponseDto.success("Deleted successfully", null));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    ResponseDto.error("Failed to delete", e.getMessage()));
        }
    }
}
