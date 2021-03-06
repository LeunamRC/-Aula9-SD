package br.com.projaula1.controller;

import br.com.projaula1.constant.Constants;
import br.com.projaula1.model.Fornecedor;
import br.com.projaula1.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping(Constants.API_FORNECEDOR)
    public void save(@RequestBody Fornecedor fornecedor){
        fornecedorService.sendFornecedorRabbit(fornecedor);
    }

    @GetMapping(Constants.API_FORNECEDOR)
    public List<Fornecedor> findAll(){
        return fornecedorService.findAll();
    }

    @PutMapping(Constants.API_FORNECEDOR)
    public void update(@RequestBody Fornecedor fornecedor){
        fornecedorService.save(fornecedor);
    }

    @DeleteMapping(Constants.API_FORNECEDOR + "/{id}")
    public void delete(@PathVariable("id") String id){
        fornecedorService.delete(id);
    }

    @GetMapping(Constants.API_FORNECEDOR + "/{id}")
    public Optional<Fornecedor> findById(@PathVariable("id") String id){
        return fornecedorService.findById(id);
    }
}
