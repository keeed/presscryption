/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.presenterfactories;

import presscryption.client.presenters.HomePresenter;
import presscryption.client.viewdefinitions.IHomeView;
import presscryption.client.viewfactories.IHomeViewFactory;
import presscryption.common.ComponentManager;

/**
 *
 * @author Kedren Villena
 */
public class HomePresenterFactory {
    
    public static HomePresenter CreateInstance()
    {
        IHomeView homeView = 
                ComponentManager.GetComponent(IHomeViewFactory.class)
                        .CreateHomeView();
        
        HomePresenter homePresenter 
                = new HomePresenter(homeView);
        
        homeView.RegisterPresenter(homePresenter);
        
        return homePresenter;
    }
    
}
