package Paint;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Paint implements MouseListener, MouseMotionListener {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private DrawingPanel drawingPanel; 
	
	private Point lastPoint; // Para almacenar la última posición del mouse
     // Para almacenar los puntos dibujados
	private List<Point> points = new ArrayList<>();
	
    List<List<Point>> listaDePuntos = new ArrayList<>();
    
    private boolean isErasing = false;
    private int brushSize = 3;
    private JLabel brushSizeLabel;
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
		brush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isErasing = false;
			}
		});
		brush.setBounds(59, 174, 89, 23);
		panel.add(brush);
		
		JButton borrador = new JButton("Borrador");
		borrador.setBounds(59, 253, 89, 23);
		panel.add(borrador);
		
		JButton rellenar = new JButton("Rellenar");
		rellenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rellenar.setBounds(59, 297, 66, 23);
		panel.add(rellenar);
		limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaDePuntos.clear();
                drawingPanel.repaint();
			}
		});
		
		rellenar.setBounds(108, 300, 40, 23);
        panel.add(rellenar);
        
        brushSizeLabel = new JLabel("Tamaño: " + brushSize);
        brushSizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        brushSizeLabel.setBounds(59, 208, 89, 14);
        panel.add(brushSizeLabel);
        
        JButton menosBrush = new JButton("-");
        menosBrush.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (brushSize > 1) { // Límite mínimo de tamaño
                    brushSize--;
                    tamañoBrush();
        		}
        	}
        });
        menosBrush.setBounds(6, 174, 36, 23);
        panel.add(menosBrush);
        
        JButton masBrush = new JButton("+1");
        masBrush.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (brushSize < 20) { // Límite máximo de tamaño
                    brushSize++;
                    tamañoBrush();
        		}
        	}
        });
        masBrush.setBounds(177, 174, 36, 23);
        panel.add(masBrush);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(290, 34, 578, 525);
		frame.getContentPane().add(panel_1);
		
		drawingPanel = new DrawingPanel();
		panel_1.add(drawingPanel, BorderLayout.CENTER);

        drawingPanel.addMouseListener(this);
        drawingPanel.addMouseMotionListener(this);
		
		
	}
	
	public void tamañoBrush() {
		brushSizeLabel.setText("Tamaño: " + brushSize);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point newPoint = e.getPoint(); 
		 
		 points.add(newPoint);  
	        
	     drawingPanel.repaint();
	        
	     lastPoint = newPoint;
		
	}
	
	class DrawingPanel extends JPanel {
	    public DrawingPanel() {
	        setBackground(Color.WHITE);
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Graphics2D g2d = (Graphics2D) g;
	        
	        // Configuración del dibujo
	        g2d.setColor(Color.BLACK);
	        g2d.setStroke(new BasicStroke(3));
	        
	        // Dibujar todos los trazos guardados (listaDePuntos)
	        for (List<Point> trazo : listaDePuntos) {
	            if (trazo.size() > 1) {
	                for (int i = 1; i < trazo.size(); i++) {
	                    Point p1 = trazo.get(i - 1);
	                    Point p2 = trazo.get(i);
	                    g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
	                }
	            }
	        }
	        
	        // Dibujar el trazo actual (points) mientras se arrastra el mouse
	        if (points.size() > 1) {
	            for (int i = 1; i < points.size(); i++) {
	                Point p1 = points.get(i - 1);
	                Point p2 = points.get(i);
	                g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
	            }
	        }
	    }
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		lastPoint = e.getPoint();
        points.add(lastPoint);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		ArrayList<Point> listaCopiada = (ArrayList<Point>) (((ArrayList<Point>) points).clone());
		
		listaDePuntos.add(listaCopiada); 
		points.clear();
		
		System.out.println(listaDePuntos);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
