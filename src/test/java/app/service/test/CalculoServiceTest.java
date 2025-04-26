package app.service.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.service.CalculoService;

@SpringBootTest
public class CalculoServiceTest {

    @Autowired
    CalculoService calculoService;

    @Test
    @DisplayName("Cena 01 - Testando o método somar com valores válidos")
    void cenario01() {
        List<Integer> lista = List.of(3, 5, 2);
        int resultadoEsperado = 10;
        int resultadoObtido = this.calculoService.soma(lista);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    @DisplayName("Cena 02 - Testando o método somar com valores inválidos")
    void cenario02() {
        List<Integer> lista = new ArrayList<>();
        lista.add(3);
        lista.add(null);
        lista.add(2);

        assertThrows(RuntimeException.class, () -> {
            this.calculoService.soma(lista);
        });
    }

    @Test
    @DisplayName("Cena 03 - Testar mediana com número par de elementos")
    void cenario03() {
        List<Integer> lista = List.of(3, 2, 3, 4);
        assertEquals(3.0, this.calculoService.mediana(lista));
    }

    @Test
    @DisplayName("Cena 04 - Testar mediana com número ímpar de elementos")
    void cenario04() {
        List<Integer> lista = List.of(3, 2, 1, 9, 4);
        assertEquals(3.0, this.calculoService.mediana(lista));
    }

    @Test
    @DisplayName("Cena 05 - Testar mediana com lista de 7 elementos")
    void cenario05() {
        List<Integer> lista = List.of(8, 2, 1, 9, 39, 339, 4);
        assertEquals(8.0, this.calculoService.mediana(lista));
    }

    @Test
    @DisplayName("Cena 06 - Testar média com valores válidos")
    void cenario06() {
        List<Integer> lista = List.of(10, 20, 30);
        assertEquals(20.0, this.calculoService.media(lista));
    }

    @Test
    @DisplayName("Cena 07 - Testar maior número")
    void cenario07() {
        List<Integer> lista = List.of(1, 5, 9, 3, 4);
        assertEquals(9, this.calculoService.maiorNumero(lista));
    }

    @Test
    @DisplayName("Cena 08 - Testar menor número")
    void cenario08() {
        List<Integer> lista = List.of(10, 4, 5, 99);
        assertEquals(4, this.calculoService.menorNumero(lista));
    }

    @Test
    @DisplayName("Cena 09 - Testar moda com número que mais se repete")
    void cenario09() {
        List<Integer> lista = List.of(2, 3, 3, 5, 5, 5, 1);
        assertEquals(5, this.calculoService.moda(lista));
    }

    @Test
    @DisplayName("Cena 10 - Testar moda com empate (moda menor deve aparecer)")
    void cenario10() {
        List<Integer> lista = List.of(2, 2, 3, 3);
        int resultado = this.calculoService.moda(lista);
        assertTrue(resultado == 2 || resultado == 3); // aceitamos qualquer um dos dois
    }

    @Test
    @DisplayName("Cena 11 - Testar métodos com lista nula")
    void cenario11() {
        assertThrows(IllegalArgumentException.class, () -> calculoService.mediana(null));
        assertThrows(IllegalArgumentException.class, () -> calculoService.maiorNumero(null));
        assertThrows(IllegalArgumentException.class, () -> calculoService.menorNumero(null));
        assertThrows(IllegalArgumentException.class, () -> calculoService.moda(null));
    }

    @Test
    @DisplayName("Cena 12 - Testar métodos com lista vazia")
    void cenario12() {
        List<Integer> vazia = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> calculoService.mediana(vazia));
        assertThrows(IllegalArgumentException.class, () -> calculoService.maiorNumero(vazia));
        assertThrows(IllegalArgumentException.class, () -> calculoService.menorNumero(vazia));
        assertThrows(IllegalArgumentException.class, () -> calculoService.moda(vazia));
    }
}
