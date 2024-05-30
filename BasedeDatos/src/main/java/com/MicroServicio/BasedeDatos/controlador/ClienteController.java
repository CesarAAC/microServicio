package com.MicroServicio.BasedeDatos.controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.MicroServicio.BasedeDatos.modelo.Cliente;
import com.MicroServicio.BasedeDatos.repositorio.ClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public String clientes(Model model) {
        model.addAttribute("Clientes", clienteRepository.findAll());
        return "clientes";
    }

    @GetMapping("clientes/new")
    public String clientesForm(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "clienteNuevo";
    }

    @PostMapping("clientes/new/save")
    public String clientesGuardar(Model model, @ModelAttribute Cliente cliente) {
        Cliente cliente2= new Cliente(null, cliente.getNombre(), cliente.getProfesion(), cliente.getIngresos(), cliente.getPatrimonio(), cliente.getDeudas());
        clienteRepository.save(cliente2);
        return "/clientes";
    }
    
    
}
