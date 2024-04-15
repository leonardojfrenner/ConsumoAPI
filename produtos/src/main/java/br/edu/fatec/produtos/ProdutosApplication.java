package br.edu.fatec.produtos;

import br.edu.fatec.produtos.service.ConsomeApi;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@SpringBootApplication
public class ProdutosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProdutosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsomeApi apiConsumer = new ConsomeApi();
		String dados = apiConsumer.obterDados("https://api.escuelajs.co/api/v1/products/");

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(dados);

		List<String> produtosImperdiveis = StreamSupport.stream(jsonNode.spliterator(), false)
				.filter(product -> {
					JsonNode priceNode = product.get("price");
					return priceNode != null && !priceNode.isNull() && priceNode.asDouble() < 30;
				})
				.map(product -> {
					String title = product.get("title").asText().toUpperCase();
					double price = product.get("price").asDouble();
					return title + " - IMPERDÍVEL! (R$" + price + ")";
				})
				.collect(Collectors.toList());

		System.out.println("Produtos Imperdíveis:");
		produtosImperdiveis.forEach(System.out::println);
		System.out.println("Total de produtos imperdíveis: " + produtosImperdiveis.size());
	}
}
