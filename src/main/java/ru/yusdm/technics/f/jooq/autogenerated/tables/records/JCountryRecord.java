/*
 * This file is generated by jOOQ.
 */
package ru.yusdm.technics.f.jooq.autogenerated.tables.records;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

import ru.yusdm.technics.f.jooq.autogenerated.tables.JCountry;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JCountryRecord extends UpdatableRecordImpl<JCountryRecord> implements Record3<Long, String, Integer> {

    private static final long serialVersionUID = 386907097;

    /**
     * Setter for <code>public.country.id</code>.
     */
    public JCountryRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.country.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.country.name</code>.
     */
    public JCountryRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.country.name</code>.
     */
    @Size(max = 255)
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.country.population</code>.
     */
    public JCountryRecord setPopulation(Integer value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.country.population</code>.
     */
    @NotNull
    public Integer getPopulation() {
        return (Integer) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, String, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Long, String, Integer> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return JCountry.COUNTRY.ID;
    }

    @Override
    public Field<String> field2() {
        return JCountry.COUNTRY.NAME;
    }

    @Override
    public Field<Integer> field3() {
        return JCountry.COUNTRY.POPULATION;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public Integer component3() {
        return getPopulation();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public Integer value3() {
        return getPopulation();
    }

    @Override
    public JCountryRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public JCountryRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public JCountryRecord value3(Integer value) {
        setPopulation(value);
        return this;
    }

    @Override
    public JCountryRecord values(Long value1, String value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JCountryRecord
     */
    public JCountryRecord() {
        super(JCountry.COUNTRY);
    }

    /**
     * Create a detached, initialised JCountryRecord
     */
    public JCountryRecord(Long id, String name, Integer population) {
        super(JCountry.COUNTRY);

        set(0, id);
        set(1, name);
        set(2, population);
    }
}