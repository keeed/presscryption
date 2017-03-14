/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.medicinemanagement.data.contract.objects;

import java.time.LocalDateTime;

/**
 *
 * @author Kedren Villena
 */
public class MedicineDataDTO {

    private long _id;
    private String _genericName;
    private String _brandName;
    private LocalDateTime _dateCreated;
    private LocalDateTime _dateModified;
    private int _quantity;

    public MedicineDataDTO(
            long id,
            String genericName,
            String brandName,
            LocalDateTime dateCreated,
            LocalDateTime dateModified,
            int quantity) {
        setId(id);
        setGenericName(genericName);
        setBrandName(brandName);
        setDateCreated(dateCreated);
        setDateModified(dateModified);
        setQuantity(quantity);
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
     * @return the _dateCreated
     */
    public LocalDateTime getDateCreated() {
        return _dateCreated;
    }

    /**
     * @param _dateCreated the _dateCreated to set
     */
    public void setDateCreated(LocalDateTime _dateCreated) {
        this._dateCreated = _dateCreated;
    }

    /**
     * @return the _dateModified
     */
    public LocalDateTime getDateModified() {
        return _dateModified;
    }

    /**
     * @param _dateModified the _dateModified to set
     */
    public void setDateModified(LocalDateTime _dateModified) {
        this._dateModified = _dateModified;
    }

    /**
     * @return the _quantity
     */
    public int getQuantity() {
        return _quantity;
    }

    /**
     * @param _quantity the _quantity to set
     */
    public void setQuantity(int _quantity) {
        this._quantity = _quantity;
    }
}
