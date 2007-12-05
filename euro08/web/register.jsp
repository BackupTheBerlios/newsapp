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
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        <!-- end #sidebar1 --></div>
      <div id="mainContent">
        <h2>User Registration</h2>
        
<h:form id="registerForm">

<div class="center">
<h:panelGrid columns="2">

  
  <f:facet name="footer">
    <h:panelGroup>
    <h:commandButton value="submit" 
      action="#{register.register}" />
      <br />
      <h:messages globalOnly="true" styleClass="formUserError"/>
    </h:panelGroup>
  </f:facet>
    
  <h:outputLabel for="firstname" value="Firstname"/>
  <h:panelGroup>
  <h:inputText required="true" id="firstname" value="#{register.firstname}"
    maxlength="255" size="30"/><f:verbatim><br/></f:verbatim>
  <h:outputText value=" "/><h:message for="firstname" styleClass="formUserError"/>
  </h:panelGroup>
  
  <h:outputLabel for="lastname" value="Lastname"/>
  <h:panelGroup>
  <h:inputText required="true" id="lastname" value="#{register.lastname}"
    maxlength="255" size="30"/><f:verbatim><br/></f:verbatim>
  <h:outputText value=" "/><h:message for="lastname" styleClass="formUserError"/>
  </h:panelGroup>
  
  <h:outputLabel for="email" value="Email"/>
  <h:panelGroup>
  <h:inputText id="email" value="#{register.email}" 
    maxlength="255" size="40" 
    required="true">
      <f:validator validatorId="EmailValidator"/>
  </h:inputText><f:verbatim><br/></f:verbatim>
  <h:outputText value=" "/><h:message for="email" styleClass="formUserError"/>
  </h:panelGroup>
  
  <h:outputLabel for="emailConfirm" value="Email Confirm"/>
  <h:panelGroup>
  <h:inputText id="emailConfirm" value="#{register.emailConfirm}" 
    maxlength="255" size="40" 
    required="true"/><f:verbatim><br/></f:verbatim>
  <h:outputText value=" "/><h:message for="emailConfirm" styleClass="formUserError"/>
  </h:panelGroup>

  <h:outputLabel for="password" value="Password"/>
  <h:panelGroup>
  <h:inputSecret id="password" value="#{register.password}" 
    maxlength="64" size="20" 
    required="true" redisplay="true">
      <f:validateLength minimum="6"/>
  </h:inputSecret><f:verbatim><br/></f:verbatim>
  <h:outputText value=" "/><h:message for="password" styleClass="formUserError"/>
  </h:panelGroup>
  
  <h:outputLabel for="passwordConfirm" value="Password Confirm"/>
  <h:panelGroup>
  <h:inputSecret id="passwordConfirm" value="#{register.passwordConfirm}" 
    maxlength="64" size="20" 
    required="true" redisplay="true"/><f:verbatim><br/></f:verbatim>
  <h:outputText value=" "/><h:message for="passwordConfirm" styleClass="formUserError"/>
  </h:panelGroup>

    
</h:panelGrid>
</div>
</h:form>
    
        <!-- end #mainContent --></div>
    	<!-- Dieses clear-Element sollte direkt auf das #mainContent-div folgen, um das #container-div anzuweisen, alle untergeordneten Floats aufzunehmen. --><br class="clearfloat" />
      <div id="footer">
        <p>Lars Schnyder, Lorenz Grimm</p>
        <!-- end #footer --></div>
    <!-- end #container --></div>
    </body>
</html>
</f:view>





