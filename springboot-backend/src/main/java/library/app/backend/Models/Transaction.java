package library.app.backend.Models;

import jakarta.persistence.*;
import library.app.backend.Enums.TransactionType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "[transaction]")
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rental_id", nullable = false, referencedColumnName = "id")
    private Rental rental;
    @Column(nullable = false)
    private LocalDateTime transactionDate;
    @Enumerated(EnumType.STRING)
    @Column()
    private TransactionType transactionType;
}
