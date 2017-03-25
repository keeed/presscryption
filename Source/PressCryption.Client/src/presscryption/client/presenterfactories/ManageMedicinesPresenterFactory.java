/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.presenterfactories;

import presscryption.client.presenters.ManageMedicinesPresenter;
import presscryption.client.viewdefinitions.IManageMedicinesView;
import presscryption.client.viewfactories.IManageMedicinesViewFactory;
import presscryption.common.ComponentManager;
import presscryption.medicinemanagement.contract.services.IMedicineManagementService;
import presscryption.servicemodels.IMedicineServiceModel;
import presscryption.servicemodels.MedicineServiceModel;

/**
 *
 * @author Kedren Villena
 */
public class ManageMedicinesPresenterFactory {
    
    public static ManageMedicinesPresenter CreateInstance() {
        
        IMedicineServiceModel medicineServiceModel = 
                new MedicineServiceModel(
                    ComponentManager.GetComponent(IMedicineManagementService.class));
        
        IManageMedicinesView manageMedicinesView 
                = ComponentManager.GetComponent(IManageMedicinesViewFactory.class)
                    .CreateManageMedicinesView();
        
        ManageMedicinesPresenter presenter = 
                new ManageMedicinesPresenter(manageMedicinesView, medicineServiceModel);
        
        manageMedicinesView.RegisterPresenter(presenter);
        
        return presenter;       
    }
}
