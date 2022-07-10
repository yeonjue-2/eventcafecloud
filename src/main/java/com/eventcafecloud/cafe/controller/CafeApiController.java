package com.eventcafecloud.cafe.controller;

import com.eventcafecloud.cafe.dto.CafeListResponseDto;
import com.eventcafecloud.cafe.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CafeApiController {

    private final CafeService cafeService;

    @GetMapping("/api/cafes")
    public Page<CafeListResponseDto> ReadAllCafeList(
            @RequestParam("page") int page,
            @RequestParam("size") int size
//            @RequestParam("sortBy") String sortBy,
//            @RequestParam("isAsc") boolean isAsc
    ){
        page = page - 1;
        return cafeService.findAllCafeList(page, size);
    }

    @GetMapping("/api/cafes/top5")
    public List<CafeListResponseDto> ReadCafeTopFive(){
        return cafeService.findCafeTopFiveList();
    }
}