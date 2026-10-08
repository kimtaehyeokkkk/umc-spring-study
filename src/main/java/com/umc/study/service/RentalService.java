package com.umc.study.service;

import com.umc.study.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;

    public void createRental(Map<String, Object> body) {
        rentalRepository.save(body);
    }

    public String returnRental(Long rentalId) {
        int updatedRows = rentalRepository.markReturned(rentalId);

        if (updatedRows == 0) {
            return "반납할 수 있는 대여 기록이 없습니다. (존재하지 않거나 이미 반납됨)";
        }
        return "반납 처리가 완료되었습니다!";
    }
}