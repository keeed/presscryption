/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import presscryption.client.models.Medicine;
import presscryption.client.models.Medicines;
import presscryption.client.presenters.ManageMedicinesPresenter;
import presscryption.client.viewdefinitions.IManageMedicinesView;
import presscryption.servicemodels.IMedicineServiceModel;

/**
 *
 * @author Kedren Villena
 */
public class ManageMedicinesViewPresenterTest {
    
    public ManageMedicinesViewPresenterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void OnInitialize_ShouldLoadMedicines() {
        Medicines viewMedicines = new Medicines();
        
        IMedicineServiceModel mockedMedicineServiceModel
                = mock(IMedicineServiceModel.class);
        
        Medicines medicines = new Medicines();
        medicines.AddMedicine(new Medicine("Paracetamol", "Biogesic"));
        medicines.AddMedicine(new Medicine("Paracetamol", "Calpol"));
        medicines.AddMedicine(new Medicine("Paracetamol", "Panadol"));
        
        when(mockedMedicineServiceModel.GetMedicines())
                .thenReturn(medicines);
        
        IManageMedicinesView mockedManageMedicinesView 
                = mock(IManageMedicinesView.class);
        
        doAnswer((Answer<Void>) new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock iom) throws Throwable {
                Medicines medicines1 = (Medicines)iom.getArgument(0);            
                viewMedicines.addAll(medicines1);
                return null;
            }
        }).when(mockedManageMedicinesView).setMedicines(any(Medicines.class));
        
        when(mockedManageMedicinesView.getMedicines())
                .thenReturn(viewMedicines);
        
        ManageMedicinesPresenter presenter 
                = new ManageMedicinesPresenter(mockedManageMedicinesView, mockedMedicineServiceModel);
        
        presenter.Initialize();
        
        assertTrue(presenter.getManageMedicinesView().getMedicines().size() > 0);
    }
    
    @Test
    public void OnInitialize_ShouldNoLoadMedicines_WhenMedicinesEmpty() {
        Medicines viewMedicines = new Medicines();
        
        IMedicineServiceModel mockedMedicineServiceModel
                = mock(IMedicineServiceModel.class);
        
        Medicines medicines = new Medicines();
        
        when(mockedMedicineServiceModel.GetMedicines())
                .thenReturn(medicines);
        
        IManageMedicinesView mockedManageMedicinesView 
                = mock(IManageMedicinesView.class);
        
        doAnswer((Answer<Void>) new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock iom) throws Throwable {
                Medicines medicines1 = (Medicines)iom.getArgument(0);            
                viewMedicines.addAll(medicines1);
                return null;
            }
        }).when(mockedManageMedicinesView).setMedicines(any(Medicines.class));
        
        when(mockedManageMedicinesView.getMedicines())
                .thenReturn(viewMedicines);
        
        ManageMedicinesPresenter presenter 
                = new ManageMedicinesPresenter(mockedManageMedicinesView, mockedMedicineServiceModel);
        
        presenter.Initialize();
        
        assertTrue(0 == presenter.getManageMedicinesView().getMedicines().size());
    }
    
    @Test
    public void OnAddMedicine_ShouldSuccessfullyAddMedicine() 
    {
        Medicines viewMedicines = new Medicines();
        Medicines servceModelMedicines = new Medicines();
        
        IMedicineServiceModel mockedMedicineServiceModel
                = mock(IMedicineServiceModel.class);

        when(mockedMedicineServiceModel.GetMedicines())
                .thenReturn(servceModelMedicines);
        
        doAnswer((Answer<Long>) new Answer<Long>() {
            @Override
            public Long answer(InvocationOnMock iom) throws Throwable {
                Medicine medicine1 = (Medicine)iom.getArgument(0);            
                servceModelMedicines.AddMedicine(medicine1);
                return new Long(1);
            }
        }).when(mockedMedicineServiceModel).AddMedicine(any(Medicine.class));
        
        IManageMedicinesView mockedManageMedicinesView 
                = mock(IManageMedicinesView.class);
        
        doAnswer((Answer<Void>) new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock iom) throws Throwable {
                Medicines medicines1 = (Medicines)iom.getArgument(0);            
                viewMedicines.addAll(medicines1);
                return null;
            }
        }).when(mockedManageMedicinesView).setMedicines(any(Medicines.class));
        
        Medicine newMedicine = new Medicine("New GenericName Medicine", "New BrandName Medicine");
        
        when(mockedManageMedicinesView.getMedicines())
                .thenReturn(viewMedicines);
        
        when(mockedManageMedicinesView.getGenericName())
                .thenReturn(newMedicine.getGenericName().getValue());
        
        when(mockedManageMedicinesView.getBrandName())
                .thenReturn(newMedicine.getBrandName().getValue());
        
        ManageMedicinesPresenter presenter 
                = new ManageMedicinesPresenter(mockedManageMedicinesView, mockedMedicineServiceModel);
        
        presenter.Initialize();
        
        int oldCount = presenter.getManageMedicinesView().getMedicines().size();
        
        presenter.AddMedicine();
        
        assertTrue(oldCount + 1 == presenter.getManageMedicinesView().getMedicines().size());
    }
    
    @Test
    public void OnDeleteSelectedMedicine_ShouldSuccessfullyDeleteMedicine() 
    {
        Medicines viewMedicines = new Medicines();
        Medicines servceModelMedicines = new Medicines();
        
        IMedicineServiceModel mockedMedicineServiceModel
                = mock(IMedicineServiceModel.class);

        when(mockedMedicineServiceModel.GetMedicines())
                .thenReturn(servceModelMedicines);
        
        doAnswer((Answer<Long>) new Answer<Long>() {
            @Override
            public Long answer(InvocationOnMock iom) throws Throwable {
                Medicine medicine1 = (Medicine)iom.getArgument(0);            
                servceModelMedicines.AddMedicine(medicine1);
                return new Long(1);
            }
        }).when(mockedMedicineServiceModel).AddMedicine(any(Medicine.class));
        
        doAnswer((Answer<Void>) new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock iom) throws Throwable {
                Medicine medicine1 = (Medicine)iom.getArgument(0);            
                servceModelMedicines.remove(medicine1);
                return null;
            }
        }).when(mockedMedicineServiceModel).DeleteMedicine(any(Medicine.class));
        
        IManageMedicinesView mockedManageMedicinesView 
                = mock(IManageMedicinesView.class);
        
        doAnswer((Answer<Void>) new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock iom) throws Throwable {
                Medicines medicines1 = (Medicines)iom.getArgument(0);            
                viewMedicines.addAll(medicines1);
                return null;
            }
        }).when(mockedManageMedicinesView).setMedicines(any(Medicines.class));
        
        Medicine newMedicine = new Medicine("New GenericName Medicine", "New BrandName Medicine");
        
        when(mockedManageMedicinesView.getMedicines())
                .thenReturn(viewMedicines);
        
        when(mockedManageMedicinesView.getGenericName())
                .thenReturn(newMedicine.getGenericName().getValue());
        
        when(mockedManageMedicinesView.getBrandName())
                .thenReturn(newMedicine.getBrandName().getValue());
        
        ManageMedicinesPresenter presenter 
                = new ManageMedicinesPresenter(mockedManageMedicinesView, mockedMedicineServiceModel);
        
        presenter.Initialize();
        
        int oldCount = presenter.getManageMedicinesView().getMedicines().size();
        
        presenter.AddMedicine();
        
        assertTrue(oldCount + 1 == presenter.getManageMedicinesView().getMedicines().size());
    }
}
