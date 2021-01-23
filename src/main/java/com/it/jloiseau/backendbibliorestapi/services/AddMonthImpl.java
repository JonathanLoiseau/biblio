package com.it.jloiseau.backendbibliorestapi.services;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.temporal.Temporal;

public class AddMonthImpl implements AddMonth {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Override
    public void add (Temporal temporal, LocalDate localDate) {

    }
}
