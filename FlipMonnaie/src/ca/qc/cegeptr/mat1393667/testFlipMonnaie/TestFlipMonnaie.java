package ca.qc.cegeptr.mat1393667.testFlipMonnaie;
import ca.qc.cegeptr.mat1393667.outils.*;
import je.suis.vedge.*;//Contient seulement méthode pour system.out.println raccourcis
public class TestFlipMonnaie {

	public static void main(String[] args) {
		FlipMonnaie unePiece=new FlipMonnaie();
		FlipMonnaie deuxPiece=new FlipMonnaie(0);
		vedge pr=new vedge();
		pr.t("Première pièce de monnaie");
		pr.t("getFace: "+unePiece.getFace()+" quelFace (Boolean): "+unePiece.quelFace()+" quelFaceFormat (formaté): "+unePiece.quelFaceFormat());
		unePiece.setFace(unePiece.lancer());
		pr.t("lançons la pièce getFace:"+unePiece.getFace());
		pr.t(unePiece.gagnant());
		pr.t("Deuxième piece de monnaie");
		pr.t(deuxPiece.toString());
		deuxPiece.setFace(1);
		pr.t("Assignons la face 1");
		pr.t(deuxPiece.toString());
		pr.t(deuxPiece.gagnant());
		
	}

}
