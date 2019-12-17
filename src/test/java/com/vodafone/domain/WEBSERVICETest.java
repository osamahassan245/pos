package com.vodafone.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.vodafone.web.rest.TestUtil;

public class WEBSERVICETest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(WEBSERVICE.class);
        WEBSERVICE wEBSERVICE1 = new WEBSERVICE();
        wEBSERVICE1.setId(1L);
        WEBSERVICE wEBSERVICE2 = new WEBSERVICE();
        wEBSERVICE2.setId(wEBSERVICE1.getId());
        assertThat(wEBSERVICE1).isEqualTo(wEBSERVICE2);
        wEBSERVICE2.setId(2L);
        assertThat(wEBSERVICE1).isNotEqualTo(wEBSERVICE2);
        wEBSERVICE1.setId(null);
        assertThat(wEBSERVICE1).isNotEqualTo(wEBSERVICE2);
    }
}
