package com.api.contract.management.dto.datatable;

import com.api.contract.management.common.util.ObjectMapperUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The Class DataTableResults.
 *
 * @author pavan.solapure
 * @param <T> the generic type
 */
public class DataTableResults<T> {

    /** The draw. */
    private String draw;

    /** The records filtered. */
    private String recordsFiltered;

    /** The records total. */
    private String recordsTotal;

    /** The list of data objects. */
    @JsonProperty("data")
    List<T> listOfDataObjects;

    @JsonIgnore
    public String getJson() {
        return ObjectMapperUtil.convertToString(this);
    }

    /**
     * Gets the draw.
     *
     * @return the draw
     */
    public String getDraw() {
        return draw;
    }

    /**
     * Sets the draw.
     *
     * @param draw the draw to set
     */
    public void setDraw(String draw) {
        this.draw = draw;
    }

    /**
     * Gets the records filtered.
     *
     * @return the recordsFiltered
     */
    public String getRecordsFiltered() {
        return recordsFiltered;
    }

    /**
     * Sets the records filtered.
     *
     * @param recordsFiltered the recordsFiltered to set
     */
    public void setRecordsFiltered(String recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    /**
     * Gets the records total.
     *
     * @return the recordsTotal
     */
    public String getRecordsTotal() {
        return recordsTotal;
    }

    /**
     * Sets the records total.
     *
     * @param recordsTotal the recordsTotal to set
     */
    public void setRecordsTotal(String recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    /**
     * Gets the list of data objects.
     *
     * @return the listOfDataObjects
     */
    public List<T> getListOfDataObjects() {
        return listOfDataObjects;
    }

    /**
     * Sets the list of data objects.
     *
     * @param listOfDataObjects the listOfDataObjects to set
     */
    public void setListOfDataObjects(List<T> listOfDataObjects) {
        this.listOfDataObjects = listOfDataObjects;
    }

}
