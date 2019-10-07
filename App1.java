package prueba1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class App1 {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			App1 window = new App1();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		shell.setSize(750, 500);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label lblUnidades = new Label(composite, SWT.NONE);
		lblUnidades.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblUnidades.setBounds(226, 105, 55, 15);
		lblUnidades.setText("Unidades");
		
		text = new Text(composite, SWT.BORDER);
		text.setBounds(307, 102, 183, 21);
		
		Label lblPrecio = new Label(composite, SWT.NONE);
		lblPrecio.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblPrecio.setBounds(226, 161, 40, 15);
		lblPrecio.setText("Precio");
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBounds(307, 158, 183, 21);
		
		Label lblNewLabel = new Label(composite, SWT.BORDER);
		lblNewLabel.setAlignment(SWT.CENTER);
		
		Button btnCalcular = new Button(composite, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int un = Integer.parseInt(text.getText());
				double pr = Double.parseDouble(text_1.getText());
				String tot = Double.toString(un*pr);
				if(pr==0) {
					lblNewLabel.setText("El precio no puede ser 0");
				}else if (un==0) {
					lblNewLabel.setText("Estaría bien que introduzcas alguna unidad");
				}else {
					lblNewLabel.setText(tot + " €");
				}
			}
		});
		btnCalcular.setBounds(307, 213, 75, 25);
		btnCalcular.setText("CALCULAR");
		
		
		lblNewLabel.setBounds(243, 269, 213, 63);
		
		Label lblCalculadoraDePrecio = new Label(composite, SWT.SHADOW_IN);
		lblCalculadoraDePrecio.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblCalculadoraDePrecio.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		lblCalculadoraDePrecio.setBounds(187, 49, 321, 37);
		lblCalculadoraDePrecio.setText("CALCULADORA DE PRECIO");

	}
}
