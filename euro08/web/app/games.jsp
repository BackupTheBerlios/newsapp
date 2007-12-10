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
        <h2>All Games</h2>
        <h:form id="games">
        	<h3>Tickets requested:</h3>
        	<h:dataTable id="eventsTable" rows="5"
                    value="#{GameRegistry.trainingEventsForUser}"
                             var="te" rowClasses="list-row-odd,list-row-even" 
                             headerClass="table-header"
                             width="100%" binding="#{GameRegistry.data}">

                  <h:column rendered="#{UserBean.trainer}">
                    <f:facet name="header">
                     <h:panelGroup>
                     <h:commandLink actionListener="#{GameRegistry.sortByUserId}"
                                     immediate="true">
                      <h:outputText value="#{res[\'main.userAccount\']}"/>
                      </h:commandLink>
                      <h:graphicImage url="#{GameRegistry.sortUserIdAsc ? '/images/arrow-up.gif' : '/images/arrow-down.gif'}" height="13"
                                      width="9" rendered="#{GameRegistry.showSortUserIdIcon}"/>                                      
                      </h:panelGroup>
                    </f:facet>
                    <h:outputText value="#{te.userid}"/>
                  </h:column>              
                  
                  <h:column>
                    <f:facet name="header">
                    <h:panelGroup>
                    <h:commandLink actionListener="#{GameRegistry.sortByStatus}" immediate="true" >                    
                      <h:outputText value="#{res[\'main.status\']}"/>
                    </h:commandLink>
                      <h:graphicImage url="#{GameRegistry.sortStatusAsc ? '/images/arrow-up.gif' : '/images/arrow-down.gif'}" height="13"
                                      width="9" rendered="#{GameRegistry.showSortStatusIcon}"/>
                    </h:panelGroup>
                   </f:facet>
                      <h:outputText value="#{te.status}"/>
                  </h:column>
                  
                  <h:column>
                    <h:commandLink action="#{GameRegistry.editTrainingEventAction}">
                      <h:outputText value="#{res[\'main.select\']}" />
                    </h:commandLink>
                  </h:column>
                </h:dataTable>
            
            <h3>No tickets requested:</h3>
        	<h:dataTable id="eventsTable" rows="5"
                    value="#{GameRegistry.trainingEventsForUser}"
                             var="te" rowClasses="list-row-odd,list-row-even" 
                             headerClass="table-header"
                             width="100%" binding="#{GameRegistry.data}">

                  <h:column rendered="#{UserBean.trainer}">
                    <f:facet name="header">
                     <h:panelGroup>
                     <h:commandLink actionListener="#{GameRegistry.sortByUserId}"
                                     immediate="true">
                      <h:outputText value="#{res[\'main.userAccount\']}"/>
                      </h:commandLink>
                      <h:graphicImage url="#{GameRegistry.sortUserIdAsc ? '/images/arrow-up.gif' : '/images/arrow-down.gif'}" height="13"
                                      width="9" rendered="#{GameRegistry.showSortUserIdIcon}"/>                                      
                      </h:panelGroup>
                    </f:facet>
                    <h:outputText value="#{te.userid}"/>
                  </h:column>              
                  
                  <h:column>
                    <f:facet name="header">
                    <h:panelGroup>
                    <h:commandLink actionListener="#{GameRegistry.sortByStatus}" immediate="true" >                    
                      <h:outputText value="#{res[\'main.status\']}"/>
                    </h:commandLink>
                      <h:graphicImage url="#{GameRegistry.sortStatusAsc ? '/images/arrow-up.gif' : '/images/arrow-down.gif'}" height="13"
                                      width="9" rendered="#{GameRegistry.showSortStatusIcon}"/>
                    </h:panelGroup>
                   </f:facet>
                      <h:outputText value="#{te.status}"/>
                  </h:column>
                  
                  <h:column>
                    <h:commandLink action="#{GameRegistry.editTrainingEventAction}">
                      <h:outputText value="#{res[\'main.select\']}" />
                    </h:commandLink>
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