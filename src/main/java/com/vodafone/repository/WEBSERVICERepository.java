package com.vodafone.repository;
import com.vodafone.domain.WEBSERVICE;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the WEBSERVICE entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WEBSERVICERepository extends JpaRepository<WEBSERVICE, Long> {

}
