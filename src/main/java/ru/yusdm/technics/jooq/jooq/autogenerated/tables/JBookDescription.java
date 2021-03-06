/*
 * This file is generated by jOOQ.
 */
package ru.yusdm.technics.jooq.jooq.autogenerated.tables;


import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import ru.yusdm.technics.jooq.jooq.autogenerated.JPublic;
import ru.yusdm.technics.jooq.jooq.autogenerated.Keys;
import ru.yusdm.technics.jooq.jooq.autogenerated.tables.records.JBookDescriptionRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JBookDescription extends TableImpl<JBookDescriptionRecord> {

    private static final long serialVersionUID = 292757618;

    /**
     * The reference instance of <code>public.book_description</code>
     */
    public static final JBookDescription BOOK_DESCRIPTION = new JBookDescription();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JBookDescriptionRecord> getRecordType() {
        return JBookDescriptionRecord.class;
    }

    /**
     * The column <code>public.book_description.description</code>.
     */
    public final TableField<JBookDescriptionRecord, String> DESCRIPTION = createField(DSL.name("description"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.book_description.book_id</code>.
     */
    public final TableField<JBookDescriptionRecord, Long> BOOK_ID = createField(DSL.name("book_id"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>public.book_description</code> table reference
     */
    public JBookDescription() {
        this(DSL.name("book_description"), null);
    }

    /**
     * Create an aliased <code>public.book_description</code> table reference
     */
    public JBookDescription(String alias) {
        this(DSL.name(alias), BOOK_DESCRIPTION);
    }

    /**
     * Create an aliased <code>public.book_description</code> table reference
     */
    public JBookDescription(Name alias) {
        this(alias, BOOK_DESCRIPTION);
    }

    private JBookDescription(Name alias, Table<JBookDescriptionRecord> aliased) {
        this(alias, aliased, null);
    }

    private JBookDescription(Name alias, Table<JBookDescriptionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> JBookDescription(Table<O> child, ForeignKey<O, JBookDescriptionRecord> key) {
        super(child, key, BOOK_DESCRIPTION);
    }

    @Override
    public Schema getSchema() {
        return JPublic.PUBLIC;
    }

    @Override
    public UniqueKey<JBookDescriptionRecord> getPrimaryKey() {
        return Keys.BOOK_DESCRIPTION_PKEY;
    }

    @Override
    public List<UniqueKey<JBookDescriptionRecord>> getKeys() {
        return Arrays.<UniqueKey<JBookDescriptionRecord>>asList(Keys.BOOK_DESCRIPTION_PKEY);
    }

    @Override
    public List<ForeignKey<JBookDescriptionRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<JBookDescriptionRecord, ?>>asList(Keys.BOOK_DESCRIPTION__FKH16RLDAUN98KPAGN9Q4QGD7S9);
    }

    public JBook book() {
        return new JBook(this, Keys.BOOK_DESCRIPTION__FKH16RLDAUN98KPAGN9Q4QGD7S9);
    }

    @Override
    public JBookDescription as(String alias) {
        return new JBookDescription(DSL.name(alias), this);
    }

    @Override
    public JBookDescription as(Name alias) {
        return new JBookDescription(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public JBookDescription rename(String name) {
        return new JBookDescription(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JBookDescription rename(Name name) {
        return new JBookDescription(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, Long> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
