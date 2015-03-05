package com.kevinjkahl.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;

import javax.swing.AbstractAction;

import com.kevinjkahl.calculator.model.Model;
import com.kevinjkahl.calculator.view.View;

public class Controller extends KeyAdapter {

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

	@SuppressWarnings ( "serial" )
	public static class ClearEverythingAction extends AbstractAction {

		@Override
		public void actionPerformed( ActionEvent e ) {
//			model.clear( e.getActionCommand() );
//			view.update( model.getDisplayString() );
//			view.borderChange( false, e.getActionCommand() );
		}

		public static ClearEverythingAction ClearEverythingActionFactory() {
			return new ClearEverythingAction();
		}

	}

	@SuppressWarnings ( "serial" )
	public static class ClearAction extends AbstractAction {

		@Override
		public void actionPerformed( ActionEvent e ) {
//			model.clear( e.getActionCommand() );
//			view.update( model.getDisplayString() );
//			view.borderChange( false, e.getActionCommand() );
		}

		public static ClearAction ClearActionFactory() {
			return new ClearAction();
		}
	}

	@SuppressWarnings ( "serial" )
	public static class NumberAction extends AbstractAction {

		@Override
		public void actionPerformed( ActionEvent e ) {			
//			model.HandleNumber( e.getActionCommand() );
//			view.update( model.getDisplayString() );
		}

		public static NumberAction NumberActionFactory() {
			return new NumberAction();
		}
	}

	@SuppressWarnings ( "serial" )
	public static class DotAction extends AbstractAction {

		@Override
		public void actionPerformed( ActionEvent e ) {
//			model.HandleDot();
//			view.update( model.getDisplayString() );
//			view.borderChange( false, e.getActionCommand() );
		}

		public static DotAction DotActionFactory() {
			return new DotAction();
		}
	}

	@SuppressWarnings ( "serial" )
	public static class OperatorAction extends AbstractAction {

		@Override
		public void actionPerformed( ActionEvent e ) {
//			model.handleOperator( e.getActionCommand() );
//			view.borderChange( false, e.getActionCommand() );
		}

		public static OperatorAction OperatorActionFactory() {
			return new OperatorAction();
		}

	}

	@SuppressWarnings ( "serial" )
	public static class EqualsAction extends AbstractAction {

		@Override
		public void actionPerformed( ActionEvent e ) {
//			model.calculate();
//			view.update( model.getDisplayString() );
//			view.borderChange( false, e.getActionCommand() );
		}

		public static EqualsAction EqualsActionFactory() {
			return new EqualsAction();
		}

	}

}//end controller
