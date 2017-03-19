/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.medicinemanagement.data.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import presscryption.medicinemanagement.data.contract.objects.MedicineDataDTO;
import presscryption.medicinemanagement.data.contract.services.IMedicineManagementDataService;

/**
 *
 * @author Kedren Villena
 */
public class SQLiteMedicineManagementDataService implements IMedicineManagementDataService {
    
    private static final String CONNECTION_STRING = "jdbc:sqlite:data/PressCryption.db";

    @Override
    public long AddMedicine(MedicineDataDTO medicine) {
        String query
                = "INSERT INTO `Medicine`(`ID`,`Generic Name`,`Brand Name`,`Date Created`,`Date Modified`,`Quantity`) VALUES (NULL,?,?,?,?,?);";

        try (Connection connection = SQLiteConnector.connect(CONNECTION_STRING);
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {

            preparedStatement.setString(1, medicine.getGenericName());
            preparedStatement.setString(2, medicine.getBrandName());
            preparedStatement.setString(3, medicine.getDateCreated().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            preparedStatement.setString(4, medicine.getDateModified().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            preparedStatement.setInt(5, medicine.getQuantity());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteConnector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }

    @Override
    public ArrayList<MedicineDataDTO> GetAllMedicine() {
        String query = "SELECT * FROM Medicine";
        
        ArrayList<MedicineDataDTO> medicinesDataDTO = new ArrayList<>();

        try (Connection connection = SQLiteConnector.connect(CONNECTION_STRING);
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            
            preparedStatement.executeQuery();
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                MedicineDataDTO medicineDataDTO = 
                        new MedicineDataDTO(
                                resultSet.getLong("ID"), 
                                resultSet.getString("Generic Name"), 
                                resultSet.getString("Brand Name"), 
                                LocalDateTime.parse(resultSet.getString("Date Created")), 
                                LocalDateTime.parse(resultSet.getString("Date Modified")), 
                                resultSet.getInt("Quantity"));
                
                medicinesDataDTO.add(medicineDataDTO);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return medicinesDataDTO;
    }

    @Override
    public void UpdateMedicine(MedicineDataDTO medicine) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteMedicine(MedicineDataDTO medicine) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
