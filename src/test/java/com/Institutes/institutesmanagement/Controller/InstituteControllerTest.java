package com.Institutes.institutesmanagement.Controller;

import com.Institutes.institutesmanagement.Entity.Institute;
import com.Institutes.institutesmanagement.Service.InstituteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InstituteController.class)
class InstituteControllerTest {


    @Autowired
    private MockMvc mockmvc;
    @MockBean
    private InstituteService instituteService;
    Institute instituteone;
    Institute institutetwo;

 List<Institute> instituteList=new ArrayList<>();


    @BeforeEach
    void setUp() {
        instituteone=new Institute(1L, "siddaganga", "tumkur", "sit@gmail.com", "AI");

    institutetwo=new Institute(2l, "rv collage", "bangalore", "rv@gmail.com", "mech");
        instituteList.add(instituteone);
        instituteList.add(institutetwo);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testregisterInstitute() throws Exception {

        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(instituteone);

        when(instituteService.registerInstitute(instituteone))
                .thenReturn(instituteone);
        this.mockmvc.perform(post("/api/institutes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void testgetByInstituteId() throws Exception{

        when(instituteService.getInstituteById(2l))
                .thenReturn(institutetwo);
        this.mockmvc.perform(get("/api/institutes/2")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    void testgetAllInstitutes() throws Exception{
        when(instituteService.getAllinstitutes())
                .thenReturn(instituteList);
        this.mockmvc.perform(get("/api/institutes")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testupdateInstitute() throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(instituteone);

        when(instituteService.updateinstitute(instituteone))
                .thenReturn(instituteone);
        this.mockmvc.perform(put("/api/institutes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                     .andDo(print())
                     .andExpect(status().isOk());
    }

    @Test
    void testdeleteinstituteById() throws Exception {
        when(instituteService.deletInstituteById(1l)).thenReturn("success");
        this.mockmvc.perform(delete("/api/institutes/1")).andDo(print()).andExpect(status().isOk());


    }
}