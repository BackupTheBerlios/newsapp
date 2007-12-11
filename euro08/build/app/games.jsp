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
        <h1><img src="../images/euro08.gif" alt="logo" width="69" height="88" /> Adv. Web - Euro 08  Ticketing System</h1>
      <!-- end #header --></div>
            <div id="sidebar1">
        <h2>Navigation</h2>
        <h:form id="app_index_logout">
		<h:commandLink value="Home" action="login" /><br />
		<h:commandLink value="View Tickets" action="games" />
		<br /><br />
        	<h:commandButton value="Logout" action="#{login.logout}" />
        </h:form>
        <br />
      </div>
      <div id="mainContent">
       <br /><h:messages globalOnly="true" styleClass="formUserError"/>
      <div id="gameListing">
        	<h2><h:outputText rendered="#{GameRegistry.someOrdered}" value="All Matches you requested tickets for (Maximum 4):"/></h2>
        	<h:dataTable id="orderedMatchesTable" rows="100" rendered="#{GameRegistry.someOrdered}"
                    value="#{GameRegistry.orderedGames}"
                             var="game" rowClasses="list-row-odd,list-row-even" 
                             headerClass="table-header"
                             width="100%" binding="#{GameRegistry.data}">

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
                       <h:outputText value="Cat. / Price"/>
                       </h:panelGroup>
                    </f:facet>
                   <h:outputText value="#{game.category} / #{game.price}"/>
                  </h:column>   
                  
                  <h:column>
                    <f:facet name="header">
                     <h:panelGroup>
                       <h:outputText value=""/>
                       <h:graphicImage url="images/icons/soccer.gif"/>                                      
                      </h:panelGroup>
                    </f:facet>
                    <h:form id="delete">
                    	<h:commandButton value="Delete"  action="#{game.delete}" />
                    </h:form>
                  </h:column>
                  
                </h:dataTable>
                
                
            <h2><h:outputText value="All Matches:"/></h2>
        	<h:dataTable id="allMatchesTable" rows="100"
                    value="#{GameRegistry.allGames}" rendered="#{GameRegistry.notYetRollout}"
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
                       <h:outputText value="Cat. / Price"/>
                       </h:panelGroup>
                    </f:facet>
                   <h:outputText value="#{game.category} / #{game.price}"/>
                  </h:column>   
                  
                  <h:column rendered="#{GameRegistry.anyLeft}">
                   <f:facet name="header">
                    <h:panelGroup>
                      <h:outputText value="#"/>
                      </h:panelGroup>
                   </f:facet>
                   <h:panelGroup>
                    <h:form id="request">
					  <h:commandButton value="Request" action="#{game.request}" />
					  <h:graphicImage value="" />
                    </h:form>
				   </h:panelGroup>
                  </h:column>

                </h:dataTable>
        <p><br />
        </p>
        
        </div></div>
 
      <div id="footer">
        <p>Lars Schnyder, Lorenz Grimm</p>
        <!-- end #footer --></div>
    <!-- end #container --></div>
    </body>
</html>
</f:view>