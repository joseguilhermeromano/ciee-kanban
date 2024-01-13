package br.com.ciee.kanban.services;

import br.com.ciee.kanban.domain.Kanban;
import br.com.ciee.kanban.repositories.KanbanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private KanbanRepository kanbanRepository;
    public void instanciaBaseDados(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Kanban k1 = new Kanban(
                null,
                "Estudar",
                "Estudar Spring Boot 2 e Angular 11",
                LocalDateTime.parse("25/03/2022 10:40", formatter),
                false
        );

        Kanban k2 = new Kanban(
                null,
                "Ler",
                "Ler livro de desenvolvimento pessoal",
                LocalDateTime.parse("22/03/2022 10:40", formatter),
                true
        );

        Kanban k3 = new Kanban(
                null,
                "Exercicios",
                "Praticar exercícios físicos",
                LocalDateTime.parse("21/03/2022 10:40", formatter),
                false
        );

        Kanban k4 = new Kanban(
                null,
                "Meditar",
                "Meditar durante 30 minutos pela manhã",
                LocalDateTime.parse("27/03/2022 10:40", formatter),
                true
        );
        kanbanRepository.saveAll(Arrays.asList(k1, k2, k3, k4));
    }
}
