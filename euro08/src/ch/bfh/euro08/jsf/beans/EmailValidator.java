package ch.bfh.euro08.jsf.beans;

import javax.faces.validator.*;
import javax.faces.context.*;
import javax.faces.component.*;

import javax.faces.application.*;


public class EmailValidator implements Validator {
  
  public void validate(FacesContext context, UIComponent component, Object toValidate) {
    boolean isValid = true;
    String value = null;
    
    if ((context == null) || (component == null)) {
      throw new NullPointerException();
    }
    if (!(component instanceof UIInput)) {
      return;
    }
    if (null == toValidate) {
      return;
    }
    value = toValidate.toString();
    int atIndex = value.indexOf('@');
    if (atIndex < 0) {
      isValid = false;
    }
    else if (value.lastIndexOf('.') < atIndex) {
      isValid = false;
    }
    if ( !isValid ) {
      FacesMessage errMsg = new FacesMessage("Validation Error: Wrong Email-Format");
      FacesContext.getCurrentInstance().addMessage("email", errMsg);
      throw new ValidatorException(errMsg);
    }
  }
}
