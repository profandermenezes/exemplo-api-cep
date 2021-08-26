package br.com.andermenezes.exemplo.controlador;

import br.com.andermenezes.exemplo.servico.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controlador para receber e encaminhar a requisição do browser

@RestController
@RequestMapping("/consultar")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{cep}")
    public String obterEndereco(@PathVariable String cep) {
        // Chama o serviço e retorna o resultado pro browser
        return enderecoService.obterEnderecoPeloCep(cep);
    }

}
