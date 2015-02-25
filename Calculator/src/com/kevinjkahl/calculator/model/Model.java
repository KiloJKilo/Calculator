package com.kevinjkahl.calculator.model;

public class Model {

	// This is the numeric value of the number the user is entering, or the number that was just calculated.
	private double displayValue;

	// This is the previous value entered or calculated.
	private double internalValue;

	// This is the String corresponding to what the user. is entering
	private String displayString;

	// This is the last operation entered by the user.
	private String operation;

	// This is true if the next digit entered starts a new value.
	private boolean start;

	// This is true if a decimal dot has been entered for the current value.
	private boolean dot;

	// this holds if the last input was a number or a operator
	private String lastInput;

	/**
	 * Constructor calls the defaultState() method which sets up *for initial use
	 */
	public Model() {
		defaultState();

	}

	/**
	 * method to clear the last number... c
	 *
	 * @param type
	 *            - clear the last operator or last number or clear everything
	 **/
	public void clear( String clear ) {
		if ( clear == "CE" ) {
			// clear everything
			defaultState();
			System.out.println( "Everything Was Cleared" );
		} else if ( clear == "C" ) {
			// clear last - of operator, clear the operator, if not operator, clear display and set to zero
			if ( this.getLastInput() == "Operator" ) {
				System.out.println( "Last Operator Cleared" );
				this.setOperation( "" );
			} else {
				System.out.println( "Last Number Cleared" );
				this.clearDisplay();
				this.HandleNumber( "0" );
			}// end if operator or number
		}// end if C

	}// end if CE or C

	public void HandleNumber( String number ) {
		if ( start ) {
			defaultState();
		}
		lastInput = "Number";
		displayString += number;
		displayValue = Double.valueOf( displayString );
	}

	public void HandleDot() {
		if ( start ) {
			defaultState();
		}
		lastInput = "Number";
		if ( !dot ) {
			dot = true;
			if ( displayString.equals( "" ) ) {
				displayString = "0";

			}
			displayString += ".";
		}
		lastInput = "Number";
	}

	public void HandleOperator( String operator ) {

		if ( start ) {
			defaultState();
		}
		lastInput = "Operator";
		if ( operator.equals( "+" ) ) {
			displayValue = internalValue + displayValue;
		} else if ( operator.equals( "-" ) ) {
			displayValue = internalValue - displayValue;
		} else if ( operator.equals( "*" ) ) {
			displayValue = internalValue * displayValue;
		} else if ( operator.equals( "/" ) ) {
			if ( displayValue == 0 || displayValue == 0.00 ) {

			} else {
				displayValue = internalValue / displayValue;
			}

		}
updateValues( operator );
	}

	/**
	 * method set the calc to a default state or reset it to a default state if in use
	 * 
	 * @return
	 *
	 */
	private void defaultState() {
		displayValue = 0.0;
		displayString = "0";
		internalValue = 0;
		dot = false;
		start = true;
		operation = "";

	}
	
	private void updateValues(String operator ){
		displayString = "" + displayValue;
		internalValue = displayValue;
		operation = operator;
		start = true;
		
	}

	public void clearDisplay() {
		displayString = "";
	}

	public boolean isStart() {
		return start;
	}

	public void setStart( boolean start ) {
		this.start = start;
	}

	public String getLastInput() {
		return lastInput;
	}

	public void setOperation( String operation ) {
		this.operation = operation;
	}

	public String getOperation() {
		return operation;
	}

	/**
	 * @return the String value of what was just calculated or what the user is entering
	 */
	public String getValue() {
		return displayString;
	}

}
