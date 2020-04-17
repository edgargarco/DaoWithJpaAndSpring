package garco.DaoPatterSpringBootAndMySQL.controllers;

import garco.DaoPatterSpringBootAndMySQL.data.persistence.model.Foo;
import garco.DaoPatterSpringBootAndMySQL.data.persistence.service.IFooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class IFooController {
    private IFooService iFooService;
    @Autowired
    public void setiFooService(IFooService iFooService) {
        this.iFooService = iFooService;
    }
    @PostMapping("/foo/create")
    public void create(@Valid @NonNull @RequestBody Foo foo){
        iFooService.create(foo);
    }
    @GetMapping("/foo/getAll")
    public List<Foo> findAll(){
        return iFooService.findAll();
    }
}
