package com.appkobo.campusnavi.controller;

import com.appkobo.campusnavi.model.Professor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {
    @PostMapping
    public ResponseEntity<List<Professor>> createProfessor(@RequestBody Professor professor) {
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getProfessors(@RequestParam(required = false) Long schoolId, @RequestParam(required = false) String query) {
        List<Professor> professors = Arrays.asList(
                new Professor(1L, null, "山田", "太郎", null, null),
                new Professor(2L, null, "山田", "花子", null, null),
                new Professor(3L, null, "田中", "一郎", null, null),
                new Professor(4L, null, "田中", "二郎", null, null),
                new Professor(5L, null, "田中", "三郎", null, null),
                new Professor(6L, null, "佐藤", "一郎", null, null),
                new Professor(7L, null, "佐藤", "二郎", null, null),
                new Professor(8L, null, "佐藤", "三郎", null, null),
                new Professor(9L, null, "鈴木", "一郎", null, null),
                new Professor(10L, null, "鈴木", "二郎", null, null),
                new Professor(11L, null, "鈴木", "三郎", null, null),
                new Professor(12L, null, "高橋", "一郎", null, null),
                new Professor(13L, null, "高橋", "二郎", null, null),
                new Professor(14L, null, "高橋", "三郎", null, null),
                new Professor(15L, null, "渡辺", "一郎", null, null),
                new Professor(16L, null, "渡辺", "二郎", null, null),
                new Professor(17L, null, "渡辺", "三郎", null, null),
                new Professor(18L, null, "伊藤", "一郎", null, null),
                new Professor(19L, null, "伊藤", "二郎", null, null),
                new Professor(20L, null, "伊藤", "三郎", null, null),
                new Professor(21L, null, "山本", "一郎", null, null),
                new Professor(22L, null, "山本", "二郎", null, null),
                new Professor(23L, null, "山本", "三郎", null, null),
                new Professor(24L, null, "中村", "一郎", null, null),
                new Professor(25L, null, "中村", "二郎", null, null),
                new Professor(26L, null, "中村", "三郎", null, null),
                new Professor(27L, null, "小林", "一郎", null, null),
                new Professor(28L, null, "小林", "二郎", null, null),
                new Professor(29L, null, "小林", "三郎", null, null),
                new Professor(30L, null, "加藤", "一郎", null, null),
                new Professor(31L, null, "加藤", "二郎", null, null),
                new Professor(32L, null, "加藤", "三郎", null, null),
                new Professor(33L, null, "吉田", "一郎", null, null),
                new Professor(34L, null, "吉田", "二郎", null, null),
                new Professor(35L, null, "吉田", "三郎", null, null),
                new Professor(36L, null, "山口", "一郎", null, null),
                new Professor(37L, null, "山口", "二郎", null, null),
                new Professor(38L, null, "山口", "三郎", null, null),
                new Professor(39L, null, "斎藤", "一郎", null, null),
                new Professor(40L, null, "斎藤", "二郎", null, null)
        );

        List<Professor> filteredProfessors = professors.stream()
                .filter(p -> (p.getLastName() + p.getFirstName()).contains(query))
                .toList();

        return ResponseEntity.ok()
                .body(filteredProfessors);
    }
}
