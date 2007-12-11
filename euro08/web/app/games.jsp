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
        <p><a href="games.jsp">View all Games</a><br /></p>
        <p>View Order<br />
        View Your Tickets<!-- end #sidebar1 --></p>
      </div>
      <div id="mainContent">
      <div id="gameListing">
        <h:form id="games">
        <h:message for="ticket" styleClass="formUserError"/>
        	<h2><h:outputText rendered="#{GameRegistry.someOrdered}" value="All Matches you requested tickets for:"/></h2>
        	<h:dataTable id="orderedMatchesTable" rows="100" rendered="#{GameRegistry.someOrdered}"
                    value="#{GameRegistry.orderedGames}"
                             var="game" rowClasses="list-row-odd,list-row-even" 
                             headerClass="table-header"
                             width="100%" binding="#{GameRegistry.data}">

                  <h:column>
                    <f:facet name="header">
                     <h:panelGroup>
                       <h:outputText value="Date"/>
                       <h:graphicImage url="images/icons/date.gif"/>                                      
                      </h:panelGroup>
                    </f:facet>
                   <h:outputText value="#{game.datetime}"/>
                  </h:column>
                  
                   <h:column>
                    <f:facet name="header">
                     <h:panelGroup>
                       <h:outputText value="Stade"/>
                       <h:graphicImage url="images/icons/date.gif"/>                                      
                      </h:panelGroup>
                    </f:facet>
                   <h:outputText value="#{game.stade}, #{game.country}"/>
                  </h:column>  
                 
                  <h:column>
                    <f:facet name="header">
                     <h:panelGroup>
                       <h:outputText value="Teams"/>
                       <h:graphicImage url="images/icons/soccer.gif"/>                                      
                      </h:panelGroup>
                    </f:facet>
                   <h:outputText value="#{game.team1} - #{game.team2}"/>
                  </h:column>  
                  
                  <h:column>
                    <f:facet name="header">
                     <h:panelGroup>
                       <h:outputText value="Cat. / Price"/>
                       <h:graphicImage url="images/icons/soccer.gif"/>                                      
                      </h:panelGroup>
                    </f:facet>
                   <h:outputText value="#{game.category} / #{game.price}"/>
                  </h:column>   
                  
                  <h:column>
                    <f:facet name="header">
                     <h:panelGroup>
                       <h:outputText value="#"/>
                       <h:graphicImage url="images/icons/soccer.gif"/>                                      
                      </h:panelGroup>
                    </f:facet>
                   <h:outputText value="#{game.ticketcount}"/>
                  </h:column>
                  
                  <h:column>
                    <f:facet name="header">
                     <h:panelGroup>
                       <h:outputText value=""/>
                       <h:graphicImage url="images/icons/soccer.gif"/>                                      
                      </h:panelGroup>
                    </f:facet>
                    <h:form>
                    	<h:inputHidden value="#{GameRegistry.delete_number}" />
                    	<h:commandButton value="Delete" action="#{GameRegistry.delete}" />
                    </h:form>
                  </h:column>
                  
                </h:dataTable>
                
                
            <h2><h:outputText value="All Matches:"/></h2>
        	<h:dataTable id="allMatchesTable" rows="100"
                    value="#{GameRegistry.allGames}"
                             var="game" rowClasses="list-row-odd,list-row-even" 
                             headerClass="table-header"
                             width="100%" binding="#{GameRegistry.data2}">

                  <h:column>
                    <f:facet name="header">
                     <h:panelGroup>
                       <h:outputText value="Date"/>
                       <h:graphicImage url="images/icons/date.gif"/>                                      
                      </h:panelGroup>
                    </f:facet>
                   <h:outputText value="#{game.datetime}"/>
                  </h:column>
                  
                   <h:column>
                    <f:facet name="header">
                     <h:panelGroup>
                       <h:outputText value="Stade"/>
                       <h:graphicImage url="images/icons/date.gif"/>                                      
                      </h:panelGroup>
                    </f:facet>
                   <h:outputText value="#{game.stade}, #{game.country}"/>
                  </h:column>  
                 
                  <h:column>
                    <f:facet name="header">
                     <h:panelGroup>
                       <h:outputText value="Teams"/>
                       <h:graphicImage url="images/icons/soccer.gif"/>                                      
                      </h:panelGroup>
                    </f:facet>
                   <h:outputText value="#{game.team1} - #{game.team2}"/>
                  </h:column>  
                  
                  <h:column>
                    <f:facet name="header">
                     <h:panelGroup>
                       <h:outputText value="Cat. / Price"/>
                       <h:graphicImage url="images/icons/soccer.gif"/>                                      
                      </h:panelGroup>
                    </f:facet>
                   <h:outputText value="#{game.category} / #{game.price}"/>
                  </h:column>   
                  
                  <h:column>
                   <f:facet name="header">
                    <h:panelGroup>
                      <h:outputText value="#"/>
                      <h:graphicImage url="images/icons/soccer.gif"/>                                      
                     </h:panelGroup>
                   </f:facet>
                   <h:panelGroup>
					  <h:inputText required="true" id="ticket" value="#{register.firstname}"
					    maxlength="1" size="1"/>
					    <h:commandButton value="Request" action="#{GameRegistry.request}" />
				   </h:panelGroup>
                  </h:column>

                </h:dataTable>
        </h:form>
        <p><br />
        </p>
        <!-- end #mainContent --></div></div>
    	<!-- Dieses clear-Element sollte direkt auf das #mainContent-div folgen, um das #container-div anzuweisen, alle untergeordneten Floats aufzunehmen. --><br class="clearfloat" />
      <div id="footer">
        <p>Lars Schnyder, Lorenz Grimm</p>
        <!-- end #footer --></div>
    <!-- end #container --></div>
    </body>
</html>
</f:view>