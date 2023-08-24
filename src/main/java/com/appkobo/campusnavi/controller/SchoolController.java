package com.appkobo.campusnavi.controller;

import com.appkobo.campusnavi.model.School;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolController {
    @PostMapping
    public ResponseEntity<?> createSchool(@RequestBody School school) {
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<School>> getSchools(@RequestParam(required = false) String query) {
        // Dummy implementation
        List<School> schools = Arrays.asList(
                new School(1L, "東京大学", "東京", "東京都", null, null),
                new School(2L, "京都大学", "京都", "京都府", null, null),
                new School(3L, "大阪大学", "大阪", "大阪府", null, null),
                new School(4L, "名古屋大学", "名古屋", "愛知県", null, null),
                new School(5L, "北海道大学", "札幌", "北海道", null, null),
                new School(6L, "東北大学", "仙台", "宮城県", null, null),
                new School(7L, "神戸大学", "神戸", "兵庫県", null, null),
                new School(8L, "九州大学", "福岡", "福岡県", null, null),
                new School(9L, "千葉大学", "千葉", "千葉県", null, null),
                new School(10L, "横浜国立大学", "横浜", "神奈川県", null, null),
                new School(11L, "東京工業大学", "東京", "東京都", null, null),
                new School(12L, "大阪市立大学", "大阪", "大阪府", null, null),
                new School(13L, "東京農工大学", "東京", "東京都", null, null),
                new School(14L, "東京医科歯科大学", "東京", "東京都", null, null),
                new School(15L, "東京外国語大学", "東京", "東京都", null, null),
                new School(16L, "東京海洋大学", "東京", "東京都", null, null),
                new School(17L, "東京芸術大学", "東京", "東京都", null, null),
                new School(18L, "東京学芸大学", "東京", "東京都", null, null),
                new School(19L, "東京理科大学", "東京", "東京都", null, null),
                new School(20L, "東京電機大学", "東京", "東京都", null, null),
                new School(21L, "東京工科大学", "東京", "東京都", null, null),
                new School(22L, "東京造形大学", "東京", "東京都", null, null),
                new School(23L, "東京都市大学", "東京", "東京都", null, null),
                new School(24L, "東京家政大学", "東京", "東京都", null, null),
                new School(25L, "東京福祉大学", "東京", "東京都", null, null),
                new School(26L, "東京農業大学", "東京", "東京都", null, null),
                new School(27L, "東京富士大学", "東京", "東京都", null, null),
                new School(28L, "東京国際大学", "東京", "東京都", null, null),
                new School(29L, "東京女子大学", "東京", "東京都", null, null),
                new School(30L, "東京未来大学", "東京", "東京都", null, null)
        );

        List<School> filteredSchools = schools.stream()
                .filter(s -> s.getName().contains(query))
                .toList();

        return ResponseEntity.ok()
                .body(filteredSchools);
    }
}
