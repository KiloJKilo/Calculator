package com.kevinjkahl.calculator.view;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import com.kevinjkahl.calculator.controller.Controller.ClearAction;
import com.kevinjkahl.calculator.controller.Controller.ClearEverythingAction;
import com.kevinjkahl.calculator.controller.Controller.DotAction;
import com.kevinjkahl.calculator.controller.Controller.DotActionR;
import com.kevinjkahl.calculator.controller.Controller.EqualsAction;
import com.kevinjkahl.calculator.controller.Controller.EqualsActionR;
import com.kevinjkahl.calculator.controller.Controller.NumberAction;
import com.kevinjkahl.calculator.controller.Controller.NumberActionR;
import com.kevinjkahl.calculator.controller.Controller.OperatorAction;
import com.kevinjkahl.calculator.controller.Controller.OperatorActionR;

public class View {

	private JFrame frame;
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
	private EqualsAction equalsAction;
	private NumberActionR numberActionR;
	GridBagLayout gridBagLayout = new GridBagLayout();
	private EqualsActionR equalsActionR;
	private OperatorActionR operatorActionR;
	private DotActionR dotActionR;
	private JButton currentButton;

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
		designButtons();
	}

	private void createButton() {
		

	}

	// Initialize the contents of the frame.
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont( new Font( "Tahoma", Font.PLAIN, 10 ) );
		frame.setBounds( 100, 100, 316, 300 );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setFocusable( true );

		im = frame.getRootPane().getInputMap( JComponent.WHEN_IN_FOCUSED_WINDOW );
		am = frame.getRootPane().getActionMap();

		gridBagLayout.columnWidths = new int[] { 61, 41, 41, 41, 43, 0 };
		gridBagLayout.rowHeights = new int[] { 32, 23, 23, 23, 23, 23, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout( gridBagLayout );

		lblDisplay = new JLabel( "", SwingConstants.RIGHT );
		lblDisplay.setBorder( BorderFactory.createLineBorder( Color.BLACK ) );
		GridBagConstraints gbc_lblDisplay = new GridBagConstraints();
		gbc_lblDisplay.fill = GridBagConstraints.BOTH;
		gbc_lblDisplay.insets = new Insets( 0, 0, 5, 0 );
		gbc_lblDisplay.gridwidth = 5;
		gbc_lblDisplay.gridx = 0;
		gbc_lblDisplay.gridy = 0;
		frame.getContentPane().add( lblDisplay, gbc_lblDisplay );
		
		btnDecimal = new JButton( new nAction( "." ) );
		btnZero = new JButton( new nAction( "0" ) );
		btnOne = new JButton( new nAction( "1" ) );
		btnTwo = new JButton( new nAction( "2" ) );
		btnThree = new JButton( new nAction( "3" ) );
		btnFour = new JButton( new nAction( "4" ) );
		btnFive = new JButton( new nAction( "5" ) );
		btnSix = new JButton( new nAction( "6" ) );
		btnSeven = new JButton( new nAction( "7" ) );
		btnEight = new JButton( new nAction( "8" ) );
		btnNine = new JButton( new nAction( "9" ) );

		btnC = new JButton( "C" );
		// btnC.setBackground( Color.LIGHT_GRAY );
		// btnC.setBorder( BorderFactory.createLineBorder( Color.BLACK ) );
		GridBagConstraints gbc_btnC = new GridBagConstraints();
		gbc_btnC.anchor = GridBagConstraints.NORTH;
		gbc_btnC.fill = GridBagConstraints.BOTH;
		gbc_btnC.insets = new Insets( 0, 0, 5, 5 );
		gbc_btnC.gridx = 0;
		gbc_btnC.gridy = 1;
		frame.getContentPane().add( btnC, gbc_btnC );

		btnVoidA = new JButton( "" );
		btnVoidA.setEnabled( false );
		GridBagConstraints gbc_btnVoidA = new GridBagConstraints();
		gbc_btnVoidA.fill = GridBagConstraints.BOTH;
		gbc_btnVoidA.insets = new Insets( 0, 0, 5, 5 );
		gbc_btnVoidA.gridx = 1;
		gbc_btnVoidA.gridy = 1;
		frame.getContentPane().add( btnVoidA, gbc_btnVoidA );

		btnDivision = new JButton( "/" );
		// btnDivision.setBorder( BorderFactory.createLineBorder( Color.black ) );
		GridBagConstraints gbc_btnDivision = new GridBagConstraints();
		gbc_btnDivision.anchor = GridBagConstraints.NORTH;
		gbc_btnDivision.fill = GridBagConstraints.BOTH;
		gbc_btnDivision.insets = new Insets( 0, 0, 5, 5 );
		gbc_btnDivision.gridx = 2;
		gbc_btnDivision.gridy = 1;
		frame.getContentPane().add( btnDivision, gbc_btnDivision );

		btnMultiplication = new JButton( "*" );
		// btnMultiplication.setBorder( BorderFactory.createLineBorder( Color.black ) );
		GridBagConstraints gbc_btnMultiplication = new GridBagConstraints();
		gbc_btnMultiplication.fill = GridBagConstraints.BOTH;
		gbc_btnMultiplication.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnMultiplication.insets = new Insets( 0, 0, 5, 5 );
		gbc_btnMultiplication.gridx = 3;
		gbc_btnMultiplication.gridy = 1;
		frame.getContentPane().add( btnMultiplication, gbc_btnMultiplication );

		btnSubtraction = new JButton( "-" );
		// btnSubtraction.setBorder( BorderFactory.createLineBorder( Color.black ) );
		GridBagConstraints gbc_btnSubtraction = new GridBagConstraints();
		gbc_btnSubtraction.anchor = GridBagConstraints.NORTH;
		gbc_btnSubtraction.fill = GridBagConstraints.BOTH;
		gbc_btnSubtraction.insets = new Insets( 0, 0, 5, 0 );
		gbc_btnSubtraction.gridx = 4;
		gbc_btnSubtraction.gridy = 1;
		frame.getContentPane().add( btnSubtraction, gbc_btnSubtraction );

		btnCe = new JButton( "CE" );
		// btnCe.setBorder( BorderFactory.createLineBorder( Color.black ) );
		GridBagConstraints gbc_btnCe = new GridBagConstraints();
		gbc_btnCe.anchor = GridBagConstraints.NORTH;
		gbc_btnCe.fill = GridBagConstraints.BOTH;
		gbc_btnCe.insets = new Insets( 0, 0, 5, 5 );
		gbc_btnCe.gridx = 0;
		gbc_btnCe.gridy = 2;
		frame.getContentPane().add( btnCe, gbc_btnCe );

//		btnSeven = new JButton( "7" );
		// btnSeven.setBorder( BorderFactory.createLineBorder( Color.black ) );
		GridBagConstraints gbc_btnSeven = new GridBagConstraints();
		gbc_btnSeven.fill = GridBagConstraints.BOTH;
		gbc_btnSeven.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSeven.insets = new Insets( 0, 0, 5, 5 );
		gbc_btnSeven.gridx = 1;
		gbc_btnSeven.gridy = 2;
		frame.getContentPane().add( btnSeven, gbc_btnSeven );

//		btnEight = new JButton( "8" );
		// btnEight.setBorder( BorderFactory.createLineBorder( Color.black ) );
		GridBagConstraints gbc_btnEight = new GridBagConstraints();
		gbc_btnEight.fill = GridBagConstraints.BOTH;
		gbc_btnEight.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnEight.insets = new Insets( 0, 0, 5, 5 );
		gbc_btnEight.gridx = 2;
		gbc_btnEight.gridy = 2;
		frame.getContentPane().add( btnEight, gbc_btnEight );

//		btnNine = new JButton( "9" );
		// btnNine.setBorder( BorderFactory.createLineBorder( Color.black ) );
		GridBagConstraints gbc_btnNine = new GridBagConstraints();
		gbc_btnNine.fill = GridBagConstraints.BOTH;
		gbc_btnNine.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNine.insets = new Insets( 0, 0, 5, 5 );
		gbc_btnNine.gridx = 3;
		gbc_btnNine.gridy = 2;
		frame.getContentPane().add( btnNine, gbc_btnNine );

		btnAddition = new JButton( "+" );
		// btnAddition.setBorder( BorderFactory.createLineBorder( Color.black ) );
		GridBagConstraints gbc_btnAddition = new GridBagConstraints();
		gbc_btnAddition.anchor = GridBagConstraints.WEST;
		gbc_btnAddition.fill = GridBagConstraints.BOTH;
		gbc_btnAddition.insets = new Insets( 0, 0, 5, 0 );
		gbc_btnAddition.gridheight = 2;
		gbc_btnAddition.gridx = 4;
		gbc_btnAddition.gridy = 2;
		frame.getContentPane().add( btnAddition, gbc_btnAddition );

		btnVoidB = new JButton( "" );
		btnVoidB.setEnabled( false );
		GridBagConstraints gbc_btnVoidB = new GridBagConstraints();
		gbc_btnVoidB.fill = GridBagConstraints.BOTH;
		gbc_btnVoidB.insets = new Insets( 0, 0, 5, 5 );
		gbc_btnVoidB.gridx = 0;
		gbc_btnVoidB.gridy = 3;
		frame.getContentPane().add( btnVoidB, gbc_btnVoidB );

//		btnFour = new JButton( "4" );
		// btnFour.setBorder( BorderFactory.createLineBorder( Color.black ) );
		GridBagConstraints gbc_btnFour = new GridBagConstraints();
		gbc_btnFour.fill = GridBagConstraints.BOTH;
		gbc_btnFour.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnFour.insets = new Insets( 0, 0, 5, 5 );
		gbc_btnFour.gridx = 1;
		gbc_btnFour.gridy = 3;
		frame.getContentPane().add( btnFour, gbc_btnFour );

//		btnFive = new JButton( "5" );
		// btnFive.setBorder( BorderFactory.createLineBorder( Color.black ) );
		GridBagConstraints gbc_btnFive = new GridBagConstraints();
		gbc_btnFive.fill = GridBagConstraints.BOTH;
		gbc_btnFive.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnFive.insets = new Insets( 0, 0, 5, 5 );
		gbc_btnFive.gridx = 2;
		gbc_btnFive.gridy = 3;
		frame.getContentPane().add( btnFive, gbc_btnFive );

//		btnSix = new JButton( "6" );
		// btnSix.setBorder( BorderFactory.createLineBorder( Color.black ) );
		GridBagConstraints gbc_btnSix = new GridBagConstraints();
		gbc_btnSix.fill = GridBagConstraints.BOTH;
		gbc_btnSix.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSix.insets = new Insets( 0, 0, 5, 5 );
		gbc_btnSix.gridx = 3;
		gbc_btnSix.gridy = 3;
		frame.getContentPane().add( btnSix, gbc_btnSix );

		btnVoidC = new JButton( "" );
		btnVoidC.setEnabled( false );
		GridBagConstraints gbc_btnVoidC = new GridBagConstraints();
		gbc_btnVoidC.fill = GridBagConstraints.BOTH;
		gbc_btnVoidC.insets = new Insets( 0, 0, 5, 5 );
		gbc_btnVoidC.gridx = 0;
		gbc_btnVoidC.gridy = 4;
		frame.getContentPane().add( btnVoidC, gbc_btnVoidC );

//		btnOne = new JButton( "1" );
		// btnOne.setBorder( BorderFactory.createLineBorder( Color.black ) );
		GridBagConstraints gbc_btnOne = new GridBagConstraints();
		gbc_btnOne.fill = GridBagConstraints.BOTH;
		gbc_btnOne.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnOne.insets = new Insets( 0, 0, 5, 5 );
		gbc_btnOne.gridx = 1;
		gbc_btnOne.gridy = 4;
		frame.getContentPane().add( btnOne, gbc_btnOne );
		btnOne.getModel().setPressed( true );

//		btnTwo = new JButton( "2" );
		// btnTwo.setBorder( BorderFactory.createLineBorder( Color.black ) );
		GridBagConstraints gbc_btnTwo = new GridBagConstraints();
		gbc_btnTwo.fill = GridBagConstraints.BOTH;
		gbc_btnTwo.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnTwo.insets = new Insets( 0, 0, 5, 5 );
		gbc_btnTwo.gridx = 2;
		gbc_btnTwo.gridy = 4;
		frame.getContentPane().add( btnTwo, gbc_btnTwo );

//		btnThree = new JButton( "3" );
		// btnThree.setBorder( BorderFactory.createLineBorder( Color.black ) );
		GridBagConstraints gbc_btnThree = new GridBagConstraints();
		gbc_btnThree.fill = GridBagConstraints.BOTH;
		gbc_btnThree.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnThree.insets = new Insets( 0, 0, 5, 5 );
		gbc_btnThree.gridx = 3;
		gbc_btnThree.gridy = 4;
		frame.getContentPane().add( btnThree, gbc_btnThree );

		btnEquals = new JButton( "=" );
		// btnEquals.setBorder( BorderFactory.createLineBorder( Color.black ) );
		GridBagConstraints gbc_btnEquals = new GridBagConstraints();
		gbc_btnEquals.anchor = GridBagConstraints.WEST;
		gbc_btnEquals.fill = GridBagConstraints.BOTH;
		gbc_btnEquals.gridheight = 2;
		gbc_btnEquals.gridx = 4;
		gbc_btnEquals.gridy = 4;
		frame.getContentPane().add( btnEquals, gbc_btnEquals );

		btnVoidD = new JButton( "" );
		btnVoidD.setEnabled( false );
		GridBagConstraints gbc_btnVoidD = new GridBagConstraints();
		gbc_btnVoidD.fill = GridBagConstraints.BOTH;
		gbc_btnVoidD.insets = new Insets( 0, 0, 0, 5 );
		gbc_btnVoidD.gridx = 0;
		gbc_btnVoidD.gridy = 5;
		frame.getContentPane().add( btnVoidD, gbc_btnVoidD );

		//btnZero = new JButton( "0" );
		// btnZero.setBorder( BorderFactory.createLineBorder( Color.black ) );
		GridBagConstraints gbc_btnZero = new GridBagConstraints();
		gbc_btnZero.fill = GridBagConstraints.BOTH;
		gbc_btnZero.insets = new Insets( 0, 0, 0, 5 );
		gbc_btnZero.gridwidth = 2;
		gbc_btnZero.gridx = 1;
		gbc_btnZero.gridy = 5;
		frame.getContentPane().add( btnZero, gbc_btnZero );

//		btnDecimal = new JButton( "." );
//		// btnDecimal.setBorder( BorderFactory.createLineBorder( Color.black ) );
//		GridBagConstraints gbc_btnDecimal = new GridBagConstraints();
//		gbc_btnDecimal.anchor = GridBagConstraints.NORTH;
//		gbc_btnDecimal.fill = GridBagConstraints.BOTH;
//		gbc_btnDecimal.insets = new Insets( 0, 0, 0, 5 );
//		gbc_btnDecimal.gridx = 3;
//		gbc_btnDecimal.gridy = 5;
//		frame.getContentPane().add( btnDecimal, gbc_btnDecimal );

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

	private void designButtons() {
		Component[] components = frame.getContentPane().getComponents();
		for ( Component component : components ) {
			if ( component instanceof JButton ) {
				JButton button = ( JButton ) component;
				button.setBackground( new Color( 225, 225, 225 ) );
				button.setBorder( BorderFactory.createLineBorder( Color.BLACK ) );
				//am.put( "number-pressed", new NumberKeyPressedAction( button, true ) );
				//am.put( "number-released", new NumberKeyPressedAction( button, false ) );
			}
		}
		
	}

	public void createActions( ActionListener controller ) {
		// create our actions
		clearEverythingAction = ClearEverythingAction.ClearEverythingActionFactory();
		clearAction = ClearAction.ClearActionFactory();
		numberAction = NumberAction.NumberActionFactory();
		numberActionR = NumberActionR.NumberActionFactoryR();
		operatorAction = OperatorAction.OperatorActionFactory();
		operatorActionR = OperatorActionR.OperatorActionFactoryR();
		dotAction = DotAction.DotActionFactory();
		dotActionR = DotActionR.DotActionFactoryR();
		equalsAction = EqualsAction.EqualsActionFactory();
		equalsActionR = EqualsActionR.EqualsActionFactoryR();

		// register buttons
//		btnC.addActionListener( controller );
//		btnCe.addActionListener( controller );
//		btnZero.addActionListener( controller );
//		btnOne.addActionListener( controller );
//		btnTwo.addActionListener( controller );
//		btnThree.addActionListener( controller );
//		btnFour.addActionListener( controller );
//		btnFive.addActionListener( controller );
//		btnSix.addActionListener( controller );
//		btnSeven.addActionListener( controller );
//		btnEight.addActionListener( controller );
//		btnNine.addActionListener( controller );
//		btnDecimal.addActionListener( controller );
//		btnMultiplication.addActionListener( controller );
//		btnDivision.addActionListener( controller );
//		btnAddition.addActionListener( controller );
//		btnSubtraction.addActionListener( controller );
//		btnEquals.addActionListener( controller );

		// map keys
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "Escape" );// escape goes to clear everything action

		// number keys go to number action
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD0, 0, false ), "number-pressed" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD0, 0, true ), "number-released" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD1, 0, false ), "number-pressed" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD1, 0, true ), "number-released" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD2, 0, false ), "number-pressed" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD2, 0, true ), "number-released" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD3, 0, false ), "number-pressed" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD3, 0, true ), "number-released" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD4, 0, false ), "number-pressed" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD4, 0, true ), "number-released" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD5, 0, false ), "number-pressed" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD5, 0, true ), "number-released" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD6, 0, false ), "number-pressed" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD6, 0, true ), "number-released" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD7, 0, false ), "number-pressed" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD7, 0, true ), "number-released" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD8, 0, false ), "number-pressed" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD8, 0, true ), "number-released" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD9, 0, false ), "number-pressed" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_NUMPAD9, 0, true ), "number-released" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_DECIMAL, 0, false ), "Dot" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_DECIMAL, 0, true ), "Number Released" );

		// operators go to operator action
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_MULTIPLY, 0, false ), "Operator" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_MULTIPLY, 0, true ), "Operator Released" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_DIVIDE, 0, false ), "Operator" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_DIVIDE, 0, true ), "Operator Released" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_ADD, 0, false ), "Operator" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_ADD, 0, true ), "Operator Released" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_SUBTRACT, 0, false ), "Operator" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_SUBTRACT, 0, true ), "Operator Released" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_ENTER, 0, false ), "Equals" );
		im.put( KeyStroke.getKeyStroke( KeyEvent.VK_ENTER, 0, true ), "Equals Released" );

		// map actions
		am.put( "number-pressed", new NumberKeyPressedAction( btnZero, true ) );
		am.put( "number-released", new NumberKeyPressedAction( btnZero, false ) );
		am.put( "number-pressed", new NumberKeyPressedAction( btnOne, true ) );
		am.put( "number-released", new NumberKeyPressedAction( btnOne, false ) );
		am.put( "number-pressed", new NumberKeyPressedAction( btnTwo, true ) );
		am.put( "number-released", new NumberKeyPressedAction( btnTwo, false ) );
		am.put( "number-pressed", new NumberKeyPressedAction( btnThree, true ) );
		am.put( "number-released", new NumberKeyPressedAction( btnThree, false ) );
		am.put( "number-pressed", new NumberKeyPressedAction( btnFour, true ) );
		am.put( "number-released", new NumberKeyPressedAction( btnFour, false ) );
		am.put( "number-pressed", new NumberKeyPressedAction( btnFive, true ) );
		am.put( "number-released", new NumberKeyPressedAction( btnFive, false ) );
		am.put( "number-pressed", new NumberKeyPressedAction( btnSix, true ) );
		am.put( "number-released", new NumberKeyPressedAction( btnSix, false ) );
		am.put( "number-pressed", new NumberKeyPressedAction( btnSeven, true ) );
		am.put( "number-released", new NumberKeyPressedAction( btnSeven, false ) );
		am.put( "number-pressed", new NumberKeyPressedAction( btnEight, true ) );
		am.put( "number-released", new NumberKeyPressedAction( btnEight, false ) );
		am.put( "number-pressed", new NumberKeyPressedAction( btnNine, true ) );
		am.put( "number-released", new NumberKeyPressedAction( btnNine, false ) );
		
		am.put( "Escape", clearEverythingAction );
		am.put( "Number", numberAction );
		am.put( "Number Released", numberActionR );
		am.put( "Operator", operatorAction );
		am.put( "Operator Released", operatorActionR );
		am.put( "Dot", dotAction );
		am.put( "Dot Released", dotActionR );
		am.put( "Equals", equalsAction );
		am.put( "Equals Released", equalsActionR );

	}

	public void borderChange( boolean change, String key ) {

		Color borderOnColor = Color.RED;
		Color borderOffColor = Color.BLACK;
		Color equalsFillOnColor = new Color( 152, 251, 152 );// green
		Color fillOnColr = new Color( 255, 228, 255 ); // red
		Color fillOffColor = new Color( 225, 225, 225 );// grey

		// if border is true, the button needs to be highlighted, if false, remove border
		switch ( key ) {
		case "\n":
			if ( change ) {
				btnEquals.setBackground( equalsFillOnColor );
			} else {
				btnEquals.setBackground( fillOffColor );
			}
			break;
		case "+":
			if ( change ) {
				btnAddition.setBackground( fillOnColr );
			} else {
				btnAddition.setBackground( fillOffColor );
			}
			break;
		case "-":
			if ( change ) {
				btnSubtraction.setBackground( fillOnColr );
			} else {
				btnSubtraction.setBackground( fillOffColor );
			}
			break;
		case "/":
			if ( change ) {
				btnDivision.setBackground( fillOnColr );
			} else {
				btnDivision.setBackground( fillOffColor );
			}
			break;
		case "*":
			if ( change ) {
				btnMultiplication.setBackground( fillOnColr );
			} else {
				btnMultiplication.setBackground( fillOffColor );
			}
			break;
		case ".":
			if ( change ) {
				btnDecimal.setBorder( BorderFactory.createLineBorder( borderOnColor ) );
			} else {
				btnDecimal.setBorder( BorderFactory.createLineBorder( borderOffColor ) );
			}
			break;
		case "0":
			if ( change ) {
				btnZero.setBorder( BorderFactory.createLineBorder( borderOnColor ) );
			} else {
				btnZero.setBorder( BorderFactory.createLineBorder( borderOffColor ) );
			}
			break;
		case "1":
			if ( change ) {
				btnOne.setBorder( BorderFactory.createLineBorder( borderOnColor ) );
			} else {
				btnOne.setBorder( BorderFactory.createLineBorder( borderOffColor ) );
			}

			break;
		case "2":
			if ( change ) {
				btnTwo.setBorder( BorderFactory.createLineBorder( borderOnColor ) );
			} else {
				btnTwo.setBorder( BorderFactory.createLineBorder( borderOffColor ) );
			}
			break;
		case "3":
			if ( change ) {
				btnThree.setBorder( BorderFactory.createLineBorder( borderOnColor ) );
			} else {
				btnThree.setBorder( BorderFactory.createLineBorder( borderOffColor ) );
			}
			break;
		case "4":
			if ( change ) {
				btnFour.setBorder( BorderFactory.createLineBorder( borderOnColor ) );
			} else {
				btnFour.setBorder( BorderFactory.createLineBorder( borderOffColor ) );
			}
			break;
		case "5":
			if ( change ) {
				btnFive.setBorder( BorderFactory.createLineBorder( borderOnColor ) );
			} else {
				btnFive.setBorder( BorderFactory.createLineBorder( borderOffColor ) );
			}
			break;
		case "6":
			if ( change ) {
				btnSix.setBorder( BorderFactory.createLineBorder( borderOnColor ) );
			} else {
				btnSix.setBorder( BorderFactory.createLineBorder( borderOffColor ) );
			}
			break;
		case "7":
			if ( change ) {
				btnSeven.setBorder( BorderFactory.createLineBorder( borderOnColor ) );
			} else {
				btnSeven.setBorder( BorderFactory.createLineBorder( borderOffColor ) );
			}
			break;
		case "8":
			if ( change ) {
				btnEight.setBorder( BorderFactory.createLineBorder( borderOnColor ) );
			} else {
				btnEight.setBorder( BorderFactory.createLineBorder( borderOffColor ) );
			}
			break;
		case "9":
			if ( change ) {
				btnNine.setBorder( BorderFactory.createLineBorder( borderOnColor ) );
			} else {
				btnNine.setBorder( BorderFactory.createLineBorder( borderOffColor ) );
			}
			break;
		case "c":
			if ( change ) {
				btnC.setBorder( BorderFactory.createLineBorder( borderOnColor ) );
			} else {
				btnC.setBorder( BorderFactory.createLineBorder( borderOffColor ) );
			}
			break;
		case "":
			if ( change ) {
				btnCe.setBorder( BorderFactory.createLineBorder( borderOnColor ) );
			} else {
				btnCe.setBorder( BorderFactory.createLineBorder( borderOffColor ) );
			}
			break;
		default:
			break;
		}

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
