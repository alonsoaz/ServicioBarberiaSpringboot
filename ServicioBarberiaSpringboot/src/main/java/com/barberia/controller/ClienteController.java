package com.barberia.controller;

import com.barberia.entity.Aidis;
import com.barberia.entity.InsertarCliente;
import com.barberia.entity.LoginCliente;
import com.barberia.entity.MensajesBeans;
import com.barberia.entity.MessagenID;
import com.barberia.entity.RecuperarClienteInterno;
import com.barberia.model.ClienteModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@org.springframework.web.bind.annotation.RequestMapping(path={"/barberia"})
public class ClienteController
{
  @Autowired
  private ClienteModel ClienteModel;
  
  public ClienteController(ClienteModel ClienteModel)
  {
    this.ClienteModel = ClienteModel;
  }
  
  @GetMapping(value={"/cliente/allclientes"}, produces={"application/json"})
  @ResponseBody
  public List<com.barberia.entity.ListarClienteInterno> getClientes() {
    return ClienteModel.getInstance().getClienteRecords();
  }
  
  @GetMapping(value={"/cliente/allclientes"}, params={"words"}, produces={"application/json"})
  @ResponseBody
  public List<com.barberia.entity.BuscarClienteInterno> getClienteByWords(@org.springframework.web.bind.annotation.RequestParam String words) {
    return ClienteModel.getInstance().getClienteByWords(words);
  }
  
  @GetMapping(value={"/cliente/get/{id}"}, produces={"application/json"})
  @ResponseBody
  public List<RecuperarClienteInterno> getClienteById(@PathVariable int id) {
    return ClienteModel.getInstance().getCliente(id);
  }
  










  @PostMapping(value={"/{idUser}/cliente/register"}, produces={"application/json"}, consumes={"application/json"})
  @ResponseBody
  public List<MensajesBeans> registerUsuario(@PathVariable int idUser, @RequestBody InsertarCliente ins)
  {
    InsertarCliente inst = new InsertarCliente(ins.getaNombre(), ins.getbApellido(), ins.getcTelefono(), ins.getdDni(), ins.geteEmail(), ins.getfDirecion());
    

    return ClienteModel.getInstance().addCliente(inst, idUser);
  }
  











  @PostMapping(value={"/{idUser}/cliente/register/login"}, produces={"application/json"}, consumes={"application/json"})
  @ResponseBody
  public List<Aidis> registerUsuarioLogin(@PathVariable int idUser, @RequestBody InsertarCliente ins)
  {
    InsertarCliente inst = new InsertarCliente(ins.getaNombre(), ins.getbApellido(), ins.getcTelefono(), ins.getdDni(), ins.geteEmail(), ins.getfDirecion());
    

    return ClienteModel.getInstance().addClienteLogin(inst, idUser);
  }
  







  @PostMapping(value={"/android/login"}, produces={"application/json"}, consumes={"application/json"})
  @ResponseBody
  public List<MessagenID> logInClient(@RequestBody LoginCliente ins)
  {
    LoginCliente inst = new LoginCliente(ins.getaDni(), ins.getbTelf());
    

    return ClienteModel.getInstance().LogInClient(inst);
  }
  














  @PutMapping(value={"/{idUser}/cliente/update/{id}"}, produces={"application/json"}, consumes={"application/json"})
  @ResponseBody
  public List<MensajesBeans> updateClient(@PathVariable int idUser, @PathVariable int id, @RequestBody RecuperarClienteInterno ins)
  {
    RecuperarClienteInterno inst = new RecuperarClienteInterno(ins.getIdEstado(), ins.getBnombre(), ins.getCapellido(), ins.getDtelefono(), ins.geteDni(), ins.getFcorreo(), ins.getGdireccion());
    

    return ClienteModel.getInstance().updtClient(id, inst, idUser);
  }
  




  @PutMapping(value={"/{idUser}/cliente/delete/{id}"}, produces={"application/json"}, consumes={"application/json"})
  @ResponseBody
  public List<MensajesBeans> deleteUser(@PathVariable int idUser, @PathVariable int id)
  {
    return ClienteModel.getInstance().delClient(id);
  }
}
