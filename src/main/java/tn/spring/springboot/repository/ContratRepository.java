package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.spring.springboot.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat,Long> {
    @Query("Select C from Contrat C where C.dateDebutContrat = ?1 and C.dateFinContrat = ?2 and C.archive=false")
    public List<Contrat> getContratByDate(Date startDate, Date endDate);

    @Query(nativeQuery = true, value= "SELECT DATEDIFF( ct.date_fin_contrat,CAST( NOW() AS Date )) AS DateDiff from Contrat as ct  where ct.id_contrat = ?1 ")
    Integer GetDaysById(Long id);
    @Query(nativeQuery = true, value= "SELECT DATEDIFF( CAST( NOW() AS Date ),ct.date_debut_contrat) AS DateDiff from Contrat as ct  where ct.id_contrat = ?1 ")
    Integer GetDaysByIdFromStart(Integer id);
}
