/*
 * Adrineh Khodaverdian
 * Professor Zareh Gorjian
 * CS/IS 139 
 * GUI Calculator part 1
 * November 25,2021
 */


package guiClaculator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Calculator extends Application{
	
	// instruction buttons

	private Button assign = new Button ("=");
	private Button dot = new Button ("   .   ");
	private Button plus = new Button ("+");
	private Button plusMinus = new Button ("+/- ");		
	private Button mul = new Button (" x");
	private Button div = new Button ("÷");
	private Button clear = new Button ("  C  ");	
	private Button delete = new Button (" <x ");
	private Button percentage = new Button (" %  ");
	private Button minus = new Button ("- ");
	
	//number buttons
	private Button b0 = new Button ("  0  ");
	private Button b1 = new Button ("   1  ");
	private Button b2 = new Button ("  2  ");
	private Button b3 = new Button (" 3   ");
	private Button b4 = new Button ("   4 ");
	private Button b5 = new Button ("  5  ");
	private Button b6 = new Button (" 6   ");
	private Button b7 = new Button ("   7 ");
	private Button b8 = new Button ("  8  ");
	private Button b9 = new Button (" 9   ");
	
	//other variables
	private double op1,op2, result, number;
	private Label lanswer = new Label();
	private boolean assign_pressed = false;
	private boolean dot_pressed = false;
	private boolean plus_pressed = false;
	private boolean plusMinus_pressed = false;
	private boolean mul_pressed = false;
	private boolean minus_pressed = false;
	private boolean div_pressed = false;
	private boolean clear_pressed = false;
	private boolean delete_pressed = false;
	private boolean percentage_pressed = false;
	String numString = "";
	
	@Override //Override the start method in the application class
	public void start(Stage primaryStage) throws Exception {
		//we are gonna add two types of panes to scene
		StackPane rootPane = new StackPane();
		
		
		//answer display field
		lanswer.setAlignment(Pos.CENTER);
		lanswer.setStyle("-fx-border-color: #000; -fx-padding: 5px; -fx-background-color: WHITE;");
		lanswer.setMinWidth(160);
		lanswer.setMinHeight(45);
		
		
		//the display box is set into the horizontal pane
		HBox hpane = new HBox();
		hpane.setMouseTransparent(true); //enabling the buttons
		hpane.getChildren().add(lanswer);
		hpane.setAlignment(Pos.TOP_CENTER);
		
		
		//creating button element instructions and sizing them
		assign.setPrefSize(40,60);
		assign.setOnAction(new EventHandler<ActionEvent>() {
	        @Override // Override the handle method
	        public void handle(ActionEvent e) {
	        	op2 = number;
	        	if(plus_pressed) {
	        		result = op1 + op2;
	        		number = result;
	        		lanswer.setText(Double.toString(result));
	        		plus_pressed = false;
	        		numString = "";
	        	}  
	        	else if (dot_pressed) {
	        			String str = Double.toString(op2);
		        		result = op1 + op2/ Math.pow(10, str.length()-2);
		        		lanswer.setText(Double.toString(result));
		        		number = result;
		        		dot_pressed = false;
		        		numString = "";
		        	 
	        	}
	        	else if (plusMinus_pressed) {
	        		result *= -1;
	        		lanswer.setText(Double.toString(result));
	        		number = 0.0;
	        		plusMinus_pressed = false;
	        		numString = "";
	        	}
	        	else if(mul_pressed) {
	        		result = op1*op2;
	        		number = result;
	        		lanswer.setText(Double.toString(result));
	        		mul_pressed = false;
	        		numString = "";
	        	}
	        	else if(div_pressed) {
	        		result = op1/op2;
	        		number = result;
	        		lanswer.setText(Double.toString(result));
	        		div_pressed = false;
	        		numString = "";
	        	}
	        	else if(clear_pressed) {
	        		result = 0;
	        		op1 = 0;
	        		op2 = 0;
	        		number = 0.0;
	        		lanswer.setText(Double.toString(result));
	        		clear_pressed = false;
	        	
	        		numString = "";
	        	}
	        	else if(percentage_pressed) {
	        		result = op1/100;
	        		number = result;
	        		lanswer.setText(Double.toString(result));
	        		percentage_pressed = false;
	        		numString = "";
	        	}
	        	else if(delete_pressed) {
	        		StringBuilder sb = new StringBuilder(Double.toString(op1));
	        		sb.deleteCharAt(sb.length()-1);
	        		String str = sb.toString();
	        		result = Double.parseDouble(str);
	        		number = 0.0;
	        		lanswer.setText(Double.toString(result));
	        		delete_pressed = false;
	        		numString = "";
	        	}
	        	else if(minus_pressed) {
	        		result = op1-op2 ;
	        		number = result;
	        		lanswer.setText(Double.toString(result));
	        		minus_pressed = false;	        	
	        		numString = "";
	        	}
	        
	        }
		});
		
		
		//Setting all the instruction keys to action 
		dot.setPrefSize(40,60);
		dot.setOnAction(new EventHandler<ActionEvent>() {
	        @Override // Override the handle method
	        public void handle(ActionEvent e) {
	        	op1 = number;
		        lanswer.setText("");
		        number = 0;
		        dot_pressed = true;
		        numString = "";
	        }
		});
		plus.setPrefSize(40,60);
		plus.setOnAction(new EventHandler<ActionEvent>() {
	        @Override // Override the handle method
	        public void handle(ActionEvent e) {
	        	op1 = number;
		        lanswer.setText("+");
		        plus_pressed = true;
		    	number = 0;
		        numString = "";
	        }
		});
		plusMinus.setPrefSize(40,60);
		plusMinus.setOnAction(new EventHandler<ActionEvent>() {
	        @Override // Override the handle method
	        public void handle(ActionEvent e) {
	        	op1 = number;
		        lanswer.setText("+/-");
		        plusMinus_pressed = true;
		       	number = 0;
		        numString = "";
	        }
		});
		mul.setPrefSize(40,60);
		mul.setOnAction(new EventHandler<ActionEvent>() {
	        @Override // Override the handle method
	        public void handle(ActionEvent e) {
	        	op1 = number;
		        lanswer.setText("*");
		        mul_pressed = true;
		        number = 0;
		        numString = "";
	        }
		});
		div.setPrefSize(40,60);
		div.setOnAction(new EventHandler<ActionEvent>() {
	        @Override // Override the handle method
	        public void handle(ActionEvent e) {
	        	op1 = number;
		        lanswer.setText("÷");
		        div_pressed = true;
		        number = 0;
		        numString = "";
	        }
		});
		clear.setPrefSize(40,60);
		clear.setOnAction(new EventHandler<ActionEvent>() {
	        @Override // Override the handle method
	        public void handle(ActionEvent e) {
	        	op1 = number;
	            lanswer.setText("");
		        clear_pressed = true;
		        number = 0;
		        numString = "";
	        }
		});
		
		
		delete.setPrefSize(40,60);
		delete.setOnAction(new EventHandler<ActionEvent>() {
	        @Override // Override the handle method
	        public void handle(ActionEvent e) {
	        	op1 = number;
		        lanswer.setText("");
		        delete_pressed = true;
		    	number = 0;
		        numString = "";
	        }
		});
		
		percentage.setPrefSize(40,60);
		percentage.setOnAction(new EventHandler<ActionEvent>() {
	        @Override // Override the handle method
	        public void handle(ActionEvent e) {
	        	op1 = number;
		        lanswer.setText("%");
		        percentage_pressed = true;
		     	number = 0;
		        numString = "";
	        }
		});
		
		
		minus.setPrefSize(40,60);
		minus.setOnAction(new EventHandler<ActionEvent>() {
	        @Override // Override the handle method
	        public void handle(ActionEvent e) {
	        	op1 = number;
		        lanswer.setText("-");
		        minus_pressed = true;
		        number = 0;
		        numString = "";
	        }
		});
		
		/**********creating number elements**********/
		
		b0.setPrefSize(40,60);
		b0.setOnAction(new EventHandler<ActionEvent>() {
		        @Override // Override the handle method
		        public void handle(ActionEvent e) {
		        	numString = numString + "0";
		        	number = Double.parseDouble(numString);
		        	number = Double.parseDouble(numString);
			        lanswer.setText(numString);
		        }
        });
		b1.setPrefSize(40,60);
	    b1.setOnAction(new EventHandler<ActionEvent>() {
	        @Override // Override the handle method
	        public void handle(ActionEvent e) {
	        	numString = numString + "1";
	        	number = Double.parseDouble(numString);
	        	number = Double.parseDouble(numString);
		        lanswer.setText(numString);
	        }
	    });
		b2.setPrefSize(40,60);
		b2.setOnAction(new EventHandler<ActionEvent>() {
		        @Override // Override the handle method
		        public void handle(ActionEvent e) {
		        	numString = numString + "2";
		        	number = Double.parseDouble(numString);
		        	number = Double.parseDouble(numString);
			        lanswer.setText(numString);
		        }
       });
	   b3.setPrefSize(40,60);
	   b3.setOnAction(new EventHandler<ActionEvent>() {
	         @Override // Override the handle method
	         public void handle(ActionEvent e) {
	        	 numString = numString + "3";
	        	 number = Double.parseDouble(numString);
	        	 number = Double.parseDouble(numString);
		         lanswer.setText(numString);
	        }
      });	
	  b4.setPrefSize(40,60);
	  b4.setOnAction(new EventHandler<ActionEvent>() {
	        @Override // Override the handle method
	        public void handle(ActionEvent e) {
	        	numString = numString + "4";
	        	number = Double.parseDouble(numString);
	        	number = Double.parseDouble(numString);
		        lanswer.setText(numString);
	        }
	  });
	  b5.setPrefSize(40,60);
	  b5.setOnAction(new EventHandler<ActionEvent>() {
		     @Override // Override the handle method
		     public void handle(ActionEvent e) {
		    	 numString = numString + "5";
		         number = Double.parseDouble(numString);
		         number = Double.parseDouble(numString);
			     lanswer.setText(numString);
		    }
      });
	  b6.setPrefSize(40,60);
	  b6.setOnAction(new EventHandler<ActionEvent>() {
	        @Override // Override the handle method
	        public void handle(ActionEvent e) {
	        	numString = numString + "6";
	        	number = Double.parseDouble(numString);
	        	number = Double.parseDouble(numString);
		        lanswer.setText(numString);
		        }
	   });

	   b7.setPrefSize(40,60);
	   b7.setOnAction(new EventHandler<ActionEvent>() {
	        @Override // Override the handle method
	        public void handle(ActionEvent e) {
	        	numString = numString + "7";
	        	number = Double.parseDouble(numString);
	        	number = Double.parseDouble(numString);
		        lanswer.setText(numString);
	        }
		});

		b8.setPrefSize(40,60);
		b8.setOnAction(new EventHandler<ActionEvent>() {
		        @Override // Override the handle method
		        public void handle(ActionEvent e) {
		        	numString = numString + "8";
		        	number = Double.parseDouble(numString);
		        	number = Double.parseDouble(numString);
			        lanswer.setText(numString);
		        }
		});

		b9.setPrefSize(40,60);
		b9.setOnAction(new EventHandler<ActionEvent>() {
				@Override // Override the handle method
				public void handle(ActionEvent e) {
					numString = numString + "9";
					number = Double.parseDouble(numString);
					number = Double.parseDouble(numString);
					lanswer.setText(numString);
	        }
		});
	
		//styling instruction buttons border color
		assign.setStyle("-fx-border-color: BLUE");
		dot.setStyle("-fx-border-color: BLUE");
		plus.setStyle("-fx-border-color: BLUE");
		plusMinus.setStyle("-fx-border-color: BLUE");
		mul.setStyle("-fx-border-color: BLUE");
		div.setStyle("-fx-border-color: BLUE");
		clear.setStyle("-fx-border-color:BLUE");
		delete.setStyle("-fx-border-color:BLUE");
		percentage.setStyle("-fx-border-color:BLUE");
		minus.setStyle("-fx-border-color:BLUE");
		
		

		GridPane pane =  new GridPane();
		pane.setAlignment(Pos.BOTTOM_CENTER);
	
		//row 1
		pane.add(div, 3,1);
		pane.add(delete, 2,1);
		pane.add(clear, 1,1);
		pane.add(percentage, 0,1);

		//row 2
		pane.add(mul, 3,2);
		pane.add(b9, 2,2);
		pane.add(b8, 1,2);
		pane.add(b7, 0,2);
		//row 3
		pane.add(minus, 3,3);
		pane.add(b6, 2,3);
		pane.add(b5, 1,3);
		pane.add(b4, 0,3);
		//row 4
		pane.add(plus, 3,4);
		pane.add(b3, 2,4);
		pane.add(b2, 1,4);
		pane.add(b1, 0,4);
		//last row
		pane.add(assign, 3,5);
		pane.add(dot, 2,5);
		pane.add(b0,1,5);
		pane.add(plusMinus, 0, 5);
		
		
		//adding to panes to scene
		rootPane.getChildren().addAll(pane, hpane);
		rootPane.setStyle("-fx-background-color: LAVENDER");
		
		//create a scene and place a pane in to scene  	
		Scene  scene = new Scene (rootPane, 200, 345);
 
	    primaryStage.setScene(scene);
		primaryStage.setTitle("Calculator");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false); //do not allow to resize 
		primaryStage.show();
		
		
	}
	
	
	public static void main( String [] args) {
		
		launch(args);
		
	}

}
