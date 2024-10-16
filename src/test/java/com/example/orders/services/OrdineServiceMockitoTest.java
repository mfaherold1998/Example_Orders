package com.example.orders.services;

import com.example.orders.dto.ClientDto;
import com.example.orders.dto.OrdineDto;
import com.example.orders.entity.Client;
import com.example.orders.entity.Ordine;
import com.example.orders.exceptions.NotFoundException;
import com.example.orders.mappers.OrdineMapper;
import com.example.orders.repository.OrdineRepository;
import com.example.orders.service.OrdineService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class OrdineServiceMockitoTest {

    @Mock
    private OrdineRepository ordineRepository;

    @Spy
    private OrdineMapper ordineMapper = Mappers.getMapper(OrdineMapper.class);

    @InjectMocks
    private OrdineService ordineService;

    private NotFoundException createNotFoundException(Long id){
        return new NotFoundException("Not Found Exception","There is not Bill with id "+id);
    }

    @Test
    void getAllOrdini_withValidOrdineDTO_returnListOOrdineDto() {

        Client cli = Client.builder().id(1L).build();
        Ordine ordine1 = Ordine.builder().id(1L).dateOrdine(new Date()).total(100.0).cli(cli).build();
        Ordine ordine2 = Ordine.builder().id(2L).dateOrdine(new Date()).total(100.0).cli(cli).build();
        List<Ordine> ordini = new ArrayList<>();
        ordini.add(ordine1);
        ordini.add(ordine2);

        Mockito.when(ordineRepository.findAll()).thenReturn(ordini);

        List<OrdineDto> response = ordineService.getAllOrdini();

        assertEquals(2, response.size());

    }

    @Test
    void getAllOrdine_withNone_returnEmptyListOfOrdineDto() {

        List<Ordine> ordini = new ArrayList<>();

        Mockito.when(ordineRepository.findAll()).thenReturn(ordini);

        List<OrdineDto> response = ordineService.getAllOrdini();

        assertEquals(0, response.size());
    }

    @Test
    void saveOrdine_withValidOrdineDTO_returnSavedOrdineDto() {

        Client cli = Client.builder().id(1L).build();
        ClientDto cliDto = ClientDto.builder().id(1L).build();
        Ordine ordine = Ordine.builder().id(1L).dateOrdine(new Date()).total(100.0).cli(cli).build();
        OrdineDto ordineDto = OrdineDto.builder().id(1L).dateOrdine(new Date()).total(100.0).cli(cliDto).build();

        Mockito.when(ordineRepository.saveAndFlush(ArgumentMatchers.any(Ordine.class))).thenReturn(ordine);

        OrdineDto savedDto = ordineService.saveOrdine(ordineDto);

        assertNotNull(savedDto);
    }

    @Test
    void saveOrdine_withInvalidOrdineDTO_throwException() {

        ClientDto cliDto = ClientDto.builder().id(1L).build();
        OrdineDto ordineDto = OrdineDto.builder().id(1L).dateOrdine(new Date()).total(100.0).cli(cliDto).build();

        Mockito.when(ordineRepository.saveAndFlush(ArgumentMatchers.any(Ordine.class))).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> {
            ordineService.saveOrdine(ordineDto);
        });
    }

    @Test
    void saveOrdine_withTwoValidDto_returnOrdineDto() {

        Client cli = Client.builder().id(1L).build();
        ClientDto cliDto = ClientDto.builder().id(1L).build();
        Ordine ordine = Ordine.builder().id(1L).dateOrdine(new Date()).total(100.0).cli(cli).build();
        OrdineDto ordineDto = OrdineDto.builder().id(1L).dateOrdine(new Date()).total(100.0).cli(cliDto).build();


        Mockito.when(ordineRepository.saveAndFlush(ArgumentMatchers.any(Ordine.class))).thenReturn(ordine);

        OrdineDto savedOrdine = ordineService.saveOrdine(ordineDto);

        assertEquals(1L, savedOrdine.getId());
    }

    @Test
    void getOrdineById_withValidOrdineDto_returnOrdineDto(){

        Long id = 1L;
        Client cli = Client.builder().id(1L).build();
        Ordine ordine = Ordine.builder().id(1L).dateOrdine(new Date()).total(100.0).cli(cli).build();
        Optional<Ordine> optOrdine = Optional.of(ordine);

        Mockito.when(ordineRepository.findById(id)).thenReturn(optOrdine);

        OrdineDto ord = ordineService.getOrdineById(id);

        assertNotNull(ord);
        assertEquals(1L, cli.getId());

    }

    @Test
    void getOrdineById_withInvalidId_throwException(){

        Long id = 1L;

        Mockito.when(ordineRepository.findById(id)).thenThrow(createNotFoundException(id));

        assertThrows(NotFoundException.class, () -> {
            ordineService.getOrdineById(id);
        });
    }

    @Test
    void deleteOrdine_withValidOrdineDto_mockitoVerify(){

        Long id = 1L;

        Mockito.when(ordineRepository.existsById(id)).thenReturn(true);
        Mockito.doNothing().when(ordineRepository).deleteById(id);

        ordineService.deleteOrdine(id);

        Mockito.verify(ordineRepository, Mockito.times(1)).deleteById(id);

    }

    @Test
    void deleteOrdine_withInvalidId_throwException(){

        Long id = 1L;

        assertThrows(NotFoundException.class, () -> {
            ordineService.deleteOrdine(id);
        });
    }

    @Test
    void existById_withExistingOrdineDto_returnTrue(){

        Long id = 1L;

        Mockito.when(ordineRepository.existsById(id)).thenReturn(true);

        assertTrue(ordineService.existsById(id));
    }

    @Test
    void updateOrdine_withValidOrdineDto_returnUpdatedOrdineDto(){

        Long id = 1L;
        Client cli = Client.builder().id(id).build();
        ClientDto cliDto = ClientDto.builder().id(id).build();
        Ordine ordine = Ordine.builder().id(id).dateOrdine(new Date()).total(100.0).cli(cli).build();
        OrdineDto ordineDto = OrdineDto.builder().id(id).dateOrdine(new Date()).total(100.0).cli(cliDto).build();

        Mockito.when(ordineRepository.saveAndFlush(ArgumentMatchers.any(Ordine.class))).thenReturn(ordine);
        Mockito.when(ordineRepository.existsById(id)).thenReturn(true);

        OrdineDto updatedOrdine = ordineService.updateOrdine(ordineDto);

        assertEquals(id, updatedOrdine.getId());
    }

    @Test
    void updateOrdine_withInvalidOrdineDto_throwException(){

        Long id = 1L;
        OrdineDto ordineDto = OrdineDto.builder().id(id).build();

        Mockito.when(ordineRepository.existsById(id)).thenReturn(false);

        assertThrows(NotFoundException.class, () -> {
            ordineService.updateOrdine(ordineDto);
        });
    }

}
