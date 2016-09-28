package triangles;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TriangleBoard extends JPanel {
	private static final long serialVersionUID = 1L;
	Timer timer;
	int speed = 0;
	int x1 = 0;
	int x2 = 500;
	int x3 = 1000;
	int y1 = 100;
	int y2 = 500;
	int y3 = 100;
	Point2D.Double point1 = new Point2D.Double(x1, y1);
	Point2D.Double point2 = new Point2D.Double(x2, y2);
	Point2D.Double point3 = new Point2D.Double(x3, y3);
	int count = 0;
	ArrayList<Point2D.Double> points = new ArrayList<Point2D.Double>();
	double[] currentPos = new double[2];
	double[] temp = new double[2];

	public TriangleBoard() {
		points.add(point1);
		points.add(point2);
		points.add(point3);
		currentPos[0] = x1;
		currentPos[1] = y1;

		ActionListener actListner = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				temp = calcMid(currentPos);
				points.add(new Point2D.Double(temp[0], temp[1]));
				repaint();
			}
		};
		timer = new Timer(speed, actListner);

		setBackground(Color.black);
		setFocusable(true);
		timer.start();
	}

	public void paintComponent(Graphics graphics) {

		super.paintComponent(graphics);
		Graphics2D graphics2d = (Graphics2D) graphics;

		graphics.setColor(Color.white);
		graphics2d.setStroke(new BasicStroke(2.0F));
		for (int i = 0; i < points.size(); i++) {
			graphics2d.drawLine((int) points.get(i).getX(), (int) points.get(i)
					.getY(), (int) points.get(i).getX(), (int) points.get(i)
					.getY());
		}

	}

	public double[] calcMid(double[] currentPos) {
		double[] end = new double[2];
		double[] fin = new double[2];
		double r = Math.random() * 4;
		if (r <= 1) {
			end[0] = point1.getX();
			end[1] = point1.getY();
		} else if (r <= 2) {
			end[0] = point2.getX();
			end[1] = point2.getY();
		} else {
			end[0] = point3.getX();
			end[1] = point3.getY();
		}

		fin[0] = (currentPos[0] + end[0]) / 2;
		fin[1] = (currentPos[1] + end[1]) / 2;
		currentPos[0] = fin[0];
		currentPos[1] = fin[1];

		return fin;
	}
	
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
