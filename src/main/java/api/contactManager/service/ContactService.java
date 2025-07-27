package api.contactManager.service;//package api.contactManager.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface ContactService {

    Logger log = LoggerFactory.getLogger(ContactService.class);

    String getPingBody();

}
