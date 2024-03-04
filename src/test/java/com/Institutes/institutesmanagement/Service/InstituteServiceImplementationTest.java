package com.Institutes.institutesmanagement.Service;

import com.Institutes.institutesmanagement.Entity.Institute;
import com.Institutes.institutesmanagement.Repository.InstituteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

//import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


class InstituteServiceImplementationTest {


    @Mock
    private InstituteRepository instituteRepository;
    private InstituteService instituteService;

    AutoCloseable autoCloseable;

    Institute institute;


    @BeforeEach
    void setUp() {

        autoCloseable = MockitoAnnotations.openMocks(this);
        instituteService = new InstituteServiceImplementation(instituteRepository);
        institute = new Institute(1L, "siddaganga", "tumkur", "sit@gmail.com", "AI");


    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void registerInstitute() {
        mock(Institute.class);
        mock(InstituteRepository.class);

        when(instituteRepository.save(institute)).thenReturn(institute);
        /*assertThat(instituteService.registerInstitute(institute).getName()).isEqualTo(institute.getName());*/
        assertThat(instituteService.registerInstitute(institute)).isEqualTo(institute);


    }

    @Test
    void testgetInstituteById() {
        mock(Institute.class);
        mock(InstituteRepository.class);

        when(instituteRepository.findById(1L)).thenReturn(Optional.ofNullable(institute));

        assertThat(instituteService.getInstituteById(1L).getName())
                .isEqualTo(institute.getName());
    }

    @Test
    void testgetAllinstitutes() {

        mock(Institute.class);
        mock(InstituteRepository.class);

        when(instituteRepository.findAll()).thenReturn(new ArrayList<Institute>(
                Collections.singleton(institute)
        ));

        assertThat(instituteService.getAllinstitutes().get(0).getContact()).
                isEqualTo(institute.getContact());


    }

    @Test
    void testupdateinstitute() {
        mock(Institute.class);
        mock(InstituteRepository.class);

        Institute updatedinstitute = new Institute(1L, "bangaloreuniversity", "tumkur", "sit@gmail.com", "AI");

        when(instituteRepository.save(updatedinstitute)).thenReturn(updatedinstitute);
        assertEquals("bangaloreuniversity", updatedinstitute.getName());


    }

    @Test
    void testdeletInstituteById() {
        mock(Institute.class);
        mock(InstituteRepository.class);
        instituteService.deletInstituteById(1l);
        Mockito.verify(instituteRepository, Mockito.times(1)).deleteById(1l);
    }
}