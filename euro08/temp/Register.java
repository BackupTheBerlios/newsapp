package com.jsfcompref.trainer.backing;

import com.jsfcompref.trainer.UserBean;
import com.jsfcompref.trainer.UserRegistry;
import com.jsfcompref.trainer.UserRegistryJava;
import com.jsfcompref.trainer.util.JSFUtil;
import com.jsfcompref.trainer.util.UserUtil;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectOneRadio;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;


/**
 * Backing bean for register.jsp
 */



public class Register 
{
  
  private HtmlInputText firstName;
  private HtmlInputText lastName;
  private HtmlSelectOneRadio gender;
  private HtmlInputText dob;
  private HtmlInputText email;
  private HtmlSelectOneMenu serviceLevel;
  private HtmlInputText userid;
  private HtmlInputSecret password;
  private HtmlInputSecret passwordCheck;
  
  private final static String AUTH_USER = "Authorized_User";

  public Register()
  {
  }

  public void validateEmail(FacesContext context, UIComponent toValidate,
                            Object value) throws ValidatorException {
    String eMail = (String) value;
    if(eMail.indexOf("@")<0) {
      FacesMessage message = new FacesMessage("Invalid email address!");
      throw new ValidatorException(message);
    }
  }


  public void validatePassword(FacesContext context, UIComponent toValidate,
                            Object value) throws ValidatorException {
    
    String password1 = (String)this.getPassword().getValue();
    String password2 = (String) value;
        
    if(!password1.equals(password2)) {
      FacesMessage message = new FacesMessage("Passwords do not match!");
      throw new ValidatorException(message);
    }
  }

  
 public String registerUser()
 {

  UserBean newUser = new UserBean();
  
  newUser.setFirstname(firstName.getValue().toString());
  newUser.setLastname(lastName.getValue().toString());
  newUser.setGender(gender.getValue().toString());
  newUser.setDob((Date)dob.getValue());
  newUser.setEmail(email.getValue().toString());
  newUser.setServiceLevel(serviceLevel.getValue().toString());
  newUser.setUserid(userid.getValue().toString());
  newUser.setPassword(password.getValue().toString());
  
  
  UserRegistry ManagedUserRegistry = (UserRegistry) JSFUtil.getManagedObject("UserRegistry");
  
  if (ManagedUserRegistry.AddRegisteredUser(newUser) == null) {
    // userid exists
    
    FacesContext.getCurrentInstance().addMessage(null, 
      new FacesMessage("Userid " + newUser.getUserid() + " already exists! Please choose another." ));
    newUser = null;
    
    return(null);
  }
  else {

      // Is a new user, continue logging in
    UserBean managedUserBean = 
      (UserBean)JSFUtil.getManagedObject("UserBean");
    UserUtil.copyUserProperties(newUser, managedUserBean);
    managedUserBean.setIsLoggedIn(true);

    //Place AUTH_USER string on session to disable security filter on session to disable security filter
    JSFUtil.storeOnSession(FacesContext.getCurrentInstance(), AUTH_USER, "Authorized_User");

    
    FacesContext.getCurrentInstance().addMessage(null,
                 new FacesMessage("Registration Successful!"));
    System.out.println("Done Registering User..");
    return("main");
  
  }
  
 }

  public void setFirstName(HtmlInputText firstName) {
    this.firstName = firstName;
  }

  public HtmlInputText getFirstName() {
    return firstName;
  }

  public void setLastName(HtmlInputText lastName) {
    this.lastName = lastName;
  }

  public HtmlInputText getLastName() {
    return lastName;
  }

  public void setGender(HtmlSelectOneRadio gender) {
    this.gender = gender;
  }

  public HtmlSelectOneRadio getGender() {
    return gender;
  }

  public void setDob(HtmlInputText dob) {
    this.dob = dob;
  }

  public HtmlInputText getDob() {
    return dob;
  }

  public void setEmail(HtmlInputText email) {
    this.email = email;
  }

  public HtmlInputText getEmail() {
    return email;
  }

  public void setServiceLevel(HtmlSelectOneMenu serviceLevel) {
    this.serviceLevel = serviceLevel;
  }

  public HtmlSelectOneMenu getServiceLevel() {
    return serviceLevel;
  }

  public void setUserid(HtmlInputText userid) {
    this.userid = userid;
  }

  public HtmlInputText getUserid() {
    return userid;
  }

  public void setPassword(HtmlInputSecret password) {
    this.password = password;
  }

  public HtmlInputSecret getPassword() {
    return password;
  }



  public void setPasswordCheck(HtmlInputSecret passwordChk) {
    this.passwordCheck = passwordChk;
  }

  public HtmlInputSecret getPasswordCheck() {
    return passwordCheck;
  }


}
