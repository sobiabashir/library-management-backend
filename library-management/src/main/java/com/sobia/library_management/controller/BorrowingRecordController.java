package com.sobia.library_management.controller;

import com.sobia.library_management.dto.request.BorrowingRecordRequestDTO;
import com.sobia.library_management.dto.response.BorrowingRecordResponseDTO;
import com.sobia.library_management.service.BorrowingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/borrowing")
@CrossOrigin(origins = "*")
public class BorrowingRecordController {

    @Autowired
    private BorrowingRecordService borrowingRecordService;

    @GetMapping
    public ResponseEntity<List<BorrowingRecordResponseDTO>> getAllRecords() {
        return ResponseEntity.ok(borrowingRecordService.getAllRecords());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowingRecordResponseDTO> getRecordById(@PathVariable Long id) {
        return ResponseEntity.ok(borrowingRecordService.getRecordById(id));
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<BorrowingRecordResponseDTO>> getRecordsByMember(@PathVariable Long memberId) {
        return ResponseEntity.ok(borrowingRecordService.getRecordsByMember(memberId));
    }

    @PostMapping("/borrow")
    public ResponseEntity<BorrowingRecordResponseDTO> borrowBook(@RequestBody BorrowingRecordRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(borrowingRecordService.borrowBook(requestDTO));
    }

    @PutMapping("/return/{recordId}")
    public ResponseEntity<BorrowingRecordResponseDTO> returnBook(@PathVariable Long recordId) {
        return ResponseEntity.ok(borrowingRecordService.returnBook(recordId));
    }
}
