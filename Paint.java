package Paint;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Paint {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paint window = new Paint();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Paint() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(224, 255, 255));
		frame.setBounds(100, 100, 911, 636);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(32, 34, 219, 525);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton colorBlanco = new JRadioButton("");
		colorBlanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(colorBlanco);
		colorBlanco.setBackground(new Color(255, 255, 255));
		colorBlanco.setForeground(new Color(255, 255, 255));
		colorBlanco.setBounds(6, 403, 21, 23);
		panel.add(colorBlanco);
		
		JRadioButton colorRojo = new JRadioButton("");
		colorRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		colorRojo.setSelected(true);
		colorRojo.setForeground(new Color(255, 0, 0));
		colorRojo.setBackground(new Color(255, 255, 255));
		buttonGroup.add(colorRojo);
		colorRojo.setBounds(45, 403, 21, 23);
		panel.add(colorRojo);
		
		JRadioButton colorAzul = new JRadioButton("");
		colorAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		colorAzul.setBackground(new Color(255, 255, 255));
		buttonGroup.add(colorAzul);
		colorAzul.setBounds(82, 403, 21, 23);
		panel.add(colorAzul);
		
		JRadioButton colorVerde = new JRadioButton("");
		colorVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		colorVerde.setBackground(new Color(255, 255, 255));
		buttonGroup.add(colorVerde);
		colorVerde.setBounds(119, 403, 21, 23);
		panel.add(colorVerde);
		
		JRadioButton colorAmarillo = new JRadioButton("");
		colorAmarillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		colorAmarillo.setBackground(new Color(255, 255, 255));
		buttonGroup.add(colorAmarillo);
		colorAmarillo.setBounds(155, 403, 21, 23);
		panel.add(colorAmarillo);
		
		JRadioButton colorNegro = new JRadioButton("");
		colorNegro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		colorNegro.setBackground(new Color(255, 255, 255));
		buttonGroup.add(colorNegro);
		colorNegro.setBounds(192, 403, 21, 23);
		panel.add(colorNegro);
		
		JLabel lblNewLabel = new JLabel("Colores");
		lblNewLabel.setBounds(94, 382, 36, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Formas");
		lblNewLabel_1.setBounds(94, 11, 36, 14);
		panel.add(lblNewLabel_1);
		
		JButton rectangulo = new JButton("Rectángulo");
		rectangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rectangulo.setBounds(59, 36, 89, 23);
		panel.add(rectangulo);
		
		JButton circulo = new JButton("Círculo");
		circulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		circulo.setBounds(59, 70, 89, 23);
		panel.add(circulo);
		
		JButton triangulo = new JButton("Triángulo");
		triangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		triangulo.setBounds(59, 104, 89, 23);
		panel.add(triangulo);
		
		JButton limpiar = new JButton("Limpiar");
		limpiar.setBounds(59, 458, 106, 43);
		panel.add(limpiar);
		
		JLabel lblNewLabel_2 = new JLabel("Opciones");
		lblNewLabel_2.setBounds(82, 149, 46, 14);
		panel.add(lblNewLabel_2);
		
		JButton brush = new JButton("Brush");
		brush.setBounds(59, 174, 89, 23);
		panel.add(brush);
		
		JButton borrador = new JButton("Borrador");
		borrador.setBounds(59, 218, 89, 23);
		panel.add(borrador);
		
		JButton rellenar = new JButton("Rellenar");
		rellenar.setBounds(59, 262, 89, 23);
		panel.add(rellenar);
		limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(290, 34, 578, 525);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		Canvas canvas = new Canvas();
		canvas.setBounds(0, 0, 578, 525);
		panel_1.add(canvas);
	}
}
