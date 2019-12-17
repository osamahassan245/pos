package com.vodafone.service;

import com.vodafone.domain.WEBSERVICE;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link WEBSERVICE}.
 */
public interface WEBSERVICEService {

    /**
     * Save a wEBSERVICE.
     *
     * @param wEBSERVICE the entity to save.
     * @return the persisted entity.
     */
    WEBSERVICE save(WEBSERVICE wEBSERVICE);

    /**
     * Get all the wEBSERVICES.
     *
     * @return the list of entities.
     */
    List<WEBSERVICE> findAll();


    /**
     * Get the "id" wEBSERVICE.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<WEBSERVICE> findOne(Long id);

    /**
     * Delete the "id" wEBSERVICE.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
