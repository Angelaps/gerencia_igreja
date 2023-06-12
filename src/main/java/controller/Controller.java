
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans membro = new JavaBeans();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			novoConato(request, response);
		} else if (action.equals("/Controller") && request.getParameter("listagem") != null) {
			listaCadastro(request, response);
		} else if (action.equals("/select")) {
			editarCadastro(request, response);
		} else if (action.equals("/update")) {
			salvarEdicao(request, response);
		} else if (action.equals("/delete")) {
			removerCadastro(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// listar contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("central.jsp");
	}

	protected void listaCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// criando um objeto que ira receber os dados Javabeans
		ArrayList<JavaBeans> lista = dao.listarContatos();
		// encaminhar a lista
		request.setAttribute("presbiteros", lista);
		RequestDispatcher rd = request.getRequestDispatcher("listaPresbitero.jsp");
		rd.forward(request, response);
	}

	// Novo contatos
	protected void novoConato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variavéis javabeans
		membro.setNome(request.getParameter("nome")); // armazena o nome obtido no form na variavel nome no javabeans
		membro.setCargo(request.getParameter("cargo"));
		membro.setDizimista(request.getParameter("dizimista"));
		// invocar o metodo inserirCOntato passando o objeto contato
		dao.inserirContato(membro);
		// redirecionar para o documento agenda.jsp
		response.sendRedirect("main");
	}

	// ediat cadastro
	protected void editarCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebiemnto do id do registro a ser editado
		String id_membro = request.getParameter("id_membro"); 
		// Setar a variabel JavaBeans
		membro.setId_membro(id_membro);
		// executar o método selecionarContato (DAO)
		dao.selecionarContato(membro);
		// setar os atributos do formulario com o conteudo javaBeans
		request.setAttribute("id_membro", membro.getId_membro());
		request.setAttribute("nome", membro.getNome());
		request.setAttribute("cargo", membro.getCargo());
		request.setAttribute("dizimista", membro.getDizimista());
		// Encaminhar so documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	protected void salvarEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variaveis javabeans
		membro.setId_membro(request.getParameter("id_membro"));
		membro.setNome(request.getParameter("nome"));
		membro.setCargo(request.getParameter("cargo"));
		membro.setDizimista(request.getParameter("dizimista"));
		// executar o metodo aletarCadastro
		dao.alterarCadastro(membro);
		// redirecionar ao metodo central.jsp com os dados atualizados
		response.sendRedirect("main");
	}
	// remover um cadastro
	protected void removerCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebimento do id do contato a ser recebido da js
		String id_membro = request.getParameter("id_membro");
		// setar a variavel id_membro JavaBeans
		membro.setId_membro(id_membro);
		// ecevulat o metodo deletarCadastro DAO passando o objeto membro
		dao.deletarCadastro(membro);
		// redirecionar para o documento agenda.jsp
				response.sendRedirect("main");
	}
	

}
