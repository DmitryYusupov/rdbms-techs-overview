/*
 * This file is generated by jOOQ.
 */
package ru.yusdm.technics.f.jooq.autogenerated.tables.pojos;


import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JpjCountry implements Serializable {

    private static final long serialVersionUID = -49756393;

    private final Long    id;
    private final String  name;
    private final Integer population;

    public JpjCountry(JpjCountry value) {
        this.id = value.id;
        this.name = value.name;
        this.population = value.population;
    }

    public JpjCountry(
        Long    id,
        String  name,
        Integer population
    ) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public Long getId() {
        return this.id;
    }

    @Size(max = 255)
    public String getName() {
        return this.name;
    }

    @NotNull
    public Integer getPopulation() {
        return this.population;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JpjCountry (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(population);

        sb.append(")");
        return sb.toString();
    }
}
