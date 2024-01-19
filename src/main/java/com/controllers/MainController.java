package com.controllers;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Books;
import com.model.User;
import com.model.UserBooks;
import com.services.BooksServices;
import com.services.UserBooksServices;
import com.services.UserServices;

@Controller
public class MainController {

	 
	@Autowired
	private BooksServices booksServices;
	@Autowired
	private UserBooksServices userBooksServices;
	@Autowired
	private UserServices userServices;
	
	
	
/* ******************************************************************************** */
	
	//Method to create and initialize the session
	private void initSession(HttpServletRequest request, User user) {
		HttpSession httpSession = request.getSession(true);
		httpSession.setAttribute("currentuser", user);
	}
	

	//Method to log you out of the session
	@RequestMapping("/logout")
	public String userLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(false); // Get existing session if exists

	    if (session != null) {
	        session.invalidate(); // Invalidate the session
	    }

	    return "redirect:/login";
	}

	
/* ******************************************************************************** */
	
	//takes to homepage
	@RequestMapping("/")
	public String homePage() {
		
		return "index";
	}
	
/* ******************************************************************************* */

	
	//takes to register page
	@RequestMapping("/register")
	public String registerPage() {
		
		return "register";
	}
	
	//registers a user
	@RequestMapping(value="/register-user", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute User user) {
		userServices.createUser(user);
		
		return "login";
	}

/* ******************************************************************************* */
	
	//takes to login page
	@RequestMapping("/login")
	public String loginPage() {
		
		return "login";
	}
	
	//user login
	@RequestMapping(value="/user-login", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute User user, HttpServletRequest request, Model model) {
		
		String email = user.getEmail();
		String password = user.getPassword();
		
		User existingUser = userServices.getUserByEmail(email);
		
		if(existingUser!= null && existingUser.getPassword().equals(password)) {
			
			model.addAttribute("userdetails", existingUser);
			initSession(request, existingUser);
			
			if(existingUser.getRole().equals("admin")) {
				System.out.println("admin login success");
				return "adminpage";
			}
			else {
				System.out.println("user login success");
				return "userpage";
			}
		
		}
		
		return "redirect:/login";
	}
	
/* ********************************************************************************* */
	
	//takes to userpage
	@RequestMapping("/userpage")
	public String userPage() {
		return "userpage";
	}
		
	//takes to adminpage
	@RequestMapping("/adminpage")
	public String adminPage() {
		return "adminpage";
	}
	
	@RequestMapping("/addbook")
	public String addBookPage() {
		
		return "addbook";
	}
	
	@RequestMapping(value="/addnewbook", method = RequestMethod.POST)
	public String addNewBook(@ModelAttribute Books book) {
		this.booksServices.createBook(book);
		
		return "addbook";
	}
	
	@RequestMapping("/adminmybooks")
	public String adminBooks(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("currentuser");
		Long userId = currentUser.getId();
		System.out.println("id in controller is : " + userId);
		List<Books> books = this.booksServices.returnBooksOfUser(userId);
		model.addAttribute("userbooks", books);
		return "adminmybooks";
	}
	
	@RequestMapping("/mybooks")
	public String showUserBooks(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("currentuser");
		Long userId = currentUser.getId();
		System.out.println("id in controller is : " + userId);
		List<Books> books = this.booksServices.returnBooksOfUser(userId);
		model.addAttribute("listofmybooks", books);
		return "mybooks";
	}
	
/* ***************************************************************************** */	
	@RequestMapping("/users")
	public String userList(Model model) {
		List<User> users = this.userServices.getUsers();
		model.addAttribute("listofusers", users);
		return "users";
	}

/* ****************************************************************************** */	
	
	//For User Library
	@RequestMapping("/library")
	public String userLibrary(Model model) {
		List<Books> books = this.booksServices.getBooks();
		model.addAttribute("listofbooks", books);
		return "library";
	}
	
	@RequestMapping("/getuserbook/{bid}/{uid}")
	public String getUserBook(@PathVariable("bid") Long bookId, @PathVariable("uid") Long userId) {
		
		UserBooks userBooks = new UserBooks();
		userBooks.setUserId(userId);
		userBooks.setBookId(bookId);
		this.userBooksServices.addData(userBooks);
		
		return "redirect:/library";
	}
	
	//For Admin Library
	@RequestMapping("/adminlibrary")
	public String adminLibrary(Model model) {
		List<Books> books = this.booksServices.getBooks();
		model.addAttribute("listofbooks", books);
		return "adminlibrary";
	}

	@RequestMapping("/getadminbook/{bid}/{uid}")
	public String getAdminBook(@PathVariable("bid") Long bookId, @PathVariable("uid") Long userId) {
		
		UserBooks userBooks = new UserBooks();
		userBooks.setUserId(userId);
		userBooks.setBookId(bookId);
		this.userBooksServices.addData(userBooks);
		
		return "redirect:/adminlibrary";
	}
	
	
/* *********************************************************************************** */	
	
	@RequestMapping("/userpage/updateuserdata")
	public String updateUserData(@ModelAttribute User user, HttpServletRequest request, Model model) {
		userServices.updateUser(user);
		model.addAttribute("userdetails",user);
		return "userpage";
	}
	
	@RequestMapping("/adminpage/updateadmindata")
	public String updateAdminData(@ModelAttribute User user, HttpServletRequest request, Model model) {
		userServices.updateUser(user);
		model.addAttribute("userdetails",user);
		return "adminpage";
	}
	
	//**************************************************************************************
	
	
	
}
