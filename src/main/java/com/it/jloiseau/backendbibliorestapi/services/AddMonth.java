package com.it.jloiseau.backendbibliorestapi.services;

import java.time.LocalDate;
import java.time.temporal.Temporal;

public interface AddMonth {
    void add(Temporal temporal, LocalDate localDate);
}
