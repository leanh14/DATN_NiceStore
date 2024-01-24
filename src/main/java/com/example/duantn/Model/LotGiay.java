package com.example.duantn.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "LotGiay")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class LotGiay {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}
