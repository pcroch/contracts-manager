package api.contactManager.service;//package api.contactManager.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface EnterpriseService {

    Logger log = LoggerFactory.getLogger(EnterpriseService.class);

    String getPingBody();

}
