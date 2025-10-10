package org.serratec.exercicios_aula02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
	
	@GetMapping("/calcular")
	public String calcular(@RequestParam double num1, @RequestParam double num2, @RequestParam String operacao) {
		double resultado;
		switch (operacao) {
		case "soma" -> resultado = num1 + num2;
		case "substracao" -> resultado = num1 - num2;
		case "multiplicacao" -> resultado = num1 * num2;
		case "divisao" -> {
			if (num2 == 0) return "Erro: não é possível dividir por 0!";
			resultado = num1/num2;
		}
		default -> {
			return "Erro: operação inválida!";
		}
	}
		return "Resultado: " + resultado;
//		Outra forma de retornar poderia ser usando o formatted:
//		%.2f diz que a variavel é um float com 2 casas decimais (ex: 1,00)
//		return "Resultado: %.2f".formatted(resultado);
		
	}
	
	@GetMapping("/somar")
	public double somar(@RequestParam double num1, @RequestParam double num2) {
		return num1 + num2;
	}
	
	@GetMapping("/subtrair")
	public double subtrair(@RequestParam double num1, @RequestParam double num2) {
		return num1 - num2;
	}
	
	@GetMapping("/multiplicar")
	public double multiplicar(@RequestParam double num1, @RequestParam double num2) {
		return num1 * num2;
	}
	
	@GetMapping("/dividir")
	public double dividir(@RequestParam double num1, @RequestParam double num2) {
		if (num2 == 0) return 0;
		return num1 / num2;
	}
}
