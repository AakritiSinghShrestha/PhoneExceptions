package com.codedifferently.phone;

import com.codedifferently.exceptions.InvalidPhoneNumberFormatException;
import com.codedifferently.tools.RandomNumberFactory;

import java.util.logging.Logger;

public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        PhoneNumber[] phoneNumber =new PhoneNumber[phoneNumberCount];
        for(int i=0;i<phoneNumber.length;i++){
            phoneNumber[i] = createRandomPhoneNumber();
        }
        return phoneNumber;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {

    Integer areaCode = RandomNumberFactory.createInteger(100,999);
    Integer centralOfficeCode = RandomNumberFactory.createInteger(100,999);
    Integer phoneLineCode = RandomNumberFactory.createInteger(1000,9999);
        return createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);

    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        //(###)-###-####
        String phonenumber="";
        try{
             phonenumber= String.format("(%d)-%d-%d",areaCode,centralOfficeCode,phoneLineCode );
            return createPhoneNumber(phonenumber);
        }catch(InvalidPhoneNumberFormatException e){
            logger.info(phonenumber+"is not a valid phone number" );
            return null;

        }

    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException{
       logger.info("Attempting to create a new PhoneNumber object with a value of (###)-###-####" + phoneNumberString
       );

        return new PhoneNumber(phoneNumberString);
    }
}
