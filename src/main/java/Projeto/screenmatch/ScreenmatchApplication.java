package Projeto.screenmatch;

import Projeto.screenmatch.model.DadosSerie;
import Projeto.screenmatch.service.ConsumindoApi;
import Projeto.screenmatch.service.ConverteDado;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoapi = new ConsumindoApi();
		var json = consumoapi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=454f06d7");
//		System.out.println(json);

		ConverteDado conversor = new ConverteDado();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
