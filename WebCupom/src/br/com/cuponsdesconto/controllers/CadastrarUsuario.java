package br.com.cuponsdesconto.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cuponsdesconto.dao.UsuarioDao;
import br.com.cuponsdesconto.entidades.Usuario;

@WebServlet("/CadastrarUsuario")
public class CadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastrarUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario(nome, cpf, email, senha);
		if(new UsuarioDao().adicionar(usuario))
			request.setAttribute("mensagem", "Cadastro realizado com sucesso");
	    else
	    	request.setAttribute("mensagem", "Erro no cadastro");
	    
	    request.getRequestDispatcher("confirmacaoCadastro.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
