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

import ru.yusdm.technics.f.jooq.autogenerated.tables.JBookDescription;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JBookDescriptionRecord extends UpdatableRecordImpl<JBookDescriptionRecord> implements Record2<String, Long> {

    private static final long serialVersionUID = -674403771;

    /**
     * Setter for <code>public.book_description.description</code>.
     */
    public JBookDescriptionRecord setDescription(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.book_description.description</code>.
     */
    @Size(max = 255)
    public String getDescription() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.book_description.book_id</code>.
     */
    public JBookDescriptionRecord setBookId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.book_description.book_id</code>.
     */
    @NotNull
    public Long getBookId() {
        return (Long) get(1);
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
    public Row2<String, Long> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, Long> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return JBookDescription.BOOK_DESCRIPTION.DESCRIPTION;
    }

    @Override
    public Field<Long> field2() {
        return JBookDescription.BOOK_DESCRIPTION.BOOK_ID;
    }

    @Override
    public String component1() {
        return getDescription();
    }

    @Override
    public Long component2() {
        return getBookId();
    }

    @Override
    public String value1() {
        return getDescription();
    }

    @Override
    public Long value2() {
        return getBookId();
    }

    @Override
    public JBookDescriptionRecord value1(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public JBookDescriptionRecord value2(Long value) {
        setBookId(value);
        return this;
    }

    @Override
    public JBookDescriptionRecord values(String value1, Long value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JBookDescriptionRecord
     */
    public JBookDescriptionRecord() {
        super(JBookDescription.BOOK_DESCRIPTION);
    }

    /**
     * Create a detached, initialised JBookDescriptionRecord
     */
    public JBookDescriptionRecord(String description, Long bookId) {
        super(JBookDescription.BOOK_DESCRIPTION);

        set(0, description);
        set(1, bookId);
    }
}
