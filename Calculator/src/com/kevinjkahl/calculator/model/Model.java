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

	public Model() {
		displayValue = 0.0;
		displayString = "" + displayValue;
		internalValue = 0;
		dot = false;
		start = true;
		operation = "";
	}

	/**
	 * @return the String value of what was just calculated or what the user is entering
	 */
	public String getValue() {
		return displayString;
	}

	public void update( String text ) {
		if ( start ) {
			internalValue = displayValue;
			displayValue = 0;
			displayString = "";
			start = false;
			dot = false;
		}
		if ( text.length() == 1 && "0123456789".indexOf( text ) >= 0 ) {
			displayString += text;
			displayValue = Double.valueOf( displayString );
			lastInput = "Number";
		} else if ( text.equals( "." ) ) {
			if ( !dot ) {
				dot = true;
				if ( displayString.equals( "" ) ) {
					displayString = "0";

				}
				displayString += ".";
			}
			lastInput = "Number";
		} else {
			lastInput = "Operator";
			if ( operation.equals( "+" ) ) {
				displayValue = internalValue + displayValue;
			} else if ( operation.equals( "-" ) ) {
				displayValue = internalValue - displayValue;
			} else if ( operation.equals( "*" ) ) {
				displayValue = internalValue * displayValue;
			} else if ( operation.equals( "/" ) ) {
				displayValue = internalValue / displayValue;
			}
			displayString = "" + displayValue;
			internalValue = displayValue;
			operation = text;
			start = true;
		}
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

}
