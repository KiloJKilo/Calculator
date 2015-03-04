package com.kevinjkahl.calculator.model;

public class Model {

	// This is the numeric value of the number the user is entering, or the number that was just calculated.
	private double displayValue;

	// This is the previous value entered or calculated.
	private double internalValue;

	// This is the String corresponding to what the user is entering
	private String displayString;

	// This is the last operation entered by the user.
	private String operation;

	// This is true if the next digit entered starts a new value.
	private String state;

	// This is true if a decimal dot has been entered for the current value.
	private boolean dot;

	// this holds if the last input was a number or a operator
	private String lastInput;

	private String firstOperand;

	private String secondOperand;

	private String strAnswer;
	private Double dblAnswer;

	/**
	 * Constructor calls the defaultState() method which sets up *for initial use
	 */
	public Model() {
		setToDefault();

	}

	/**
	 * method to clear the display of the last number/operator or clear the entire operation
	 *
	 * @param clear
	 *            the last operator or last number or clear everything
	 * 
	 */
	public void clear( String clear ) {
		if ( clear == "C" ) {
			// clear last - of operator, clear the operator, if not operator, clear display and set to zero
			if ( this.getLastInput() == "Operator" ) {
				System.out.println( "Last Operator Cleared" );
				this.setOperation( "" );
			} else {
				System.out.println( "Last Number Cleared" );
				this.clearDisplay();
				this.HandleNumber( "0" );
			}
		} else {
			// clear everything
			setToDefault();
		}// end if operator or number
	}// end if C

	public void HandleNumber( String number ) {
		if ( state == "Start" || state == "First Operand" ) {
			setFirstOperand( number );
			setDisplayString( number );
			setState( "First Operand" );
		} else if ( state == "Operator" || state == "Second Operand" ) {
			this.setSecondOperand( number );
			setDisplayString( number );
			setState( "Second Operand" );
		} else if ( getState() == "Answer" ) {
			displayString = "0";
			this.setFirstOperand( number );
			setDisplayString( number );
			setState( "First Operand" );
		}

	}

	public void HandleDot() {
		// if ( state ) {
		// setState( false );
		// }
		if ( !dot ) {
			dot = true;
			if ( displayString.equals( "" ) ) {
				displayString = "0";

			}
			displayString += ".";
		}
		lastInput = "Number";
	}

	public void calculate() {
		clearDisplay();
		if ( getOperation().equals( "+" ) ) {
			dblAnswer = Double.parseDouble( firstOperand ) + Double.parseDouble( secondOperand );
		} else if ( getOperation().equals( "-" ) ) {
			dblAnswer = Double.parseDouble( firstOperand ) - Double.parseDouble( secondOperand );
		} else if ( getOperation().equals( "*" ) ) {
			dblAnswer = Double.parseDouble( firstOperand ) * Double.parseDouble( secondOperand );
		} else if ( getOperation().equals( "/" ) ) {
			if ( displayValue == 0 || displayValue == 0.00 ) {

			} else {
				dblAnswer = Double.parseDouble( firstOperand ) / Double.parseDouble( secondOperand );
			}

		}

		setStrAnswer( dblAnswer.toString() );
		setDisplayString( dblAnswer.toString() );
		setState( "Answer" );
		firstOperand = "";
		secondOperand = "";
		operation = "";
		// displayString = "" + displayValue;
		// internalValue = displayValue;
		// operation = operator;
		// state = true;
	}

	public void handleOperator( String operator ) {
		displayString = "";
		if ( getState() == "Start" ) {
			// do nothing
		} else if ( getState() == "First Operand" ) {
			setOperation( operator );
			setState( "Operator" );
		} else if ( getState() == "Answer" ) {
			setFirstOperand( getStrAnswer() );
			setState( "Operator" );
			setOperation( operator );
		} else if ( state == "Operator" ) {
			setOperation( operator );
			setState( "Operator" );
		} else if ( state == "Second Operand" ) {
			rollingCalculate();
			setOperation( operator );
		}
	}

	private void rollingCalculate() {
		displayString = "";
		if ( getOperation().equals( "+" ) ) {
			dblAnswer = Double.parseDouble( firstOperand ) + Double.parseDouble( secondOperand );
		} else if ( getOperation().equals( "-" ) ) {
			dblAnswer = Double.parseDouble( firstOperand ) - Double.parseDouble( secondOperand );
		} else if ( getOperation().equals( "*" ) ) {
			dblAnswer = Double.parseDouble( firstOperand ) * Double.parseDouble( secondOperand );
		} else if ( getOperation().equals( "/" ) ) {
			if ( displayValue == 0 || displayValue == 0.00 ) {

			} else {
				dblAnswer = Double.parseDouble( firstOperand ) / Double.parseDouble( secondOperand );
			}

		}
		firstOperand = "";
		secondOperand = "";
		setFirstOperand( dblAnswer.toString() );
		setState( "Operator" );

	}

	private void setToDefault() {
		displayValue = 0.0;
		displayString = "0";
		internalValue = 0;
		firstOperand = "";
		secondOperand = "";
		dblAnswer = 0.0;
		strAnswer = "";
		dot = false;
		setState( "Start" );
		operation = "";
	}

	public void clearDisplay() {
		displayString = "";
	}

	public String getState() {
		return state;
	}

	public void setState( String state ) {
		this.state = state;

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
	public String getDisplayString() {
		return displayString;
	}

	public void setDisplayString( String string ) {
		this.displayString += string;
	}

	public String getSecondOperand() {
		return secondOperand;
	}

	public void setSecondOperand( String secondOperand ) {
		this.secondOperand += secondOperand;
	}

	public String getFirstOperand() {
		return firstOperand;
	}

	public void setFirstOperand( String firstOperand ) {
		this.firstOperand += firstOperand;
	}

	public String getStrAnswer() {
		return strAnswer;
	}

	public void setStrAnswer( String strAnswer ) {
		this.strAnswer = strAnswer;
	}

	public Double getDblAnswer() {
		return dblAnswer;
	}

	public void setDblAnswer( Double dblAnswer ) {
		this.dblAnswer = dblAnswer;
	}

}
