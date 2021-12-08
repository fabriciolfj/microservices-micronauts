package com.github.fabriciolfj.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    private String code;
    private Long balance;
    private LocalDateTime dateMov;
    private Long exit;
    private Long entrance;

    public void calculateBalance(final Long balance) {
        this.balance = balance;
        if (exit > 0) {
            this.balance -= exit;
            return;
        }

        this.balance += entrance;
        return;
    }
}
