package com.policymanagement.profile.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.policymanagement.profile.dao.NomineeRelationDAO;
import com.policymanagement.profile.entity.NomineeRelation;
import com.policymanagement.profile.model.NomineeRelationDTO;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NomineeRelationImplementationTest {
  
    @Test
    void testGetNomineeTypes() {
       
        NomineeRelationDAO nomineeRelationRepository = mock(NomineeRelationDAO.class);
        when(nomineeRelationRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue((new NomineeRelationImplementation(nomineeRelationRepository)).getNomineeTypes().isEmpty());
        verify(nomineeRelationRepository).findAll();
    }

    @Test
    void testGetNomineeTypes2() {
    
        ArrayList<NomineeRelation> nomineeRelationList = new ArrayList<>();
        nomineeRelationList.add(new NomineeRelation());
        NomineeRelationDAO nomineeRelationRepository = mock(NomineeRelationDAO.class);
        when(nomineeRelationRepository.findAll()).thenReturn(nomineeRelationList);
        List<NomineeRelationDTO> actualNomineeTypes = (new NomineeRelationImplementation(nomineeRelationRepository))
                .getNomineeTypes();
        assertEquals(1, actualNomineeTypes.size());
        NomineeRelationDTO getResult = actualNomineeTypes.get(0);
        assertNull(getResult.getId());
        assertNull(getResult.getType());
        verify(nomineeRelationRepository).findAll();
    }

   
  

 
    @Test
    void testSeedNomineeTypes2() {
        
        NomineeRelationDAO nomineeRelationRepository = mock(NomineeRelationDAO.class);
        when(nomineeRelationRepository.save(Mockito.<NomineeRelation>any())).thenReturn(new NomineeRelation());
        NomineeRelationImplementation nomineeRelationImplementation = new NomineeRelationImplementation(
                nomineeRelationRepository);

        ArrayList<String> nomineeTypes = new ArrayList<>();
        nomineeTypes.add("foo");
        nomineeRelationImplementation.seedNomineeTypes(nomineeTypes);
        verify(nomineeRelationRepository).save(Mockito.<NomineeRelation>any());
    }
}

