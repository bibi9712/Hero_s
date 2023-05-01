package com.example.flyway.service;

import com.example.flyway.entity.Evolution;
import com.example.flyway.entity.Hero;
import com.example.flyway.entity.HeroTimeEvol;
import com.example.flyway.entity.TypeHero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class CheckHeroEvolutionShould {

    private CheckHeroEvolution checkHeroEvolution;

    @BeforeEach
    void init() {
        checkHeroEvolution = com.example.flyway.service.CheckHeroEvolution.create();
    }

    @Test
    void return_EVOL_4_when_hero_evol_end_date_is_close() {
        final var hero = new Hero(1, "Kakarot", TypeHero.SAIYAN);
        final var heroTimeEvol = new HeroTimeEvol(1, hero, LocalDate.now().minusMonths(3), LocalDate.now().plusDays(1));
        final var evolByTime = checkHeroEvolution.getEvolByTime(heroTimeEvol);
        assertThat(evolByTime).isEqualTo(Evolution.EVOL_4);
        System.out.println("ERROR ERROR !!! LE PERSO VA MOURRIR");
    }

    @Test
    void return_EVOL_1_when_hero_evol() {
        final var hero = new Hero(1, "Buu", TypeHero.MAJIN);
        final var heroTimeEvol = new HeroTimeEvol(1, hero, LocalDate.now().minusMonths(3), LocalDate.now().plusYears(1));
        final var evolByTime = checkHeroEvolution.getEvolByTime(heroTimeEvol);
        assertThat(evolByTime).isEqualTo(Evolution.EVOL_1);
        System.out.println("IL A ENCORE DU POTENTIEL");
    }

}