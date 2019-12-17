package com.vodafone.service.impl;

import com.vodafone.service.WEBSERVICEService;
import com.vodafone.domain.WEBSERVICE;
import com.vodafone.repository.WEBSERVICERepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link WEBSERVICE}.
 */
@Service
@Transactional
public class WEBSERVICEServiceImpl implements WEBSERVICEService {

    private final Logger log = LoggerFactory.getLogger(WEBSERVICEServiceImpl.class);

    private final WEBSERVICERepository wEBSERVICERepository;

    public WEBSERVICEServiceImpl(WEBSERVICERepository wEBSERVICERepository) {
        this.wEBSERVICERepository = wEBSERVICERepository;
    }

    /**
     * Save a wEBSERVICE.
     *
     * @param wEBSERVICE the entity to save.
     * @return the persisted entity.
     */
    @Override
    public WEBSERVICE save(WEBSERVICE wEBSERVICE) {
        log.debug("Request to save WEBSERVICE : {}", wEBSERVICE);
        return wEBSERVICERepository.save(wEBSERVICE);
    }

    /**
     * Get all the wEBSERVICES.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<WEBSERVICE> findAll() {
        log.debug("Request to get all WEBSERVICES");
        return wEBSERVICERepository.findAll();
    }


    /**
     * Get one wEBSERVICE by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<WEBSERVICE> findOne(Long id) {
        log.debug("Request to get WEBSERVICE : {}", id);
        return wEBSERVICERepository.findById(id);
    }

    /**
     * Delete the wEBSERVICE by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete WEBSERVICE : {}", id);
        wEBSERVICERepository.deleteById(id);
    }
}
