import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/AlteraCliente")
public class AlteraClienteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{

		
		String id = request.getParameter("nomeid");
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String pessoa = request.getParameter("idn");
		String codg;
		
		int pessoaI = Integer.parseInt(pessoa);
		if(pessoaI == 1){
			codg = request.getParameter("cpf");
		}
		else{
			codg = request.getParameter("cnpj");
		}
		
		long id1 =Long.parseLong(id);
		
		ClienteDao dao = new ClienteDao();
		List<Cliente> clientes = dao.listaContato();
		
		for(Cliente cliente : clientes){
			if (cliente.getId() == id1){
				cliente.setNome(nome);
				cliente.setEmail(email);
				cliente.setEndereco(endereco);
				cliente.setTelefone(telefone);
				cliente.setPessoa(pessoaI);
				cliente.setCod(codg);
				cliente.setId(cliente.getId());
				dao.altera(cliente);
				
			}
			
		}

}
}