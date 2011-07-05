package com.shsz.young.jeff.test.model;
import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class CarTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void manufacturerIsNull() {
    	
    	// validate
        Car car = new Car(null, "DD-AB-123", 4);

        Set<ConstraintViolation<Car>> constraintViolations =
            validator.validate(car);

        assertEquals(1, constraintViolations.size());
        assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
        
        // valicateProperty
        car = new Car(null, "DD-AB-123", 4);
        
        constraintViolations =
        	validator.validateProperty(car, "manufacturer");
        
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
        
        // validateValue
        constraintViolations = validator.validateValue(Car.class, "licensePlate", "A");

        assertEquals(1, constraintViolations.size());
        assertEquals("size must be between 2 and 14", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void licensePlateTooShort() {
        Car car = new Car("Morris", "D", 4);

        Set<ConstraintViolation<Car>> constraintViolations = 
            validator.validate(car);

        assertEquals(1, constraintViolations.size());
        assertEquals("size must be between 2 and 14", constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void seatCountTooLow() {
        Car car = new Car("Morris", "DD-AB-123", 1);

        Set<ConstraintViolation<Car>> constraintViolations =
            validator.validate(car);

        assertEquals(1, constraintViolations.size());
        assertEquals("must be greater than or equal to 2", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void carIsValid() {
        Car car = new Car("Morris", "DD-AB-123", 2);

        Set<ConstraintViolation<Car>> constraintViolations =
            validator.validate(car);

        assertEquals(0, constraintViolations.size());
    }
    
    @Test
    public void demo1() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    	Car car = new Car(null, "D", 1);
    	car.setDriver(new Person(null));
    	Set<ConstraintViolation<Car>> constraintViolations =
            validator.validate(car);
    	for (ConstraintViolation<Car> cv : constraintViolations) {
    		 Method methods[] = cv.getClass().getMethods();
    		    for (Method method : methods) {
    		        if (( method.getName().startsWith("get")
    		        		|| String.class.isAssignableFrom(method.getReturnType())
    		        		|| Date.class.isAssignableFrom(method.getReturnType())
    		        		|| long.class.isAssignableFrom(method.getReturnType())
    		        		|| int.class.isAssignableFrom(method.getReturnType())
    		        		|| double.class.isAssignableFrom(method.getReturnType())
    		        		|| float.class.isAssignableFrom(method.getReturnType())
    		        		|| char.class.isAssignableFrom(method.getReturnType())
    		        		|| boolean.class.isAssignableFrom(method.getReturnType()))
    		        		&& method.getParameterTypes().length == 0) {
    		        	System.out.println(method.getName() + ": " + method.invoke(cv, new Object[]{}));
    		        }
    		    }
    		System.out.println("================================<");
    	}
    }
    
    @Test
    public void testLicensePlateNotUpperCase() {

        Car car = new Car("Morris", "dd-ab-123", 4);

        Set<ConstraintViolation<Car>> constraintViolations =
            validator.validate(car);
        assertEquals(1, constraintViolations.size());
        assertEquals(
            "Case mode must be UPPER.", 
            constraintViolations.iterator().next().getMessage());
    }
    @Test
    public void dummyTest() {
    	System.getProperties().list(System.out);
    }
}
