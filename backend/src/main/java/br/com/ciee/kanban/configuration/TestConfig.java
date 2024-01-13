package br.com.ciee.kanban.configuration;

import br.com.ciee.kanban.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    private DBService dbService;
    @Bean
    public boolean instancia() {
        this.dbService.instanciaBaseDados();
        return true;
    }
}
