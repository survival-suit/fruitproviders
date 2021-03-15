package fruitproviders.Services;

import fruitproviders.DAO.IPartnerDAO;
import fruitproviders.Models.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
public class PartnerService implements IPartnerService{

    private IPartnerDAO partnerDAO;

    @Autowired
    public void setPartnerDAO(IPartnerDAO partnerDAO){ this.partnerDAO = partnerDAO; }

    @Override
    @Transactional
    public List<Partner> getAllPartners() {
        return partnerDAO.getAllPartners();
    }

    @Override
    @Transactional
    public void add(Partner partner) {
        partnerDAO.add(partner);
    }

    @Override
    @Transactional
    public void delete(Partner partner) {
        partnerDAO.delete(partner);
    }

    @Override
    @Transactional
    public Partner getById(UUID id) {
        return partnerDAO.getById(id);
    }
}
