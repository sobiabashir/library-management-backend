package com.sobia.library_management.dto.request;

import lombok.Data;
import java.time.LocalDate;

@Data
public class BorrowingRecordRequestDTO {

    private LocalDate borrowDate;
    private Long bookId;
    private Long memberId;
}
