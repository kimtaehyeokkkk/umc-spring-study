package com.umc.study.controller;

import com.umc.study.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rentals")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    @PostMapping
    public String createRental(@RequestBody Map<String, Object> body) {
        rentalService.createRental(body);
        return "대여 기록이 생성되었습니다!";
    }

    @PatchMapping("/{rentalId}/return")
    public String returnRental(@PathVariable Long rentalId) {
        return rentalService.returnRental(rentalId);
    }
}