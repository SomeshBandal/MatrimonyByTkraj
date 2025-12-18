package com.spring.jwt.HoroscopeDetails;

import com.spring.jwt.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/horoscope")
@RequiredArgsConstructor
public class HoroscopeDetailsController {

    private final HoroscopeDetailsService horoscopeService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto<?>> create(@RequestBody HoroscopeDetailsDTO dto) {
        try {
            return ResponseEntity.ok(ResponseDto.success("Created successfully",
                    horoscopeService.create(dto)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    ResponseDto.error("Failed to create", e.getMessage()));
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDto<?>> getById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(ResponseDto.success("Fetched successfully",
                    horoscopeService.getById(id)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    ResponseDto.error("Failed to fetch", e.getMessage()));
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDto<?>> getAll() {
        try {
            return ResponseEntity.ok(ResponseDto.success("Fetched successfully",
                    horoscopeService.getAll()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    ResponseDto.error("Failed to fetch", e.getMessage()));
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ResponseDto<?>> update(@PathVariable Integer id,
                                                 @RequestBody HoroscopeDetailsDTO dto) {
        try {
            return ResponseEntity.ok(ResponseDto.success("Updated successfully",
                    horoscopeService.update(id, dto)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    ResponseDto.error("Failed to update", e.getMessage()));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto<?>> delete(@PathVariable Integer id) {
        try {
            horoscopeService.delete(id);
            return ResponseEntity.ok(ResponseDto.success("Deleted successfully", null));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    ResponseDto.error("Failed to delete", e.getMessage()));
        }
    }
}
