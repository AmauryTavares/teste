import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Batalha extends Thread{
	
	private int arena;
//	ArrayList<DadosPersonagem> listaDadosPersonagens;
//	ArrayList<Personagem> listaPersonagens;
//	int qtdPersonagens;
	static int qtdMortos1 = 0;
	static int qtdMortos2 = 0;
	static Semaphore sem = new Semaphore(1);
	
	Time time1, time2;
	
	
	Random rand = new Random();
	public Batalha(int timeA, int timeB){
		arena = Arena.sortearArena();
		this.time1 = new Time(timeA, "TimeA", arena);
		this.time2 = new Time(timeB, "TimeB", arena);
	}
	
//	public Batalha (int qtd) {
//		this.arena = Arena.sortearArena();
//		listaDadosPersonagens = new ArrayList<>();
//		listaPersonagens = new ArrayList<>();
//		criarLista(qtd);
//		this.qtdPersonagens = qtd;
//	}
	
//	private void criarLista(int tamanho) {
//		for (int i = 0; i < tamanho; i++) {
//			DadosPersonagem pDados = new DadosPersonagem("Personagem" + (i + 1), arena);
//			Personagem personagem = new Personagem(pDados, listaDadosPersonagens, listaPersonagens, arena);
//			listaDadosPersonagens.add(pDados);
//			listaPersonagens.add(personagem);
//		}
//	}
	
	synchronized public static void morto(int time) {
		if(time == 1){
			qtdMortos1++;
		}else {
			qtdMortos2++;
		}
	}
	
	static public int getQtdMortos() {
		return qtdMortos1 + qtdMortos2;
	}
			
	private void iniciarBatalha () {
		for (int i = 0; i < time1.getIntegrantes().size(); i++) {
			time1.getIntegrantes().get(i).start();
			//System.out.println(listaPersonagens.get(i).personagem.toString());
		}
		for (int i = 0; i < time2.getIntegrantes().size(); i++) {
			time2.getIntegrantes().get(i).start();
			//System.out.println(listaPersonagens.get(i).personagem.toString());
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		iniciarBatalha();
		int vencedor1 = 0;
		int vencedor2 = 0;
		while ((qtdMortos1 != (time1.getQtdPersonagens() - 1)) && (qtdMortos2 != (time2.getQtdPersonagens() - 1))) {
			try {
				Thread.sleep(100);
				System.out.println("(TEMPORARIO) QUANTIDADE DE MORTOS: " + qtdMortos1 + " " + qtdMortos2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		
		for (int i = 0; i < time1.getIntegrantes().size(); i++) {
			time1.getIntegrantes().get(i).stop();
		}
		
		for (int i = 0; i < time2.getIntegrantes().size(); i++) {
			time2.getIntegrantes().get(i).stop();
		}
		
		if (qtdMortos1 == time1.getQtdPersonagens()-1)
			System.out.println("\n\n###################VENCEDOR###################\n\n" 
					+ time2.getNome());
		else if (qtdMortos1 == time2.getQtdPersonagens()-1) {
			System.out.println("\n\n###################VENCEDOR###################\n\n" 
					+ time1.getNome());
		}
		
	}

}
