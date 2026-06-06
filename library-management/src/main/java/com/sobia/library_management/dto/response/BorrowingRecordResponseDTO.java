package com.sobia.library_management.dto.response;

import com.sobia.library_management.enums.BorrowStatus;
import lombok.Data;
import java.time.LocalDate;

@Data
public class BorrowingRecordResponseDTO {

    private Long id;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private BorrowStatus status;
    private String bookTitle;
    private String memberName;
}
