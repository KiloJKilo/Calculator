package com.kevinjkahl.calculator.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.kevinjkahl.calculator.controller.Controller;

public class View extends KeyAdapter {

	private JFrame frame;
	private JTextField txfDisplay;
	private JLabel lblDisplay;

	public void CalcView() {
		EventQueue.invokeLater( new Runnable() {

			public void run() {
				try {
					View window = new View();
					window.frame.setVisible( true );
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

	// Initialize the contents of the frame.
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont( new Font( "Tahoma", Font.PLAIN, 10 ) );
		frame.setBounds( 100, 100, 450, 300 );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.getContentPane().setLayout( null );
		frame.addKeyListener( new Controller() );
		frame.setFocusable( true );

		JButton btnAddition = new JButton( "+" );
		btnAddition.addActionListener( new Controller() );
		btnAddition.setBounds( 304, 90, 43, 51 );
		frame.getContentPane().add( btnAddition );

		JButton btnVoidA = new JButton( "" );
		btnVoidA.setEnabled( false );
		btnVoidA.setBounds( 113, 90, 48, 23 );
		frame.getContentPane().add( btnVoidA );

		JButton btnEight = new JButton( "8" );
		btnEight.addActionListener( new Controller() );
		btnEight.setBounds( 212, 90, 41, 23 );
		frame.getContentPane().add( btnEight );

		JButton btnSeven = new JButton( "7" );
		btnSeven.addActionListener( new Controller() );
		btnSeven.setBounds( 166, 90, 41, 23 );
		frame.getContentPane().add( btnSeven );

		JButton btnNine = new JButton( "9" );
		btnNine.addActionListener( new Controller() );
		btnNine.setBounds( 258, 90, 41, 23 );
		frame.getContentPane().add( btnNine );
		frame.getContentPane().add( btnAddition );

		JButton btnVoidB = new JButton( "" );
		btnVoidB.setEnabled( false );
		btnVoidB.setBounds( 113, 118, 48, 23 );
		frame.getContentPane().add( btnVoidB );

		JButton btnFour = new JButton( "4" );
		btnFour.addActionListener( new Controller() );
		btnFour.setBounds( 166, 118, 41, 23 );
		frame.getContentPane().add( btnFour );

		JButton btnFive = new JButton( "5" );
		btnFive.addActionListener( new Controller() );
		btnFive.setBounds( 212, 118, 41, 23 );
		frame.getContentPane().add( btnFive );

		JButton btnSix = new JButton( "6" );
		btnSix.addActionListener( new Controller() );
		btnSix.setBounds( 258, 118, 41, 23 );
		frame.getContentPane().add( btnSix );

		JButton btnVoidC = new JButton( "" );
		btnVoidC.setEnabled( false );
		btnVoidC.setBounds( 113, 146, 48, 23 );
		frame.getContentPane().add( btnVoidC );

		JButton btnOne = new JButton( "1" );
		btnOne.addActionListener( new Controller() );
		btnOne.setBounds( 166, 146, 41, 23 );
		frame.getContentPane().add( btnOne );

		JButton btnTwo = new JButton( "2" );
		btnTwo.addActionListener( new Controller() );
		btnTwo.setBounds( 212, 146, 41, 23 );
		frame.getContentPane().add( btnTwo );

		JButton btnThree = new JButton( "3" );
		btnThree.addActionListener( new Controller() );
		btnThree.setBounds( 258, 146, 41, 23 );
		frame.getContentPane().add( btnThree );

		JButton btnVoidD = new JButton( "" );
		btnVoidD.setEnabled( false );
		btnVoidD.setBounds( 113, 174, 48, 23 );
		frame.getContentPane().add( btnVoidD );

		JButton btnZero = new JButton( "0" );
		btnZero.addActionListener( new Controller() );
		btnZero.setBounds( 167, 174, 86, 23 );
		frame.getContentPane().add( btnZero );

		JButton btnDecimal = new JButton( "." );
		btnDecimal.addActionListener( new Controller() );
		btnDecimal.setBounds( 258, 174, 41, 23 );
		frame.getContentPane().add( btnDecimal );

		JButton btnEquals = new JButton( "=" );
		btnEquals.addActionListener( new Controller() );
		btnEquals.setBounds( 304, 146, 43, 51 );
		frame.getContentPane().add( btnEquals );

		JButton btnSubtraction = new JButton( "-" );
		btnSubtraction.addActionListener( new Controller() );
		btnSubtraction.setBounds( 304, 63, 43, 23 );
		frame.getContentPane().add( btnSubtraction );

		JButton btnCe = new JButton( "CE" );
		btnCe.addActionListener( new Controller() );
		btnCe.setBounds( 113, 63, 48, 23 );
		frame.getContentPane().add( btnCe );

		JButton btnC = new JButton( "C" );
		btnC.addActionListener( new Controller() );
		btnC.setBounds( 166, 63, 41, 23 );
		frame.getContentPane().add( btnC );

		JButton btnDivide = new JButton( "/" );
		btnDivide.addActionListener( new Controller() );
		btnDivide.setBounds( 212, 63, 41, 23 );
		frame.getContentPane().add( btnDivide );

		JButton btnMultiply = new JButton( "*" );
		btnMultiply.addActionListener( new Controller() );
		btnMultiply.setBounds( 258, 63, 41, 23 );
		frame.getContentPane().add( btnMultiply );

		txfDisplay = new JTextField( null );
		txfDisplay.setHorizontalAlignment( SwingConstants.RIGHT );
		txfDisplay.setBounds( 113, 25, 234, 32 );
		frame.getContentPane().add( txfDisplay );
		txfDisplay.setColumns( 10 );

		lblDisplay = new JLabel();
		lblDisplay.setBounds( 115, 208, 232, 32 );
		frame.getContentPane().add( lblDisplay );
		lblDisplay.setBorder( BorderFactory.createLineBorder( Color.blue ) );

	}

	// method used to update the display
	private void updateDisplay( String entry ) {
		// TODO: clean up changeover from text box to label

		// Acquire the text that is currently shown in display
		// String currentText = txfDisplay.getText();
		String currentText = lblDisplay.getText();

		if ( currentText == null ) {// if the display is empty, this is the first incoming entry
			// update the display to reflect the number
			txfDisplay.setText( entry );
			lblDisplay.setText( entry );

		} else if ( currentText != null ) {// the display was not null, so something is there. Add the incoming entry to the display, in addition to what was there
			String newText;
			newText = currentText + " " + entry;
			txfDisplay.setText( newText );
			lblDisplay.setText( newText );

		}

	}

	// method to handle key events
	public void keyPressed( KeyEvent e ) {
		Controller controller = new Controller();
		controller.keyPressed( e );
	}

	// public void registerListener(Controller controller) {
	// Component[] components = frame.getContentPane().getComponents();
	// for (Component component : components) {
	// if (component instanceof AbstractButton) {
	// AbstractButton button = (AbstractButton) component;
	// button.addActionListener(controller);
	// }
	// }
	// } TODO: Implement this method to create a listener for each button

}
