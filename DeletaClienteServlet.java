import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeletaCliente")
public class DeletaClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
		
		String id = request.getParameter("nomeid");
		long id1 =Long.parseLong(id);

		ClienteDao dao = new ClienteDao();
		List<Cliente> clientes = dao.listaContato();
		
		for(Cliente cliente : clientes){
			if (cliente.getId() == id1){
				
				dao.remove(cliente);
			}	
		}
}
}