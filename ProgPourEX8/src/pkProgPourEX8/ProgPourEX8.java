package pkProgPourEX8;

public class ProgPourEX8 {

	public static void main(String[] args) {
		int iA=0, iB=1, iC=0;
		for(int i=0;i<20;i++)
		{
			iA=iB;
			iB=iC;
			iC=iA+iB;
			System.out.println("#"+(i+1)+":"+iC);
		}
	}

}
