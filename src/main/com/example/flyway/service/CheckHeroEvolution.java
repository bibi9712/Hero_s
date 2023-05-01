package com.example.flyway.service;

import com.example.flyway.entity.Evolution;
import com.example.flyway.entity.HeroTimeEvol;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@FunctionalInterface
public interface CheckHeroEvolution {
    static CheckHeroEvolution create() {
        return heroTimeEvol -> {
            long diffInDays = ChronoUnit.DAYS.between(LocalDate.now(), heroTimeEvol.endEnding());
            if (diffInDays <= 10) {
                return Evolution.EVOL_4;
            }
            return Evolution.EVOL_1;
        };
    }

    Evolution getEvolByTime(HeroTimeEvol heroTimeEvol);
}
