package com.kevinjkahl.calculator.model;

public class Model {

	// This is the String corresponding to what the user is entering
	private String displayString;

	// This is the last operation entered by the user.
	private String operation;

	// This is true if the next digit entered starts a new value.
	private String state;

	// This holds if the last input was a number or a operator
	private String lastInput;

	// This holds the first operand number/decimal entered
	private String firstOperand;

	// This holds the second operand number/decimal entered
	private String secondOperand;

	// This holds a string representation of the answer
	private String strAnswer;

	// This holds a double representation of the answer
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
	public void handleClear( String clear ) {
		if ( clear == "C" ) {
			// clear last - of operator, clear the operator, if not operator, clear display and set to zero
			if ( getState() == "Operator" ) {
				setOperation( "" );
			} else if ( getState() == "First Operand" ) {
				firstOperand = "0";
				clearDisplay();
			} else if ( getState() == "Second Operand" ) {
				secondOperand = "0";
				this.clearDisplay();
			}
		} else {
			setToDefault();
		}
	}

	/**
	 * Method to handle the incoming number/dot. Assign it to the first operand or second, or to add a dot. The last part will start a new operation of the incoming number was during the state of
	 * answer. Aka, the first thing they did after pressing equals was enter a new number.
	 *
	 * @param number
	 *            the incoming number 0 to 9 or dot.
	 * 
	 */
	public void HandleNumber( String number ) {
		if ( state == "Start" || state == "First Operand" ) {
			if ( number == "." ) {
				if ( displayString.equals( "" ) ) {
					displayString = "0";
					firstOperand += "0";
				}
				displayString += ".";
				firstOperand += ".";
			} else {
				setFirstOperand( number );
				setDisplayString( number );
			}// end if dot

			setState( "First Operand" );
		} else if ( state == "Operator" || state == "Second Operand" ) {
			if ( number == "." ) {
				if ( displayString.equals( "" ) ) {
					displayString = "0";
					secondOperand += "0";
				}
				displayString += ".";
				secondOperand += ".";
			} else {
				setSecondOperand( number );
				setDisplayString( number );
			}// end if dot
			setState( "Second Operand" );
		} else if ( getState() == "Answer" ) {
			displayString = "0";
			if ( number == "." ) {
				if ( displayString.equals( "" ) ) {
					displayString = "0";
					firstOperand += "0";
				}
				displayString += ".";
				firstOperand += ".";
			} else {
				setFirstOperand( number );
				setDisplayString( number );
			}// end if dot
			setState( "First Operand" );
		}

	}

	/**
	 * Method to perform calc on first and second operands.
	 */
	public void calculate() {
		clearDisplay();
		if ( getOperation().equals( "+" ) ) {
			dblAnswer = Double.parseDouble( firstOperand ) + Double.parseDouble( secondOperand );
		} else if ( getOperation().equals( "-" ) ) {
			dblAnswer = Double.parseDouble( firstOperand ) - Double.parseDouble( secondOperand );
		} else if ( getOperation().equals( "*" ) ) {
			dblAnswer = Double.parseDouble( firstOperand ) * Double.parseDouble( secondOperand );
		} else if ( getOperation().equals( "/" ) ) {
			if ( secondOperand == "0" || secondOperand == "0.00" ) {

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
	}

	/**
	 * Method to handle the assignment of the operator
	 * 
	 * @param operator
	 *            incoming operator
	 */
	public void handleOperator( String operator ) {
		//TODO: create the ability to apply a negative sign to a number
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

	/**
	 * Method that calculates a rolling. Aka, when they enter an operand after receiving their answer, as in they want to perform a calculation on the previous answer.
	 */
	private void rollingCalculate() {
		displayString = "";
		if ( getOperation().equals( "+" ) ) {
			dblAnswer = Double.parseDouble( firstOperand ) + Double.parseDouble( secondOperand );
		} else if ( getOperation().equals( "-" ) ) {
			dblAnswer = Double.parseDouble( firstOperand ) - Double.parseDouble( secondOperand );
		} else if ( getOperation().equals( "*" ) ) {
			dblAnswer = Double.parseDouble( firstOperand ) * Double.parseDouble( secondOperand );
		} else if ( getOperation().equals( "/" ) ) {
			if ( secondOperand == "0" || secondOperand == "0.00" ) {

			} else {
				dblAnswer = Double.parseDouble( firstOperand ) / Double.parseDouble( secondOperand );
			}

		}
		firstOperand = "";
		secondOperand = "";
		setFirstOperand( dblAnswer.toString() );
		setState( "Operator" );

	}

	/**
	 * Method to set the variables to a default state.
	 */
	private void setToDefault() {
		displayString = "0";
		firstOperand = "";
		secondOperand = "";
		dblAnswer = 0.0;
		strAnswer = "";
		setState( "Start" );
		operation = "";
	}

	/**
	 * Method to clear the string associated with the display
	 */
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
