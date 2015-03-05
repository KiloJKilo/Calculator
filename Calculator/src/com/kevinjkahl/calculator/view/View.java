package com.kevinjkahl.calculator.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
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
import com.kevinjkahl.calculator.controller.Controller.EqualsAction;
import com.kevinjkahl.calculator.controller.Controller.NumberAction;
import com.kevinjkahl.calculator.controller.Controller.OperatorAction;

@SuppressWarnings ( "serial" )
public class View extends JPanel {

	private JFrame frame;
	private JLabel lblDisplay;
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
		frame.setTitle( "Simple Calculator" );

		gridBagLayout.columnWidths = new int[] { 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23 };
		gridBagLayout.rowHeights = new int[] { 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23 };
		gridBagLayout.columnWeights = new double[] { 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0 };
		frame.getContentPane().setLayout( gridBagLayout );

		createButton( 7, 11, 2, 2, ".", "Number", KeyEvent.VK_PERIOD, KeyEvent.VK_DECIMAL );
		createButton( 3, 11, 2, 4, "0", "Number", KeyEvent.VK_0, KeyEvent.VK_NUMPAD0 );
		createButton( 3, 9, 2, 2, "1", "Number", KeyEvent.VK_1, KeyEvent.VK_NUMPAD1 );
		createButton( 5, 9, 2, 2, "2", "Number", KeyEvent.VK_2, KeyEvent.VK_NUMPAD2 );
		createButton( 7, 9, 2, 2, "3", "Number", KeyEvent.VK_3, KeyEvent.VK_NUMPAD3 );
		createButton( 3, 7, 2, 2, "4", "Number", KeyEvent.VK_4, KeyEvent.VK_NUMPAD4 );
		createButton( 5, 7, 2, 2, "5", "Number", KeyEvent.VK_5, KeyEvent.VK_NUMPAD5 );
		createButton( 7, 7, 2, 2, "6", "Number", KeyEvent.VK_6, KeyEvent.VK_NUMPAD6 );
		createButton( 3, 5, 2, 2, "7", "Number", KeyEvent.VK_7, KeyEvent.VK_NUMPAD7 );
		createButton( 5, 5, 2, 2, "8", "Number", KeyEvent.VK_8, KeyEvent.VK_NUMPAD8 );
		createButton( 7, 5, 2, 2, "9", "Number", KeyEvent.VK_9, KeyEvent.VK_NUMPAD9 );
		// createButton( 3, 2, 2, 2, "" ); TODO: implement square root
		createButton( 1, 3, 2, 2, "C", "C" );
		createButton( 1, 5, 2, 2, "CE", "CE", KeyEvent.VK_ESCAPE );
		createButton( 7, 3, 2, 2, "*", "Operator", KeyEvent.VK_MULTIPLY );
		createButton( 5, 3, 2, 2, "/", "Operator", KeyEvent.VK_DIVIDE );
		createButton( 9, 5, 4, 2, "+", "Operator", KeyEvent.VK_ADD );
		createButton( 9, 3, 2, 2, "-", "Operator", KeyEvent.VK_SUBTRACT );
		createButton( 9, 9, 4, 2, "=", "Equals", KeyEvent.VK_ENTER );

		lblDisplay = new JLabel( "", SwingConstants.RIGHT );
		lblDisplay.setBorder( BorderFactory.createLineBorder( Color.BLUE ) );
		GridBagConstraints gbc_lblDisplay = new GridBagConstraints();
		gbc_lblDisplay.fill = GridBagConstraints.BOTH;
		gbc_lblDisplay.insets = new Insets( 0, 0, 5, 5 );
		gbc_lblDisplay.gridwidth = 10;
		gbc_lblDisplay.gridheight = 2;
		gbc_lblDisplay.gridx = 1;
		gbc_lblDisplay.gridy = 1;
		frame.getContentPane().add( lblDisplay, gbc_lblDisplay );
		frame.pack();
		frame.setResizable( false );

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
	private void createButton( int x, int y, int h, int w, String actionCommand, String buttonType, int... keys ) {
		JButton btn = null;

		if ( buttonType == "Number" ) {
			NumberAction a = new NumberAction( actionCommand );
			btn = new JButton( a );
		} else if ( buttonType == "Operator" ) {
			OperatorAction a = new OperatorAction( actionCommand );
			btn = new JButton( a );
		} else if ( buttonType == "C" ) {
			ClearAction a = new ClearAction( actionCommand );
			btn = new JButton( a );
		} else if ( buttonType == "CE" ) {
			ClearEverythingAction a = new ClearEverythingAction( actionCommand );
			btn = new JButton( a );
		} else if ( buttonType == "Equals" ) {
			EqualsAction a = new EqualsAction( actionCommand );
			btn = new JButton( a );
		}

		InputMap im = btn.getInputMap( WHEN_IN_FOCUSED_WINDOW );
		ActionMap am = btn.getActionMap();

		for ( int virtualKey : keys ) {

			im.put( KeyStroke.getKeyStroke( virtualKey, 0, false ), "number-pressed" );
			im.put( KeyStroke.getKeyStroke( virtualKey, 0, true ), "number-released" );

		}

		am.put( "number-pressed", new NumberKeyPressedAction( btn, true ) );
		am.put( "number-released", new NumberKeyPressedAction( btn, false ) );

		GridBagConstraints gbc_btn = new GridBagConstraints();
		gbc_btn.fill = GridBagConstraints.BOTH;
		gbc_btn.insets = new Insets( 0, 0, 5, 5 );
		gbc_btn.gridheight = h;
		gbc_btn.gridwidth = w;
		gbc_btn.gridx = x;
		gbc_btn.gridy = y;
		frame.getContentPane().add( btn, gbc_btn );
		btn.setBackground( new Color( 225, 225, 225 ) );
		btn.setBorder( BorderFactory.createLineBorder( Color.BLACK ) );

	}

	/**
	 * Method to update the JLabel with the numbers and math.
	 * 
	 * @param value
	 *            - string value of number
	 */
	public void update( String value ) {
		// if (digits < 0) {TODO:implement a way to display the number in decimal format only if needed
		// display.setText(value);
		// } else {

		if ( value == "" ) {
			lblDisplay.setText( "" );
		} else {
			String format = "%." + 2 + "f";
			String text = String.format( format, Double.valueOf( value ) );
			lblDisplay.setText( text );
		}
		// }
	}

	/**
	 * This AbstractAction invokes a armed/pressed for the button registered to it.
	 * 
	 * @author MadProgrammer <br>
	 *         <a href="http://stackoverflow.com/users/992484/madprogrammer">MadProgammer @ Stackoverflow</a> <br>
	 *         <a href="http://stackoverflow.com/questions/28843656/calling-a-java-abstractaction-from-a-button-mouse-release/28844281#28844281">Context taken from</a>
	 */
	public class NumberKeyPressedAction extends AbstractAction {

		private final JButton btn;
		private final boolean pressed;

		/**
		 * 
		 * @param btn
		 *            incoming button
		 * @param pressed
		 *            weather it was pressed or not
		 */
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
