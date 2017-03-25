/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.models;

import java.time.LocalDateTime;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Kedren Villena
 */
public class Medicine {
    
    private LongProperty _id;
    private StringProperty _genericName;
    private StringProperty _brandName;
    private ObjectProperty<LocalDateTime> _dateCreated;
    private ObjectProperty<LocalDateTime> _dateModified;
    
    public Medicine(
            String genericName,
            String brandName) {
        this(
                0,
                genericName, 
                brandName, 
                LocalDateTime.now(), 
                LocalDateTime.now());
    }
    
    public Medicine(
            long id,
            String genericName,
            String brandName,
            LocalDateTime dateCreated,
            LocalDateTime dateModified) {
        setId(new SimpleLongProperty(id));
        setGenericName(new SimpleStringProperty(genericName));
        setBrandName(new SimpleStringProperty(brandName));
        setDateCreated(new SimpleObjectProperty<>(dateCreated));
        setDateModified(new SimpleObjectProperty<>(dateModified));
    }
    
    /**
     * @return the _id
     */
    public LongProperty getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(LongProperty _id) {
        this._id = _id;
    }

    /**
     * @return the _genericName
     */
    public StringProperty getGenericName() {
        return _genericName;
    }

    /**
     * @param _genericName the _genericName to set
     */
    public void setGenericName(StringProperty _genericName) {
        this._genericName = _genericName;
    }

    /**
     * @return the _brandName
     */
    public StringProperty getBrandName() {
        return _brandName;
    }

    /**
     * @param _brandName the _brandName to set
     */
    public void setBrandName(StringProperty _brandName) {
        this._brandName = _brandName;
    }

    /**
     * @return the _dateCreated
     */
    public ObjectProperty<LocalDateTime> getDateCreated() {
        return _dateCreated;
    }

    /**
     * @param _dateCreated the _dateCreated to set
     */
    public void setDateCreated(ObjectProperty<LocalDateTime> _dateCreated) {
        this._dateCreated = _dateCreated;
    }

    /**
     * @return the _dateModified
     */
    public ObjectProperty<LocalDateTime> getDateModified() {
        return _dateModified;
    }

    /**
     * @param _dateModified the _dateModified to set
     */
    public void setDateModified(ObjectProperty<LocalDateTime> _dateModified) {
        this._dateModified = _dateModified;
    }
}
