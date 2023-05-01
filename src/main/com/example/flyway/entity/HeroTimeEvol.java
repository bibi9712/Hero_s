package com.example.flyway.entity;

import java.time.LocalDate;

public record HeroTimeEvol(int id,
                           Hero hero,
                           LocalDate begin,
                           LocalDate endEnding) {
}
