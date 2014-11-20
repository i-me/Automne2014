package pkProgMatrice2D1;
import java.util.Arrays;

import javax.swing.JOptionPane;
public class ProgMatrice2D1 {

	public static void main(String[] args) {
		final int iTAILLEARRAY=5;
		int iMatA[][]=new int[iTAILLEARRAY][iTAILLEARRAY], iMatB[][]=new int[iTAILLEARRAY][iTAILLEARRAY];
		String sSortieA="-", sSortieB="-";
		for (int i=0;i<iMatA.length;i++)
		{
			Arrays.fill(iMatA[i], 1);
			for(int i2=1;i2<=iTAILLEARRAY;i2++)
			{
				iMatB[i][i2-1]=i2;
			}
		}
		for(int i=0;i<iTAILLEARRAY;i++)
		{
			for(int i2=0;i2<iTAILLEARRAY;i2++)
			{
				sSortieA+=String.valueOf(iMatA[i][i2])+"-";
				sSortieB+=String.valueOf(iMatB[i][i2])+"-";
			}
			sSortieA+="\n-";
			sSortieB+="\n-";
		}
		System.out.println(sSortieA);
		System.out.println(sSortieB);
	}

}
