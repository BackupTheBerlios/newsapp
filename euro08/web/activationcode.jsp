<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<f:view>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<!--[if IE]>
    <style type="text/css"> 
    /* FÃ¼gen Sie CSS-Korrekturen fÃ¼r alle IE-Versionen in diesen bedingten Kommentar ein. */
    .twoColLiqLtHdr #sidebar1 { padding-top: 30px; }
    .twoColLiqLtHdr #mainContent { zoom: 1; padding-top: 15px; }
    /* Mit der obigen proprietÃ¤ren Zoom-Eigenschaft wird IE die Eigenschaft hasLayout zugewiesen, die zur Verhinderung verschiedener Fehler erforderlich ist. */
    </style>
    <![endif]--></head>

<body class="twoColLiqLtHdr">

    <div id="container"> 
      <div id="header">
        <h1><img src="images/euro08.gif" alt="logo" width="69" height="88" /> Adv. Web - Euro 08  Ticketing System</h1>
      <!-- end #header --></div>
      <div id="sidebar1">
        <h2>Navigation</h2>
        <p><h:commandLink value="View Tickets" action="games" /></p>
        <form id="logout">
        	<h:commandButton value="Logout" action="#{login.logout}" />
        </form>
      </div>
      <div id="mainContent">
        <h2>User Login</h2>

		Hello <b><h:outputText value="#{user.firstname}"/></b>! This is the first time you try to log into this system. Please provide the Activation Code sent you by email.<br /><br />
		<h:form id="activate">
			<h:outputText value="Enter Activation Code: "/>
			<h:inputText required="true" id="activationcode" binding="#{login.activationcode}" />
			<br /><br />
			<h:commandButton value="Activate" action="#{login.activate}" />&nbsp;
			<font color="red"><h:messages globalOnly="true" infoClass="LoginError"/></font>
		</h:form>

    
        <!-- end #mainContent --></div>
    	<!-- Dieses clear-Element sollte direkt auf das #mainContent-div folgen, um das #container-div anzuweisen, alle untergeordneten Floats aufzunehmen. -->
      <div id="footer">
        <p>Lars Schnyder, Lorenz Grimm</p>
        <!-- end #footer --></div>
    <!-- end #container --></div>
    </body>
</html>
</f:view>
