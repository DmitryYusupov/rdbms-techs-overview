/*
 * This file is generated by jOOQ.
 */
package ru.yusdm.technics.jooq.jooq.autogenerated.tables.daos;


import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;

import ru.yusdm.technics.jooq.jooq.autogenerated.tables.JCity;
import ru.yusdm.technics.jooq.jooq.autogenerated.tables.pojos.JpjCity;
import ru.yusdm.technics.jooq.jooq.autogenerated.tables.records.JCityRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JCityDao extends DAOImpl<JCityRecord, JpjCity, Long> {

    /**
     * Create a new JCityDao without any configuration
     */
    public JCityDao() {
        super(JCity.CITY, JpjCity.class);
    }

    /**
     * Create a new JCityDao with an attached configuration
     */
    public JCityDao(Configuration configuration) {
        super(JCity.CITY, JpjCity.class, configuration);
    }

    @Override
    public Long getId(JpjCity object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JpjCity> fetchRangeOfJId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(JCity.CITY.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<JpjCity> fetchByJId(Long... values) {
        return fetch(JCity.CITY.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public JpjCity fetchOneByJId(Long value) {
        return fetchOne(JCity.CITY.ID, value);
    }

    /**
     * Fetch records that have <code>main_street BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JpjCity> fetchRangeOfJMainStreet(String lowerInclusive, String upperInclusive) {
        return fetchRange(JCity.CITY.MAIN_STREET, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>main_street IN (values)</code>
     */
    public List<JpjCity> fetchByJMainStreet(String... values) {
        return fetch(JCity.CITY.MAIN_STREET, values);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JpjCity> fetchRangeOfJName(String lowerInclusive, String upperInclusive) {
        return fetchRange(JCity.CITY.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<JpjCity> fetchByJName(String... values) {
        return fetch(JCity.CITY.NAME, values);
    }

    /**
     * Fetch records that have <code>country_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<JpjCity> fetchRangeOfJCountryId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(JCity.CITY.COUNTRY_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>country_id IN (values)</code>
     */
    public List<JpjCity> fetchByJCountryId(Long... values) {
        return fetch(JCity.CITY.COUNTRY_ID, values);
    }
}
