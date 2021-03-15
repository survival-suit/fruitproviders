package fruitproviders.DAO;

import fruitproviders.Models.Partner;
import java.util.*;

public interface IPartnerDAO {
    List<Partner> getAllPartners();
    void add(Partner partner);
    void delete(Partner partner);
    Partner getById(UUID id);
}
