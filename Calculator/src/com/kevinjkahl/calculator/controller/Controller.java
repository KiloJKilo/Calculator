package com.kevinjkahl.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import com.kevinjkahl.calculator.controller.Controller.EscAction;
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
		// TODO Could create an all inclusive method of clearing that takes a c or ce parameter
		// TODO: Consolidate the operations and possibly place into select

		if ( cmd == "C" ) {// if user presses clear
			if ( model.getLastInput() == "Operator" ) {// if the last thing entered was an operator, clear that
				System.out.println( "Clear operator" );
				model.setOperation( "" );
			} else {// other wise it was a number, clear that.
				System.out.println( "Clear number" );
				model.clearDisplay();
				view.update( "0" );
			}// end C

		} else if ( cmd == "CE" ) {// if the user presses clear all
			System.out.println( "Clear Everyhing" );
			model.setOperation( "" );
			model.clearDisplay();
			model.setStart( true );
			view.update( "0" );
			model.HandleNumber( "0" );

		} else {// c or ce was not pressed, it's going to be a number or operator

			// handle a non number being the first button pressed
			// TODO: Does this belong in the model?
			if ( model.isStart() ) { // if this is the start of a new operation
				if ( isOperator( cmd ) ) { // and an operator was entered
					if ( model.getOperation() != null || model.getOperation() != "" ) {// there is an operator already, change it
						model.setOperation( cmd );
					} else {// they are not trying to change the operator
						if ( model.getValue() != null || model.getValue() != "" ) {// is there a display value? if so, continue the math with that number
							model.setStart( false );// reset the model so we are still 'in an operation'
							// model.update( cmd );
							view.update( model.getValue() );
						} else {// if there was nothing there, do nothing
							System.out.println( "Non Number to start" );
						}
					}// end start of new operation

				} else {// they did not enter an operator
					// model.update( cmd );
					view.update( model.getValue() );
				}
			} else {// not the start of a new operation
				// model.update( cmd );
				view.update( model.getValue() );
			}
		}// end handling a non number
	}

	// method to determine if the current command is a operator

	/**
	 * @param the
	 *            current input. a number, c, ce, or an operator
	 */
	private boolean isOperator( String command ) {
		if ( command == "*" || command == "+" || command == "-" || command == "/" || command == "=" ) {
			return true;
		} else {
			return false;
		}
	}

	public static class EscAction extends AbstractAction {

		public EscAction( String name, Integer mnemonic ) {
			// constructor
		}

		@Override
		public void actionPerformed( ActionEvent e ) {
			// TODO Auto-generated method stub
			System.out.println( "Move this to Escape " );
		}

		public static EscAction EscActionFactory() {
			// TODO Auto-generated method stub
			return new EscAction( "Escape", new Integer( KeyEvent.VK_ESCAPE ) );
		}

	}

	public static class ClearEverythingAction extends AbstractAction {

		public ClearEverythingAction( ) {
			// constructor
		}

		@Override
		public void actionPerformed( ActionEvent e ) {
			// TODO Auto-generated method stub
			System.out.println( "Clear Everything Action" );
		}

		public static ClearEverythingAction ClearEverythingActionFactory() {
			// TODO Auto-generated method stub
			//return new ClearEverythingAction( "Clear Everything", new Integer( KeyEvent.VK_ESCAPE ) );
			return new ClearEverythingAction(  );
		}

	}
	@SuppressWarnings ( "serial" )
	public static class ClearAction extends AbstractAction {

		public ClearAction( ) {
			// constructor
		}

		@Override
		public void actionPerformed( ActionEvent e ) {
			// TODO Auto-generated method stub
			System.out.println( "Clear Action" );
		}

		public static ClearAction ClearActionFactory() {
			// TODO Auto-generated method stub
			return new ClearAction( );
		}
	}
	
	@SuppressWarnings ( "serial" )
	public static class NumberAction extends AbstractAction {

		public NumberAction( ) {
			// constructor
		}

		@Override
		public void actionPerformed( ActionEvent e ) {
			// TODO Auto-generated method stub
			System.out.println( e.getActionCommand() );
			//System.out.println( "Number Action" );
		}

		public static NumberAction NumberActionFactory() {
			// TODO Auto-generated method stub
			return new NumberAction( );
		}
	}

	@SuppressWarnings ( "serial" )
	public static class OperatorAction extends AbstractAction {

		public OperatorAction( ) {
			// constructor
		}

		@Override
		public void actionPerformed( ActionEvent e ) {
			// TODO Auto-generated method stub
			System.out.println( e.getActionCommand() );
		}

		public static OperatorAction OperatorActionFactory() {
			// TODO Auto-generated method stub
			return new OperatorAction( );
		}

	}
	
}
