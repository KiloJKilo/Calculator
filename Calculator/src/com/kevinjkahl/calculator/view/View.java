package com.kevinjkahl.calculator.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.kevinjkahl.calculator.controller.Controller;

public class View {

	private JFrame frame;
	// private JTextField txfDisplay; TODO: Remove txtField display and all references
	// private Model model;
	// private Controller controller;
	private JLabel lblDisplay;
	private JButton btnMultiplication;
	private JButton btnDivision;
	private JButton btnAddition;
	private JButton btnSubtraction;
	private JButton btnEquals;
	private JButton btnZero;
	private JButton btnOne;
	private JButton btnTwo;
	private JButton btnThree;
	private JButton btnFour;
	private JButton btnFive;
	private JButton btnSix;
	private JButton btnSeven;
	private JButton btnEight;
	private JButton btnNine;
	private JButton btnDecimal;
	private JButton btnC;
	private JButton btnCe;
	private JButton btnVoidA;
	private JButton btnVoidB;
	private JButton btnVoidC;
	private JButton btnVoidD;

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

	// Initialize the contents of the frame.
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont( new Font( "Tahoma", Font.PLAIN, 10 ) );
		frame.setBounds( 100, 100, 450, 300 );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.getContentPane().setLayout( null );
		// frame.addKeyListener( controller );
		frame.setFocusable( true );

		// InputMap im = frame.getRootPane().getInputMap(JComponent.WHEN_FOCUSED);
		// ActionMap am = frame.getRootPane().getActionMap();

		lblDisplay = new JLabel();
		lblDisplay.setBounds( 115, 24, 232, 32 );
		frame.getContentPane().add( lblDisplay );
		lblDisplay.setBorder( BorderFactory.createLineBorder( Color.blue ) );

		btnMultiplication = new JButton( "*" );
		btnMultiplication.setBounds( 258, 63, 41, 23 );
		frame.getContentPane().add( btnMultiplication );

		btnDivision = new JButton( "/" );
		btnDivision.setBounds( 212, 63, 41, 23 );
		frame.getContentPane().add( btnDivision );

		btnAddition = new JButton( "+" );
		btnAddition.setBounds( 304, 90, 43, 51 );
		frame.getContentPane().add( btnAddition );

		btnSubtraction = new JButton( "-" );
		btnSubtraction.setBounds( 304, 63, 43, 23 );
		frame.getContentPane().add( btnSubtraction );

		btnEquals = new JButton( "=" );
		btnEquals.setBounds( 304, 146, 43, 51 );
		frame.getContentPane().add( btnEquals );

		btnZero = new JButton( "0" );
		// btnZero.addActionListener( controller );
		btnZero.setBounds( 167, 174, 86, 23 );
		frame.getContentPane().add( btnZero );

		btnOne = new JButton( "1" );
		btnOne.setBounds( 166, 146, 41, 23 );
		frame.getContentPane().add( btnOne );

		btnTwo = new JButton( "2" );
		btnTwo.setBounds( 212, 146, 41, 23 );
		frame.getContentPane().add( btnTwo );

		btnThree = new JButton( "3" );
		btnThree.setBounds( 258, 146, 41, 23 );
		frame.getContentPane().add( btnThree );

		btnFour = new JButton( "4" );
		btnFour.setBounds( 166, 118, 41, 23 );
		frame.getContentPane().add( btnFour );

		btnFive = new JButton( "5" );
		btnFive.setBounds( 212, 118, 41, 23 );
		frame.getContentPane().add( btnFive );

		btnSix = new JButton( "6" );
		btnSix.setBounds( 258, 118, 41, 23 );
		frame.getContentPane().add( btnSix );

		btnSeven = new JButton( "7" );
		btnSeven.setBounds( 166, 90, 41, 23 );
		frame.getContentPane().add( btnSeven );

		btnEight = new JButton( "8" );
		btnEight.setBounds( 212, 90, 41, 23 );
		frame.getContentPane().add( btnEight );

		btnNine = new JButton( "9" );
		btnNine.setBounds( 258, 90, 41, 23 );
		frame.getContentPane().add( btnNine );

		btnDecimal = new JButton( "." );
		btnDecimal.setBounds( 258, 174, 41, 23 );
		frame.getContentPane().add( btnDecimal );

		btnC = new JButton( "C" );
		btnC.setBounds( 166, 63, 41, 23 );
		frame.getContentPane().add( btnC );

		btnCe = new JButton( "CE" );
		btnCe.setBounds( 113, 63, 48, 23 );
		frame.getContentPane().add( btnCe );

		btnVoidA = new JButton( "" );
		btnVoidA.setEnabled( false );
		btnVoidA.setBounds( 113, 90, 48, 23 );
		frame.getContentPane().add( btnVoidA );

		btnVoidB = new JButton( "" );
		btnVoidB.setEnabled( false );
		btnVoidB.setBounds( 113, 118, 48, 23 );
		frame.getContentPane().add( btnVoidB );

		btnVoidC = new JButton( "" );
		btnVoidC.setEnabled( false );
		btnVoidC.setBounds( 113, 146, 48, 23 );
		frame.getContentPane().add( btnVoidC );

		btnVoidD = new JButton( "" );
		btnVoidD.setEnabled( false );
		btnVoidD.setBounds( 113, 174, 48, 23 );
		frame.getContentPane().add( btnVoidD );

		// txfDisplay = new JTextField( null );
		// txfDisplay.setHorizontalAlignment( SwingConstants.RIGHT );
		// txfDisplay.setBounds( 113, 25, 234, 32 );
		// frame.getContentPane().add( txfDisplay );
		// txfDisplay.setColumns( 10 );

	}

	// method used to update the display
//	public void updateDisplay( String entry ) {
//		// TODO: clean up changeover from text box to label
//		//TODO: Address weather this belongs in the view or the controller
//
//		// Acquire the text that is currently shown in display
//		// String currentText = txfDisplay.getText();
//		String currentText = lblDisplay.getText();
//
//		if ( currentText == null ) {// if the display is empty, this is the first incoming entry
//			// update the display to reflect the number
//			// txfDisplay.setText( entry );
//			lblDisplay.setText( entry );
//
//		} else if ( currentText != null ) {// the display was not null, so something is there. Add the incoming entry to the display, in addition to what was there
//			String newText;
//			newText = currentText + " " + entry;
//			// txfDisplay.setText( newText );
//			lblDisplay.setText( newText );
//
//		}
//
//	}

	public void update(String value) {
//		if (digits < 0) {
//			display.setText(value);
//		} else {
			String format = "%." + 2 + "f";
			String text = String.format(format, Double.valueOf(value));
			lblDisplay.setText(text);
//		}
	}

	// method to toggle the outline border.
	public void toggleBorder( char entry, boolean border ) {

		switch ( entry ) {
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
			if ( border = true ) {
				btnOne.setBorder( BorderFactory.createLineBorder( Color.blue ) );
			} else {
				btnOne.setBorder( BorderFactory.createLineBorder( Color.blue ) );
			}

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
			System.out.println( "Clear" );
			break;
		case '':
			System.out.println( "Clear Everything" );
			break;
		default:
			break;
		}

	}

	public void setController( ActionListener theController ) {
		Component[] components = frame.getContentPane().getComponents();
		for ( Component component : components ) {
			if ( component instanceof JButton ) {
				JButton button = ( JButton ) component;
				button.addActionListener( theController );
			}
		}
	}
}
