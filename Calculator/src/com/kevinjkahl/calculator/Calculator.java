package com.kevinjkahl.calculator;

import com.kevinjkahl.calculator.controller.Controller;
import com.kevinjkahl.calculator.model.Model;
import com.kevinjkahl.calculator.view.View;

/**
 * @version 1.5
 * 
 * @author Kevin Kahl
 */

public class Calculator {

	public static void main( String[] args ) {

		// create new model, view and controller
		Model theModel = new Model();
		View theView = new View();
		new Controller( theModel, theView );

		// start it up
		theView.CalcView();

	}

}
