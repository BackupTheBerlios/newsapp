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
        	<h:commandLink value="Ticket management" action="ticketmanagement" /><br /><br />
        	<h:commandButton value="Logout" action="#{login.logout}" />
        </h:form>
        <br />
      </div>
      <div id="mainContent">
      <h2>Ticket Rollout</h2>
       <b>Do Rollout</b> 
       <h:form id="admin_rollout_rollout">
       	<h:commandButton action="#{rollout.rollout}" value="Rollout now!" />
       </h:form>
       
        
<h:dataTable id="rolloutTable" rows="100"
                    value="#{GameRegistry.rollout}" 
                             var="game" rowClasses="list-row-odd,list-row-even" 
                             headerClass="table-header"
                             width="100%" binding="#{GameRegistry.data2}">

                  <h:column>
                    <f:facet name="header">
                     <h:panelGroup>
                       <h:outputText value="Date"/>
                       </h:panelGroup>
                    </f:facet>
                   <h:outputText value="#{game.datetime}"/>
                  </h:column>
                  
                   <h:column>
                    <f:facet name="header">
                     <h:panelGroup>
                       <h:outputText value="Stade"/>
                       </h:panelGroup>
                    </f:facet>
                   <h:outputText value="#{game.stade}, #{game.country}"/>
                  </h:column>  
                 
                  <h:column>
                    <f:facet name="header">
                     <h:panelGroup>
                       <h:outputText value="Teams"/>
                       </h:panelGroup>
                    </f:facet>
                   <h:outputText value="#{game.team1} - #{game.team2}"/>
                  </h:column>  
                  
                  <h:column>
                    <f:facet name="header">
                     <h:panelGroup>
                       <h:outputText value="Cat."/>
                       </h:panelGroup>
                    </f:facet>
                   <h:outputText value="#{game.category}"/>
                  </h:column>   
                  


                </h:dataTable>
        
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