package com.kevinjkahl.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.swing.AbstractAction;
import javax.swing.JButton;

import com.kevinjkahl.calculator.model.Model;
import com.kevinjkahl.calculator.view.View;

public class Controller extends KeyAdapter implements ActionListener {

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
			view.borderChange( true, e.getActionCommand() );
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
			view.borderChange( true, e.getActionCommand() );
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
			view.borderChange( true, e.getActionCommand() );
			
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
			view.borderChange( true, e.getActionCommand() );
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
			view.borderChange( true, e.getActionCommand() );
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
			view.borderChange( true, e.getActionCommand() );
//			model.calculate();
//			view.update( model.getDisplayString() );
//			view.borderChange( false, e.getActionCommand() );
		}

		public static EqualsAction EqualsActionFactory() {
			return new EqualsAction();
		}

	}

	@SuppressWarnings ( "serial" )
	public static class ClearEverythingActionR extends AbstractAction {

		@Override
		public void actionPerformed( ActionEvent e ) {
			view.borderChange( false, e.getActionCommand() );
		}

		public static ClearEverythingActionR ClearEverythingActionFactoryR() {
			return new ClearEverythingActionR();
		}

	}

	@SuppressWarnings ( "serial" )
	public static class ClearActionR extends AbstractAction {

		@Override
		public void actionPerformed( ActionEvent e ) {
			view.borderChange( false, e.getActionCommand() );
		}

		public static ClearActionR ClearActionFactoryR() {
			return new ClearActionR();
		}
	}

	@SuppressWarnings ( "serial" )
	public static class NumberActionR extends AbstractAction {

		@Override
		public void actionPerformed( ActionEvent e ) {
			view.borderChange( false, e.getActionCommand() );
		}

		public static NumberActionR NumberActionFactoryR() {
			return new NumberActionR();
		}
	}

	@SuppressWarnings ( "serial" )
	public static class DotActionR extends AbstractAction {

		@Override
		public void actionPerformed( ActionEvent e ) {
			view.borderChange( false, e.getActionCommand() );
		}

		public static DotActionR DotActionFactoryR() {
			return new DotActionR();
		}
	}

	@SuppressWarnings ( "serial" )
	public static class OperatorActionR extends AbstractAction {

		@Override
		public void actionPerformed( ActionEvent e ) {
			view.borderChange( false, e.getActionCommand() );
		}

		public static OperatorActionR OperatorActionFactoryR() {
			return new OperatorActionR();
		}

	}

	@SuppressWarnings ( "serial" )
	public static class EqualsActionR extends AbstractAction {

		@Override
		public void actionPerformed( ActionEvent e ) {
			view.borderChange( false, e.getActionCommand() );
		}

		public static EqualsActionR EqualsActionFactoryR() {
			return new EqualsActionR();
		}

	}

	/**
	 * Handles the events fired from the buttons
	 */
	@Override
	public void actionPerformed( ActionEvent e ) {
		switch ( e.getActionCommand() ) {
		case "=":
			break;
		case "+":
		case "-":
		case "/":
		case "*":
			break;
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
			break;
		case "c":
			System.out.println( "Clear" );
			break;
		case "Ce":
			System.out.println( "Clear Everything" );
			break;
		default:
			break;
		}

	}//end action performed
	
	public class NumberKeyPressedAction extends AbstractAction {

		private final JButton btn;
		private final boolean pressed;

		public NumberKeyPressedAction( JButton btn, boolean pressed ) {
			// You could just pass the button model, but this was easier...
			this.btn = btn;
			this.pressed = pressed;
		}

		@Override
		public void actionPerformed( ActionEvent e ) {
			if ( pressed ) {
				btn.getModel().setArmed( pressed );
				btn.getModel().setPressed( pressed );
			} else {
				btn.getModel().setPressed( pressed );
				btn.getModel().setArmed( pressed );
			}
		}

	}//end NumberKeyPressedAction
	
	public class NewNumberAction extends AbstractAction {

		public NewNumberAction( String name ) {
			super( name );
		}

	@Override
		public void actionPerformed( ActionEvent e ) {
			System.out.println( getValue( NAME ) + " was clicked" );
		}

	}

}//end controller
