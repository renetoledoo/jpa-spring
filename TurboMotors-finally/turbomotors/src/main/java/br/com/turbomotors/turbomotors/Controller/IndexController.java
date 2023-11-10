package br.com.turbomotors.turbomotors.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.turbomotors.turbomotors.Repositorio.CarroCrud;
import br.com.turbomotors.turbomotors.Repositorio.ClienteRepositorio;
import br.com.turbomotors.turbomotors.Repositorio.MarcaRepository;
import br.com.turbomotors.turbomotors.Repositorio.TipoRepositorio;
import br.com.turbomotors.turbomotors.Tabelas.Cliente;
import br.com.turbomotors.turbomotors.Tabelas.Marca;
import br.com.turbomotors.turbomotors.Tabelas.Tipo;
import br.com.turbomotors.turbomotors.Tabelas.Veiculo;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class IndexController {

    @Autowired
    private ClienteRepositorio acao;

    @Autowired
    private CarroCrud servicos;
    
    @Autowired
    private MarcaRepository acao_marcas;

    @Autowired
    private TipoRepositorio acao_tipo;



    @GetMapping({"", "/login", "/logout"})
    public String index() {
        return "login";
    }

    @GetMapping({"/web/painel", "web/painel.html"})
    public String painel() {
        return "web/painel";
    }

    @GetMapping( "web/carro.html")
    public ModelAndView cadastroCarro() {
        System.out.println("----------------- LOG DO SISTEMA -------------------------");
        long startTime = System.currentTimeMillis(); // Captura o tempo inicial
        List<Marca> marcas = acao_marcas.findAll();
        List<Tipo> tipos = acao_tipo.findAll();
        List<Veiculo> carrosDoSistema = servicos.findAll();
        ModelAndView minhaView = new ModelAndView("web/carro");
        minhaView.addObject("listaMarcas", marcas);
        minhaView.addObject("idMarca", new Marca()); 
        minhaView.addObject("tiposCarros", tipos);
        minhaView.addObject("carrosDoSistema", carrosDoSistema);
        long endTime = System.currentTimeMillis(); // Captura o tempo final
        long executionTime = endTime - startTime; // Calcula o tempo de execução
    
        System.out.println("A função 'cadastroCarro' levou " + executionTime + " milissegundos para ser executada.");
        return minhaView;
    }
     @GetMapping( "web/funcionario.html")
    public String cadastroFuncionario() {
        return "web/funcionario";
    }
    @GetMapping("/login-incorreto")
     public ModelAndView retornarError() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/login");
        view.addObject("erroSenha", view);
        return view;
        
    }
}
