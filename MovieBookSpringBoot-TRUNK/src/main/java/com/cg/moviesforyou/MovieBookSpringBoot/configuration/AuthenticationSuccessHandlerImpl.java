package com.cg.moviesforyou.MovieBookSpringBoot.configuration;

import java.io.IOException;

import java.security.Principal;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.cg.moviesforyou.MovieBookSpringBoot.dto.MBSUserDetails;

public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler{

@Autowired
HttpSession session;

private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

//private static final Logger logger = LoggerFactory.getLogger(AuthenticationSuccessHandlerImpl.class);
	

	/*
	 * @Override public void onAuthenticationSuccess(HttpServletRequest request,
	 * HttpServletResponse response, Authentication authentication) throws
	 * IOException, ServletException { String targetUrl=null; Collection<? extends
	 * GrantedAuthority> authorities = authentication.getAuthorities();
	 * logger.info("Retrieved current authorities."); for (GrantedAuthority
	 * grantedAuthority : authorities) { if
	 * (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) { targetUrl =
	 * "/AdminHome"; logger.info("Admin Role Found."); }else if
	 * (grantedAuthority.getAuthority().equals("ROLE_USER")) { targetUrl =
	 * "/UserHome"; logger.info("User Role Found."); }else {
	 * logger.error("Illegal Role Found."); throw new IllegalStateException(); } }
	 * if (response.isCommitted()) {
	 * logger.error("Response has already been committed. Unable to redirect to " +
	 * targetUrl); return; } logger.info("Redirecting to Target URL: "+targetUrl);
	 * redirectStrategy.sendRedirect(request, response, targetUrl); }
	 * 
	 * //Getter for redirectStrategy object public RedirectStrategy
	 * getRedirectStrategy() { return redirectStrategy; }
	 * 
	 * //Setter for redirectStrategy object public void
	 * setRedirectStrategy(RedirectStrategy redirectStrategy) {
	 * this.redirectStrategy = redirectStrategy; }
	 */
	
	  @Override 
	  public void onAuthenticationSuccess(HttpServletRequest request,
	  HttpServletResponse response, Authentication authentication) throws
	  IOException, ServletException { 
		  // TODO Auto-generated method stub
		  String username=""; 
		  if(authentication.getPrincipal() instanceof Principal) {
	  username=((Principal)authentication.getPrincipal()).getName(); } else {
	  username=((MBSUserDetails)authentication.getPrincipal()).getUsername(); }
	  
	  System.out.println("username: "+username);
	  
	  session.setAttribute("username", username);
	  
	  handle(request, response, authentication);
	  
	  clearAuthenticationAttributes(request); }
	  
	  protected void handle(HttpServletRequest request, HttpServletResponse
	  response, Authentication authentication) throws IOException { 
		  // TODO Auto-generated method stub 
		  String targetUrl =determineTargetUrl(authentication);
	  
	  if (response.isCommitted()) { 
//		  logger.debug(
//	  "Response has already been committed. Unable to redirect to " + targetUrl);
	  return; }
	  
	  redirectStrategy.sendRedirect(request, response, targetUrl);
	  
	  
	  }
	  
	  protected String determineTargetUrl(Authentication authentication) {
		 
	  //TODO Auto-generated method stub
		  boolean isUser = false; 
		  boolean isAdmin = false;
	  Collection<? extends GrantedAuthority> authorities =authentication.getAuthorities(); 
	  for (GrantedAuthority grantedAuthority :authorities) { 
		  if (grantedAuthority.getAuthority().equals("ROLE_USER"))
		  {
			  System.out.println("TargetUrl : User");
	  isUser = true; break; 
	  } 
		  else if
	  (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) { isAdmin = true;
	  break; } }
	  
	  if (isUser) { 
		  session.setAttribute("role","USER");
		  return "UserHome";
	  
	  } else if (isAdmin) { 
		  session.setAttribute("role","ADMIN");
		  
		  return "AdminHome";
	  } else { throw new IllegalStateException(); }
	  
	  } protected void clearAuthenticationAttributes(HttpServletRequest request) {
	  // TODO Auto-generated method stub HttpSession session =
	  request.getSession(false); if (session == null) { return; }
	  session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	  
	  
	  }
	  
	  
	  //Getter for redirectStrategy object
	  public RedirectStrategy getRedirectStrategy() { return redirectStrategy; }
	  
	  //Setter for redirectStrategy object
	  public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
	  this.redirectStrategy = redirectStrategy; }
	 
}
