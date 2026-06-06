package com.sobia.library_management.service;

import com.sobia.library_management.dto.request.BorrowingRecordRequestDTO;
import com.sobia.library_management.dto.response.BorrowingRecordResponseDTO;
import com.sobia.library_management.entity.Book;
import com.sobia.library_management.entity.BorrowingRecord;
import com.sobia.library_management.entity.Member;
import com.sobia.library_management.enums.BorrowStatus;
import com.sobia.library_management.repository.BookRepository;
import com.sobia.library_management.repository.BorrowingRecordRepository;
import com.sobia.library_management.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowingRecordService {

    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    public List<BorrowingRecordResponseDTO> getAllRecords() {
        return borrowingRecordRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public BorrowingRecordResponseDTO getRecordById(Long id) {
        BorrowingRecord record = borrowingRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found with id: " + id));
        return convertToDTO(record);
    }

    public List<BorrowingRecordResponseDTO> getRecordsByMember(Long memberId) {
        return borrowingRecordRepository.findByMemberId(memberId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // BORROW a book
    public BorrowingRecordResponseDTO borrowBook(BorrowingRecordRequestDTO requestDTO) {
        Book book = bookRepository.findById(requestDTO.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + requestDTO.getBookId()));

        if (book.getAvailableCopies() <= 0) {
            throw new RuntimeException("No available copies for book: " + book.getTitle());
        }

        Member member = memberRepository.findById(requestDTO.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + requestDTO.getMemberId()));

        // reduce available copies
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);

        BorrowingRecord record = new BorrowingRecord();
        record.setBorrowDate(requestDTO.getBorrowDate());
        record.setStatus(BorrowStatus.BORROWED);
        record.setBook(book);
        record.setMember(member);

        BorrowingRecord saved = borrowingRecordRepository.save(record);
        return convertToDTO(saved);
    }

    // RETURN a book
    public BorrowingRecordResponseDTO returnBook(Long recordId) {
        BorrowingRecord record = borrowingRecordRepository.findById(recordId)
                .orElseThrow(() -> new RuntimeException("Record not found with id: " + recordId));

        // increase available copies
        Book book = record.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepository.save(book);

        record.setReturnDate(LocalDate.now());
        record.setStatus(BorrowStatus.RETURNED);

        BorrowingRecord updated = borrowingRecordRepository.save(record);
        return convertToDTO(updated);
    }

    private BorrowingRecordResponseDTO convertToDTO(BorrowingRecord record) {
        BorrowingRecordResponseDTO dto = new BorrowingRecordResponseDTO();
        dto.setId(record.getId());
        dto.setBorrowDate(record.getBorrowDate());
        dto.setReturnDate(record.getReturnDate());
        dto.setStatus(record.getStatus());
        dto.setBookTitle(record.getBook().getTitle());
        dto.setMemberName(record.getMember().getFirstName() + " " + record.getMember().getLastName());
        return dto;
    }
}