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
	*  * <h1>The Class DisplayDialog.</h1>
	* Represents dialog of display button
	* <p>
	*
	* @author  Guy Liberman & Omri Polnikviat
	* @version 1.0
	* @since   2015-10-31
	*/

	
	class DisplayDialog extends Dialog {
	  
  	/** The message. */
  	private String message;
	  
  	/** The name. */
  	private String name;

	  /**
  	 * Instantiates a new display dialog.
  	 *
  	 * @param parent the parent
  	 */
  	public DisplayDialog(Shell parent) {
	    this(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
	  }

	  /**
  	 * Instantiates a new display dialog.
  	 *
  	 * @param parent the parent
  	 * @param style the style
  	 */
  	public DisplayDialog(Shell parent, int style) {
	    super(parent, style);
	    setText("Display Maze");
	    setMessage("Please enter a Name:");
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
	    return name;
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
	    
	    Button ok = new Button(shell, SWT.PUSH);
	    ok.setText("OK");
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    ok.setLayoutData(data);
	    ok.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(SelectionEvent event) {
	    	  name = mazeText.getText();
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
	        shell.close();
	      }
	    });

	    shell.setDefaultButton(ok);
	  }
	}
