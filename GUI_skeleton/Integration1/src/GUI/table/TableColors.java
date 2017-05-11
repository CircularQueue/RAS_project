package GUI.table;

import javafx.scene.paint.Color;

public enum TableColors {
	
	Color1(120,45,200), 
	Color2(220, 115, 230), 
	Color3(115, 155, 255), 
	Color4(80, 145, 160),
	Color5(100, 200, 185),
	Color6(150, 240, 190), 
	Color7(100, 235, 95), 
	Color8(200, 250, 95), 
	Color9(225, 200, 68), 
	Color10(255,255,255);
	
	private int red;
	private int green;
	private int blue;
	
	Color color;
	
	private TableColors(int red, int  green, int blue){
		color = Color.rgb(red, green, blue);	
	}
}
