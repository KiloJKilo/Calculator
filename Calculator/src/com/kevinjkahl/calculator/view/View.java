package com.kevinjkahl.calculator.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import com.kevinjkahl.calculator.controller.Controller.ClearAction;
import com.kevinjkahl.calculator.controller.Controller.ClearEverythingAction;
import com.kevinjkahl.calculator.controller.Controller.DotAction;
import com.kevinjkahl.calculator.controller.Controller.NumberAction;
import com.kevinjkahl.calculator.controller.Controller.OperatorAction;

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
	private ClearEverythingAction clearEverythingAction;
	private InputMap im;
	private ActionMap am;
	private ClearAction clearAction;
	private NumberAction numberAction;
	private OperatorAction operatorAction;
	private DotAction dotAction;
	

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
		frame.setBounds( 100, 100, 316, 300 );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.getContentPane().setLayout( null );
		// frame.addKeyListener( controller );
		frame.setFocusable( true );

		im = frame.getRootPane().getInputMap( JComponent.WHEN_IN_FOCUSED_WINDOW );
		am = frame.getRootPane().getActionMap();

		// frame.getRootPane().getInputMap().put( KeyStroke.getKeyStroke( "ESCAPE" ), escAction );
		// frame.getRootPane().getActionMap().put("doSomething", escAction);

		lblDisplay = new JLabel( "", SwingConstants.RIGHT );
		lblDisplay.setBounds( 29, 11, 247, 32 );
		lblDisplay.setBorder( BorderFactory.createLineBorder( Color.blue ) );
		frame.getContentPane().add( lblDisplay );

		btnMultiplication = new JButton( "*" );
		btnMultiplication.setBounds( 187, 50, 41, 23 );
		frame.getContentPane().add( btnMultiplication );

		btnDivision = new JButton( "/" );
		btnDivision.setBounds( 141, 50, 41, 23 );
		frame.getContentPane().add( btnDivision );

		btnAddition = new JButton( "+" );
		btnAddition.setBounds( 233, 77, 43, 51 );
		frame.getContentPane().add( btnAddition );

		btnSubtraction = new JButton( "-" );
		btnSubtraction.setBounds( 233, 50, 43, 23 );
		frame.getContentPane().add( btnSubtraction );

		btnEquals = new JButton( "=" );
		btnEquals.setBounds( 233, 133, 43, 51 );
		frame.getContentPane().add( btnEquals );

		btnZero = new JButton( "0" );
		btnZero.setBounds( 96, 161, 86, 23 );
		frame.getContentPane().add( btnZero );

		btnOne = new JButton( "1" );
		btnOne.setBounds( 95, 133, 41, 23 );
		frame.getContentPane().add( btnOne );

		btnTwo = new JButton( "2" );
		btnTwo.setBounds( 141, 133, 41, 23 );
		frame.getContentPane().add( btnTwo );

		btnThree = new JButton( "3" );
		btnThree.setBounds( 187, 133, 41, 23 );
		frame.getContentPane().add( btnThree );

		btnFour = new JButton( "4" );
		btnFour.setBounds( 95, 105, 41, 23 );
		frame.getContentPane().add( btnFour );

		btnFive = new JButton( "5" );
		btnFive.setBounds( 141, 105, 41, 23 );
		frame.getContentPane().add( btnFive );

		btnSix = new JButton( "6" );
		btnSix.setBounds( 187, 105, 41, 23 );
		frame.getContentPane().add( btnSix );

		btnSeven = new JButton( "7" );
		btnSeven.setBounds( 95, 77, 41, 23 );
		frame.getContentPane().add( btnSeven );

		btnEight = new JButton( "8" );
		btnEight.setBounds( 141, 77, 41, 23 );
		frame.getContentPane().add( btnEight );

		btnNine = new JButton( "9" );
		btnNine.setBounds( 187, 77, 41, 23 );
		frame.getContentPane().add( btnNine );

		btnDecimal = new JButton( "." );
		btnDecimal.setBounds( 187, 161, 41, 23 );
		frame.getContentPane().add( btnDecimal );

		btnC = new JButton( "C" );
		// btnC.setAction( escAction );
		btnC.setBounds( 29, 50, 61, 23 );
		frame.getContentPane().add( btnC );

		btnCe = new JButton( "CE" );
		btnCe.setBounds( 29, 77, 61, 23 );
		frame.getContentPane().add( btnCe );

		btnVoidA = new JButton( "" );
		btnVoidA.setEnabled( false );
		btnVoidA.setBounds( 95, 50, 41, 23 );
		frame.getContentPane().add( btnVoidA );

		btnVoidB = new JButton( "" );
		btnVoidB.setEnabled( false );
		btnVoidB.setBounds( 29, 105, 61, 23 );
		frame.getContentPane().add( btnVoidB );

		btnVoidC = new JButton( "" );
		btnVoidC.setEnabled( false );
		btnVoidC.setBounds( 29, 133, 61, 23 );
		frame.getContentPane().add( btnVoidC );

		btnVoidD = new JButton( "" );
		btnVoidD.setEnabled( false );
		btnVoidD.setBounds( 29, 161, 61, 23 );
		frame.getContentPane().add( btnVoidD );

	}

	public void update( String value ) {
		// if (digits < 0) {
		// display.setText(value);
		// } else {
		String format = "%." + 2 + "f";
		String text = String.format( format, Double.valueOf( value ) );
		lblDisplay.setText( text );
		// }
	}

	public void setController( ActionListener theController ) {
		Component[] components = frame.getContentPane().getComponents();
		//escAction = EscAction.EscActionFactory();
		for ( Component component : components ) {
			if ( component instanceof JButton ) {
				JButton button = ( JButton ) component;
				button.addActionListener( theController );
				// escAction = new Controller.EscAction( "escape", new Integer( KeyEvent.VK_ESCAPE ) );
				// button.setAction( escAction );
			}
		}
	}

	public void createActions() {
		// create our actions
		clearEverythingAction = ClearEverythingAction.ClearEverythingActionFactory();
		clearAction = ClearAction.ClearActionFactory();
		numberAction = NumberAction.NumberActionFactory();
		operatorAction = OperatorAction.OperatorActionFactory();
		dotAction = DotAction.DotActionFactory();
		
		//register buttons
		btnC.addActionListener( clearAction );
		btnCe.addActionListener( clearEverythingAction );
		btnZero.addActionListener( numberAction );
		btnOne.addActionListener( numberAction );
		btnTwo.addActionListener( numberAction );
		btnThree.addActionListener( numberAction );
		btnFour.addActionListener( numberAction );
		btnFive.addActionListener( numberAction );
		btnSix.addActionListener( numberAction );
		btnSeven.addActionListener( numberAction );
		btnEight.addActionListener( numberAction );
		btnNine.addActionListener( numberAction );
		btnDecimal.addActionListener( dotAction );
		btnMultiplication.addActionListener( operatorAction );
		btnDivision.addActionListener( operatorAction );
		btnAddition.addActionListener( operatorAction );
		btnSubtraction.addActionListener( operatorAction );
		btnEquals.addActionListener( operatorAction );
		
		//map keys
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "Escape" );//escape goes to clear everything action
		
		//number keys go to number action
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD0, 0 ), "Number" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD1, 0 ), "Number" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD2, 0 ), "Number" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD3, 0 ), "Number" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD4, 0 ), "Number" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD5, 0 ), "Number" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD6, 0 ), "Number" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD7, 0 ), "Number" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD8, 0 ), "Number" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD9, 0 ), "Number" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_DECIMAL, 0 ), "Dot" );
		
		//operators go to operator action
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_MULTIPLY, 0 ), "Operator" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_DIVIDE, 0 ), "Operator" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_ADD, 0 ), "Operator" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_SUBTRACT, 0 ), "Operator" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_EQUALS, 0 ), "Dot" );
		
		//map actions
		am.put( "Escape", clearEverythingAction );
		am.put( "Number", numberAction );
		am.put( "Operator", operatorAction );
		am.put( "Dot", dotAction );
		
	}
}
