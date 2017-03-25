/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.presenters;

import presscryption.client.presenterfactories.ManageMedicinesPresenterFactory;
import presscryption.client.viewdefinitions.IHomeView;

/**
 *
 * @author Kedren Villena
 */
public class HomePresenter {

    private IHomeView _homeView;

    public HomePresenter(IHomeView homeView) {
        if (homeView == null) {
            throw new IllegalArgumentException("homeView");
        }

        setHomeView(homeView);
    }

    public IHomeView getHomeView() {
        return _homeView;
    }

    protected void setHomeView(IHomeView homeView) {
        _homeView = homeView;
    }

    public void ShowManageMedicinesView() {
        ManageMedicinesPresenter manageMedicinesPresenter 
                = ManageMedicinesPresenterFactory.CreateInstance();
        
        manageMedicinesPresenter.OnInitialize();
        
        manageMedicinesPresenter.getManageMedicinesView().Show();
    }
}
