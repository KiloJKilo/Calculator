package com.kevinjkahl.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

	public Controller() {
		// no argument constructor
	}

	// this method handles the button press events from view
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

	// method to handle key events
	public void keyPressed( KeyEvent e ) {

		char key = e.getKeyChar();

		switch ( key ) {
		case '1':
			System.out.println( "1" );
			break;

		default:
			break;
		}
		
	}

}
