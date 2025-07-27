package api.contactManager.service.impl;//package api.contactManager.service.impl;

import api.contactManager.service.EnterpriseService;
import org.springframework.stereotype.Service;

@Service
public class ImplEnterpriseServiceImpl implements EnterpriseService {


    @Override
    public String getPingBody() {
        return "hello world from Enterprise";
    }
}
