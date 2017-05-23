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
    private String questionToSend = "";

    @UpnpStateVariable
    private String commandeToSend = "";

    public void sendQuestion(String q) {
        questionToSend = q;
        getPropertyChangeSupport().firePropertyChange("QuestionToSend", null, questionToSend);
    }

    public void sendCommande(String c) {
        commandeToSend = c;
        getPropertyChangeSupport().firePropertyChange("CommandeToSend", null, commandeToSend);
    }
}
