package com.kevinjkahl.calculator.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.kevinjkahl.calculator.model.Model;
import com.kevinjkahl.calculator.view.View;

public class Controller {

	// The model of this MVC implementation of a calculator.
	private static Model model;
	// The view of this MVC implementation of a calculator.
	private static View view;

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
		Controller.model = model;
		Controller.view = view;

	}

	/**
	 * AbstractAction handling the ClearEverything event
	 */
	@SuppressWarnings ( "serial" )
	public static class ClearEverythingAction extends AbstractAction {

		public ClearEverythingAction( String actionCommand ) {
			super( actionCommand );
		}

		@Override
		public void actionPerformed( ActionEvent e ) {
			model.handleClear( e.getActionCommand() );
			view.update( model.getDisplayString() );
		}

	}

	/**
	 * AbstractAction handling the Clear event
	 */
	@SuppressWarnings ( "serial" )
	public static class ClearAction extends AbstractAction {

		public ClearAction( String actionCommand ) {
			super( actionCommand );
		}

		@Override
		public void actionPerformed( ActionEvent e ) {
			model.handleClear( e.getActionCommand() );
			view.update( model.getDisplayString() );
		}

	}

	/**
	 * AbstractAction handling the Number event
	 */
	@SuppressWarnings ( "serial" )
	public static class NumberAction extends AbstractAction {

		static String name;

		public NumberAction( String actionCommand ) {
			super( actionCommand );
		}

		@Override
		public void actionPerformed( ActionEvent e ) {
			model.HandleNumber( e.getActionCommand() );
			view.update( model.getDisplayString() );
		}

	}

	@SuppressWarnings ( "serial" )
	public static class OperatorAction extends AbstractAction {

		public OperatorAction( String name ) {
			super( name );
		}

		@Override
		public void actionPerformed( ActionEvent e ) {
			model.handleOperator( e.getActionCommand() );
		}

	}

	/**
	 * AbstractAction handling the Equals event
	 */
	@SuppressWarnings ( "serial" )
	public static class EqualsAction extends AbstractAction {

		public EqualsAction( String actionCommand ) {
			super( actionCommand );
		}

		@Override
		public void actionPerformed( ActionEvent e ) {
			model.calculate();
			view.update( model.getDisplayString() );
		}

	}

}
