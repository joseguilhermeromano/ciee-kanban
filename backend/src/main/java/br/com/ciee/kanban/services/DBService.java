package br.com.ciee.kanban.services;

import br.com.ciee.kanban.domain.Kanban;
import br.com.ciee.kanban.repositories.KanbanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private KanbanRepository kanbanRepository;
    public void instanciaBaseDados(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Kanban k1 = new Kanban(
                null,
                "Matheus Silva",
                "matheus.silva@gmail.com", 
                "Analisar Currículo e documentos.",
                LocalDate.parse("25/02/2024", formatter),
                "screening",
                0,
                false
        );

        Kanban k2 = new Kanban(
                null,
                "Igor Alves",
                "igor.alves@gmail.com",
                "Analisar Currículo e documentos.",
                LocalDate.parse("22/02/2024", formatter),
                "screening",
                1,
                true
        );

        Kanban k3 = new Kanban(
                null,
                "Ricardo Costa",
                "ricardo.costa@gmail.com",
                "Analisar Currículo e documentos.",
                LocalDate.parse("21/02/2024", formatter),
                "screening",
                2,
                false
        );

        Kanban k4 = new Kanban(
                null,
                "Alexandre Oliveira",
                "alexandre.oliveira@gmail.com",
                "Analisar Currículo e documentos.",
                LocalDate.parse("27/02/2024", formatter),
                "interview",
                0,
                true
        );

        Kanban k5 = new Kanban(
                null,
                "Lucino Almeida",
                "lucino.almeida@gmail.com",
                "Analisar Currículo e documentos.",
                LocalDate.parse("27/02/2024", formatter),
                "interview",
                1,
                true
        );

        Kanban k6 = new Kanban(
                null,
                "Maria Neves",
                "maria.neves@gmail.com", 
                "Analisar Currículo e documentos.",
                LocalDate.parse("25/02/2024", formatter),
                "interview",
                2,
                false
        );

        Kanban k7 = new Kanban(
                null,
                "Daniel Novaes",
                "daniel.novaes@gmail.com",
                "Analisar Currículo e documentos.",
                LocalDate.parse("22/02/2024", formatter),
                "proposal",
                0,
                true
        );

        Kanban k8 = new Kanban(
                null,
                "Ana Clara",
                "ana.clara@gmail.com",
                "Analisar Currículo e documentos.",
                LocalDate.parse("21/02/2024", formatter),
                "proposal",
                1,
                false
        );

        Kanban k9 = new Kanban(
                null,
                "Elizete Bezerra",
                "elizete.bezerra@gmail.com",
                "Analisar Currículo e documentos.",
                LocalDate.parse("27/02/2024", formatter),
                "contract",
                0,
                true
        );

        Kanban k10 = new Kanban(
                null,
                "Thiago Lima",
                "thiago.lima@gmail.com",
                "Analisar Currículo e documentos.",
                LocalDate.parse("27/02/2024", formatter),
                "contract",
                1,
                true
        );
        kanbanRepository.saveAll(Arrays.asList(k1, k2, k3, k4, k5, k6, k7, k8, k9, k10));
    }
}
