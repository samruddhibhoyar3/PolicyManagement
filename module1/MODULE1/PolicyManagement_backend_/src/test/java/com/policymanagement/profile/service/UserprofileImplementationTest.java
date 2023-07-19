package com.policymanagement.profile.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.policymanagement.profile.dao.UserprofileDAO;
import com.policymanagement.profile.entity.Userprofile;
import com.policymanagement.profile.model.UserprofileDTO;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserprofileImplementationTest {
   
    @Test
    void testCreateUser() {
        

        UserprofileImplementation userprofileImplementation = new UserprofileImplementation(mock(UserprofileDAO.class));
        assertThrows(IllegalArgumentException.class, () -> userprofileImplementation.createUser(new UserprofileDTO()));
    }

  
  
    @Test
    void testCreateUser4() {
      

        UserprofileDAO userprofileRepository = mock(UserprofileDAO.class);
        when(userprofileRepository.save(Mockito.<Userprofile>any())).thenReturn(new Userprofile());
        when(userprofileRepository.count()).thenReturn(3L);
        UserprofileImplementation userprofileImplementation = new UserprofileImplementation(userprofileRepository);
        UserprofileDTO profileDTO = new UserprofileDTO(1L, "janedoe", "Jane", "Indian", "Smith", LocalDate.of(1970, 1, 1),
                "Indian", "Indian", "42 Main St", "Indian", "Indian", "42", "6625550144", "42 Main St");

        UserprofileDTO actualCreateUserResult = userprofileImplementation.createUser(profileDTO);
        assertNull(actualCreateUserResult.getCurrentAddress());
        assertNull(actualCreateUserResult.getUsername());
        assertNull(actualCreateUserResult.getProfession());
        assertNull(actualCreateUserResult.getPhoneNumber());
        assertNull(actualCreateUserResult.getNationality());
        assertNull(actualCreateUserResult.getMiddleName());
        assertNull(actualCreateUserResult.getLastName());
        assertNull(actualCreateUserResult.getIdProof());
        assertNull(actualCreateUserResult.getGender());
        assertEquals("", actualCreateUserResult.getFirstTwoLettersLowerCase());
        assertNull(actualCreateUserResult.getEmailAddress());
        assertNull(actualCreateUserResult.getDocNumber());
        assertNull(actualCreateUserResult.getDateOfBirth());
        verify(userprofileRepository).save(Mockito.<Userprofile>any());
        verify(userprofileRepository).count();
        assertEquals("jasmit0004", profileDTO.getUsername());
    }

     
    @Test
    void testCreateUser6() {
      

        UserprofileDAO userprofileRepository = mock(UserprofileDAO.class);
        when(userprofileRepository.count()).thenThrow(new IllegalArgumentException("Indian"));
        UserprofileImplementation userprofileImplementation = new UserprofileImplementation(userprofileRepository);
        assertThrows(IllegalArgumentException.class,
                () -> userprofileImplementation
                        .createUser(new UserprofileDTO(1L, "janedoe", "Jane", "Indian", "Smith", LocalDate.of(1970, 1, 1),
                                "Indian", "Indian", "42 Main St", "Indian", "Indian", "42", "6625550144", "42 Main St")));
        verify(userprofileRepository).count();
    }

   
  
  
    @Test
    void testGenerateUsername4() {
     

        UserprofileDAO userprofileRepository = mock(UserprofileDAO.class);
        when(userprofileRepository.count()).thenReturn(3L);
        UserprofileImplementation userprofileImplementation = new UserprofileImplementation(userprofileRepository);
        UserprofileDTO profileDTO = new UserprofileDTO(1L, "janedoe", "Jane", "Middle Name", "Smith",
                LocalDate.of(1970, 1, 1), "Gender", "Profession", "42 Main St", "Nationality", "Id Proof", "42", "6625550144",
                "42 Main St");

        userprofileImplementation.generateUsername(profileDTO);
        verify(userprofileRepository).count();
        assertEquals("jasmit0004", profileDTO.getUsername());
    }

  
    @Test
    void testGenerateUsername5() {
    

        UserprofileDAO userprofileRepository = mock(UserprofileDAO.class);
        when(userprofileRepository.count()).thenThrow(new IllegalArgumentException("%04d"));
        UserprofileImplementation userprofileImplementation = new UserprofileImplementation(userprofileRepository);
        assertThrows(IllegalArgumentException.class,
                () -> userprofileImplementation.generateUsername(
                        new UserprofileDTO(1L, "janedoe", "Jane", "Middle Name", "Smith", LocalDate.of(1970, 1, 1), "Gender",
                                "Profession", "42 Main St", "Nationality", "Id Proof", "42", "6625550144", "42 Main St")));
        verify(userprofileRepository).count();
    }

  
    @Test
    void testGetUserByUsername() {
       

        UserprofileDAO userprofileRepository = mock(UserprofileDAO.class);
        Userprofile userprofile = new Userprofile();
        when(userprofileRepository.findByUsername(Mockito.<String>any())).thenReturn(userprofile);
        assertSame(userprofile, (new UserprofileImplementation(userprofileRepository)).getUserByUsername("janedoe"));
        verify(userprofileRepository).findByUsername(Mockito.<String>any());
    }

   
    @Test
    void testGetUserByUsername2() {
       

        UserprofileDAO userprofileRepository = mock(UserprofileDAO.class);
        when(userprofileRepository.findByUsername(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class,
                () -> (new UserprofileImplementation(userprofileRepository)).getUserByUsername("janedoe"));
        verify(userprofileRepository).findByUsername(Mockito.<String>any());
    }

    
    @Test
    void testGetUserProfile() {
       

        UserprofileDAO userprofileRepository = mock(UserprofileDAO.class);
        when(userprofileRepository.findByUsername(Mockito.<String>any())).thenReturn(new Userprofile());
        UserprofileDTO actualUserProfile = (new UserprofileImplementation(userprofileRepository))
                .getUserProfile("janedoe");
        assertNull(actualUserProfile.getCurrentAddress());
        assertNull(actualUserProfile.getUsername());
        assertNull(actualUserProfile.getProfession());
        assertNull(actualUserProfile.getPhoneNumber());
        assertNull(actualUserProfile.getNationality());
        assertNull(actualUserProfile.getMiddleName());
        assertNull(actualUserProfile.getLastName());
        assertNull(actualUserProfile.getIdProof());
        assertNull(actualUserProfile.getGender());
        assertEquals("", actualUserProfile.getFirstTwoLettersLowerCase());
        assertNull(actualUserProfile.getEmailAddress());
        assertNull(actualUserProfile.getDocNumber());
        assertNull(actualUserProfile.getDateOfBirth());
        verify(userprofileRepository).findByUsername(Mockito.<String>any());
    }

   
    @Test
    void testGetUserProfile2() {
        

        UserprofileDAO userprofileRepository = mock(UserprofileDAO.class);
        when(userprofileRepository.findByUsername(Mockito.<String>any())).thenReturn(null);
        assertNull((new UserprofileImplementation(userprofileRepository)).getUserProfile("janedoe"));
        verify(userprofileRepository).findByUsername(Mockito.<String>any());
    }

   
    @Test
    void testGetUserProfile3() {
        

        Userprofile userprofile = mock(Userprofile.class);
        when(userprofile.getUsername()).thenThrow(new IllegalArgumentException("foo"));
        UserprofileDAO userprofileRepository = mock(UserprofileDAO.class);
        when(userprofileRepository.findByUsername(Mockito.<String>any())).thenReturn(userprofile);
        assertThrows(IllegalArgumentException.class,
                () -> (new UserprofileImplementation(userprofileRepository)).getUserProfile("janedoe"));
        verify(userprofileRepository).findByUsername(Mockito.<String>any());
        verify(userprofile).getUsername();
    }
}

