package com.inditex.inditex_technical_test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.inditex.inditex_technical_test.dto.AlbumDTO;
import com.inditex.inditex_technical_test.dto.ConfirmationDTO;
import com.inditex.inditex_technical_test.service.DataCollectionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AlbumDataControllerTest {
    private ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    private MockMvc mockMvc;
    @Mock
    private DataCollectionService dataCollectionService;

    @InjectMocks
    private AlbumDataController albumDataController;

    private Set<AlbumDTO> albumDTOList = new LinkedHashSet<>();

    private Flux<AlbumDTO> albumDTOFlux = null;

    private ConfirmationDTO confirmationDTO = new ConfirmationDTO();

    @BeforeEach
    public void setup() {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(albumDataController).build();

        AlbumDTO albumDTO1 = new AlbumDTO();
        albumDTO1.setId(1);
        albumDTO1.setUserId(1);
        albumDTO1.setTitle("XXX");
        albumDTO1.setPhotoList(new ArrayList<>());

        AlbumDTO albumDTO2 = new AlbumDTO();
        albumDTO2.setId(2);
        albumDTO2.setUserId(1);
        albumDTO2.setTitle("XXX");
        albumDTO2.setPhotoList(new ArrayList<>());

        AlbumDTO albumDTO3 = new AlbumDTO();
        albumDTO3.setId(3);
        albumDTO3.setUserId(1);
        albumDTO3.setTitle("XXX");
        albumDTO3.setPhotoList(new ArrayList<>());

        albumDTOList.add(albumDTO1);
        albumDTOList.add(albumDTO2);
        albumDTOList.add(albumDTO3);

        albumDTOFlux = Flux.fromIterable(albumDTOList);

        confirmationDTO.setCode("200 OK");
        confirmationDTO.setDescription("OK");

    }

    @Test
    void test_when_getAlbumsFromDatabase_Is_Ok() throws Exception {

        when(dataCollectionService.getDataFromDatabase()).thenReturn(albumDTOFlux);
        mockMvc.perform(get("/v2/albums-from-h2").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    void test_when_saveAlbumsInDatabase_Is_Ok() throws Exception {

        when(dataCollectionService.saveDataInDatabase()).thenReturn(Mono.just(confirmationDTO));
        mockMvc.perform(get("/v2/save-albums-in-database").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

}