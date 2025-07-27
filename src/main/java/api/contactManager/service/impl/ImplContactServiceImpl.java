package api.contactManager.service.impl;//package api.contactManager.service.impl;

import api.contactManager.service.ContactService;
import api.contactManager.service.EnterpriseService;
import org.springframework.stereotype.Service;

@Service
public class ImplContactServiceImpl implements ContactService {

    @Override
    public String getPingBody() {
        return "Hello world from Contact";
    }
}
