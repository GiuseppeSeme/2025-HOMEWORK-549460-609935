package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractComandoTest {
	
	ConcreteComando cc;
	Partita p;
	@BeforeEach
	void setUp() throws Exception {
		cc =new ConcreteComando();
		p=new Partita(Labirinto.newBuilder("labirinto.txt").getLabirinto());
	}

	@Test
	void testConcreteComandoGetNome() {
		assertNotEquals("AbstractComando",cc.getNome());
		assertEquals("ConcreteComando",cc.getNome());
	}

	@Test
	public void testConcreteComandoEsegui() {
		cc.esegui(p);
		assertTrue(p.isFinita());
	}
	@Test
	public void testConcreteComandoParametro() {
		cc.setParametro("pippo");
		assertNotNull(cc.getParametro());
	}
	@Test
	public void testConcreteComandoGetIO() {
		cc.setIo(new IOConsole(new Scanner(System.in)));
		assertNotNull(cc.getIo());
	}
}
