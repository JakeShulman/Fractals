package triangles;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class TriangleRunner {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Triangles");

		Canvas canvas = new Canvas();

		frame.setDefaultCloseOperation(3);

		frame.getContentPane().add(new TriangleBoard());

		frame.setPreferredSize(new Dimension(1000, 530));

		frame.setLocation(0, 0);

		frame.setVisible(true);

		frame.pack();

		frame.setResizable(false);

		TriangleBoard panel = new TriangleBoard();
	}
}
