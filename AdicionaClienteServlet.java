import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet ("/adicionaCliente")
public class AdicionaClienteServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
		PrintWriter out = response.getWriter();
		
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

		
		
		
		
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setEndereco(endereco);
		cliente.setEmail(email);
		cliente.setTelefone(telefone);
		cliente.setPessoa(pessoaI);
		cliente.setCod(codg);
		
		ClienteDao dao = new ClienteDao();
		dao.adiciona(cliente);
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Parâmetros recuperados</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Dados do cliente</h1>");
		out.println("Nome: " + cliente.getNome() + "<br />");
		out.println("E-mail: " + cliente.getEmail() + "<br />");
		out.println("Endereço: " + cliente.getEndereco() + "<br />");
		out.println("Telefone: " + cliente.getTelefone() + "<br />");
		if(cliente.getPessoa() == 1){
			out.println("Pessoa: Pessoa Fisica.  </br>");
			out.println("Cpf: "+ cliente.getCod() + "</br>");
		}
		else{
			out.println("Pessoa: Pessoa Juridica.</br>");
			out.println("Cnpj: "+ cliente.getCod() + "</br>");
		}
		out.println("</body>");
		out.println("</html>");
	}
	
	
}
