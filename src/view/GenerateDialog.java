package view;

	import org.eclipse.swt.SWT;
	import org.eclipse.swt.events.SelectionAdapter;
	import org.eclipse.swt.events.SelectionEvent;
	import org.eclipse.swt.layout.GridData;
	import org.eclipse.swt.layout.GridLayout;
	import org.eclipse.swt.widgets.Button;
	import org.eclipse.swt.widgets.Dialog;
	import org.eclipse.swt.widgets.Display;
	import org.eclipse.swt.widgets.Label;
	import org.eclipse.swt.widgets.Shell;
	import org.eclipse.swt.widgets.Text;
	//TODO: Auto-generated Javadoc
	/**
	* 
	*  * <h1>The Class GenerateDialog.</h1>
	* Represents dialog of generate button
	* <p>
	*
	* @author  Guy Liberman & Omri Polnikviat
	* @version 1.0
	* @since   2015-10-31
	*/
	

	class GenerateDialog extends Dialog {
	  
  	/** The message. */
  	private String message;
	  
  	/** The name. */
  	private String name;
	  
  	/** The x. */
  	private String x;
	  
  	/** The y. */
  	private String y;
	  
  	/** The z. */
  	private String z;

	  /**
  	 * Instantiates a new generate dialog.
  	 *
  	 * @param parent the parent
  	 */
  	public GenerateDialog(Shell parent) {
	    this(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
	  }

	  /**
  	 * Instantiates a new generate dialog.
  	 *
  	 * @param parent the parent
  	 * @param style the style
  	 */
  	public GenerateDialog(Shell parent, int style) {
	    super(parent, style);
	    setText("Generate Maze");
	    setMessage("Please enter a values:");
	  }

	  /**
  	 * Gets the message.
  	 *
  	 * @return the message
  	 */
  	public String getMessage() {
	    return message;
	  }

	  /**
  	 * Sets the message.
  	 *
  	 * @param message the new message
  	 */
  	public void setMessage(String message) {
	    this.message = message;
	  }

	  /**
  	 * Gets the input.
  	 *
  	 * @return the input
  	 */
  	public String getInput() {
	    return name;
	  }

	  /**
  	 * Sets the input.
  	 *
  	 * @param input the new input
  	 */
  	public void setInput(String input) {
	    this.name = input;
	  }

	  /**
  	 * Open.
  	 *
  	 * @return the string
  	 */
  	public String open() {
	    Shell shell = new Shell(getParent(), getStyle());
	    shell.setText(getText());
	    createContents(shell);
	    shell.pack();
	    shell.open();
	    Display display = getParent().getDisplay();
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch()) {
	        display.sleep();
	      }
	    }
	    return name + " " + x + " " + y + " " + z;
	  }

	  /**
  	 * Creates the contents.
  	 *
  	 * @param shell the shell
  	 */
  	private void createContents(final Shell shell) {
	    shell.setLayout(new GridLayout(2, true));

	    Label labelMaze = new Label(shell, SWT.NONE);
	    labelMaze.setText("Maze Name:");
	    GridData data = new GridData();
	    data.horizontalSpan = 1;
	    labelMaze.setLayoutData(data);

	    final Text mazeText = new Text(shell, SWT.BORDER);
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 1;
	    mazeText.setLayoutData(data);

	    Label labelX = new Label(shell, SWT.NONE);
	    labelX.setText("X Axis Size:");

	    final Text xText = new Text(shell, SWT.BORDER);
	    xText.setLayoutData(data);

	    Label labelY = new Label(shell, SWT.NONE);
	    labelY.setText("Y Axis Size:");

	    final Text yText = new Text(shell, SWT.BORDER);
	    yText.setLayoutData(data);
	    
	    Label labelZ = new Label(shell, SWT.NONE);
	    labelZ.setText("Y Axis Size:");

	    final Text zText = new Text(shell, SWT.BORDER);
	    zText.setLayoutData(data);
	    
	    Button ok = new Button(shell, SWT.PUSH);
	    ok.setText("OK");
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    ok.setLayoutData(data);
	    ok.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(SelectionEvent event) {
	    	  name = mazeText.getText();
	    	  x = xText.getText();
	    	  y = yText.getText();
	    	  z = zText.getText();
	        shell.close();
	      }
	    });

	    Button cancel = new Button(shell, SWT.PUSH);
	    cancel.setText("Cancel");
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    cancel.setLayoutData(data);
	    cancel.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(SelectionEvent event) {
	    	  name = null;
	    	  x=null;
	    	  y=null;
	    	  x=null;
	        shell.close();
	      }
	    });

	    shell.setDefaultButton(ok);
	  }
	}
