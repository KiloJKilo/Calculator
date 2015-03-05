package com.kevinjkahl.calculator.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import com.kevinjkahl.calculator.controller.Controller.ClearAction;
import com.kevinjkahl.calculator.controller.Controller.ClearEverythingAction;
import com.kevinjkahl.calculator.controller.Controller.DotAction;
import com.kevinjkahl.calculator.controller.Controller.EqualsAction;
import com.kevinjkahl.calculator.controller.Controller.NumberAction;
import com.kevinjkahl.calculator.controller.Controller.OperatorAction;

public class View extends JPanel {

	private JFrame frame;
	private JLabel lblDisplay;
	private ClearEverythingAction clearEverythingAction;
	private ClearAction clearAction;
	private NumberAction numberAction;
	private OperatorAction operatorAction;
	private DotAction dotAction;
	private EqualsAction equalsAction;
	GridBagLayout gridBagLayout = new GridBagLayout();

	public void CalcView() {
		EventQueue.invokeLater( new Runnable() {

			public void run() {
				try {
					// View window = new View();
					frame.setVisible( true );
				} catch ( Exception e ) {
					e.printStackTrace();
				}
			}
		} );
	}

	// Create the application.
	public View() {
		initialize();
		frame.pack();
		frame.setResizable(false);
	}

	/*
	 * Method to create the display and the components contained within.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setFont( new Font( "Tahoma", Font.PLAIN, 10 ) );
		frame.setBounds( 100, 100, 316, 300 );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setFocusable( true );

		gridBagLayout.columnWidths = new int[] { 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23 };
		gridBagLayout.rowHeights = new int[] { 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23 };
		gridBagLayout.columnWeights = new double[] { 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0 };
		frame.getContentPane().setLayout( gridBagLayout );

		createButton( 7, 10, 2, 2, ".", KeyEvent.VK_PERIOD, KeyEvent.VK_DECIMAL );
		createButton( 3, 10, 2, 4, "0", KeyEvent.VK_0, KeyEvent.VK_NUMPAD0 );
		createButton( 3, 8, 2, 2, "1", KeyEvent.VK_1, KeyEvent.VK_NUMPAD1 );
		createButton( 5, 8, 2, 2, "2", KeyEvent.VK_2, KeyEvent.VK_NUMPAD2 );
		createButton( 7, 8, 2, 2, "3", KeyEvent.VK_3, KeyEvent.VK_NUMPAD3 );
		createButton( 3, 6, 2, 2, "4", KeyEvent.VK_4, KeyEvent.VK_NUMPAD4 );
		createButton( 5, 6, 2, 2, "5", KeyEvent.VK_5, KeyEvent.VK_NUMPAD5 );
		createButton( 7, 6, 2, 2, "6", KeyEvent.VK_6, KeyEvent.VK_NUMPAD6 );
		createButton( 3, 4, 2, 2, "7", KeyEvent.VK_7, KeyEvent.VK_NUMPAD7 );
		createButton( 5, 4, 2, 2, "8", KeyEvent.VK_8, KeyEvent.VK_NUMPAD8 );
		createButton( 7, 4, 2, 2, "9", KeyEvent.VK_9, KeyEvent.VK_NUMPAD9 );
		createButton( 3, 2, 2, 2, "" );
		createButton( 1, 2, 2, 2, "C" );
		createButton( 1, 4, 2, 2, "CE", KeyEvent.VK_ESCAPE );
		createButton( 7, 2, 2, 2, "*", KeyEvent.VK_MULTIPLY );
		createButton( 5, 2, 2, 2, "/", KeyEvent.VK_DIVIDE );
		createButton( 9, 4, 4, 2, "+", KeyEvent.VK_ADD );
		createButton( 9, 2, 2, 2, "-", KeyEvent.VK_SUBTRACT );
		createButton( 9, 8, 4, 2, "=", KeyEvent.VK_ENTER );

		lblDisplay = new JLabel( "", SwingConstants.RIGHT );
		lblDisplay.setBorder( BorderFactory.createLineBorder( Color.BLACK ) );
		GridBagConstraints gbc_lblDisplay = new GridBagConstraints();
		gbc_lblDisplay.fill = GridBagConstraints.BOTH;
		gbc_lblDisplay.insets = new Insets( 0, 0, 5, 0 );
		gbc_lblDisplay.gridwidth = 10;
		gbc_lblDisplay.gridheight = 2;
		gbc_lblDisplay.gridx = 1;
		gbc_lblDisplay.gridy = 0;
		frame.getContentPane().add( lblDisplay, gbc_lblDisplay );

		// btnC = new JButton( "C" );
		// // btnC.setBackground( Color.LIGHT_GRAY );
		// // btnC.setBorder( BorderFactory.createLineBorder( Color.BLACK ) );
		// GridBagConstraints gbc_btnC = new GridBagConstraints();
		// gbc_btnC.anchor = GridBagConstraints.NORTH;
		// gbc_btnC.fill = GridBagConstraints.BOTH;
		// gbc_btnC.insets = new Insets( 0, 0, 5, 5 );
		// gbc_btnC.gridx = 0;
		// gbc_btnC.gridy = 1;
		// frame.getContentPane().add( btnC, gbc_btnC );
		//

	}

	/**
	 * Method to create the JButton components, apply design attributes to buttons, apply key bindings and action to buttons and swing design attributes.
	 * 
	 * @param x
	 *            grid location on x
	 * @param y
	 *            grid location on y
	 * @param h
	 *            height of button within bounds
	 * @param w
	 *            width of button within bounds
	 * @param actionCommand
	 *            the number or symbol of button
	 * @param name
	 *            the name of the button
	 * @param keys
	 *            virtual keys associated with the number pad and number strip
	 */
	private void createButton( int x, int y, int h, int w, String actionCommand, int... keys ) {

		nAction na = new nAction( actionCommand );
		JButton btn = new JButton( na );
		// btn.setName( name );
		InputMap im = btn.getInputMap( WHEN_IN_FOCUSED_WINDOW );
		ActionMap am = btn.getActionMap();

		for ( int virtualKey : keys ) {

			im.put( KeyStroke.getKeyStroke( virtualKey, 0, false ), "number-pressed" );
			im.put( KeyStroke.getKeyStroke( virtualKey, 0, true ), "number-released" );

		}

		am.put( "number-pressed", new NumberKeyPressedAction( btn, true ) );
		am.put( "number-released", new NumberKeyPressedAction( btn, false ) );

		GridBagConstraints gbc_btn = new GridBagConstraints();
		// gbc_btnEquals.anchor = GridBagConstraints.WEST;
		gbc_btn.fill = GridBagConstraints.BOTH;
		gbc_btn.insets = new Insets( 0, 0, 5, 5 );
		gbc_btn.gridheight = h;
		gbc_btn.gridwidth = w;
		gbc_btn.gridx = x;
		gbc_btn.gridy = y;
		frame.getContentPane().add( btn, gbc_btn );
		btn.setBackground( new Color( 225, 225, 225 ) );
		btn.setBorder( BorderFactory.createLineBorder( Color.BLACK ) );

		// frame.getContentPane().add( btn );

	}

	/**
	 * Method to update the JLabel with the numbers and math.
	 * 
	 * @param value
	 *            String value of number
	 */
	public void update( String value ) {
		// if (digits < 0) {
		// display.setText(value);
		// } else {
		String format = "%." + 2 + "f";
		String text = String.format( format, Double.valueOf( value ) );
		lblDisplay.setText( text );
		// }
	}

	/**
	 * Method to register abstract actions in the Controller class to be used in the View class
	 * 
	 * @param controller
	 *            passing the instance of the controller in as an ActionListener
	 */
	public void createActions( ActionListener controller ) {
		// create our actions
		clearEverythingAction = ClearEverythingAction.ClearEverythingActionFactory();
		clearAction = ClearAction.ClearActionFactory();
		numberAction = NumberAction.NumberActionFactory();
		operatorAction = OperatorAction.OperatorActionFactory();
		dotAction = DotAction.DotActionFactory();
		equalsAction = EqualsAction.EqualsActionFactory();

		// register buttons
		// btnC.addActionListener( controller );
		// btnCe.addActionListener( controller );
		// btnZero.addActionListener( controller );
		// btnOne.addActionListener( controller );
		// btnTwo.addActionListener( controller );
		// btnThree.addActionListener( controller );
		// btnFour.addActionListener( controller );
		// btnFive.addActionListener( controller );
		// btnSix.addActionListener( controller );
		// btnSeven.addActionListener( controller );
		// btnEight.addActionListener( controller );
		// btnNine.addActionListener( controller );
		// btnDecimal.addActionListener( controller );
		// btnMultiplication.addActionListener( controller );
		// btnDivision.addActionListener( controller );
		// btnAddition.addActionListener( controller );
		// btnSubtraction.addActionListener( controller );
		// btnEquals.addActionListener( controller );

		// map keys
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "Escape" );// escape goes to clear everything action

		// number keys go to number action
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD0, 0, false ), "number-pressed" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD0, 0, true ), "number-released" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD1, 0, false ), "number-pressed" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD1, 0, true ), "number-released" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD2, 0, false ), "number-pressed" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD2, 0, true ), "number-released" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD3, 0, false ), "number-pressed" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD3, 0, true ), "number-released" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD4, 0, false ), "number-pressed" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD4, 0, true ), "number-released" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD5, 0, false ), "number-pressed" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD5, 0, true ), "number-released" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD6, 0, false ), "number-pressed" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD6, 0, true ), "number-released" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD7, 0, false ), "number-pressed" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD7, 0, true ), "number-released" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD8, 0, false ), "number-pressed" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD8, 0, true ), "number-released" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD9, 0, false ), "number-pressed" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD9, 0, true ), "number-released" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_DECIMAL, 0, false ), "Dot" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_DECIMAL, 0, true ), "Number Released" );

		// // operators go to operator action
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_MULTIPLY, 0, false ), "Operator" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_MULTIPLY, 0, true ), "Operator Released" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_DIVIDE, 0, false ), "Operator" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_DIVIDE, 0, true ), "Operator Released" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_ADD, 0, false ), "Operator" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_ADD, 0, true ), "Operator Released" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_SUBTRACT, 0, false ), "Operator" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_SUBTRACT, 0, true ), "Operator Released" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_ENTER, 0, false ), "Equals" );
		// im.put( KeyStroke.getKeyStroke( KeyEvent.VK_ENTER, 0, true ), "Equals Released" );
		//
		// // map actions
		// am.put( "number-pressed", new NumberKeyPressedAction( btnZero, true ) );
		// am.put( "number-released", new NumberKeyPressedAction( btnZero, false ) );
		// am.put( "number-pressed", new NumberKeyPressedAction( btnOne, true ) );
		// am.put( "number-released", new NumberKeyPressedAction( btnOne, false ) );
		// am.put( "number-pressed", new NumberKeyPressedAction( btnTwo, true ) );
		// am.put( "number-released", new NumberKeyPressedAction( btnTwo, false ) );
		// am.put( "number-pressed", new NumberKeyPressedAction( btnThree, true ) );
		// am.put( "number-released", new NumberKeyPressedAction( btnThree, false ) );
		// am.put( "number-pressed", new NumberKeyPressedAction( btnFour, true ) );
		// am.put( "number-released", new NumberKeyPressedAction( btnFour, false ) );
		// am.put( "number-pressed", new NumberKeyPressedAction( btnFive, true ) );
		// am.put( "number-released", new NumberKeyPressedAction( btnFive, false ) );
		// am.put( "number-pressed", new NumberKeyPressedAction( btnSix, true ) );
		// am.put( "number-released", new NumberKeyPressedAction( btnSix, false ) );
		// am.put( "number-pressed", new NumberKeyPressedAction( btnSeven, true ) );
		// am.put( "number-released", new NumberKeyPressedAction( btnSeven, false ) );
		// am.put( "number-pressed", new NumberKeyPressedAction( btnEight, true ) );
		// am.put( "number-released", new NumberKeyPressedAction( btnEight, false ) );
		// am.put( "number-pressed", new NumberKeyPressedAction( btnNine, true ) );
		// am.put( "number-released", new NumberKeyPressedAction( btnNine, false ) );

		// am.put( "Escape", clearEverythingAction );
		// am.put( "Number", numberAction );
		// am.put( "Number Released", numberActionR );
		// am.put( "Operator", operatorAction );
		// am.put( "Operator Released", operatorActionR );
		// am.put( "Dot", dotAction );
		// am.put( "Dot Released", dotActionR );
		// am.put( "Equals", equalsAction );
		// am.put( "Equals Released", equalsActionR );

	}

	public class nAction extends AbstractAction {

		public nAction( String name ) {
			super( name );
		}

		@Override
		public void actionPerformed( ActionEvent e ) {
			System.out.println( getValue( NAME ) + " was clicked \n" );
			System.out.println( e.getActionCommand() + " Action Command" );
		}

	}

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

	}
}
