<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>
  <f:loadBundle basename="com.jsfcompref.trainer.resources.UIResources"
                var="res"/>
  <html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"></meta>
      <title>
       <h:outputText value="#{res.title} - #{res['register.pageTitle']}"/>
      </title>
      <link href="css/vt.css" rel="stylesheet" media="screen"></link>
      <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body><h:form>
        <table width="100%" border="0">
          <tr>
            <td>
              <h1 align="center">
                <h:graphicImage url="/images/vtlogo.jpg"
                                alt="#{res.title}"/>
                <h:outputText value="#{res.title}"/>
              </h1>
            </td>
          </tr>          
          <tr>
          <td> 
        <f:subview id="loginbar">
          <jsp:include page="loginbar.jsp"/>
        </f:subview>
          </td>
         </tr>
          <tr>
            <td>
              <p>
                <h:outputText value="#{res[\'register.header\']}" styleClass="PageTitle"/></p>

              <h:messages globalOnly="true" infoClass="RegError"/>              

              <h:panelGrid width="70%" columns="3" border="0">

                <h:outputLabel value="#{res[\'register.firstName\']}" for="fname" />                
                <h:inputText required="true" id="fname"
                             binding="#{Register_Backing.firstName}"/>
                <h:message for="fname" errorClass="ValidateError"/>

                <h:outputLabel value="#{res[\'register.lastName\']}" for="lname" />                
                <h:inputText required="true" id="lname"
                               binding="#{Register_Backing.lastName}"/>
                <h:message for="lname" errorClass="ValidateError"/>

                <h:outputLabel value="#{res[\'register.gender\']}" for="gender" />                
                 <h:selectOneRadio required="true" id="gender" 
                                   binding="#{Register_Backing.gender}" >
                   <f:selectItem itemLabel="#{res[\'register.male\']}" itemValue="male"/>
                   <f:selectItem itemLabel="#{res[\'register.female\']}" itemValue="female"/>
                 </h:selectOneRadio>
                <h:message for="gender" errorClass="ValidateError"/>

                <h:outputLabel value="#{res[\'register.dob\']}" for="dob"/>                
                <h:inputText id="dob" required="true" 
                    
                         binding="#{Register_Backing.dob}" >                  
                  <f:convertDateTime pattern="MM-dd-yyyy"/>
                  <f:validator validatorId="pastDateValidate"/>
                </h:inputText>
                <h:message for="dob" errorClass="ValidateError"/>

                <h:outputLabel value="#{res[\'register.email\']}" for="email"/>                
                <h:inputText required="true" id="email"
                               binding="#{Register_Backing.email}"
                             validator="#{Register_Backing.validateEmail}"/>
                <h:message for="email" errorClass="ValidateError"/>

                <h:outputLabel value="#{res[\'register.serviceLevel\']}" for="level"/> 
                <h:selectOneMenu  binding="#{Register_Backing.serviceLevel}" id="level">
                  <f:selectItem itemLabel="#{res[\'register.basic\']}" itemValue="Basic"/>
                  <f:selectItem itemLabel="#{res[\'register.medium\']}" itemValue="Medium"/>
                  <f:selectItem itemLabel="#{res[\'register.premium\']}" itemValue="Premium"/>
                </h:selectOneMenu>
                <f:verbatim>&nbsp;</f:verbatim>

                <h:outputLabel value="#{res[\'register.userid\']}" for="userid"/>                
                <h:inputText required="true" id="userid"
                             binding="#{Register_Backing.userid}"/>
                <h:message for="userid" errorClass="ValidateError"/>

                <h:outputLabel value="#{res[\'register.password\']}" for="password"/>                
                <h:inputSecret required="true" id="password"
                             binding="#{Register_Backing.password}" />
                <h:message for="password" errorClass="ValidateError"/>

                <h:outputLabel value="#{res[\'register.passwordReType\']}" for="password2"/>                
                <h:inputSecret required="true" id="password2"
                             binding="#{Register_Backing.passwordCheck}"
                            validator="#{Register_Backing.validatePassword}"/>
                <h:message for="password2" errorClass="ValidateError"/>


                <f:verbatim>&nbsp;</f:verbatim>
                <h:panelGroup>
                  <h:commandButton value="#{res[\'register.registerButton\']}"
                                   action="#{Register_Backing.registerUser}"/>
                  <f:verbatim>&nbsp;&nbsp;&nbsp;&nbsp;</f:verbatim>
                  <h:commandButton value="#{res[\'register.cancelButton\']}" action="cancel"
                                   immediate="true"/>
                </h:panelGroup>

              </h:panelGrid>
            </td>
          </tr>
        </table>
      </h:form></body>
  </html>
</f:view>