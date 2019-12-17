package com.vodafone.web.rest;

import com.vodafone.domain.WEBSERVICE;
import com.vodafone.service.WEBSERVICEService;
import com.vodafone.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.vodafone.domain.WEBSERVICE}.
 */
@RestController
@RequestMapping("/api")
public class WEBSERVICEResource {

    private final Logger log = LoggerFactory.getLogger(WEBSERVICEResource.class);

    private static final String ENTITY_NAME = "wEBSERVICE";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final WEBSERVICEService wEBSERVICEService;

    public WEBSERVICEResource(WEBSERVICEService wEBSERVICEService) {
        this.wEBSERVICEService = wEBSERVICEService;
    }

    /**
     * {@code POST  /webservices} : Create a new wEBSERVICE.
     *
     * @param wEBSERVICE the wEBSERVICE to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new wEBSERVICE, or with status {@code 400 (Bad Request)} if the wEBSERVICE has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/webservices")
    public ResponseEntity<WEBSERVICE> createWEBSERVICE(@RequestBody WEBSERVICE wEBSERVICE) throws URISyntaxException {
        log.debug("REST request to save WEBSERVICE : {}", wEBSERVICE);
        if (wEBSERVICE.getId() != null) {
            throw new BadRequestAlertException("A new wEBSERVICE cannot already have an ID", ENTITY_NAME, "idexists");
        }
        WEBSERVICE result = wEBSERVICEService.save(wEBSERVICE);
        return ResponseEntity.created(new URI("/api/webservices/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /webservices} : Updates an existing wEBSERVICE.
     *
     * @param wEBSERVICE the wEBSERVICE to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated wEBSERVICE,
     * or with status {@code 400 (Bad Request)} if the wEBSERVICE is not valid,
     * or with status {@code 500 (Internal Server Error)} if the wEBSERVICE couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/webservices")
    public ResponseEntity<WEBSERVICE> updateWEBSERVICE(@RequestBody WEBSERVICE wEBSERVICE) throws URISyntaxException {
        log.debug("REST request to update WEBSERVICE : {}", wEBSERVICE);
        if (wEBSERVICE.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        WEBSERVICE result = wEBSERVICEService.save(wEBSERVICE);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, wEBSERVICE.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /webservices} : get all the wEBSERVICES.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of wEBSERVICES in body.
     */
    @GetMapping("/webservices")
    public List<WEBSERVICE> getAllWEBSERVICES() {
        log.debug("REST request to get all WEBSERVICES");
        return wEBSERVICEService.findAll();
    }

    /**
     * {@code GET  /webservices/:id} : get the "id" wEBSERVICE.
     *
     * @param id the id of the wEBSERVICE to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the wEBSERVICE, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/webservices/{id}")
    public ResponseEntity<WEBSERVICE> getWEBSERVICE(@PathVariable Long id) {
        log.debug("REST request to get WEBSERVICE : {}", id);
        Optional<WEBSERVICE> wEBSERVICE = wEBSERVICEService.findOne(id);
        return ResponseUtil.wrapOrNotFound(wEBSERVICE);
    }

    /**
     * {@code DELETE  /webservices/:id} : delete the "id" wEBSERVICE.
     *
     * @param id the id of the wEBSERVICE to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/webservices/{id}")
    public ResponseEntity<Void> deleteWEBSERVICE(@PathVariable Long id) {
        log.debug("REST request to delete WEBSERVICE : {}", id);
        wEBSERVICEService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
