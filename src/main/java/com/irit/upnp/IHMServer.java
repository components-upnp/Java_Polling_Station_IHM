package com.irit.upnp;

import com.irit.display.Fenetre;
import org.fourthline.cling.UpnpService;
import org.fourthline.cling.UpnpServiceImpl;
import org.fourthline.cling.binding.annotations.AnnotationLocalServiceBinder;
import org.fourthline.cling.model.DefaultServiceManager;
import org.fourthline.cling.model.ValidationException;
import org.fourthline.cling.model.meta.*;
import org.fourthline.cling.model.types.DeviceType;
import org.fourthline.cling.model.types.UDADeviceType;
import org.fourthline.cling.model.types.UDN;

/**
 * Created by mkostiuk on 22/05/2017.
 */
public class IHMServer implements Runnable {
    public void run() {

        try {
            final UpnpService upnpService = new UpnpServiceImpl();
            
            upnpService.getRegistry().addDevice(createDevice());
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    private LocalDevice createDevice() throws ValidationException {
        DeviceIdentity identity =
                new DeviceIdentity(
                        UDN.uniqueSystemIdentifier("IHM Polling Station")
                );

        DeviceType type =
                new UDADeviceType("Bureau", 1);

        DeviceDetails details =
                new DeviceDetails(
                        "IHM Polling Station",					// Friendly Name
                        new ManufacturerDetails(
                                "UPS-IRIT",								// Manufacturer
                                ""),								// Manufacturer URL
                        new ModelDetails(
                                "IHMPoll",						// Model Name
                                "Composant proposant une IHM pour Polling Station",	// Model Description
                                "v1" 								// Model Number
                        )
                );
        LocalService<MasterCommandService> masterCommandService =
                new AnnotationLocalServiceBinder().read(MasterCommandService.class);
        masterCommandService.setManager(
                new DefaultServiceManager(masterCommandService, MasterCommandService.class)
        );

        new Fenetre(masterCommandService).setVisible(true);

        return new LocalDevice(
                identity, type, details,
                new LocalService[] {masterCommandService}
        );
    }
}
