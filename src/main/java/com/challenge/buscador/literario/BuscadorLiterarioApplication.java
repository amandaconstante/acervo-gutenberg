package com.challenge.buscador.literario;

import com.challenge.buscador.literario.view.BuscadorView;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuscadorLiterarioApplication implements CommandLineRunner {
    private final BuscadorView view;

    public BuscadorLiterarioApplication(BuscadorView view) {
        this.view = view;
    }

	public static void main(String[] args) {
		SpringApplication.run(BuscadorLiterarioApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        view.startApp();
    }
}
