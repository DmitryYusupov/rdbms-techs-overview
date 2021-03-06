/*
 * This file is generated by jOOQ.
 */
package ru.yusdm.technics.jooq.jooq.autogenerated;


import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import ru.yusdm.technics.jooq.jooq.autogenerated.tables.JBook;
import ru.yusdm.technics.jooq.jooq.autogenerated.tables.JBookDescription;
import ru.yusdm.technics.jooq.jooq.autogenerated.tables.JCity;
import ru.yusdm.technics.jooq.jooq.autogenerated.tables.JCountry;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JPublic extends SchemaImpl {

    private static final long serialVersionUID = 1026880526;

    /**
     * The reference instance of <code>public</code>
     */
    public static final JPublic PUBLIC = new JPublic();

    /**
     * The table <code>public.book</code>.
     */
    public final JBook BOOK = JBook.BOOK;

    /**
     * The table <code>public.book_description</code>.
     */
    public final JBookDescription BOOK_DESCRIPTION = JBookDescription.BOOK_DESCRIPTION;

    /**
     * The table <code>public.city</code>.
     */
    public final JCity CITY = JCity.CITY;

    /**
     * The table <code>public.country</code>.
     */
    public final JCountry COUNTRY = JCountry.COUNTRY;

    /**
     * No further instances allowed
     */
    private JPublic() {
        super("public", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        return Arrays.<Sequence<?>>asList(
            Sequences.HIBERNATE_SEQUENCE);
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            JBook.BOOK,
            JBookDescription.BOOK_DESCRIPTION,
            JCity.CITY,
            JCountry.COUNTRY);
    }
}
