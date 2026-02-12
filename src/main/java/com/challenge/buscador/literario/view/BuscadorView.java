package com.challenge.buscador.literario.view;

import com.challenge.buscador.literario.dto.LivroDtoResponse;
import com.challenge.buscador.literario.service.BuscadorService;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Component
public class BuscadorView {
    private final BuscadorService service;

    public BuscadorView(BuscadorService service) {
        this.service = service;
    }

    private final Scanner scanner = new Scanner(System.in);

    public void startApp() {
        String menu = """
                ***********************************************************
                **********************ACERVO GUTENDEX**********************
                *** Escolha uma opção:
                
                1 - Buscar livro por nome
                2 - Listar livros registrados
                3 - Listar autores registrados
                4 - Listar autores vivos em determinado ano
                5 - Listar livros por idioma
                
                0 - Sair
                """;
        int option = -1;
        while (option != 0) {
            System.out.println(menu);
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e ){
                System.out.println("Entrada inválida! A opção deve ser numérica.");
            }
            scanner.nextLine();
             switch (option) {
                 case 1:
                     buscarLivroPorNome();
                     break;
                 case 2:
                     listarLivros();
                     break;
//                 case 3:
//                     listarAutores();
//                     break;
//                 case 4:
//                     listarAutoresVivos();
//                     break;
//                 case 5:
//                     listarLivrosPorIdioma();
//                     break;
                 case 0:
                     System.out.println("Saindo...");
                     break;
                 default:
                     System.out.println("Digite uma das opções da lista ");
             }
        }
    }

    private void listarLivros() {
        List<LivroDtoResponse> livros = service.buscarLivros();

        System.out.println("-".repeat(30));
        System.out.println("Todos os livros baixados: \n");
        livros.forEach(l -> System.out.println(l.title() + "\nAutor: " +
                        l.authors().getFirst().name() + "\nTotal downloads: " + l.downloadCount() + "\n***")
        );
//        System.out.println("-".repeat(30));
    }

    private void buscarLivroPorNome() {
        System.out.println("Informe o nome da obra: ");
        String nomeLivro = scanner.nextLine();

        service.buscarLivroPorNome(nomeLivro);
    }
}
