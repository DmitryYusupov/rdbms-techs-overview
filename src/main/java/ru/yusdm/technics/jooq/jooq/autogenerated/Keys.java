/*
 * This file is generated by jOOQ.
 */
package ru.yusdm.technics.jooq.jooq.autogenerated;


import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;

import ru.yusdm.technics.jooq.jooq.autogenerated.tables.JBook;
import ru.yusdm.technics.jooq.jooq.autogenerated.tables.JBookDescription;
import ru.yusdm.technics.jooq.jooq.autogenerated.tables.JCity;
import ru.yusdm.technics.jooq.jooq.autogenerated.tables.JCountry;
import ru.yusdm.technics.jooq.jooq.autogenerated.tables.records.JBookDescriptionRecord;
import ru.yusdm.technics.jooq.jooq.autogenerated.tables.records.JBookRecord;
import ru.yusdm.technics.jooq.jooq.autogenerated.tables.records.JCityRecord;
import ru.yusdm.technics.jooq.jooq.autogenerated.tables.records.JCountryRecord;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>public</code> schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<JCityRecord, Long> IDENTITY_CITY = Identities0.IDENTITY_CITY;
    public static final Identity<JCountryRecord, Long> IDENTITY_COUNTRY = Identities0.IDENTITY_COUNTRY;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<JBookRecord> BOOK_PKEY = UniqueKeys0.BOOK_PKEY;
    public static final UniqueKey<JBookDescriptionRecord> BOOK_DESCRIPTION_PKEY = UniqueKeys0.BOOK_DESCRIPTION_PKEY;
    public static final UniqueKey<JCityRecord> CITY_PKEY = UniqueKeys0.CITY_PKEY;
    public static final UniqueKey<JCountryRecord> COUNTRY_PKEY = UniqueKeys0.COUNTRY_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<JBookDescriptionRecord, JBookRecord> BOOK_DESCRIPTION__FKH16RLDAUN98KPAGN9Q4QGD7S9 = ForeignKeys0.BOOK_DESCRIPTION__FKH16RLDAUN98KPAGN9Q4QGD7S9;
    public static final ForeignKey<JCityRecord, JCountryRecord> CITY__FKRPD7J1P7YXR784ADKX4PYEPBA = ForeignKeys0.CITY__FKRPD7J1P7YXR784ADKX4PYEPBA;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<JCityRecord, Long> IDENTITY_CITY = Internal.createIdentity(JCity.CITY, JCity.CITY.ID);
        public static Identity<JCountryRecord, Long> IDENTITY_COUNTRY = Internal.createIdentity(JCountry.COUNTRY, JCountry.COUNTRY.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<JBookRecord> BOOK_PKEY = Internal.createUniqueKey(JBook.BOOK, "book_pkey", new TableField[] { JBook.BOOK.ID }, true);
        public static final UniqueKey<JBookDescriptionRecord> BOOK_DESCRIPTION_PKEY = Internal.createUniqueKey(JBookDescription.BOOK_DESCRIPTION, "book_description_pkey", new TableField[] { JBookDescription.BOOK_DESCRIPTION.BOOK_ID }, true);
        public static final UniqueKey<JCityRecord> CITY_PKEY = Internal.createUniqueKey(JCity.CITY, "city_pkey", new TableField[] { JCity.CITY.ID }, true);
        public static final UniqueKey<JCountryRecord> COUNTRY_PKEY = Internal.createUniqueKey(JCountry.COUNTRY, "country_pkey", new TableField[] { JCountry.COUNTRY.ID }, true);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<JBookDescriptionRecord, JBookRecord> BOOK_DESCRIPTION__FKH16RLDAUN98KPAGN9Q4QGD7S9 = Internal.createForeignKey(Keys.BOOK_PKEY, JBookDescription.BOOK_DESCRIPTION, "fkh16rldaun98kpagn9q4qgd7s9", new TableField[] { JBookDescription.BOOK_DESCRIPTION.BOOK_ID }, true);
        public static final ForeignKey<JCityRecord, JCountryRecord> CITY__FKRPD7J1P7YXR784ADKX4PYEPBA = Internal.createForeignKey(Keys.COUNTRY_PKEY, JCity.CITY, "fkrpd7j1p7yxr784adkx4pyepba", new TableField[] { JCity.CITY.COUNTRY_ID }, true);
    }
}
