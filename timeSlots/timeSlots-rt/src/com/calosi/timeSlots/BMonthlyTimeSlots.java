package com.calosi.timeSlots;

import javax.baja.collection.BITable;
import javax.baja.collection.Column;
import javax.baja.collection.TableCursor;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.schedule.BAbstractSchedule;
import javax.baja.schedule.BCalendarSchedule;
import javax.baja.schedule.BDateSchedule;
import javax.baja.status.BStatusNumeric;
import javax.baja.sys.*;
import javax.baja.units.BUnit;
import javax.baja.util.BTimeRange;
import java.util.Arrays;

@NiagaraProperty(name = "enerE", type = "BOrd", defaultValue = "BOrd.make(\"history:/\")")
@NiagaraProperty(name = "potE", type = "BOrd", defaultValue = "BOrd.make(\"history:/\")")
@NiagaraProperty(name = "genF1", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "genF2", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "genF3", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "genPotE", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt\"), 2)")})
@NiagaraProperty(name = "febF1", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "febF2", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "febF3", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "febPotE", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt\"), 2)")})
@NiagaraProperty(name = "marF1", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "marF2", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "marF3", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "marPotE", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt\"), 2)")})
@NiagaraProperty(name = "aprF1", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "aprF2", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "aprF3", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "aprPotE", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt\"), 2)")})
@NiagaraProperty(name = "magF1", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "magF2", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "magF3", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "magPotE", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt\"), 2)")})
@NiagaraProperty(name = "giuF1", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "giuF2", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "giuF3", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "giuPotE", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt\"), 2)")})
@NiagaraProperty(name = "lugF1", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "lugF2", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "lugF3", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "lugPotE", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt\"), 2)")})
@NiagaraProperty(name = "agoF1", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "agoF2", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "agoF3", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "agoPotE", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt\"), 2)")})
@NiagaraProperty(name = "setF1", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "setF2", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "setF3", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "setPotE", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt\"), 2)")})
@NiagaraProperty(name = "ottF1", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "ottF2", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "ottF3", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "ottPotE", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt\"), 2)")})
@NiagaraProperty(name = "novF1", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "novF2", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "novF3", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "novPotE", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt\"), 2)")})
@NiagaraProperty(name = "dicF1", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "dicF2", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "dicF3", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt hour\"), 2)")})
@NiagaraProperty(name = "dicPotE", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()", facets = {@Facet(value = "BFacets.makeNumeric(BUnit.getUnit(\"kilowatt\"), 2)")})
@NiagaraProperty(name = "giornoAttuale", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()")
@NiagaraProperty(name = "giorniMese", type = "BStatusNumeric", flags = Flags.READONLY, defaultValue = "new BStatusNumeric()")
@NiagaraProperty(name = "wdFascia1", type = "BTimeRange", flags = Flags.HIDDEN, defaultValue = "new BTimeRange(BTime.make(8, 1, 0), BTime.make(19, 1, 0))")
@NiagaraProperty(name = "wdFascia21", type = "BTimeRange", flags = Flags.HIDDEN, defaultValue = "new BTimeRange(BTime.make(7, 1, 0), BTime.make(8, 1, 0))")
@NiagaraProperty(name = "wdFascia22", type = "BTimeRange", flags = Flags.HIDDEN, defaultValue = "new BTimeRange(BTime.make(19, 1, 0), BTime.make(23, 1, 0))")
@NiagaraProperty(name = "saturdayFascia2", type = "BTimeRange", flags = Flags.HIDDEN, defaultValue = "new BTimeRange(BTime.make(7, 1, 0), BTime.make(23, 1, 0))")
@NiagaraProperty(name = "wdFascia31", type = "BTimeRange", flags = Flags.HIDDEN, defaultValue = "new BTimeRange(BTime.make(0, 1, 0), BTime.make(7, 1, 0))")
@NiagaraProperty(name = "wdFascia32", type = "BTimeRange", flags = Flags.HIDDEN, defaultValue = "new BTimeRange(BTime.make(23, 1, 0), BTime.make(23, 59, 0))")
@NiagaraProperty(name = "saturdayFascia31", type = "BTimeRange", flags = Flags.HIDDEN, defaultValue = "new BTimeRange(BTime.make(0, 1, 0), BTime.make(7, 1, 0))")
@NiagaraProperty(name = "saturdayFascia32", type = "BTimeRange", flags = Flags.HIDDEN, defaultValue = "new BTimeRange(BTime.make(23, 1, 0), BTime.make(23, 59, 0))")
@NiagaraProperty(name = "sundayFascia3", type = "BTimeRange", flags = Flags.HIDDEN, defaultValue = "new BTimeRange(BTime.make(0, 1, 0), BTime.make(23, 59, 0))")
@NiagaraProperty(name = "reset", type = "BBoolean", flags = Flags.HIDDEN, defaultValue = "BBoolean.make(false)")
@NiagaraProperty(name = "feste", type = "BCalendarSchedule", defaultValue = "new BCalendarSchedule()")
@NiagaraAction(name = "calculate")
@NiagaraType
public class BMonthlyTimeSlots extends BComponent {
    /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
    /*@ $com.calosi.timeSlots.BMonthlyTimeSlots(3559970928)1.0$ @*/
    /* Generated Fri Jul 23 12:00:22 CEST 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "enerE"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code enerE} property.
     *
     * @see #getEnerE
     * @see #setEnerE
     */
    public static final Property enerE = newProperty(0, BOrd.make("history:/"), null);

    /**
     * Get the {@code enerE} property.
     *
     * @see #enerE
     */
    public BOrd getEnerE() {
        return (BOrd) get(enerE);
    }

    /**
     * Set the {@code enerE} property.
     *
     * @see #enerE
     */
    public void setEnerE(BOrd v) {
        set(enerE, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "potE"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code potE} property.
     *
     * @see #getPotE
     * @see #setPotE
     */
    public static final Property potE = newProperty(0, BOrd.make("history:/"), null);

    /**
     * Get the {@code potE} property.
     *
     * @see #potE
     */
    public BOrd getPotE() {
        return (BOrd) get(potE);
    }

    /**
     * Set the {@code potE} property.
     *
     * @see #potE
     */
    public void setPotE(BOrd v) {
        set(potE, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "genF1"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code genF1} property.
     *
     * @see #getGenF1
     * @see #setGenF1
     */
    public static final Property genF1 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code genF1} property.
     *
     * @see #genF1
     */
    public BStatusNumeric getGenF1() {
        return (BStatusNumeric) get(genF1);
    }

    /**
     * Set the {@code genF1} property.
     *
     * @see #genF1
     */
    public void setGenF1(BStatusNumeric v) {
        set(genF1, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "genF2"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code genF2} property.
     *
     * @see #getGenF2
     * @see #setGenF2
     */
    public static final Property genF2 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code genF2} property.
     *
     * @see #genF2
     */
    public BStatusNumeric getGenF2() {
        return (BStatusNumeric) get(genF2);
    }

    /**
     * Set the {@code genF2} property.
     *
     * @see #genF2
     */
    public void setGenF2(BStatusNumeric v) {
        set(genF2, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "genF3"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code genF3} property.
     *
     * @see #getGenF3
     * @see #setGenF3
     */
    public static final Property genF3 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code genF3} property.
     *
     * @see #genF3
     */
    public BStatusNumeric getGenF3() {
        return (BStatusNumeric) get(genF3);
    }

    /**
     * Set the {@code genF3} property.
     *
     * @see #genF3
     */
    public void setGenF3(BStatusNumeric v) {
        set(genF3, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "genPotE"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code genPotE} property.
     *
     * @see #getGenPotE
     * @see #setGenPotE
     */
    public static final Property genPotE = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt"), 2));

    /**
     * Get the {@code genPotE} property.
     *
     * @see #genPotE
     */
    public BStatusNumeric getGenPotE() {
        return (BStatusNumeric) get(genPotE);
    }

    /**
     * Set the {@code genPotE} property.
     *
     * @see #genPotE
     */
    public void setGenPotE(BStatusNumeric v) {
        set(genPotE, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "febF1"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code febF1} property.
     *
     * @see #getFebF1
     * @see #setFebF1
     */
    public static final Property febF1 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code febF1} property.
     *
     * @see #febF1
     */
    public BStatusNumeric getFebF1() {
        return (BStatusNumeric) get(febF1);
    }

    /**
     * Set the {@code febF1} property.
     *
     * @see #febF1
     */
    public void setFebF1(BStatusNumeric v) {
        set(febF1, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "febF2"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code febF2} property.
     *
     * @see #getFebF2
     * @see #setFebF2
     */
    public static final Property febF2 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code febF2} property.
     *
     * @see #febF2
     */
    public BStatusNumeric getFebF2() {
        return (BStatusNumeric) get(febF2);
    }

    /**
     * Set the {@code febF2} property.
     *
     * @see #febF2
     */
    public void setFebF2(BStatusNumeric v) {
        set(febF2, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "febF3"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code febF3} property.
     *
     * @see #getFebF3
     * @see #setFebF3
     */
    public static final Property febF3 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code febF3} property.
     *
     * @see #febF3
     */
    public BStatusNumeric getFebF3() {
        return (BStatusNumeric) get(febF3);
    }

    /**
     * Set the {@code febF3} property.
     *
     * @see #febF3
     */
    public void setFebF3(BStatusNumeric v) {
        set(febF3, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "febPotE"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code febPotE} property.
     *
     * @see #getFebPotE
     * @see #setFebPotE
     */
    public static final Property febPotE = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt"), 2));

    /**
     * Get the {@code febPotE} property.
     *
     * @see #febPotE
     */
    public BStatusNumeric getFebPotE() {
        return (BStatusNumeric) get(febPotE);
    }

    /**
     * Set the {@code febPotE} property.
     *
     * @see #febPotE
     */
    public void setFebPotE(BStatusNumeric v) {
        set(febPotE, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "marF1"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code marF1} property.
     *
     * @see #getMarF1
     * @see #setMarF1
     */
    public static final Property marF1 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code marF1} property.
     *
     * @see #marF1
     */
    public BStatusNumeric getMarF1() {
        return (BStatusNumeric) get(marF1);
    }

    /**
     * Set the {@code marF1} property.
     *
     * @see #marF1
     */
    public void setMarF1(BStatusNumeric v) {
        set(marF1, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "marF2"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code marF2} property.
     *
     * @see #getMarF2
     * @see #setMarF2
     */
    public static final Property marF2 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code marF2} property.
     *
     * @see #marF2
     */
    public BStatusNumeric getMarF2() {
        return (BStatusNumeric) get(marF2);
    }

    /**
     * Set the {@code marF2} property.
     *
     * @see #marF2
     */
    public void setMarF2(BStatusNumeric v) {
        set(marF2, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "marF3"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code marF3} property.
     *
     * @see #getMarF3
     * @see #setMarF3
     */
    public static final Property marF3 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code marF3} property.
     *
     * @see #marF3
     */
    public BStatusNumeric getMarF3() {
        return (BStatusNumeric) get(marF3);
    }

    /**
     * Set the {@code marF3} property.
     *
     * @see #marF3
     */
    public void setMarF3(BStatusNumeric v) {
        set(marF3, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "marPotE"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code marPotE} property.
     *
     * @see #getMarPotE
     * @see #setMarPotE
     */
    public static final Property marPotE = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt"), 2));

    /**
     * Get the {@code marPotE} property.
     *
     * @see #marPotE
     */
    public BStatusNumeric getMarPotE() {
        return (BStatusNumeric) get(marPotE);
    }

    /**
     * Set the {@code marPotE} property.
     *
     * @see #marPotE
     */
    public void setMarPotE(BStatusNumeric v) {
        set(marPotE, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "aprF1"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code aprF1} property.
     *
     * @see #getAprF1
     * @see #setAprF1
     */
    public static final Property aprF1 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code aprF1} property.
     *
     * @see #aprF1
     */
    public BStatusNumeric getAprF1() {
        return (BStatusNumeric) get(aprF1);
    }

    /**
     * Set the {@code aprF1} property.
     *
     * @see #aprF1
     */
    public void setAprF1(BStatusNumeric v) {
        set(aprF1, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "aprF2"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code aprF2} property.
     *
     * @see #getAprF2
     * @see #setAprF2
     */
    public static final Property aprF2 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code aprF2} property.
     *
     * @see #aprF2
     */
    public BStatusNumeric getAprF2() {
        return (BStatusNumeric) get(aprF2);
    }

    /**
     * Set the {@code aprF2} property.
     *
     * @see #aprF2
     */
    public void setAprF2(BStatusNumeric v) {
        set(aprF2, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "aprF3"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code aprF3} property.
     *
     * @see #getAprF3
     * @see #setAprF3
     */
    public static final Property aprF3 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code aprF3} property.
     *
     * @see #aprF3
     */
    public BStatusNumeric getAprF3() {
        return (BStatusNumeric) get(aprF3);
    }

    /**
     * Set the {@code aprF3} property.
     *
     * @see #aprF3
     */
    public void setAprF3(BStatusNumeric v) {
        set(aprF3, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "aprPotE"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code aprPotE} property.
     *
     * @see #getAprPotE
     * @see #setAprPotE
     */
    public static final Property aprPotE = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt"), 2));

    /**
     * Get the {@code aprPotE} property.
     *
     * @see #aprPotE
     */
    public BStatusNumeric getAprPotE() {
        return (BStatusNumeric) get(aprPotE);
    }

    /**
     * Set the {@code aprPotE} property.
     *
     * @see #aprPotE
     */
    public void setAprPotE(BStatusNumeric v) {
        set(aprPotE, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "magF1"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code magF1} property.
     *
     * @see #getMagF1
     * @see #setMagF1
     */
    public static final Property magF1 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code magF1} property.
     *
     * @see #magF1
     */
    public BStatusNumeric getMagF1() {
        return (BStatusNumeric) get(magF1);
    }

    /**
     * Set the {@code magF1} property.
     *
     * @see #magF1
     */
    public void setMagF1(BStatusNumeric v) {
        set(magF1, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "magF2"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code magF2} property.
     *
     * @see #getMagF2
     * @see #setMagF2
     */
    public static final Property magF2 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code magF2} property.
     *
     * @see #magF2
     */
    public BStatusNumeric getMagF2() {
        return (BStatusNumeric) get(magF2);
    }

    /**
     * Set the {@code magF2} property.
     *
     * @see #magF2
     */
    public void setMagF2(BStatusNumeric v) {
        set(magF2, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "magF3"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code magF3} property.
     *
     * @see #getMagF3
     * @see #setMagF3
     */
    public static final Property magF3 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code magF3} property.
     *
     * @see #magF3
     */
    public BStatusNumeric getMagF3() {
        return (BStatusNumeric) get(magF3);
    }

    /**
     * Set the {@code magF3} property.
     *
     * @see #magF3
     */
    public void setMagF3(BStatusNumeric v) {
        set(magF3, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "magPotE"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code magPotE} property.
     *
     * @see #getMagPotE
     * @see #setMagPotE
     */
    public static final Property magPotE = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt"), 2));

    /**
     * Get the {@code magPotE} property.
     *
     * @see #magPotE
     */
    public BStatusNumeric getMagPotE() {
        return (BStatusNumeric) get(magPotE);
    }

    /**
     * Set the {@code magPotE} property.
     *
     * @see #magPotE
     */
    public void setMagPotE(BStatusNumeric v) {
        set(magPotE, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "giuF1"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code giuF1} property.
     *
     * @see #getGiuF1
     * @see #setGiuF1
     */
    public static final Property giuF1 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code giuF1} property.
     *
     * @see #giuF1
     */
    public BStatusNumeric getGiuF1() {
        return (BStatusNumeric) get(giuF1);
    }

    /**
     * Set the {@code giuF1} property.
     *
     * @see #giuF1
     */
    public void setGiuF1(BStatusNumeric v) {
        set(giuF1, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "giuF2"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code giuF2} property.
     *
     * @see #getGiuF2
     * @see #setGiuF2
     */
    public static final Property giuF2 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code giuF2} property.
     *
     * @see #giuF2
     */
    public BStatusNumeric getGiuF2() {
        return (BStatusNumeric) get(giuF2);
    }

    /**
     * Set the {@code giuF2} property.
     *
     * @see #giuF2
     */
    public void setGiuF2(BStatusNumeric v) {
        set(giuF2, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "giuF3"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code giuF3} property.
     *
     * @see #getGiuF3
     * @see #setGiuF3
     */
    public static final Property giuF3 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code giuF3} property.
     *
     * @see #giuF3
     */
    public BStatusNumeric getGiuF3() {
        return (BStatusNumeric) get(giuF3);
    }

    /**
     * Set the {@code giuF3} property.
     *
     * @see #giuF3
     */
    public void setGiuF3(BStatusNumeric v) {
        set(giuF3, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "giuPotE"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code giuPotE} property.
     *
     * @see #getGiuPotE
     * @see #setGiuPotE
     */
    public static final Property giuPotE = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt"), 2));

    /**
     * Get the {@code giuPotE} property.
     *
     * @see #giuPotE
     */
    public BStatusNumeric getGiuPotE() {
        return (BStatusNumeric) get(giuPotE);
    }

    /**
     * Set the {@code giuPotE} property.
     *
     * @see #giuPotE
     */
    public void setGiuPotE(BStatusNumeric v) {
        set(giuPotE, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "lugF1"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code lugF1} property.
     *
     * @see #getLugF1
     * @see #setLugF1
     */
    public static final Property lugF1 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code lugF1} property.
     *
     * @see #lugF1
     */
    public BStatusNumeric getLugF1() {
        return (BStatusNumeric) get(lugF1);
    }

    /**
     * Set the {@code lugF1} property.
     *
     * @see #lugF1
     */
    public void setLugF1(BStatusNumeric v) {
        set(lugF1, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "lugF2"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code lugF2} property.
     *
     * @see #getLugF2
     * @see #setLugF2
     */
    public static final Property lugF2 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code lugF2} property.
     *
     * @see #lugF2
     */
    public BStatusNumeric getLugF2() {
        return (BStatusNumeric) get(lugF2);
    }

    /**
     * Set the {@code lugF2} property.
     *
     * @see #lugF2
     */
    public void setLugF2(BStatusNumeric v) {
        set(lugF2, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "lugF3"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code lugF3} property.
     *
     * @see #getLugF3
     * @see #setLugF3
     */
    public static final Property lugF3 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code lugF3} property.
     *
     * @see #lugF3
     */
    public BStatusNumeric getLugF3() {
        return (BStatusNumeric) get(lugF3);
    }

    /**
     * Set the {@code lugF3} property.
     *
     * @see #lugF3
     */
    public void setLugF3(BStatusNumeric v) {
        set(lugF3, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "lugPotE"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code lugPotE} property.
     *
     * @see #getLugPotE
     * @see #setLugPotE
     */
    public static final Property lugPotE = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt"), 2));

    /**
     * Get the {@code lugPotE} property.
     *
     * @see #lugPotE
     */
    public BStatusNumeric getLugPotE() {
        return (BStatusNumeric) get(lugPotE);
    }

    /**
     * Set the {@code lugPotE} property.
     *
     * @see #lugPotE
     */
    public void setLugPotE(BStatusNumeric v) {
        set(lugPotE, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "agoF1"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code agoF1} property.
     *
     * @see #getAgoF1
     * @see #setAgoF1
     */
    public static final Property agoF1 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code agoF1} property.
     *
     * @see #agoF1
     */
    public BStatusNumeric getAgoF1() {
        return (BStatusNumeric) get(agoF1);
    }

    /**
     * Set the {@code agoF1} property.
     *
     * @see #agoF1
     */
    public void setAgoF1(BStatusNumeric v) {
        set(agoF1, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "agoF2"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code agoF2} property.
     *
     * @see #getAgoF2
     * @see #setAgoF2
     */
    public static final Property agoF2 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code agoF2} property.
     *
     * @see #agoF2
     */
    public BStatusNumeric getAgoF2() {
        return (BStatusNumeric) get(agoF2);
    }

    /**
     * Set the {@code agoF2} property.
     *
     * @see #agoF2
     */
    public void setAgoF2(BStatusNumeric v) {
        set(agoF2, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "agoF3"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code agoF3} property.
     *
     * @see #getAgoF3
     * @see #setAgoF3
     */
    public static final Property agoF3 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code agoF3} property.
     *
     * @see #agoF3
     */
    public BStatusNumeric getAgoF3() {
        return (BStatusNumeric) get(agoF3);
    }

    /**
     * Set the {@code agoF3} property.
     *
     * @see #agoF3
     */
    public void setAgoF3(BStatusNumeric v) {
        set(agoF3, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "agoPotE"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code agoPotE} property.
     *
     * @see #getAgoPotE
     * @see #setAgoPotE
     */
    public static final Property agoPotE = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt"), 2));

    /**
     * Get the {@code agoPotE} property.
     *
     * @see #agoPotE
     */
    public BStatusNumeric getAgoPotE() {
        return (BStatusNumeric) get(agoPotE);
    }

    /**
     * Set the {@code agoPotE} property.
     *
     * @see #agoPotE
     */
    public void setAgoPotE(BStatusNumeric v) {
        set(agoPotE, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "setF1"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code setF1} property.
     *
     * @see #getSetF1
     * @see #setSetF1
     */
    public static final Property setF1 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code setF1} property.
     *
     * @see #setF1
     */
    public BStatusNumeric getSetF1() {
        return (BStatusNumeric) get(setF1);
    }

    /**
     * Set the {@code setF1} property.
     *
     * @see #setF1
     */
    public void setSetF1(BStatusNumeric v) {
        set(setF1, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "setF2"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code setF2} property.
     *
     * @see #getSetF2
     * @see #setSetF2
     */
    public static final Property setF2 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code setF2} property.
     *
     * @see #setF2
     */
    public BStatusNumeric getSetF2() {
        return (BStatusNumeric) get(setF2);
    }

    /**
     * Set the {@code setF2} property.
     *
     * @see #setF2
     */
    public void setSetF2(BStatusNumeric v) {
        set(setF2, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "setF3"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code setF3} property.
     *
     * @see #getSetF3
     * @see #setSetF3
     */
    public static final Property setF3 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code setF3} property.
     *
     * @see #setF3
     */
    public BStatusNumeric getSetF3() {
        return (BStatusNumeric) get(setF3);
    }

    /**
     * Set the {@code setF3} property.
     *
     * @see #setF3
     */
    public void setSetF3(BStatusNumeric v) {
        set(setF3, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "setPotE"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code setPotE} property.
     *
     * @see #getSetPotE
     * @see #setSetPotE
     */
    public static final Property setPotE = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt"), 2));

    /**
     * Get the {@code setPotE} property.
     *
     * @see #setPotE
     */
    public BStatusNumeric getSetPotE() {
        return (BStatusNumeric) get(setPotE);
    }

    /**
     * Set the {@code setPotE} property.
     *
     * @see #setPotE
     */
    public void setSetPotE(BStatusNumeric v) {
        set(setPotE, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "ottF1"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code ottF1} property.
     *
     * @see #getOttF1
     * @see #setOttF1
     */
    public static final Property ottF1 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code ottF1} property.
     *
     * @see #ottF1
     */
    public BStatusNumeric getOttF1() {
        return (BStatusNumeric) get(ottF1);
    }

    /**
     * Set the {@code ottF1} property.
     *
     * @see #ottF1
     */
    public void setOttF1(BStatusNumeric v) {
        set(ottF1, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "ottF2"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code ottF2} property.
     *
     * @see #getOttF2
     * @see #setOttF2
     */
    public static final Property ottF2 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code ottF2} property.
     *
     * @see #ottF2
     */
    public BStatusNumeric getOttF2() {
        return (BStatusNumeric) get(ottF2);
    }

    /**
     * Set the {@code ottF2} property.
     *
     * @see #ottF2
     */
    public void setOttF2(BStatusNumeric v) {
        set(ottF2, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "ottF3"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code ottF3} property.
     *
     * @see #getOttF3
     * @see #setOttF3
     */
    public static final Property ottF3 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code ottF3} property.
     *
     * @see #ottF3
     */
    public BStatusNumeric getOttF3() {
        return (BStatusNumeric) get(ottF3);
    }

    /**
     * Set the {@code ottF3} property.
     *
     * @see #ottF3
     */
    public void setOttF3(BStatusNumeric v) {
        set(ottF3, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "ottPotE"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code ottPotE} property.
     *
     * @see #getOttPotE
     * @see #setOttPotE
     */
    public static final Property ottPotE = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt"), 2));

    /**
     * Get the {@code ottPotE} property.
     *
     * @see #ottPotE
     */
    public BStatusNumeric getOttPotE() {
        return (BStatusNumeric) get(ottPotE);
    }

    /**
     * Set the {@code ottPotE} property.
     *
     * @see #ottPotE
     */
    public void setOttPotE(BStatusNumeric v) {
        set(ottPotE, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "novF1"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code novF1} property.
     *
     * @see #getNovF1
     * @see #setNovF1
     */
    public static final Property novF1 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code novF1} property.
     *
     * @see #novF1
     */
    public BStatusNumeric getNovF1() {
        return (BStatusNumeric) get(novF1);
    }

    /**
     * Set the {@code novF1} property.
     *
     * @see #novF1
     */
    public void setNovF1(BStatusNumeric v) {
        set(novF1, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "novF2"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code novF2} property.
     *
     * @see #getNovF2
     * @see #setNovF2
     */
    public static final Property novF2 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code novF2} property.
     *
     * @see #novF2
     */
    public BStatusNumeric getNovF2() {
        return (BStatusNumeric) get(novF2);
    }

    /**
     * Set the {@code novF2} property.
     *
     * @see #novF2
     */
    public void setNovF2(BStatusNumeric v) {
        set(novF2, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "novF3"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code novF3} property.
     *
     * @see #getNovF3
     * @see #setNovF3
     */
    public static final Property novF3 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code novF3} property.
     *
     * @see #novF3
     */
    public BStatusNumeric getNovF3() {
        return (BStatusNumeric) get(novF3);
    }

    /**
     * Set the {@code novF3} property.
     *
     * @see #novF3
     */
    public void setNovF3(BStatusNumeric v) {
        set(novF3, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "novPotE"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code novPotE} property.
     *
     * @see #getNovPotE
     * @see #setNovPotE
     */
    public static final Property novPotE = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt"), 2));

    /**
     * Get the {@code novPotE} property.
     *
     * @see #novPotE
     */
    public BStatusNumeric getNovPotE() {
        return (BStatusNumeric) get(novPotE);
    }

    /**
     * Set the {@code novPotE} property.
     *
     * @see #novPotE
     */
    public void setNovPotE(BStatusNumeric v) {
        set(novPotE, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "dicF1"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code dicF1} property.
     *
     * @see #getDicF1
     * @see #setDicF1
     */
    public static final Property dicF1 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code dicF1} property.
     *
     * @see #dicF1
     */
    public BStatusNumeric getDicF1() {
        return (BStatusNumeric) get(dicF1);
    }

    /**
     * Set the {@code dicF1} property.
     *
     * @see #dicF1
     */
    public void setDicF1(BStatusNumeric v) {
        set(dicF1, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "dicF2"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code dicF2} property.
     *
     * @see #getDicF2
     * @see #setDicF2
     */
    public static final Property dicF2 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code dicF2} property.
     *
     * @see #dicF2
     */
    public BStatusNumeric getDicF2() {
        return (BStatusNumeric) get(dicF2);
    }

    /**
     * Set the {@code dicF2} property.
     *
     * @see #dicF2
     */
    public void setDicF2(BStatusNumeric v) {
        set(dicF2, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "dicF3"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code dicF3} property.
     *
     * @see #getDicF3
     * @see #setDicF3
     */
    public static final Property dicF3 = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt hour"), 2));

    /**
     * Get the {@code dicF3} property.
     *
     * @see #dicF3
     */
    public BStatusNumeric getDicF3() {
        return (BStatusNumeric) get(dicF3);
    }

    /**
     * Set the {@code dicF3} property.
     *
     * @see #dicF3
     */
    public void setDicF3(BStatusNumeric v) {
        set(dicF3, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "dicPotE"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code dicPotE} property.
     *
     * @see #getDicPotE
     * @see #setDicPotE
     */
    public static final Property dicPotE = newProperty(Flags.READONLY, new BStatusNumeric(), BFacets.makeNumeric(BUnit.getUnit("kilowatt"), 2));

    /**
     * Get the {@code dicPotE} property.
     *
     * @see #dicPotE
     */
    public BStatusNumeric getDicPotE() {
        return (BStatusNumeric) get(dicPotE);
    }

    /**
     * Set the {@code dicPotE} property.
     *
     * @see #dicPotE
     */
    public void setDicPotE(BStatusNumeric v) {
        set(dicPotE, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "giornoAttuale"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code giornoAttuale} property.
     *
     * @see #getGiornoAttuale
     * @see #setGiornoAttuale
     */
    public static final Property giornoAttuale = newProperty(Flags.READONLY, new BStatusNumeric(), null);

    /**
     * Get the {@code giornoAttuale} property.
     *
     * @see #giornoAttuale
     */
    public BStatusNumeric getGiornoAttuale() {
        return (BStatusNumeric) get(giornoAttuale);
    }

    /**
     * Set the {@code giornoAttuale} property.
     *
     * @see #giornoAttuale
     */
    public void setGiornoAttuale(BStatusNumeric v) {
        set(giornoAttuale, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "giorniMese"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code giorniMese} property.
     *
     * @see #getGiorniMese
     * @see #setGiorniMese
     */
    public static final Property giorniMese = newProperty(Flags.READONLY, new BStatusNumeric(), null);

    /**
     * Get the {@code giorniMese} property.
     *
     * @see #giorniMese
     */
    public BStatusNumeric getGiorniMese() {
        return (BStatusNumeric) get(giorniMese);
    }

    /**
     * Set the {@code giorniMese} property.
     *
     * @see #giorniMese
     */
    public void setGiorniMese(BStatusNumeric v) {
        set(giorniMese, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "wdFascia1"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code wdFascia1} property.
     *
     * @see #getWdFascia1
     * @see #setWdFascia1
     */
    public static final Property wdFascia1 = newProperty(Flags.HIDDEN, new BTimeRange(BTime.make(8, 1, 0), BTime.make(19, 1, 0)), null);

    /**
     * Get the {@code wdFascia1} property.
     *
     * @see #wdFascia1
     */
    public BTimeRange getWdFascia1() {
        return (BTimeRange) get(wdFascia1);
    }

    /**
     * Set the {@code wdFascia1} property.
     *
     * @see #wdFascia1
     */
    public void setWdFascia1(BTimeRange v) {
        set(wdFascia1, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "wdFascia21"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code wdFascia21} property.
     *
     * @see #getWdFascia21
     * @see #setWdFascia21
     */
    public static final Property wdFascia21 = newProperty(Flags.HIDDEN, new BTimeRange(BTime.make(7, 1, 0), BTime.make(8, 1, 0)), null);

    /**
     * Get the {@code wdFascia21} property.
     *
     * @see #wdFascia21
     */
    public BTimeRange getWdFascia21() {
        return (BTimeRange) get(wdFascia21);
    }

    /**
     * Set the {@code wdFascia21} property.
     *
     * @see #wdFascia21
     */
    public void setWdFascia21(BTimeRange v) {
        set(wdFascia21, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "wdFascia22"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code wdFascia22} property.
     *
     * @see #getWdFascia22
     * @see #setWdFascia22
     */
    public static final Property wdFascia22 = newProperty(Flags.HIDDEN, new BTimeRange(BTime.make(19, 1, 0), BTime.make(23, 1, 0)), null);

    /**
     * Get the {@code wdFascia22} property.
     *
     * @see #wdFascia22
     */
    public BTimeRange getWdFascia22() {
        return (BTimeRange) get(wdFascia22);
    }

    /**
     * Set the {@code wdFascia22} property.
     *
     * @see #wdFascia22
     */
    public void setWdFascia22(BTimeRange v) {
        set(wdFascia22, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "saturdayFascia2"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code saturdayFascia2} property.
     *
     * @see #getSaturdayFascia2
     * @see #setSaturdayFascia2
     */
    public static final Property saturdayFascia2 = newProperty(Flags.HIDDEN, new BTimeRange(BTime.make(7, 1, 0), BTime.make(23, 1, 0)), null);

    /**
     * Get the {@code saturdayFascia2} property.
     *
     * @see #saturdayFascia2
     */
    public BTimeRange getSaturdayFascia2() {
        return (BTimeRange) get(saturdayFascia2);
    }

    /**
     * Set the {@code saturdayFascia2} property.
     *
     * @see #saturdayFascia2
     */
    public void setSaturdayFascia2(BTimeRange v) {
        set(saturdayFascia2, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "wdFascia31"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code wdFascia31} property.
     *
     * @see #getWdFascia31
     * @see #setWdFascia31
     */
    public static final Property wdFascia31 = newProperty(Flags.HIDDEN, new BTimeRange(BTime.make(0, 1, 0), BTime.make(7, 1, 0)), null);

    /**
     * Get the {@code wdFascia31} property.
     *
     * @see #wdFascia31
     */
    public BTimeRange getWdFascia31() {
        return (BTimeRange) get(wdFascia31);
    }

    /**
     * Set the {@code wdFascia31} property.
     *
     * @see #wdFascia31
     */
    public void setWdFascia31(BTimeRange v) {
        set(wdFascia31, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "wdFascia32"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code wdFascia32} property.
     *
     * @see #getWdFascia32
     * @see #setWdFascia32
     */
    public static final Property wdFascia32 = newProperty(Flags.HIDDEN, new BTimeRange(BTime.make(23, 1, 0), BTime.make(23, 59, 0)), null);

    /**
     * Get the {@code wdFascia32} property.
     *
     * @see #wdFascia32
     */
    public BTimeRange getWdFascia32() {
        return (BTimeRange) get(wdFascia32);
    }

    /**
     * Set the {@code wdFascia32} property.
     *
     * @see #wdFascia32
     */
    public void setWdFascia32(BTimeRange v) {
        set(wdFascia32, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "saturdayFascia31"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code saturdayFascia31} property.
     *
     * @see #getSaturdayFascia31
     * @see #setSaturdayFascia31
     */
    public static final Property saturdayFascia31 = newProperty(Flags.HIDDEN, new BTimeRange(BTime.make(0, 1, 0), BTime.make(7, 1, 0)), null);

    /**
     * Get the {@code saturdayFascia31} property.
     *
     * @see #saturdayFascia31
     */
    public BTimeRange getSaturdayFascia31() {
        return (BTimeRange) get(saturdayFascia31);
    }

    /**
     * Set the {@code saturdayFascia31} property.
     *
     * @see #saturdayFascia31
     */
    public void setSaturdayFascia31(BTimeRange v) {
        set(saturdayFascia31, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "saturdayFascia32"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code saturdayFascia32} property.
     *
     * @see #getSaturdayFascia32
     * @see #setSaturdayFascia32
     */
    public static final Property saturdayFascia32 = newProperty(Flags.HIDDEN, new BTimeRange(BTime.make(23, 1, 0), BTime.make(23, 59, 0)), null);

    /**
     * Get the {@code saturdayFascia32} property.
     *
     * @see #saturdayFascia32
     */
    public BTimeRange getSaturdayFascia32() {
        return (BTimeRange) get(saturdayFascia32);
    }

    /**
     * Set the {@code saturdayFascia32} property.
     *
     * @see #saturdayFascia32
     */
    public void setSaturdayFascia32(BTimeRange v) {
        set(saturdayFascia32, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "sundayFascia3"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code sundayFascia3} property.
     *
     * @see #getSundayFascia3
     * @see #setSundayFascia3
     */
    public static final Property sundayFascia3 = newProperty(Flags.HIDDEN, new BTimeRange(BTime.make(0, 1, 0), BTime.make(23, 59, 0)), null);

    /**
     * Get the {@code sundayFascia3} property.
     *
     * @see #sundayFascia3
     */
    public BTimeRange getSundayFascia3() {
        return (BTimeRange) get(sundayFascia3);
    }

    /**
     * Set the {@code sundayFascia3} property.
     *
     * @see #sundayFascia3
     */
    public void setSundayFascia3(BTimeRange v) {
        set(sundayFascia3, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "reset"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code reset} property.
     *
     * @see #getReset
     * @see #setReset
     */
    public static final Property reset = newProperty(Flags.HIDDEN, ((BBoolean) (BBoolean.make(false))).getBoolean(), null);

    /**
     * Get the {@code reset} property.
     *
     * @see #reset
     */
    public boolean getReset() {
        return getBoolean(reset);
    }

    /**
     * Set the {@code reset} property.
     *
     * @see #reset
     */
    public void setReset(boolean v) {
        setBoolean(reset, v, null);
    }

////////////////////////////////////////////////////////////////
// Property "feste"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code feste} property.
     *
     * @see #getFeste
     * @see #setFeste
     */
    public static final Property feste = newProperty(0, new BCalendarSchedule(), null);

    /**
     * Get the {@code feste} property.
     *
     * @see #feste
     */
    public BCalendarSchedule getFeste() {
        return (BCalendarSchedule) get(feste);
    }

    /**
     * Set the {@code feste} property.
     *
     * @see #feste
     */
    public void setFeste(BCalendarSchedule v) {
        set(feste, v, null);
    }

////////////////////////////////////////////////////////////////
// Action "calculate"
////////////////////////////////////////////////////////////////

    /**
     * Slot for the {@code calculate} action.
     *
     * @see #calculate()
     */
    public static final Action calculate = newAction(0, null);

    /**
     * Invoke the {@code calculate} action.
     *
     * @see #calculate
     */
    public void calculate() {
        invoke(calculate, null, null);
    }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

    @Override
    public Type getType() {
        return TYPE;
    }

    public static final Type TYPE = Sys.loadType(BMonthlyTimeSlots.class);

    /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    private String festeString = "";
    private String festeStringF3 = "";

    public void doCalculate() {
        createStringFeste();
        BOrd history = getEnerE();
        BOrd potenza = getPotE();
        BAbsTime now = BAbsTime.now();
        BTimeRange wdFascia1 = getWdFascia1();
        BTimeRange wdFascia21 = getWdFascia21();
        BTimeRange wdFascia22 = getWdFascia22();
        BTimeRange wdFascia31 = getWdFascia31();
        BTimeRange wdFascia32 = getWdFascia32();
        BTimeRange satFascia2 = getSaturdayFascia2();
        BTimeRange satFascia31 = getSaturdayFascia31();
        BTimeRange satFascia32 = getSaturdayFascia32();
        double wdf1;
        double wdf2;
        double wdf3;
        double satf2;
        double satf3;
        double sunf3;
        double festf3;
        double maxPotE;
        double corr;
        int month = (now.getMonth().getOrdinal() + 1);
        BMonth mese = now.getMonth();
        int i = now.getMonth().getOrdinal();
        int year = now.getYear();
        int daysOfMonth = BAbsTime.getDaysInMonth(year, mese);
        int day = (now.getDay());
        boolean r = getReset();
        String storico = history.toString();
        String inizioWdFascia1 = wdFascia1.getStartTime().encodeToString();
        String fineWdFascia1 = wdFascia1.getEndTime().encodeToString();
        String inizioWdFascia21 = wdFascia21.getStartTime().encodeToString();
        String fineWdFascia21 = wdFascia21.getEndTime().encodeToString();
        String inizioWdFascia22 = wdFascia22.getStartTime().encodeToString();
        String fineWdFascia22 = wdFascia22.getEndTime().encodeToString();
        String inizioWdFascia31 = wdFascia31.getStartTime().encodeToString();
        String fineWdFascia31 = wdFascia31.getEndTime().encodeToString();
        String inizioWdFascia32 = wdFascia32.getStartTime().encodeToString();
        String fineWdFascia32 = wdFascia32.getEndTime().encodeToString();
        String inizioSatFascia2 = satFascia2.getStartTime().encodeToString();
        String fineSatFascia2 = satFascia2.getEndTime().encodeToString();
        String inizioSatFascia31 = satFascia31.getStartTime().encodeToString();
        String fineSatFascia31 = satFascia31.getEndTime().encodeToString();
        String inizioSatFascia32 = satFascia32.getStartTime().encodeToString();
        String fineSatFascia32 = satFascia32.getEndTime().encodeToString();
        if (r) {
            final double RESETVALUE = 0;
            Arrays.asList(getGenPotE(), getFebPotE(), getMarPotE(), getAprPotE(), getMagPotE(), getGiuPotE(), getLugPotE(),
                    getAgoPotE(), getSetPotE(), getOttPotE(), getNovPotE(), getDicPotE(), getGenF1(), getGenF2(), getGenF3(),
                    getFebF1(), getFebF2(), getFebF3(), getMarF1(), getMarF2(), getMarF3(), getAprF1(), getAprF2(), getAprF3(),
                    getMagF1(), getMagF2(), getMagF3(), getGiuF1(), getGiuF2(), getGiuF3(), getLugF1(), getLugF2(), getLugF3(),
                    getAgoF1(), getAgoF2(), getAgoF3(), getSetF1(), getSetF2(), getSetF3(), getOttF1(), getOttF2(), getOttF3(),
                    getOttF3(), getNovF1(), getNovF2(), getNovF3(), getDicF1(), getDicF2(),
                    getDicF3()).forEach(bStatusNumeric -> bStatusNumeric.setValue(RESETVALUE));
        }
        getGiornoAttuale().setValue(day);
        getGiorniMese().setValue(daysOfMonth);
        //Giorni lavorativi totale consumo in Fascia 1
        wdf1 = result(storico + "?delta=true;period=monthToDate|bql:select SUM(value) where ((timestamp.time >= " + "'" + inizioWdFascia1 + "'" + " and timestamp.time <= " + "'" + fineWdFascia1 + "'" + ")) and (timestamp.weekday.ordinal != 6 and timestamp.weekday.ordinal != 0)" + festeString + "");
        insertOnSlot(month, wdf1, 1);
        //Giorni lavorativi totale consumo in Fascia 2
        wdf2 = result(storico + "?delta=true;period=monthToDate|bql:select SUM(value) where ((timestamp.time >= " + "'" + inizioWdFascia21 + "'" + " and timestamp.time <= " + "'" + fineWdFascia21 + "')" + "or ( timestamp.time >= " + "'" + inizioWdFascia22 + "'" + "and timestamp.time <= " + "'" + fineWdFascia22 + "'" + ")) and (timestamp.weekday.ordinal != 6 and timestamp.weekday.ordinal != 0)" + festeString + "");
        //Sabato totale consumo in Fascia 2
        satf2 = result(storico + "?delta=true;period=monthToDate|bql:select SUM(value) where (timestamp.time >= " + "'" + inizioSatFascia2 + "'" + " and timestamp.time <=  " + "'" + fineSatFascia2 + "') and (timestamp.weekday.ordinal = 6)" + festeString + "");
        insertOnSlot(month, wdf2 + satf2, 2);
        //Giorni lavorativi totale consumo in Fascia 3
        wdf3 = result(storico + "?delta=true;period=monthToDate|bql:select SUM(value) where ((timestamp.time >= " + "'" + inizioWdFascia31 + "'" + " and timestamp.time <= " + "'" + fineWdFascia31 + "')" + "or ( timestamp.time >= " + "'" + inizioWdFascia32 + "'" + "and timestamp.time <= " + "'" + fineWdFascia32 + "'" + ")) and (timestamp.weekday.ordinal != 6 and timestamp.weekday.ordinal != 0)" + festeString + "");
        //Sabato totale consumo in Fascia 3
        satf3 = result(storico + "?delta=true;period=monthToDate|bql:select SUM(value) where ((timestamp.time >= " + "'" + inizioSatFascia31 + "'" + " and timestamp.time <= " + "'" + fineSatFascia31 + "')" + "or ( timestamp.time >= " + "'" + inizioSatFascia32 + "'" + "and timestamp.time <= " + "'" + fineSatFascia32 + "'" + ")) and (timestamp.weekday.ordinal = 6)" + festeString + "");
        //Domenica totale consumo in Fascia 3
        sunf3 = result(storico + "?delta=true;period=monthToDate|bql:select SUM(value) where (timestamp.weekday.ordinal = 0)" + festeString + "");
        //Festivi totale consumo in Fascia 3
        festf3 = result(storico + "?delta=true;period=monthToDate|bql:select SUM(value) where (timestamp.month.ordinal = " + i + ")" + festeStringF3 + "");
        //correzione consumo in Fascia 3
        corr = result(storico + "?delta=true;period=monthToDate|bql:select AVG(value) where (timestamp.time >= '00:00:00.000' and timestamp.time <= '05:00:00.000')");
        insertOnSlot(month, wdf3 + satf3 + sunf3 + festf3 + corr * day, 3);
        //Picco Potenza
        maxPotE = result(potenza + "?delta=false;period=monthToDate|bql:select MAX(value)");
        insertOnSlot(month, maxPotE, -1);
    }

    private void insertOnSlot(int month, double value, int fascia) {
        switch (month) {
            case 1:
                if (fascia == 1)
                    getGenF1().setValue(value);
                else if (fascia == 2)
                    getGenF2().setValue(value);
                else if (fascia == 3)
                    getGenF3().setValue(value);
                else if (fascia == -1)
                    getGenPotE().setValue(value);
                break;
            case 2:
                if (fascia == 1)
                    getFebF1().setValue(value);
                else if (fascia == 2)
                    getFebF2().setValue(value);
                else if (fascia == 3)
                    getFebF3().setValue(value);
                else if (fascia == -1)
                    getFebPotE().setValue(value);
                break;
            case 3:
                if (fascia == 1)
                    getMarF1().setValue(value);
                else if (fascia == 2)
                    getMarF2().setValue(value);
                else if (fascia == 3)
                    getMarF3().setValue(value);
                else if (fascia == -1)
                    getMarPotE().setValue(value);
                break;
            case 4:
                if (fascia == 1)
                    getAprF1().setValue(value);
                else if (fascia == 2)
                    getAprF2().setValue(value);
                else if (fascia == 3)
                    getAprF3().setValue(value);
                else if (fascia == -1)
                    getAprPotE().setValue(value);
                break;
            case 5:
                if (fascia == 1)
                    getMagF1().setValue(value);
                else if (fascia == 2)
                    getMagF2().setValue(value);
                else if (fascia == 3)
                    getMagF3().setValue(value);
                else if (fascia == -1)
                    getMagPotE().setValue(value);
                break;
            case 6:
                if (fascia == 1)
                    getGiuF1().setValue(value);
                else if (fascia == 2)
                    getGiuF2().setValue(value);
                else if (fascia == 3)
                    getGiuF3().setValue(value);
                else if (fascia == -1)
                    getGiuPotE().setValue(value);
                break;
            case 7:
                if (fascia == 1)
                    getLugF1().setValue(value);
                else if (fascia == 2)
                    getLugF2().setValue(value);
                else if (fascia == 3)
                    getLugF3().setValue(value);
                else if (fascia == -1)
                    getLugPotE().setValue(value);
                break;
            case 8:
                if (fascia == 1)
                    getAgoF1().setValue(value);
                else if (fascia == 2)
                    getAgoF2().setValue(value);
                else if (fascia == 3)
                    getAgoF3().setValue(value);
                else if (fascia == -1)
                    getAgoPotE().setValue(value);
                break;
            case 9:
                if (fascia == 1)
                    getSetF1().setValue(value);
                else if (fascia == 2)
                    getSetF2().setValue(value);
                else if (fascia == 3)
                    getSetF3().setValue(value);
                else if (fascia == -1)
                    getSetPotE().setValue(value);
                break;
            case 10:
                if (fascia == 1)
                    getOttF1().setValue(value);
                else if (fascia == 2)
                    getOttF2().setValue(value);
                else if (fascia == 3)
                    getOttF3().setValue(value);
                else if (fascia == -1)
                    getOttPotE().setValue(value);
                break;
            case 11:
                if (fascia == 1)
                    getNovF1().setValue(value);
                else if (fascia == 2)
                    getNovF2().setValue(value);
                else if (fascia == 3)
                    getNovF3().setValue(value);
                else if (fascia == -1)
                    getNovPotE().setValue(value);
                break;
            case 12:
                if (fascia == 1)
                    getDicF1().setValue(value);
                else if (fascia == 2)
                    getDicF2().setValue(value);
                else if (fascia == 3)
                    getDicF3().setValue(value);
                else if (fascia == -1)
                    getDicPotE().setValue(value);
                break;
        }
    }

    private void createStringFeste() {
        // Crea la stringa dei giorni festivi
        BCalendarSchedule calendarSchedule = getFeste();
        BAbstractSchedule[] abstracts = calendarSchedule.getSchedules();
        for (BAbstractSchedule abs : abstracts) {
            BDateSchedule date = (BDateSchedule) abs;
            String y = String.valueOf(date.getYear());
            int m = date.getMonth();
            int d = date.getDay();
            if (y.equals("-1"))
                y = "*";
            festeString += " and (timestamp.date like " + "'" + y + "-" + String.format("%02d", (m + 1)) + "-" + String.format("%02d", d) + "'" + "= false)";
            festeStringF3 += " or (timestamp.date like " + "'" + y + "-" + String.format("%02d", (m + 1)) + "-" + String.format("%02d", d) + "'" + "= true)";
        }
    }

    //Query e Il risultato
    private double result(String query) {
        double result = -999;
        BOrd bOrd = BOrd.make(query);
        BITable table = (BITable) bOrd.get();
        Column[] columns = table.getColumns().list();
        Column col = columns[0];
        TableCursor cursor = table.cursor();
        if (cursor.next())
            result = BDouble.make(cursor.cell(col).toString()).getDouble();
        return result;
    }

    private static final BIcon icon = BIcon.make("module://timeSlots/rc/time.png");

    @Override
    public BIcon getIcon() {
        return icon;
    }

    @Override
    //TODO Handle errors (Duplicate Handle error)
    public void started() {
        getFeste().setCleanupExpiredEvents(false);
        BAbstractSchedule[] schedule = getFeste().getSchedules();
        if (schedule.length == 0) {
            insertFesta(-1, 0, 1, "Capodanno");
            insertFesta(-1, 0, 6, "Epifania");
            insertFesta(2022, 3, 17, "Pasqua");
            insertFesta(2022, 3, 18, "Pasquetta");
            insertFesta(-1, 3, 25, "Liberazione");
            insertFesta(-1, 4, 1, "FestadelLavoro");
            insertFesta(-1, 5, 2, "FestadellaRepubblica");
            insertFesta(-1, 7, 15, "Ferragosto");
            insertFesta(-1, 10, 1, "Ognissanti");
            insertFesta(-1, 11, 8, "Immacolata");
            insertFesta(-1, 11, 25, "Natale");
            insertFesta(-1, 11, 26, "SantoStefano");
        }
    }

    private void insertFesta(int year, int month, int day, String name) {
        BDateSchedule date = new BDateSchedule();
        date.setYear(year);
        date.setMonth(month);
        date.setDay(day);
        getFeste().add(date);
        getFeste().rename(getFeste().getProperty("sch0"), name);
    }
}
