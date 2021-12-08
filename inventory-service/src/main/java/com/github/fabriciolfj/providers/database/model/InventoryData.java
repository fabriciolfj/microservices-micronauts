package com.github.fabriciolfj.providers.database.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "inventory")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class InventoryData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private Long balance;
    @Column(name = "date_mov", nullable = false)
    private LocalDateTime dateMov;
    @Column(nullable = false)
    private Long exit;
    @Column(nullable = false)
    private Long entrance;
}
