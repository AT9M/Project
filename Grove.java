import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

//import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;


public class Grove extends JFrame {


	public static final JLabel lblforward = null;
	public static final JLabel lblbackward = null;
	public static final JLabel lblup = null;
	public static final JLabel lbldroi = null;
	public static final JLabel lblgau = null;
	public static final JLabel lbldown = null;
	public static final JLabel lblclock1 = null;
	public static final JLabel lblclock2 = null;
	public static final JLabel lblwave = null;
	private JPanel contentPane;
	private  Grove Grove;
	static Grove frame;
	static classgrove go;

	public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					go = new classgrove(frame);
					frame = new Grove();
				    
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	public Grove() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setLayout(null);
		
		JLabel lblgau = new JLabel("Gauche");
		lblgau.setOpaque(true);
		lblgau.setBackground(Color.PINK);
		lblgau.setBounds(28, 30, 46, 14);
		getContentPane().add(lblgau);
		
		JLabel lbldroi = new JLabel("Droite");
		lbldroi.setOpaque(true);
		lbldroi.setBackground(Color.PINK);
		lbldroi.setBounds(187, 30, 46, 14);
		getContentPane().add(lbldroi);
		
		JLabel lblup = new JLabel("Up");
		lblup.setOpaque(true);
		lblup.setBackground(Color.PINK);
		lblup.setBounds(352, 30, 46, 14);
		getContentPane().add(lblup);
		
		JLabel lbldown = new JLabel("Down");
		lbldown.setOpaque(true);
		lbldown.setBackground(Color.PINK);
		lbldown.setBounds(28, 110, 46, 14);
		getContentPane().add(lbldown);
		
		JLabel lblforward = new JLabel("Forward");
		lblforward.setOpaque(true);
		lblforward.setBackground(Color.PINK);
		lblforward.setBounds(187, 110, 46, 14);
		getContentPane().add(lblforward);
		
		JLabel lblbackward = new JLabel("Backward");
		lblbackward.setOpaque(true);
		lblbackward.setBackground(Color.PINK);
		lblbackward.setBounds(352, 110, 46, 14);
		getContentPane().add(lblbackward);
		
		JLabel lblclock1 = new JLabel("Clockwise");
		lblclock1.setOpaque(true);
		lblclock1.setBackground(Color.PINK);
		lblclock1.setBounds(28, 201, 46, 14);
		getContentPane().add(lblclock1);
		
		JLabel lblclock2 = new JLabel("UnClock");
		lblclock2.setOpaque(true);
		lblclock2.setBackground(Color.PINK);
		lblclock2.setBounds(187, 201, 46, 14);
		getContentPane().add(lblclock2);
		
		JLabel lblwave = new JLabel("Wave");
		lblwave.setOpaque(true);
		lblwave.setBackground(Color.PINK);
		lblwave.setBounds(352, 201, 46, 14);
		getContentPane().add(lblwave);
		
		
		
		go.start();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 306);
		
		
	
	}
}
