package br.com.turbomotors.turbomotors.Controller;



import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.turbomotors.turbomotors.Repositorio.CarroCrud;
import br.com.turbomotors.turbomotors.Repositorio.MarcaRepository;
import br.com.turbomotors.turbomotors.Repositorio.TipoRepositorio;
import br.com.turbomotors.turbomotors.Tabelas.Marca;
import br.com.turbomotors.turbomotors.Tabelas.Tipo;
import br.com.turbomotors.turbomotors.Tabelas.Veiculo;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class CarrosController {
    
    @Autowired
    private CarroCrud service;

    @Autowired
    private MarcaRepository serviceMarca;

        @Autowired
    private TipoRepositorio serviceipo;

        @RequestMapping(method = RequestMethod.POST, value = "/salvarCarro", consumes = {"multipart/form-data"})
        public RedirectView  criarCarros(Veiculo carros, @RequestParam("imagemCarro") final MultipartFile file, @RequestParam(name = "idd_marca", required = false) Long idMarca,  @RequestParam(name = "idTipo", required = false) Long idTipo, RedirectAttributes reidrecionarAtrivbutos){


            ModelAndView minhaView = new ModelAndView("web/carro");
            Tipo meuTipo =  serviceipo.findByVeiculosIdtipo(idTipo);
            carros.setTipo(meuTipo);

            Marca minhaMarca = serviceMarca.findByVeiculosPorId(idMarca);
            carros.setMarca(minhaMarca);


            UUID gerarGuid = UUID.randomUUID();
            boolean statusArquivo = file.isEmpty();

            if(!statusArquivo) {
                try {
                    String pasta =  "C:\\Users\\55759\\Desktop\\TurboMotors-finally\\turbomotors\\src\\main\\resources\\static\\TurboStyle\\img\\";
                    String pastaFinal = pasta + gerarGuid.toString() + '_' + file.getOriginalFilename();
                    File criarArquivo = new File(pastaFinal);
                   byte[] binarioCarro = file.getBytes();

                   carros.setCarImagem(file.getBytes());
                    file.transferTo(criarArquivo);
                
                } catch(IOException e) {
                    // minhaView.addObject("meuErro", e.getClass());
                     reidrecionarAtrivbutos.addFlashAttribute("meuErro", e.getClass());
                    System.out.println("Causa > " + e.getCause());
                    return new RedirectView("/web/carro.html", true);
                }
            
            }

            service.save(carros);
            reidrecionarAtrivbutos.addFlashAttribute("sucessoCarro", "Carro");
            return new RedirectView("/web/carro.html", true);
    }
}
    
