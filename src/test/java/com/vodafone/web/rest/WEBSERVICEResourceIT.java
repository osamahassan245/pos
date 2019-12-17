package com.vodafone.web.rest;

import com.vodafone.PosApp;
import com.vodafone.domain.WEBSERVICE;
import com.vodafone.repository.WEBSERVICERepository;
import com.vodafone.service.WEBSERVICEService;
import com.vodafone.web.rest.errors.ExceptionTranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.List;

import static com.vodafone.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link WEBSERVICEResource} REST controller.
 */
@SpringBootTest(classes = PosApp.class)
public class WEBSERVICEResourceIT {

    private static final Long DEFAULT_G_ID = 1L;
    private static final Long UPDATED_G_ID = 2L;

    private static final String DEFAULT_C_PT = "AAAAAAAAAA";
    private static final String UPDATED_C_PT = "BBBBBBBBBB";

    private static final String DEFAULT_W_SNAM = "AAAAAAAAAA";
    private static final String UPDATED_W_SNAM = "BBBBBBBBBB";

    private static final String DEFAULT_D_ESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_D_ESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_E_NDPOINT = "AAAAAAAAAA";
    private static final String UPDATED_E_NDPOINT = "BBBBBBBBBB";

    private static final String DEFAULT_W_SDL = "AAAAAAAAAA";
    private static final String UPDATED_W_SDL = "BBBBBBBBBB";

    private static final String DEFAULT_U_SERNAME = "AAAAAAAAAA";
    private static final String UPDATED_U_SERNAME = "BBBBBBBBBB";

    private static final String DEFAULT_P_ASSWORD = "AAAAAAAAAA";
    private static final String UPDATED_P_ASSWORD = "BBBBBBBBBB";

    private static final String DEFAULT_T_IMEOUT = "AAAAAAAAAA";
    private static final String UPDATED_T_IMEOUT = "BBBBBBBBBB";

    @Autowired
    private WEBSERVICERepository wEBSERVICERepository;

    @Autowired
    private WEBSERVICEService wEBSERVICEService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restWEBSERVICEMockMvc;

    private WEBSERVICE wEBSERVICE;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final WEBSERVICEResource wEBSERVICEResource = new WEBSERVICEResource(wEBSERVICEService);
        this.restWEBSERVICEMockMvc = MockMvcBuilders.standaloneSetup(wEBSERVICEResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static WEBSERVICE createEntity(EntityManager em) {
        WEBSERVICE wEBSERVICE = new WEBSERVICE()
            .gID(DEFAULT_G_ID)
            .cPT(DEFAULT_C_PT)
            .wSNAM(DEFAULT_W_SNAM)
            .dESCRIPTION(DEFAULT_D_ESCRIPTION)
            .eNDPOINT(DEFAULT_E_NDPOINT)
            .wSDL(DEFAULT_W_SDL)
            .uSERNAME(DEFAULT_U_SERNAME)
            .pASSWORD(DEFAULT_P_ASSWORD)
            .tIMEOUT(DEFAULT_T_IMEOUT);
        return wEBSERVICE;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static WEBSERVICE createUpdatedEntity(EntityManager em) {
        WEBSERVICE wEBSERVICE = new WEBSERVICE()
            .gID(UPDATED_G_ID)
            .cPT(UPDATED_C_PT)
            .wSNAM(UPDATED_W_SNAM)
            .dESCRIPTION(UPDATED_D_ESCRIPTION)
            .eNDPOINT(UPDATED_E_NDPOINT)
            .wSDL(UPDATED_W_SDL)
            .uSERNAME(UPDATED_U_SERNAME)
            .pASSWORD(UPDATED_P_ASSWORD)
            .tIMEOUT(UPDATED_T_IMEOUT);
        return wEBSERVICE;
    }

    @BeforeEach
    public void initTest() {
        wEBSERVICE = createEntity(em);
    }

    @Test
    @Transactional
    public void createWEBSERVICE() throws Exception {
        int databaseSizeBeforeCreate = wEBSERVICERepository.findAll().size();

        // Create the WEBSERVICE
        restWEBSERVICEMockMvc.perform(post("/api/webservices")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(wEBSERVICE)))
            .andExpect(status().isCreated());

        // Validate the WEBSERVICE in the database
        List<WEBSERVICE> wEBSERVICEList = wEBSERVICERepository.findAll();
        assertThat(wEBSERVICEList).hasSize(databaseSizeBeforeCreate + 1);
        WEBSERVICE testWEBSERVICE = wEBSERVICEList.get(wEBSERVICEList.size() - 1);
        assertThat(testWEBSERVICE.getgID()).isEqualTo(DEFAULT_G_ID);
        assertThat(testWEBSERVICE.getcPT()).isEqualTo(DEFAULT_C_PT);
        assertThat(testWEBSERVICE.getwSNAM()).isEqualTo(DEFAULT_W_SNAM);
        assertThat(testWEBSERVICE.getdESCRIPTION()).isEqualTo(DEFAULT_D_ESCRIPTION);
        assertThat(testWEBSERVICE.geteNDPOINT()).isEqualTo(DEFAULT_E_NDPOINT);
        assertThat(testWEBSERVICE.getwSDL()).isEqualTo(DEFAULT_W_SDL);
        assertThat(testWEBSERVICE.getuSERNAME()).isEqualTo(DEFAULT_U_SERNAME);
        assertThat(testWEBSERVICE.getpASSWORD()).isEqualTo(DEFAULT_P_ASSWORD);
        assertThat(testWEBSERVICE.gettIMEOUT()).isEqualTo(DEFAULT_T_IMEOUT);
    }

    @Test
    @Transactional
    public void createWEBSERVICEWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = wEBSERVICERepository.findAll().size();

        // Create the WEBSERVICE with an existing ID
        wEBSERVICE.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restWEBSERVICEMockMvc.perform(post("/api/webservices")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(wEBSERVICE)))
            .andExpect(status().isBadRequest());

        // Validate the WEBSERVICE in the database
        List<WEBSERVICE> wEBSERVICEList = wEBSERVICERepository.findAll();
        assertThat(wEBSERVICEList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllWEBSERVICES() throws Exception {
        // Initialize the database
        wEBSERVICERepository.saveAndFlush(wEBSERVICE);

        // Get all the wEBSERVICEList
        restWEBSERVICEMockMvc.perform(get("/api/webservices?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(wEBSERVICE.getId().intValue())))
            .andExpect(jsonPath("$.[*].gID").value(hasItem(DEFAULT_G_ID.intValue())))
            .andExpect(jsonPath("$.[*].cPT").value(hasItem(DEFAULT_C_PT)))
            .andExpect(jsonPath("$.[*].wSNAM").value(hasItem(DEFAULT_W_SNAM)))
            .andExpect(jsonPath("$.[*].dESCRIPTION").value(hasItem(DEFAULT_D_ESCRIPTION)))
            .andExpect(jsonPath("$.[*].eNDPOINT").value(hasItem(DEFAULT_E_NDPOINT)))
            .andExpect(jsonPath("$.[*].wSDL").value(hasItem(DEFAULT_W_SDL)))
            .andExpect(jsonPath("$.[*].uSERNAME").value(hasItem(DEFAULT_U_SERNAME)))
            .andExpect(jsonPath("$.[*].pASSWORD").value(hasItem(DEFAULT_P_ASSWORD)))
            .andExpect(jsonPath("$.[*].tIMEOUT").value(hasItem(DEFAULT_T_IMEOUT)));
    }
    
    @Test
    @Transactional
    public void getWEBSERVICE() throws Exception {
        // Initialize the database
        wEBSERVICERepository.saveAndFlush(wEBSERVICE);

        // Get the wEBSERVICE
        restWEBSERVICEMockMvc.perform(get("/api/webservices/{id}", wEBSERVICE.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(wEBSERVICE.getId().intValue()))
            .andExpect(jsonPath("$.gID").value(DEFAULT_G_ID.intValue()))
            .andExpect(jsonPath("$.cPT").value(DEFAULT_C_PT))
            .andExpect(jsonPath("$.wSNAM").value(DEFAULT_W_SNAM))
            .andExpect(jsonPath("$.dESCRIPTION").value(DEFAULT_D_ESCRIPTION))
            .andExpect(jsonPath("$.eNDPOINT").value(DEFAULT_E_NDPOINT))
            .andExpect(jsonPath("$.wSDL").value(DEFAULT_W_SDL))
            .andExpect(jsonPath("$.uSERNAME").value(DEFAULT_U_SERNAME))
            .andExpect(jsonPath("$.pASSWORD").value(DEFAULT_P_ASSWORD))
            .andExpect(jsonPath("$.tIMEOUT").value(DEFAULT_T_IMEOUT));
    }

    @Test
    @Transactional
    public void getNonExistingWEBSERVICE() throws Exception {
        // Get the wEBSERVICE
        restWEBSERVICEMockMvc.perform(get("/api/webservices/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateWEBSERVICE() throws Exception {
        // Initialize the database
        wEBSERVICEService.save(wEBSERVICE);

        int databaseSizeBeforeUpdate = wEBSERVICERepository.findAll().size();

        // Update the wEBSERVICE
        WEBSERVICE updatedWEBSERVICE = wEBSERVICERepository.findById(wEBSERVICE.getId()).get();
        // Disconnect from session so that the updates on updatedWEBSERVICE are not directly saved in db
        em.detach(updatedWEBSERVICE);
        updatedWEBSERVICE
            .gID(UPDATED_G_ID)
            .cPT(UPDATED_C_PT)
            .wSNAM(UPDATED_W_SNAM)
            .dESCRIPTION(UPDATED_D_ESCRIPTION)
            .eNDPOINT(UPDATED_E_NDPOINT)
            .wSDL(UPDATED_W_SDL)
            .uSERNAME(UPDATED_U_SERNAME)
            .pASSWORD(UPDATED_P_ASSWORD)
            .tIMEOUT(UPDATED_T_IMEOUT);

        restWEBSERVICEMockMvc.perform(put("/api/webservices")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedWEBSERVICE)))
            .andExpect(status().isOk());

        // Validate the WEBSERVICE in the database
        List<WEBSERVICE> wEBSERVICEList = wEBSERVICERepository.findAll();
        assertThat(wEBSERVICEList).hasSize(databaseSizeBeforeUpdate);
        WEBSERVICE testWEBSERVICE = wEBSERVICEList.get(wEBSERVICEList.size() - 1);
        assertThat(testWEBSERVICE.getgID()).isEqualTo(UPDATED_G_ID);
        assertThat(testWEBSERVICE.getcPT()).isEqualTo(UPDATED_C_PT);
        assertThat(testWEBSERVICE.getwSNAM()).isEqualTo(UPDATED_W_SNAM);
        assertThat(testWEBSERVICE.getdESCRIPTION()).isEqualTo(UPDATED_D_ESCRIPTION);
        assertThat(testWEBSERVICE.geteNDPOINT()).isEqualTo(UPDATED_E_NDPOINT);
        assertThat(testWEBSERVICE.getwSDL()).isEqualTo(UPDATED_W_SDL);
        assertThat(testWEBSERVICE.getuSERNAME()).isEqualTo(UPDATED_U_SERNAME);
        assertThat(testWEBSERVICE.getpASSWORD()).isEqualTo(UPDATED_P_ASSWORD);
        assertThat(testWEBSERVICE.gettIMEOUT()).isEqualTo(UPDATED_T_IMEOUT);
    }

    @Test
    @Transactional
    public void updateNonExistingWEBSERVICE() throws Exception {
        int databaseSizeBeforeUpdate = wEBSERVICERepository.findAll().size();

        // Create the WEBSERVICE

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restWEBSERVICEMockMvc.perform(put("/api/webservices")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(wEBSERVICE)))
            .andExpect(status().isBadRequest());

        // Validate the WEBSERVICE in the database
        List<WEBSERVICE> wEBSERVICEList = wEBSERVICERepository.findAll();
        assertThat(wEBSERVICEList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteWEBSERVICE() throws Exception {
        // Initialize the database
        wEBSERVICEService.save(wEBSERVICE);

        int databaseSizeBeforeDelete = wEBSERVICERepository.findAll().size();

        // Delete the wEBSERVICE
        restWEBSERVICEMockMvc.perform(delete("/api/webservices/{id}", wEBSERVICE.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<WEBSERVICE> wEBSERVICEList = wEBSERVICERepository.findAll();
        assertThat(wEBSERVICEList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
