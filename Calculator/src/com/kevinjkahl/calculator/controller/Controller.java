package com.kevinjkahl.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.kevinjkahl.calculator.model.Model;
import com.kevinjkahl.calculator.view.View;

public class Controller implements ActionListener, KeyListener {

	// The model of this MVC implementation of a calculator.
	private Model theModel;
	// The view of this MVC implementation of a calculator.
	private View theView;

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
		this.theModel = model;
		this.theView = view;

	}

	public Controller() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed( ActionEvent e ) {
		// TODO Auto-generated method stub

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
		default:
			break;
		}

	}

	@Override
	public void keyTyped( KeyEvent e ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed( KeyEvent e ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased( KeyEvent e ) {
		// TODO Auto-generated method stub

	}

}
