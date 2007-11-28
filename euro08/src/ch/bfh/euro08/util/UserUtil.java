package ch.bfh.euro08.util;

import ch.bfh.euro08.hibernate.beans.User;


public class UserUtil 
{

  
  public static void copyUserProperties(User userFrom, User userTo)
  {
    userTo.setFirstname(userFrom.getFirstname());
    userTo.setLastname(userFrom.getLastname());
    userTo.setEmail(userFrom.getEmail());
    userTo.setId(userFrom.getId());
    userTo.setPassword(userFrom.getPassword());
    userTo.setSuperuser(userFrom.isSuperuser());
    userTo.setActivationcode(userFrom.getActivationcode());
  }
  

  
}