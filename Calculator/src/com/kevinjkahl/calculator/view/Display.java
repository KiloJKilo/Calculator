package com.kevinjkahl.calculator.view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Display {

	private JFrame frame;
	private JTextField txfDisplay;

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {
		EventQueue.invokeLater( new Runnable() {

			public void run() {
				try {
					Display window = new Display();
					window.frame.setVisible( true );
				} catch ( Exception e ) {
					e.printStackTrace();
				}
			}
		} );
	}

	/**
	 * Create the application.
	 */
	public Display() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont( new Font( "Tahoma", Font.PLAIN, 10 ) );
		frame.setBounds( 100, 100, 450, 300 );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.getContentPane().setLayout( null );

		JButton btnAddition = new JButton( "+" );
		btnAddition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDisplay( "+" );
			}
		});
		btnAddition.setBounds( 304, 90, 43, 51 );
		frame.getContentPane().add( btnAddition );

		JButton btnVoidA = new JButton( "" );
		btnVoidA.setEnabled( false );
		btnVoidA.setBounds( 113, 90, 48, 23 );
		frame.getContentPane().add( btnVoidA );

		JButton btnEight = new JButton( "8" );
		btnEight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDisplay( "8" );
			}
		});
		btnEight.setBounds( 212, 90, 41, 23 );
		frame.getContentPane().add( btnEight );

		JButton btnSeven = new JButton( "7" );
		btnSeven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDisplay( "7" );
			}
		});
		btnSeven.setBounds( 166, 90, 41, 23 );
		frame.getContentPane().add( btnSeven );

		JButton btnNine = new JButton( "9" );
		btnNine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDisplay( "9" );
			}
		});
		btnNine.setBounds( 258, 90, 41, 23 );
		frame.getContentPane().add( btnNine );
		frame.getContentPane().add( btnAddition );

		JButton btnVoidB = new JButton( "" );
		btnVoidB.setEnabled( false );
		btnVoidB.setBounds( 113, 118, 48, 23 );
		frame.getContentPane().add( btnVoidB );

		JButton btnFour = new JButton( "4" );
		btnFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDisplay( "4" );
			}
		});
		btnFour.setBounds( 166, 118, 41, 23 );
		frame.getContentPane().add( btnFour );

		JButton btnFive = new JButton( "5" );
		btnFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDisplay( "5" );
			}
		});
		btnFive.setBounds( 212, 118, 41, 23 );
		frame.getContentPane().add( btnFive );

		JButton btnSix = new JButton( "6" );
		btnSix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDisplay( "6" );
			}
		});
		btnSix.setBounds( 258, 118, 41, 23 );
		frame.getContentPane().add( btnSix );

		JButton btnVoidC = new JButton( "" );
		btnVoidC.setEnabled( false );
		btnVoidC.setBounds( 113, 146, 48, 23 );
		frame.getContentPane().add( btnVoidC );

		JButton btnOne = new JButton( "1" );
		btnOne.addMouseListener( new MouseAdapter() {

			@Override
			public void mouseClicked( MouseEvent e ) {

				updateDisplay( "1" );

			}
		} );
		btnOne.setBounds( 166, 146, 41, 23 );
		frame.getContentPane().add( btnOne );

		JButton btnTwo = new JButton( "2" );
		btnTwo.addActionListener( new ActionListener() {

			public void actionPerformed( ActionEvent e ) {
				updateDisplay( "2" );
			}
		} );
		btnTwo.setBounds( 212, 146, 41, 23 );
		frame.getContentPane().add( btnTwo );

		JButton btnThree = new JButton( "3" );
		btnThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDisplay( "3" );
			}
		});
		btnThree.setBounds( 258, 146, 41, 23 );
		frame.getContentPane().add( btnThree );

		JButton btnVoidD = new JButton( "" );
		btnVoidD.setEnabled( false );
		btnVoidD.setBounds( 113, 174, 48, 23 );
		frame.getContentPane().add( btnVoidD );

		JButton btnZero = new JButton( "0" );
		btnZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDisplay( "0" );
			}
		});
		btnZero.setBounds( 167, 174, 86, 23 );
		frame.getContentPane().add( btnZero );

		JButton btnDecimal = new JButton( "." );
		btnDecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDisplay( "." );
			}
		});
		btnDecimal.setBounds( 258, 174, 41, 23 );
		frame.getContentPane().add( btnDecimal );

		JButton btnEquals = new JButton( "=" );
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEquals.setBounds( 304, 146, 43, 51 );
		frame.getContentPane().add( btnEquals );

		JButton btnSubtraction = new JButton( "-" );
		btnSubtraction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDisplay( "-" );
			}
		});
		btnSubtraction.setBounds( 304, 63, 43, 23 );
		frame.getContentPane().add( btnSubtraction );

		JButton btnCe = new JButton( "CE" );
		btnCe.setBounds( 113, 63, 48, 23 );
		frame.getContentPane().add( btnCe );

		JButton btnC = new JButton( "C" );
		btnC.setBounds( 166, 63, 41, 23 );
		frame.getContentPane().add( btnC );

		JButton btnDivide = new JButton( "/" );
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDisplay( "/" );
			}
		});
		btnDivide.setBounds( 212, 63, 41, 23 );
		frame.getContentPane().add( btnDivide );

		JButton btnMultiply = new JButton( "*" );
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDisplay( "*" );
			}
		});
		btnMultiply.setBounds( 258, 63, 41, 23 );
		frame.getContentPane().add( btnMultiply );

		txfDisplay = new JTextField( null );
		txfDisplay.setHorizontalAlignment( SwingConstants.RIGHT );
		txfDisplay.setBounds( 113, 25, 234, 32 );
		frame.getContentPane().add( txfDisplay );
		txfDisplay.setColumns( 10 );
	}

	// method used to update the display
	private void updateDisplay( String entry ) {

		// Acquire the text that is currently shown in display
		String currentText = txfDisplay.getText();

		if ( currentText == null ) {// if the display is empty, this is the first incoming entry
			// update the display to reflect the number
			txfDisplay.setText( entry );

		} else if ( currentText != null ) {// the display was not null, so something is there. Add the incoming entry to the display, in addition to what was there
			String newText;
			newText = currentText + " " + entry;
			txfDisplay.setText( newText );

		}

	}
}
