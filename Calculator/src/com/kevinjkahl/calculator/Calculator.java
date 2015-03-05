package com.kevinjkahl.calculator;

import com.kevinjkahl.calculator.controller.Controller;
import com.kevinjkahl.calculator.model.Model;
import com.kevinjkahl.calculator.view.View;

/**
 * 
 * 
 * @author Kevin Kahl
 */

public class Calculator {

	public static void main( String[] args ) {

		// create new model, view and controller
		Model theModel = new Model();
		View theView = new View();
		Controller theController = new Controller( theModel, theView );

		/* register controller as listener */
		//theView.setController( theController );
		//theView.createActions(theController);

		/* start it up */
		theView.CalcView();

	}

}
