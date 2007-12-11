package ch.bfh.euro08.jsf.beans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class CardValidator implements Validator {


   public void validate(FacesContext context, UIComponent component, Object toValidate) {
	    if ((context == null) || (component == null)) {
	        throw new NullPointerException();
	      }
	      if (!(component instanceof UIInput)) {
	        return;
	      }
	      if (null == toValidate) {
	        return;
	      }
	      String cardNumber;
	      cardNumber = getDigitsOnly(toValidate.toString());
	      System.out.println(cardNumber.length());
	      if(!luhnCheck(cardNumber) || cardNumber.length() == 0) {
	    	  
	          FacesMessage errMsg = new FacesMessage("Validation Error: Wrong Card Number - luhnCheck Faild");
	          FacesContext.getCurrentInstance().addMessage("card", errMsg);
	          throw new ValidatorException(errMsg);
	      }
   }

   private static boolean luhnCheck(String cardNumber) {
      int sum = 0;

      for(int i = cardNumber.length() - 1; i >= 0; i -= 2) {
         sum += Integer.parseInt(cardNumber.substring(i, i + 1));
         if(i > 0) {
            int d = 2 * Integer.parseInt(cardNumber.substring(i - 1, i));
            if(d > 9) d -= 9;
            sum += d;
         }
      }
      
      return sum % 10 == 0;
   }

   private static String getDigitsOnly(String s) {
      StringBuilder digitsOnly = new StringBuilder ();
      char c;
      for(int i = 0; i < s.length (); i++) {
         c = s.charAt (i);
         if (Character.isDigit(c)) {
            digitsOnly.append(c);
         }
      }
      return digitsOnly.toString();
   }
}
