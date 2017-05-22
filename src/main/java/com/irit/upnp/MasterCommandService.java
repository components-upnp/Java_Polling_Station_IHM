package com.irit.upnp;

import org.fourthline.cling.binding.annotations.UpnpService;
import org.fourthline.cling.binding.annotations.UpnpServiceId;
import org.fourthline.cling.binding.annotations.UpnpServiceType;
import org.fourthline.cling.binding.annotations.UpnpStateVariable;

import java.beans.PropertyChangeSupport;

/**
 * Created by mkostiuk on 22/05/2017.
 */
@UpnpService(
        serviceType = @UpnpServiceType(value = "MasterCommandService"),
        serviceId = @UpnpServiceId("MasterCommandService")
)
public class MasterCommandService {

    private final PropertyChangeSupport propertyChangeSupport;

    public MasterCommandService() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

    @UpnpStateVariable
    private String question = "";

    @UpnpStateVariable
    private String commande = "";

    public void sendQuestion(String q) {
        question = q;
        getPropertyChangeSupport().firePropertyChange("Question", "", question);
    }

    public void sendCommande(String c) {
        commande = c;
        getPropertyChangeSupport().firePropertyChange("Commande", "", commande);
    }
}
