package com.rnt.UsersApp.controller;

import java.beans.PropertyVetoException;
import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.rnt.UsersApp.dao.StringBulidDao;
import com.rnt.UsersApp.dao.UserDao;

import Exceptions.DuplicateEmailFoundException;
import comrnt.UsersApp.model.User;

@Controller
public class MainController {

	private static final Logger log = LogManager.getLogger(MainController.class);

	@ModelAttribute
	public void commonData(Model m) {
		m.addAttribute("Header", "User Management System");
	}

	@RequestMapping(value = "/Register")
	public ModelAndView about(HttpServletResponse response) throws IOException {
		return new ModelAndView("Register");
	}

	@RequestMapping(value = "/view")
	public ModelAndView view() throws SQLException, PropertyVetoException {
		ModelAndView modelAndView = new ModelAndView();
		StringBulidDao dao = new StringBulidDao();
		List<User> userRecords = dao.getUserRecords();

		modelAndView.addObject("user", userRecords);

		modelAndView.setViewName("ViewUsers");
		return modelAndView;

	}

	// handler for form
	@RequestMapping(value = "/processform", method = RequestMethod.POST)
	public ModelAndView handleFrom(@ModelAttribute User user)
			throws SQLException, PropertyVetoException {
		ModelAndView modelAndView = new ModelAndView();
		UserDao dao = new UserDao();

		String e2 = (String) user.getEmail();
		User u1 = dao.getUserByEmail(e2);
		String e1 = u1.getEmail();

		if (e1 == null) {
			StringBulidDao bulidDao = new StringBulidDao();
			boolean isInserted = bulidDao.insertUserRecords(user);
			// dao.insertRecords(user);

			if (isInserted == true) {

				modelAndView.setViewName("redirect:/view");

			} else {

				modelAndView.setViewName("Register");

			}

			return modelAndView;

		} else {
			throw new DuplicateEmailFoundException();
		}
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		UserDao dao = new UserDao();
		dao.deleteUser(id);
		ModelAndView modelAndView = new ModelAndView();

		List<User> userRecords = dao.getUserRecords();

		modelAndView.addObject("user", userRecords);

		return "redirect:/view";

	}

	@RequestMapping(value = "/editUser/{id}")
	public String edit(@PathVariable int id, Model m) {
		UserDao dao = new UserDao();
		User u = dao.getUserById(id);

		m.addAttribute("user", u);
		return "editUser";
	}

	@RequestMapping(value = "/editUser/editform", method = RequestMethod.POST)
	public ModelAndView handleEdit(@ModelAttribute User user) throws SQLException, PropertyVetoException {
		ModelAndView modelAndView = new ModelAndView();
		UserDao dao = new UserDao();
		StringBulidDao daoSB = new StringBulidDao();
		String e2 = (String) user.getEmail();
		User u1 = dao.getUserByEmail(e2);
		String e1 = u1.getEmail();
		int Currentid = user.getId();
		int DBid = u1.getId();

		if (e1 != null && DBid != Currentid) {

			throw new DuplicateEmailFoundException();
		} else {
			daoSB.updateUserRecords(user);
			modelAndView.addObject("user", user);
			modelAndView.setViewName("redirect:/view");
			return modelAndView;

		}

	}

	// Handling multiple delete Functionality

	@RequestMapping(value = "/DeleteProcess", method = RequestMethod.POST)
	public ModelAndView handleMultipleDelete(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		UserDao dao = new UserDao();

		try {
			for (String uid : request.getParameterValues("deleteMul")) {
				int id = Integer.parseInt(uid);
				dao.deleteUser(id);
			}

		} catch (Exception e) {
			log.error("got a exception in handleMultipleDelete "+e);
		}
		modelAndView.setViewName("home");
		return modelAndView;

	}

	// exception Handlers Of project

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = NullPointerException.class)
	public ModelAndView exceptionHandlerNull(NullPointerException ex) {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("msg", "null Exception Occured");
		modelAndView.setViewName("ErrorPage");
		return modelAndView;
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = DuplicateEmailFoundException.class)
	public ModelAndView exceptionHandlerMail(DuplicateEmailFoundException ex) {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("msg", "Duplicate Email not Allowded");
		modelAndView.setViewName("ErrorPage");
		return modelAndView;
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public ModelAndView exceptionHandlerGenereic(Exception e) {

		ModelAndView modelAndView = new ModelAndView();

		System.out.println(e);
		modelAndView.addObject("msg", "Exception Occured");

		modelAndView.setViewName("ErrorPage");
		return modelAndView;
	}
}
