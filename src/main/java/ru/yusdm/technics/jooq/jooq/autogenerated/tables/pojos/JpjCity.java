/*
 * This file is generated by jOOQ.
 */
package ru.yusdm.technics.jooq.jooq.autogenerated.tables.pojos;


import java.io.Serializable;

import javax.validation.constraints.Size;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JpjCity implements Serializable {

    private static final long serialVersionUID = 877195331;

    private final Long   id;
    private final String mainStreet;
    private final String name;
    private final Long   countryId;

    public JpjCity(JpjCity value) {
        this.id = value.id;
        this.mainStreet = value.mainStreet;
        this.name = value.name;
        this.countryId = value.countryId;
    }

    public JpjCity(
        Long   id,
        String mainStreet,
        String name,
        Long   countryId
    ) {
        this.id = id;
        this.mainStreet = mainStreet;
        this.name = name;
        this.countryId = countryId;
    }

   public JpjCity(
        String mainStreet,
        String name,
        Long   countryId
    ) {
        this.id = null;
        this.mainStreet = mainStreet;
        this.name = name;
        this.countryId = countryId;
    }

    public Long getId() {
        return this.id;
    }

    @Size(max = 255)
    public String getMainStreet() {
        return this.mainStreet;
    }

    @Size(max = 255)
    public String getName() {
        return this.name;
    }

    public Long getCountryId() {
        return this.countryId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JpjCity (");

        sb.append(id);
        sb.append(", ").append(mainStreet);
        sb.append(", ").append(name);
        sb.append(", ").append(countryId);

        sb.append(")");
        return sb.toString();
    }
}
