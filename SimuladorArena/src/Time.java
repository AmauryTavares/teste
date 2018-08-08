import java.util.ArrayList;
import java.util.List;

public class Time extends Thread{
	
	private String nome;
	private int arena;
	private int qtdPersonagens;
	private ArrayList<Personagem> integrantes;
	private ArrayList<DadosPersonagem> listaDados;
	private Curandeiro curandeiro;
	
	public Time(int qtd, String nome, int arena) {
		this.nome = nome;
		this.arena = arena;
		integrantes = new ArrayList<Personagem>();
		listaDados = new ArrayList<DadosPersonagem>();
		qtdPersonagens = qtd;
		formaTime(qtd);
	}
	
	public void formaTime(int qtd) {
		for(int i = 0; i <qtd; i++) {
			DadosPersonagem pDados = new DadosPersonagem(nome + "-P" + (i + 1), arena, this);
			Personagem personagem = new Personagem(pDados, listaDados, integrantes, arena);
			listaDados.add(pDados);
			integrantes.add(personagem);
		}
	}
	public int getArena() {
		return arena;
	}

	public void setArena(int arena) {
		this.arena = arena;
	}

	public int getQtdPersonagens() {
		return qtdPersonagens;
	}

	public void setQtdPersonagens(int qtdPersonagens) {
		this.qtdPersonagens = qtdPersonagens;
	}

	public ArrayList<DadosPersonagem> getListaDados() {
		return listaDados;
	}

	public void setListaDados(ArrayList<DadosPersonagem> listaDados) {
		this.listaDados = listaDados;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Personagem> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(ArrayList<Personagem> integrantes) {
		this.integrantes = integrantes;
	}

	public Personagem getCurandeiro() {
		return curandeiro;
	}

	public void setCurandeiro(Curandeiro curandeiro) {
		this.curandeiro = curandeiro;
	}

	}
