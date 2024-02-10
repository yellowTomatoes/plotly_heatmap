import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class makeMandelbrot {

	public static void main(String[] args) {
		try {
			  PrintStream consoleOut = System.out;
			  FileOutputStream writer= new FileOutputStream("mandelbrot.js");
			  PrintStream fileOut = new PrintStream(writer);
			  
			  long h = 600;
			  long w = 800;	
			  double Xscale = 2.47/w;
			  double Yscale = 2.24/h;
			  System.setOut(fileOut);
			  System.out.print("var mandelbrot = [");
			  for(int i =1; i <= (h*w);i++){
				  
				  int x= (int) (i%w == 0 ? ((i-1)/w)+1 : ((i/w)+1));
				  int y = (int) (i%w == 0 ? w : i%w);
				  double  _x = 0;
				  double _y = 0;
				  double x0 = (x*Xscale) -2;
				  double y0 = (y*Yscale)-1.12;
				  int j = 0;
				  int max = 1000;
				  while((_x*_x ) + (_y*_y) <= 4 && j < max){
				    double temp = (_x*_x) - (_y*_y) + x0;
					_y = 2*_x*_y + y0;
					_x = temp;
					j++;		  
				  //writer.write("{"+ x +" , " + y +", " + j + "} ");			 
				  //System.setOut(consoleOut);
				 // System.out.print(j);
				  //if(i%w==0)System.out.println();
				  }
				  System.out.print("{\"x\":\""+ x +"\" , \"y\":\"" + y +"\", \"z\":\"" + j + "\"},");
			  }
			  System.out.print("]; console.log(\"file loaded\")");
			  System.setOut(consoleOut);
			  System.out.println("finished printing file");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("couldn't write to file");
		}
	}
}