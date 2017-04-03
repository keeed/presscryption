/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.presenterfactories;

import presscryption.client.presenters.EditMedicinePresenter;
import presscryption.client.viewdefinitions.IEditMedicineView;
import presscryption.client.viewfactories.IEditMedicineViewFactory;
import presscryption.common.ComponentManager;
import presscryption.medicinemanagement.contract.services.IMedicineManagementService;
import presscryption.servicemodels.IMedicineServiceModel;
import presscryption.servicemodels.MedicineServiceModel;

/**
 *
 * @author Kedren Villena
 */
public class EditMedicinePresenterFactory {

    public static EditMedicinePresenter CreateInstance() {
        IMedicineServiceModel medicineServiceModel
                = new MedicineServiceModel(
                        ComponentManager.GetComponent(IMedicineManagementService.class));

        IEditMedicineView editMedicineView
                = ComponentManager.GetComponent(IEditMedicineViewFactory.class)
                        .CreateEditeMedicineView();

        EditMedicinePresenter presenter
                = new EditMedicinePresenter(editMedicineView, medicineServiceModel);

        editMedicineView.RegisterPresenter(presenter);

        return presenter;

    }

}
