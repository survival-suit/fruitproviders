package fruitproviders.Services;

import fruitproviders.Models.Partner;

import java.util.List;
import java.util.UUID;

public interface IPartnerService {
    List<Partner> getAllPartners();
    void add(Partner partner);
    void delete(Partner partner);
    Partner getById(UUID id);
}
