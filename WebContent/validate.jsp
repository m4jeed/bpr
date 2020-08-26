String URLtoDisplay    ="";
String username = request.getParameter("username").trim();
String password = request.getParameter("password").trim();
if (username.equals(null) || password.equals(null)) {
request.sendRedirect("login/vLogin.jsp");
}

WebAccount wa = new WebAccount();

//validating account
if(username.equals(wa.getusername()) && password.equals(wa.getpassword())){
         URLtoDisplay    = "dashboard/vDashboard.jsp";
         WebSession ws    = new WebSession( wa, request.getRemoteAddr());
         session.setAttribute( "onlineUser", ws );
}else {
 URLtoDisplay    = "login/vLogin.jsp";
}

request.sendRedirect(URLtoDisplay);
