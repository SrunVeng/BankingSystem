package co.istad.SRBank.dao;

import co.istad.SRBank.domain.CustomerCif;

public interface CustomerCifDao {


    void registerCif(CustomerCif customerCif);

    void deleteCif(int cifForDelete);

    CustomerCif findCustomerByNID(String NID);

}
