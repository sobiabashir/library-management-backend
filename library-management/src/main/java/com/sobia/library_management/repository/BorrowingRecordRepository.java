package com.sobia.library_management.repository;
import com.sobia.library_management.entity.BorrowingRecord;
import com.sobia.library_management.enums.BorrowStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {

    List<BorrowingRecord> findByMemberId(Long memberId);
    List<BorrowingRecord> findByBookId(Long bookId);
    List<BorrowingRecord> findByStatus(BorrowStatus status);
}
