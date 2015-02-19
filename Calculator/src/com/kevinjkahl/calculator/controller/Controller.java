package com.kevinjkahl.calculator.controller;

import java.awt.KeyEventDispatcher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import com.kevinjkahl.calculator.model.Model;
import com.kevinjkahl.calculator.view.View;

public class Controller implements ActionListener, KeyEventDispatcher {

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

	public Controller() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed( ActionEvent e ) {
		switch ( e.getActionCommand() ) {
		case "=":
			System.out.println( "Equals" );
			break;
		case "+":
			System.out.println( "Addition" );
			break;
		case "-":
			System.out.println( "Subtraction" );
			break;
		case "/":
			System.out.println( "Division" );
			break;
		case "*":
			System.out.println( "Multiplication" );
			break;
		case "1":
			System.out.println( "1" );
			break;
		case "2":
			System.out.println( "2" );
			break;
		case "3":
			System.out.println( "3" );
			break;
		case "4":
			System.out.println( "4" );
			break;
		case "5":
			System.out.println( "5" );
			break;
		case "6":
			System.out.println( "6" );
			break;
		case "7":
			System.out.println( "7" );
			break;
		case "8":
			System.out.println( "8" );
			break;
		case "9":
			System.out.println( "9" );
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

	}

	// @Override
	// public void keyTyped( KeyEvent e ) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void keyPressed( KeyEvent e ) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void keyReleased( KeyEvent e ) {
	// // TODO Auto-generated method stub
	//
	// }

	@Override
	public boolean dispatchKeyEvent( KeyEvent e ) {
		// TODO Auto-generated method stub
		// if ( e.getID() == KeyEvent.KEY_PRESSED ) {
		// update display
		// calculate

		if ( e.getID() == KeyEvent.KEY_TYPED ) {

			switch ( e.getKeyChar() ) {
			case '\n':
				System.out.println( "Equals" );
				break;
			case '+':
				System.out.println( "Addition" );
				break;
			case '-':
				System.out.println( "Subtraction" );
				break;
			case '/':
				System.out.println( "Division" );
				break;
			case '*':
				System.out.println( "Multiplication" );
				break;
			case '1':
				System.out.println( "1" );
				break;
			case '2':
				System.out.println( "2" );
				break;
			case '3':
				System.out.println( "3" );
				break;
			case '4':
				System.out.println( "4" );
				break;
			case '5':
				System.out.println( "5" );
				break;
			case '6':
				System.out.println( "6" );
				break;
			case '7':
				System.out.println( "7" );
				break;
			case '8':
				System.out.println( "8" );
				break;
			case '9':
				System.out.println( "9" );
				break;
			case 'c':
			case '':
				System.out.println( "Clear" );
				break;
			case 'a':
				System.out.println( "Clear Everything" );
				break;
			default:
				break;
			}
		}
		// System.out.println( e.getKeyChar() );
		// } else if ( e.getID() == KeyEvent.KEY_RELEASED ) {
		// System.out.println( "2test2" );
		// } else if ( e.getID() == KeyEvent.KEY_TYPED ) {
		// System.out.println( "3test3" );
		// }
		return false;
	}

}
