/*
 * This file is generated by jOOQ.
 */
package ru.yusdm.technics.f.jooq.autogenerated.tables.records;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;

import ru.yusdm.technics.f.jooq.autogenerated.tables.JBook;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JBookRecord extends UpdatableRecordImpl<JBookRecord> implements Record2<Long, String> {

    private static final long serialVersionUID = -704271716;

    /**
     * Setter for <code>public.book.id</code>.
     */
    public JBookRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.book.id</code>.
     */
    @NotNull
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.book.name</code>.
     */
    public JBookRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.book.name</code>.
     */
    @Size(max = 255)
    public String getName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Long, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return JBook.BOOK.ID;
    }

    @Override
    public Field<String> field2() {
        return JBook.BOOK.NAME;
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
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public JBookRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public JBookRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public JBookRecord values(Long value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JBookRecord
     */
    public JBookRecord() {
        super(JBook.BOOK);
    }

    /**
     * Create a detached, initialised JBookRecord
     */
    public JBookRecord(Long id, String name) {
        super(JBook.BOOK);

        set(0, id);
        set(1, name);
    }
}
