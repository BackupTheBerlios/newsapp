<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<f:view>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Welcome</title>
<link href="../style.css" rel="stylesheet" type="text/css" />
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
        <h1><img src="../images/euro08.gif" alt="logo" width="69" height="88" /> Admininterface - Euro 08  Ticketing System</h1>
      <!-- end #header --></div>
            <div id="sidebar1">
        <h2>Navigation</h2>
        <h:form id="app_index_logout">
			<h:commandLink value="Home" action="login" /><br />
			<h:commandLink value="User listing" action="users" /><br />
        	<h:commandLink value="Ticket management" action="ticketmanagement" /><br /><br />
        	<h:commandButton value="Logout" action="#{login.logout}" />
        </h:form>
        <br />
      </div>
      <div id="mainContent">
        <h2>Registerd Users</h2>
        <h:form id="admin_users_change">
        <h:dataTable id="userlist" rows="100" value="#{UserRegistry.allUsers}"
                             var="users" rowClasses="list-row-odd,list-row-even" 
                             headerClass="table-header"
                             width="100%" binding="#{UserRegistry.data}">
                                   
                   <h:column>
                    <f:facet name="header">
                     <h:panelGroup>
                       <h:outputText value="Firstname"/>
                       </h:panelGroup>
                    </f:facet>
                   <h:outputText value="#{users.firstname}"/>
                  </h:column>  
                 
                  <h:column>
                    <f:facet name="header">
                     <h:panelGroup>
                       <h:outputText value="Lastname"/>
                       </h:panelGroup>
                    </f:facet>
                   <h:outputText value="#{users.lastname}"/>
                  </h:column>  
                  
                  <h:column>
                    <f:facet name="header">
                     <h:panelGroup>
                       <h:outputText value="Email"/>
                       </h:panelGroup>
                    </f:facet>
                   <h:outputText value="#{users.superuser}"/>
                  </h:column>   
                  
                  <h:column>
                    <f:facet name="header">
                     <h:panelGroup>
                       <h:outputText value=""/>
                       </h:panelGroup>
                    </f:facet>
                    <h:form id="superuser">
                    	<h:commandButton value="Make Superuser"  action="#{users.superuser}" />
                    </h:form>
                  </h:column>
                  
                </h:dataTable>
        
        </h:form>
        <p><br />
        </p>
        <!-- end #mainContent --></div>
    	<!-- Dieses clear-Element sollte direkt auf das #mainContent-div folgen, um das #container-div anzuweisen, alle untergeordneten Floats aufzunehmen. --><br class="clearfloat" />
      <div id="footer">
        <p>Lars Schnyder, Lorenz Grimm</p>
        <!-- end #footer --></div>
    <!-- end #container --></div>
    </body>
</html>
</f:view>