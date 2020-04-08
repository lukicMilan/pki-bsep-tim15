package tim15.pki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import tim15.pki.model.Certificate;
import java.util.List;

//FALI extends JpaRepository<Certificate, Long>
//U KRAJNJEM SLUCAJU TREBA GA CELOG IMPLEMENTIRATI
public interface CertificateRepository extends JpaRepository<Certificate, Long> {
    List<Certificate> findAll();

    Certificate findOneBySerialNumber(String serialNumber);

    Certificate save(Certificate certificate);

    void removeBySerialNumber(String serialNumber);


    //PROVERITI upit!!
    @Query("select c from Certificate c where c.revokeReason is not null")
    List<Certificate> findRevokedCertificates();

    Certificate getOneBySerialNumber(String serialNumber);
}
