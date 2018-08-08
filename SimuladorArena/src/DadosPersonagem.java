import java.util.Random;

public class DadosPersonagem {

	private boolean emCombate, passivaMortoVivo, dormindo;
	private String nome;
	private int hpTotal, hpAtual, forca, inteligencia, defFisica, defMagica, energiaTotal, energiaAtual, velocidade,
			agilidade, raca, personalidade, caractFisica, taxaFuga, taxaCritico, taxaResistencia, taxaAcerto,
			taxaEsquiva, escudo, turnosMortoVivo;

	/* Dados b�nus */
	private int hpBonus, forcaBonus, inteligenciaBonus, defFisicaBonus, defMagicaBonus, energiaBonus, velocidadeBonus,
			agilidadeBonus, taxaFugaBonus, taxaCriticoBonus, taxaResistenciaBonus, taxaAcertoBonus, taxaEsquivaBonus;
	private Time time;
	Random rand = new Random();

	public DadosPersonagem(String nome, int arena, Time time) {
		this.time = time;
		this.nome = nome;
		this.setRaca(Raca.sortearRaca());
		this.setPersonalidade(Personalidade.sortearPersonalidade());
		this.setCaractFisica(CaractFisica.sortearCaractFisica());
		this.bonusRaca();
		this.bonusPersonalidade(arena);
		this.gerarCaractFisica();
		this.energiaAtual = 0; // for�a o personagem a iniciar dormindo na arena
		this.hpAtual = hpTotal;
	}

	private void gerarCaractFisica() {
		if (this.caractFisica == CaractFisica.AGIL.getValorCaractFisica()) {
			this.setHpTotal((rand.nextInt(201) + 600) * (1 + (hpBonus / 100)));
			this.setForca((rand.nextInt(41) + 80) * (1 + (forcaBonus / 100)));
			this.setInteligencia((rand.nextInt(41) + 170) * (1 + (inteligenciaBonus / 100)));
			this.setVelocidade((rand.nextInt(31) + 140) * (1 + (velocidadeBonus / 100)));
			this.setAgilidade((rand.nextInt(31) + 140) * (1 + (agilidadeBonus / 100)));
			this.setDefFisica((rand.nextInt(21) + 50 + (this.forca / 10)) * (1 + (defFisicaBonus / 100)));
			this.setDefMagica((rand.nextInt(41) + 110 + (this.inteligencia / 10)) * (1 + (defMagicaBonus / 100)));
			this.setEnergiaTotal(rand.nextInt(4) + 2 + (this.velocidade / 80) + energiaBonus);
			this.setTaxaFuga(rand.nextInt(16) + 10 + (this.velocidade / 15) + taxaFugaBonus);
			this.setTaxaCritico(rand.nextInt(16) + 20 + (this.agilidade / 10) + taxaCriticoBonus);
			this.setTaxaResistencia(rand.nextInt(8) + 5 + (this.forca / 10) + taxaResistenciaBonus);
			this.setTaxaAcerto(rand.nextInt(21) + 60 + (this.agilidade / 10) + taxaAcertoBonus);
			this.setTaxaEsquiva(rand.nextInt(16) + 25 + (this.agilidade / 10) + taxaEsquivaBonus);

		} else if (this.caractFisica == CaractFisica.MEDIANO.getValorCaractFisica()) {
			this.setHpTotal((rand.nextInt(251) + 900) * (1 + (hpBonus / 100)));
			this.setForca((rand.nextInt(31) + 120) * (1 + (forcaBonus / 100)));
			this.setInteligencia((rand.nextInt(31) + 120) * (1 + (inteligenciaBonus / 100)));
			this.setVelocidade((rand.nextInt(31) + 90) * (1 + (velocidadeBonus / 100)));
			this.setAgilidade((rand.nextInt(21) + 110) * (1 + (agilidadeBonus / 100)));
			this.setDefFisica((rand.nextInt(21) + 70 + (this.forca / 10)) * (1 + (defFisicaBonus / 100)));
			this.setDefMagica((rand.nextInt(21) + 70 + (this.inteligencia / 10)) * (1 + (defMagicaBonus / 100)));
			this.setEnergiaTotal(rand.nextInt(4) + 1 + (this.velocidade / 80) + energiaBonus);
			this.setTaxaFuga(rand.nextInt(8) + 8 + (this.velocidade / 15) + taxaFugaBonus);
			this.setTaxaCritico(rand.nextInt(11) + 10 + (this.agilidade / 10) + taxaCriticoBonus);
			this.setTaxaResistencia(rand.nextInt(16) + 15 + (this.forca / 10) + taxaResistenciaBonus);
			this.setTaxaAcerto(rand.nextInt(21) + 50 + (this.agilidade / 10) + taxaAcertoBonus);
			this.setTaxaEsquiva(rand.nextInt(11) + 20 + (this.agilidade / 10) + taxaEsquivaBonus);

		} else if (this.caractFisica == CaractFisica.FORTE.getValorCaractFisica()) {
			this.setHpTotal((rand.nextInt(401) + 1200) * (1 + (hpBonus / 100)));
			this.setForca((rand.nextInt(41) + 170) * (1 + (forcaBonus / 100)));
			this.setInteligencia((rand.nextInt(41) + 80) * (1 + (inteligenciaBonus / 100)));
			this.setVelocidade((rand.nextInt(21) + 70) * (1 + (velocidadeBonus / 100)));
			this.setAgilidade((rand.nextInt(21) + 80) * (1 + (agilidadeBonus / 100)));
			this.setDefFisica((rand.nextInt(41) + 110 + (this.forca / 10)) * (1 + (defFisicaBonus / 100)));
			this.setDefMagica((rand.nextInt(21) + 50 + (this.inteligencia / 10)) * (1 + (defMagicaBonus / 100)));
			this.setEnergiaTotal(rand.nextInt(3) + 1 + (this.velocidade / 80) + energiaBonus);
			this.setTaxaFuga(rand.nextInt(6) + 5 + (this.velocidade / 15) + taxaFugaBonus);
			this.setTaxaCritico(rand.nextInt(11) + 5 + (this.agilidade / 10) + taxaCriticoBonus);
			this.setTaxaResistencia(rand.nextInt(21) + 25 + (this.forca / 10) + taxaResistenciaBonus);
			this.setTaxaAcerto(rand.nextInt(16) + 45 + (this.agilidade / 10) + taxaAcertoBonus);
			this.setTaxaEsquiva(rand.nextInt(11) + 10 + (this.agilidade / 10) + taxaEsquivaBonus);
		}
	}

	private void bonusRaca() {
		if (this.raca == Raca.OGRO.getValorRaca()) {
			this.hpBonus = 20;
			this.forcaBonus = 25;
			this.defFisicaBonus = 15;
			this.taxaResistenciaBonus = 15;
			this.velocidadeBonus = -10;
			this.agilidadeBonus = -10;
			this.taxaAcertoBonus = -15;
			this.taxaEsquivaBonus = -15;

		} else if (this.raca == Raca.ELFO.getValorRaca()) {
			this.agilidadeBonus = 25;
			this.taxaCriticoBonus = 35;
			this.taxaAcertoBonus = 20;
			this.taxaEsquivaBonus = 20;
			this.hpBonus = -10;
			this.forcaBonus = -10;
			this.defFisicaBonus = -10;
			this.defMagicaBonus = -10;

		} else if (this.raca == Raca.ANAO.getValorRaca()) {
			this.setEscudo(600);
			this.forcaBonus = 15;
			this.defFisicaBonus = 20;
			this.taxaAcertoBonus = 20;
			this.velocidadeBonus = -15;
			this.agilidadeBonus = -15;
			this.taxaFugaBonus = -10;
			this.taxaEsquivaBonus = -15;

		} else if (this.raca == Raca.ASSASSINO.getValorRaca()) {
			this.velocidadeBonus = 25;
			this.agilidadeBonus = 25;
			this.taxaFugaBonus = 30;
			this.hpBonus = -20;
			this.taxaResistenciaBonus = -15;
			this.defFisicaBonus = -15;
			this.defMagicaBonus = -15;

		} else if (this.raca == Raca.VAMPIRO.getValorRaca()) {
			this.hpBonus = 20;
			this.taxaResistenciaBonus = 25;
			this.velocidadeBonus = 20;
			this.defFisicaBonus = -10;
			this.defMagicaBonus = -10;
			this.taxaCriticoBonus = -15;
			this.taxaAcertoBonus = -20;

		} else if (this.raca == Raca.MORTO_VIVO.getValorRaca()) {
			this.setPassivaMortoVivo(true);
			this.forcaBonus = 20;
			this.taxaResistenciaBonus = 30;
			this.defFisicaBonus = 15;
			this.velocidadeBonus = -25;
			this.agilidadeBonus = -25;
			this.taxaAcertoBonus = -20;
			this.taxaEsquivaBonus = -20;

		} else if (this.raca == Raca.MAGO.getValorRaca()) {
			this.inteligenciaBonus = 30;
			this.defMagicaBonus = 30;
			this.taxaFugaBonus = 20;
			this.taxaAcertoBonus = 30;
			this.hpBonus = 15;
			this.forcaBonus = -15;
			this.defFisicaBonus = -20;
			this.taxaResistenciaBonus = -20;

		} else if (this.raca == Raca.PALADINO.getValorRaca()) {
			this.forcaBonus = 15;
			this.inteligenciaBonus = 15;
			this.defFisicaBonus = 15;
			this.defMagicaBonus = 15;
			this.hpBonus = -10;
			this.velocidadeBonus = -15;
			this.agilidadeBonus = -15;
			this.taxaFugaBonus = -10;

		} else if (this.raca == Raca.DRACONIANA.getValorRaca()) {
			this.hpBonus = 15;
			this.defFisicaBonus = 15;
			this.taxaResistenciaBonus = 15;
			this.defMagicaBonus = -20;
			this.taxaFugaBonus = -10;
			this.taxaCriticoBonus = -25;
			this.taxaEsquivaBonus = -20;

		}
	}

	private void bonusPersonalidade(int arena) {
		if (this.personalidade == Personalidade.ADPTADOR.getValorPersonalidade()) {
			if (arena == Arena.CAMPO_GLACIAL.getValorArena()) {
				this.taxaResistenciaBonus += 20;
			} else if (arena == Arena.PANTANO.getValorArena()) {
				this.agilidadeBonus += 15;
				this.velocidadeBonus += 15;
			} else if (arena == Arena.DESERTO.getValorArena()) {
				this.energiaTotal += 1;
			} else if (arena == Arena.SELVA.getValorArena()) {
				this.taxaFugaBonus += 25;
			}

		} else if (this.personalidade == Personalidade.DEFENSOR.getValorPersonalidade()) {
			this.defFisicaBonus += 15;
			this.defMagicaBonus += 15;
		} else if (this.personalidade == Personalidade.MEDROSO.getValorPersonalidade()) {
			this.taxaFugaBonus += 40;
		}
	}

	public Time getTime() {
		return this.time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public boolean isDormindo() {
		return dormindo;
	}

	public void setDormindo(boolean dormindo) {
		this.dormindo = dormindo;
	}

	public boolean isPassivaMortoVivo() {
		return passivaMortoVivo;
	}

	public void setPassivaMortoVivo(boolean passivaMortoVivo) {
		this.passivaMortoVivo = passivaMortoVivo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getHpTotal() {
		return hpTotal;
	}

	public void setHpTotal(int hpTotal) {
		this.hpTotal = hpTotal;
	}

	public int getHpAtual() {
		return hpAtual;
	}

	public void setHpAtual(int hpAtual) {
		if (hpAtual > this.hpTotal) {
			this.hpAtual = this.hpTotal;
		} else if (hpAtual <= 0) {
			if (this.raca == Raca.MORTO_VIVO.getValorRaca()) {
				if (this.hpAtual == 0 && passivaMortoVivo) {
					this.setPassivaMortoVivo(false);
					this.turnosMortoVivo = 2;
					this.setHpAtual(1);
					System.out.println(this.nome + " se tornou um morto vivo");
				} else if (this.hpAtual == 0 && turnosMortoVivo > 0) {
					this.setHpAtual(1);
				} else {
					this.hpAtual = 0;
				}
			} else {
				this.hpAtual = 0;
			}
		} else {
			this.hpAtual = hpAtual;
		}
	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public int getDefFisica() {
		return defFisica;
	}

	public void setDefFisica(int defFisica) {
		this.defFisica = defFisica;
	}

	public int getDefMagica() {
		return defMagica;
	}

	public void setDefMagica(int defMagica) {
		this.defMagica = defMagica;
	}

	public int getEnergiaTotal() {
		return energiaTotal;
	}

	public void setEnergiaTotal(int energiaTotal) {
		this.energiaTotal = energiaTotal;
	}

	public int getEnergiaAtual() {
		return energiaAtual;
	}

	public void setEnergiaAtual(int energiaAtual) {
		if (energiaAtual > this.energiaTotal) {
			this.energiaAtual = this.energiaTotal;
		} else if (energiaAtual < 0) {
			this.energiaAtual = 0;
		} else {
			this.energiaAtual = energiaAtual;
		}
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public int getAgilidade() {
		return agilidade;
	}

	public void setAgilidade(int agilidade) {
		this.agilidade = agilidade;
	}

	public int getRaca() {
		return raca;
	}

	public void setRaca(int raca) {
		this.raca = raca;
	}

	public int getPersonalidade() {
		return personalidade;
	}

	public void setPersonalidade(int personalidade) {
		this.personalidade = personalidade;
	}

	public int getCaractFisica() {
		return caractFisica;
	}

	public void setCaractFisica(int caractFisica) {
		this.caractFisica = caractFisica;
	}

	public int getTaxaFuga() {
		return taxaFuga;
	}

	public void setTaxaFuga(int taxaFuga) {
		if (taxaFuga > 100) {
			this.taxaFuga = 100;
		} else if (taxaFuga < 0) {
			this.taxaFuga = 0;
		} else {
			this.taxaFuga = taxaFuga;
		}
	}

	public int getTaxaCritico() {
		return taxaCritico;
	}

	public void setTaxaCritico(int taxaCritico) {
		if (taxaCritico > 100) {
			this.taxaCritico = 100;
		} else if (taxaCritico < 0) {
			this.taxaCritico = 0;
		} else {
			this.taxaCritico = taxaCritico;
		}
	}

	public int getTaxaResistencia() {
		return taxaResistencia;
	}

	public void setTaxaResistencia(int taxaResistencia) {
		if (taxaResistencia > 100) {
			this.taxaResistencia = 100;
		} else if (taxaResistencia < 0) {
			this.taxaResistencia = 0;
		} else {
			this.taxaResistencia = taxaResistencia;
		}
	}

	public int getTaxaAcerto() {
		return taxaAcerto;
	}

	public void setTaxaAcerto(int taxaAcerto) {
		if (taxaAcerto > 100) {
			this.taxaAcerto = 100;
		} else if (taxaAcerto < 0) {
			this.taxaAcerto = 0;
		} else {
			this.taxaAcerto = taxaAcerto;
		}
	}

	public int getTaxaEsquiva() {
		return taxaEsquiva;
	}

	public void setTaxaEsquiva(int taxaEsquiva) {
		if (taxaEsquiva > 100) {
			this.taxaEsquiva = 100;
		} else if (taxaEsquiva < 0) {
			this.taxaEsquiva = 0;
		} else {
			this.taxaEsquiva = taxaEsquiva;
		}
	}

	public int getEscudo() {
		return escudo;
	}

	public void setEscudo(int escudo) {
		if (escudo > 600) {
			this.escudo = 600;
		} else if (escudo < 0) {
			this.escudo = 0;
		} else {
			this.escudo = escudo;
		}
	}

	public int getTurnosMortoVivo() {
		return turnosMortoVivo;
	}

	public void setTurnosMortoVivo(int turnosMortoVivo) {
		this.turnosMortoVivo = turnosMortoVivo;
	}

	synchronized public boolean iniciarBatalha() {
		if (!this.emCombate && this.hpAtual > 0) {
			this.emCombate = true;
			return true;
		}
		return false;
	}

	synchronized public void encerrarBatalha() {
		this.emCombate = false;
	}

	public boolean isEmCombate() {
		return emCombate;
	}

	@Override
	public String toString() {
		String texto = "Nome: " + this.nome + "\nHP: " + this.hpAtual + " / " + this.hpTotal + "\nEscudo: "
				+ this.escudo + " / 600" + "\nFor�a: " + this.forca + "\nIntelig�ncia: " + this.inteligencia
				+ "\nDefesa F�sica: " + this.defFisica + "\nDefesa M�gica: " + this.defMagica + "\nEnergia: "
				+ this.energiaAtual + " / " + this.energiaTotal + "\nVelocidade: " + this.velocidade + "\nAgilidade: "
				+ this.agilidade;

		if (this.raca == Raca.OGRO.getValorRaca()) {
			texto += "\nRa�a: Ogro";
		} else if (this.raca == Raca.ELFO.getValorRaca()) {
			texto += "\nRa�a: Elfo";
		} else if (this.raca == Raca.ANAO.getValorRaca()) {
			texto += "\nRa�a: An�o";
		} else if (this.raca == Raca.ASSASSINO.getValorRaca()) {
			texto += "\nRa�a: Assassino";
		} else if (this.raca == Raca.VAMPIRO.getValorRaca()) {
			texto += "\nRa�a: Vampiro";
		} else if (this.raca == Raca.MORTO_VIVO.getValorRaca()) {
			texto += "\nRa�a: Morto Vivo";
		} else if (this.raca == Raca.MAGO.getValorRaca()) {
			texto += "\nRa�a: Mago";
		} else if (this.raca == Raca.PALADINO.getValorRaca()) {
			texto += "\nRa�a: Paladino";
		} else if (this.raca == Raca.DRACONIANA.getValorRaca()) {
			texto += "\nRa�a: Draconiana";
		}

		if (this.personalidade == Personalidade.ADPTADOR.getValorPersonalidade()) {
			texto += "\nPersonalidade: Adaptador";
		} else if (this.personalidade == Personalidade.DEFENSOR.getValorPersonalidade()) {
			texto += "\nPersonalidade: Defensor";
		} else if (this.personalidade == Personalidade.AMBICIOSO.getValorPersonalidade()) {
			texto += "\nPersonalidade: Ambicioso";
		} else if (this.personalidade == Personalidade.INDECISO.getValorPersonalidade()) {
			texto += "\nPersonalidade: Indeciso";
		} else if (this.personalidade == Personalidade.ESPERTO.getValorPersonalidade()) {
			texto += "\nPersonalidade: Esperto";
		} else if (this.personalidade == Personalidade.ESTRATEGISTA.getValorPersonalidade()) {
			texto += "\nPersonalidade: Estrategista";
		} else if (this.personalidade == Personalidade.MEDROSO.getValorPersonalidade()) {
			texto += "\nPersonalidade: Medroso";
		} else if (this.personalidade == Personalidade.CORAJOSO.getValorPersonalidade()) {
			texto += "\nPersonalidade: Corajoso";
		}

		if (this.caractFisica == CaractFisica.AGIL.getValorCaractFisica()) {
			texto += "\nCaracter�stidca F�sica: �gil";
		} else if (this.caractFisica == CaractFisica.MEDIANO.getValorCaractFisica()) {
			texto += "\nCaracter�stidca F�sica: Mediano";
		} else if (this.caractFisica == CaractFisica.FORTE.getValorCaractFisica()) {
			texto += "\nCaracter�stidca F�sica: Forte";
		}
		
		texto += "\nTaxa de Fuga: " + this.taxaFuga + "%\nTaxa de Cr�tico: " + this.taxaCritico
				+ "%\nTaxa de Resist�ncia: " + this.taxaResistencia + "%\nTaxa de Acerto: " + this.taxaAcerto
				+ "%\nTaxa de Esquiva: " + this.taxaEsquiva + "%";

		if (this.raca == Raca.MORTO_VIVO.getValorRaca()) {
			texto += "\nPassiva do Morto Vivo: ";
			if (passivaMortoVivo) {
				texto += "N�o ativada";
			} else {
				texto += "Ativada";
			}
		}
		
		return texto;
	}

	public boolean equals(DadosPersonagem obj) {
		if (obj.getNome().equals(this.getNome())) {
			return true;
		}
		return false;
	}

	
	
}
