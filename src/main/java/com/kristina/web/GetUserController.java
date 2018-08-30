package com.kristina.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kristina.web.dao.UserDao;
import com.kristina.web.model.User;

/**
 * Servlet implementation class GetUserController
 */
public class GetUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String EDIT_USER = "/user.jsp";
    private static String LIST_USER = "/listUser.jsp";
    private static String INSERT_USER = "/addUser.jsp";
    private UserDao dao;
    
    public GetUserController() {
        super();
        dao = new UserDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int userId = Integer.parseInt(request.getParameter("userId"));
            dao.deleteUser(userId);
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = EDIT_USER;
            int userId = Integer.parseInt(request.getParameter("userId"));
            User user = dao.getUserById(userId);
            request.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listUser")){
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
        } else {
            forward = INSERT_USER;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
        user.setFirstname(request.getParameter("firstName"));
        user.setLastname(request.getParameter("lastName"));
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        String userid = request.getParameter("userid");
        if(userid == null || userid.isEmpty())
        {
            dao.addUser(user);
        }
        else
        {
            user.setUserid(Integer.parseInt(userid));
            dao.updateUser(user);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("users", dao.getAllUsers());
        view.forward(request, response);
    }
	}

