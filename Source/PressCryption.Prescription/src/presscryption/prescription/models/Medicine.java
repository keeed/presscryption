/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.prescription.models;

import java.util.Objects;

/**
 *
 * @author Kedren Villena
 */
public class Medicine {

    private long _id;
    private String _genericName;
    private String _brandName;
    private MedicineNotes _medicineNotes;

    public Medicine() {

    }

    /**
     * @return the _id
     */
    public long getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(long _id) {
        this._id = _id;
    }

    /**
     * @return the _genericName
     */
    public String getGenericName() {
        return _genericName;
    }

    /**
     * @param _genericName the _genericName to set
     */
    public void setGenericName(String _genericName) {
        this._genericName = _genericName;
    }

    /**
     * @return the _brandName
     */
    public String getBrandName() {
        return _brandName;
    }

    /**
     * @param _brandName the _brandName to set
     */
    public void setBrandName(String _brandName) {
        this._brandName = _brandName;
    }

    /**
     * @return the _medicineNotes
     */
    public MedicineNotes getMedicineNotes() {
        return _medicineNotes;
    }

    /**
     * @param _medicineNotes the _medicineNotes to set
     */
    public void setMedicineNotes(MedicineNotes _medicineNotes) {
        this._medicineNotes = _medicineNotes;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Medicine)) {
            return false;
        }
        Medicine converted = (Medicine) object;

        return !(this.getId() != converted.getId()
                && (this.getGenericName() == null ? converted.getGenericName() != null : !this.getGenericName().equals(converted.getGenericName()))
                && (this.getBrandName() == null ? converted.getBrandName() != null : !this.getBrandName().equals(converted.getBrandName()))
                && this.getMedicineNotes() != converted.getMedicineNotes());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (int) (this._id ^ (this._id >>> 32));
        hash = 71 * hash + Objects.hashCode(this._genericName);
        hash = 71 * hash + Objects.hashCode(this._brandName);
        hash = 71 * hash + Objects.hashCode(this._medicineNotes);
        return hash;
    }
}
