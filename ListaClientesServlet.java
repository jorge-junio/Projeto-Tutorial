import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/listaContato")
public class ListaClientesServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();

		ClienteDao dao = new ClienteDao();
		List<Cliente> clientes = dao.listaContato();
		
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Lista de clientes</h1>");
		
		for(Cliente cliente : clientes){
			out.println("Cliente id:"+ cliente.getId() + "</br>");
			out.println("Nome:"+ cliente.getNome() + "</br>");
			out.println("Email:"+ cliente.getEmail() + "</br>");
			out.println("Nome:"+ cliente.getEndereco() + "</br>");
			out.println("Telefone:"+ cliente.getTelefone() + "</br>");
			
			if(cliente.getPessoa() == 1){
				out.println("Pessoa: Pessoa Fisica.  </br>");
				out.println("Cpf:"+ cliente.getCod() + "</br>");
			}
			else{
				out.println("Pessoa: Pessoa Juridica.</br>");
				out.println("Cnpj:"+ cliente.getCod() + "</br>");
			}
			
			out.println("<br>");
		}
			out.println("</body>");
			out.println("</html>");
		
	}

}
