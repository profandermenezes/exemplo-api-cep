package br.com.andermenezes.exemplo.servico;

import br.com.andermenezes.exemplo.modelo.EnderecoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

// Serviço que é invocado pelo controlador para processar a requisição

@Service
public class EnderecoService {

    // Responsável pela comunicação com o serviço
    @Autowired
    private RestTemplate template;

    public String obterEnderecoPeloCep(String cep) {
        //Caminho para o serviço. Instruções em https://viacep.com.br/
        String endpoint = "https://viacep.com.br/ws/" + cep + "/json/";

        //Consultando o serviço e retornando o resultado numa
        // instância da classe Endereco
        EnderecoModel endereco = template.getForObject(endpoint, EnderecoModel.class);

        String resultado = "Logradouro: " + endereco.getLogradouro() + "<br/>Cidade: " + endereco.getLocalidade() +
                "<br/>UF: " + endereco.getUf();

        return resultado;
    }

}
