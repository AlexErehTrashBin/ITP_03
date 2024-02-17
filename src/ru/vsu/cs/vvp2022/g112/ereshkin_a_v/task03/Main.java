package ru.vsu.cs.vvp2022.g112.ereshkin_a_v.task03;

import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static final Line UPPER_LINE = new Line(5, 4, 1.0 / 4);
	public static final Line LOWER_LINE = new Line(0, -3, 0);
	public static final Line ALMOST_VERTICAL_LINE = new Line(0, 4, -4);
	public static final VerticalParabola PARABOLA = new VerticalParabola(-2, -5, 0.125);
	public static final Circle CIRCLE = new Circle(-1, -6, 2);

	/**
	* Проверка "правой" части рисунка (той, что выше почти вертикальной прямой)
	*/
	public static SimpleColor checkAboveAlmostVerticalLine(double x, double y){
		if (PARABOLA.isPointAboveTheParabola(x, y) && UPPER_LINE.isPointAboveLine(x, y)) {
			return SimpleColor.GRAY;
		}
		if (UPPER_LINE.isPointAboveLine(x, y)) {
			return SimpleColor.BLUE;
		}
		if (!LOWER_LINE.isPointAboveLine(x, y)) {
			return SimpleColor.GRAY;
		}
		return SimpleColor.WHITE;
	}
	/**
	 * Проверка "левой" части рисунка (той, что ниже почти вертикальной прямой)
	 */
	public static SimpleColor checkUnderAlmostVerticalLine(double x, double y){
		// В круге и выше параболы - оранжевый
		if (CIRCLE.isPointInsideTheCircle(x, y) && PARABOLA.isPointAboveTheParabola(x, y)){
			return SimpleColor.ORANGE;
		}
		// В круге и ниже параболы (из пред. условия) - жёлтый
		if (CIRCLE.isPointInsideTheCircle(x, y)){
			return SimpleColor.YELLOW;
		}
		// Выше параболы и выше верхней прямой - оранжевый
		if (PARABOLA.isPointAboveTheParabola(x, y) && UPPER_LINE.isPointAboveLine(x, y)){
			return SimpleColor.ORANGE;
		}
		// Ниже параболы (из пред. условия) и выше верхней прямой - жёлтый
		if (UPPER_LINE.isPointAboveLine(x, y)){
			return SimpleColor.YELLOW;
		}
		// Ниже параболы и выше нижней прямой - синий
		if (LOWER_LINE.isPointAboveLine(x, y)){
			return SimpleColor.BLUE;
		}
		// Иначе зелёный
		return SimpleColor.GREEN;
	}
	public static SimpleColor getColor(double x, double y) {
		if (ALMOST_VERTICAL_LINE.isPointAboveLine(x, y)) {
			return checkAboveAlmostVerticalLine(x, y);
		} else {
			return checkUnderAlmostVerticalLine(x, y);
		}
	}

	public static void printColorForPoint(double x, double y) {
		System.out.printf("(%.3f, %.3f) -> %s%n", x, y, getColor(x, y));
	}

	public static void tests() {
		printColorForPoint(-10, 10);
		printColorForPoint(3, 8);
		printColorForPoint(10, 10);
		printColorForPoint(-10, 1);
		printColorForPoint(3, -2);
		printColorForPoint(-10, -2);
		printColorForPoint(-1, -4.001);
		printColorForPoint(-1, -5);
		printColorForPoint(-10, -10);
		printColorForPoint(10, -10);
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);

		tests();

		Scanner scanner = new Scanner(System.in);
		System.out.print("Input x, y: ");
		double x = scanner.nextDouble();
		double y = scanner.nextDouble();

		printColorForPoint(x, y);
	}
}