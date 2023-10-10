package br.com.pizzaria.fastPizzas.service;

import br.com.pizzaria.fastPizzas.entity.Funcionario;
import br.com.pizzaria.fastPizzas.enums.Cargos;
import br.com.pizzaria.fastPizzas.exceptions.FuncionarioNotFoundException;
import br.com.pizzaria.fastPizzas.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;



    public Funcionario createFuncionario(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> getAllFuncionarios(){
        return funcionarioRepository.findAll();
    }

    public Funcionario getFuncionarioById(Long id){
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNotFoundException("Funcionario não encontrado com ID: " + id));
    }

    public Funcionario addFuncionario(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario updateFuncionario(Funcionario funcionarios){
        if(funcionarios.getId() == null){
            throw new IllegalArgumentException("O ID não pode ser nulo");
        }

        Funcionario funcionarioExiste = getFuncionarioById(funcionarios.getId());
        funcionarioExiste.setNome(funcionarios.getNome());
        funcionarioExiste.setCargos(funcionarios.getCargos());

        return funcionarioRepository.saveAndFlush(funcionarioExiste);
    }

//    public void updateCargo(List<Funcionario> funcionarios){
//        funcionarios.stream().map(funcionario -> funcionario.setCargos(funcionario.getCargos()));
//    }

    public void deleteById(Long id){
        try{
            Funcionario funcionarioExiste = getFuncionarioById(id);
            funcionarioRepository.delete(funcionarioExiste);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void deleteAll(){
        try {
            funcionarioRepository.deleteAll();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
