package com.garage.backend.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder



public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand", nullable = false, length = 100)
    private String brand;

    @Column(name = "model", nullable = false, length = 100)
    private String model;

    @Column(name = "year", nullable = false)
    @NotNull
    @Min(value = 1886, message = "Year car must be >= 1886")
    @Max(value = 2100, message = "Year car must be <= 2100")
    private Integer year;

    @Column(name = "license_plate", nullable = false, unique = true, length = 20)
    @NotNull(message = "license plate not must be null")
    @Pattern(regexp = "^[A-Z0-9]+$", message ="license plate must be meet the standarts")
    private String licensePlate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    //При закрытии записывается дата в createdAt
    @PrePersist
    protected void onCreate(){

        createdAt = LocalDateTime.now();

    }


}
