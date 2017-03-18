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
            long id,
            String genericName,
            String brandName,
            LocalDateTime dateCreated,
            LocalDateTime dateModified) {
        setId(id);
        setGenericName(genericName);
        setBrandName(brandName);
        setDateCreated(dateCreated);
        setDateModified(dateModified);
    }
    
    /**
     * @return the _id
     */
    protected long getId() {
        return _id.getValue();
    }

    /**
     * @param _id the _id to set
     */
    protected void setId(long _id) {
        this._id = new SimpleLongProperty(_id);
    }

    /**
     * @return the _genericName
     */
    protected String getGenericName() {
        return _genericName.getValue();
    }

    /**
     * @param _genericName the _genericName to set
     */
    protected void setGenericName(String _genericName) {
        this._genericName = new SimpleStringProperty(_genericName);
    }

    /**
     * @return the _brandName
     */
    protected String getBrandName() {
        return _brandName.getValue();
    }

    /**
     * @param _brandName the _brandName to set
     */
    protected void setBrandName(String _brandName) {
        this._brandName = new SimpleStringProperty(_brandName);
    }

    /**
     * @return the _dateCreated
     */
    protected LocalDateTime getDateCreated() {
        return _dateCreated.getValue();
    }

    /**
     * @param _dateCreated the _dateCreated to set
     */
    protected void setDateCreated(LocalDateTime _dateCreated) {
        this._dateCreated = new SimpleObjectProperty<>(_dateCreated);
    }

    /**
     * @return the _dateModified
     */
    protected LocalDateTime getDateModified() {
        return _dateModified.getValue();
    }

    /**
     * @param _dateModified the _dateModified to set
     */
    protected void setDateModified(LocalDateTime _dateModified) {
        this._dateModified = new SimpleObjectProperty<>(_dateModified);
    }

}
