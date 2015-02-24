package com.kevinjkahl.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Action;

import com.kevinjkahl.calculator.model.Model;
import com.kevinjkahl.calculator.view.View;

public class Controller extends KeyAdapter implements ActionListener {

	// The model of this MVC implementation of a calculator.
	private Model model;
	// The view of this MVC implementation of a calculator.
	private View view;

	/**
	 * This saves the model and and view.
	 * 
	 * @param model
	 *            a CalculatorModel for the functions of the calculator and the values entered by the user
	 * @param view
	 *            a CalculatorView for what should be displayed in the GUI
	 * @return
	 */
	public Controller( Model model, View view ) {
		this.model = model;
		this.view = view;

	}

	// this method handles the mouse click events from view
	@Override
	public void actionPerformed( ActionEvent e ) {
		String cmd = e.getActionCommand();

		// TODO: create a method to have a numerical representation so that the prog can check if not a number
		// TODO Could create an all inclusive method of clearing that takes a c or ce paramater

		// new method to handle button actions
		if ( cmd == "C" ) {// if user presses clear
			if ( model.getLastInput() == "Operator" ) {// if this is an operator
				System.out.println( "Clear operator" );
				model.setOperation( "" );
			} else {// it is a number - clear the last number
				System.out.println( "Clear number" );
				model.clearDisplay();
				view.update( "0" );

			}

		} else if ( cmd == "CE" ) {
			System.out.println( "Clear Everyhing" );
			model.setOperation( "" );
			model.clearDisplay();
			model.setStart( true );
			view.update( "0" );
			model.update( "0" );

		} else {
			// handle a non number being the first button pressed
			// TODO: Does this belong in the model?
			if ( model.isStart() ) { // if this is the start of a new operation
				if ( isOperator( cmd ) ) { // and one of these keys were entered
					// is there a display value? if so, continue the math with that number
					if ( model.getValue() != null || model.getValue() != "" ) {
						model.setStart( false );// reset the model so we are still 'in an operation'
						model.update( cmd );
						view.update( model.getValue() );
					} else {// if there was nothing there, do nothing
						System.out.println( "Non Number to start" );
					}

				} else {
					model.update( cmd );
					view.update( model.getValue() );
				}
			} else {
				model.update( cmd );
				view.update( model.getValue() );
			}
		}
	}

	private boolean isOperator( String command ) {
		if ( command == "*" || command == "+" || command == "-" || command == "/" || command == "=" ) {
			return true;
		} else {
			return false;
		}
	}
}