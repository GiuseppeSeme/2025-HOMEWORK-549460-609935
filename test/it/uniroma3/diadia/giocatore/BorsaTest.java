package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

class BorsaTest {
	private Borsa borsa1;
	private Borsa borsa2;
	private Attrezzo osso;
	private Attrezzo lanterna;
	private Attrezzo martello;
	private Attrezzo piedeDiPorco;
	private Attrezzo pala;
	private Attrezzo laptop;
	private Attrezzo cacciaVite;

	@BeforeEach
	void setUp() throws Exception {
		borsa1= new Borsa();
		borsa2= new Borsa();
		osso=new Attrezzo("Osso",2);
		lanterna=new Attrezzo("Lanterna",3);
		martello=new Attrezzo("Martello",16);
		piedeDiPorco=new Attrezzo("PiedeDiPorco",7);
		pala=new Attrezzo("Pala", 10);
		laptop=new Attrezzo("Laptop",3);
		cacciaVite=new Attrezzo("CacciaVite", 2);
	}
	
	@Test
	void testAggiuntaAttrezzo() {
		assertTrue(borsa1.addAttrezzo(lanterna));
		assertEquals(3,borsa1.getPeso());
		assertEquals(lanterna,borsa1.getAttrezzo("Lanterna"));
	}
	
	@Test
	void testLimitePeso(){
		borsa1.addAttrezzo(pala);
		assertFalse(borsa1.addAttrezzo(osso));
	}
	
	@Test
	void testhasAttrezzo(){
		borsa1.addAttrezzo(pala);
		assertTrue(borsa1.hasAttrezzo("Pala"));
		assertFalse(borsa1.hasAttrezzo("Osso"));
	}
	
	@Test
	void testAttrezzoInRangeDiPeso() {
		assertTrue(borsa1.addAttrezzo(piedeDiPorco));
	}
	
	@Test
	void testAttrezzoNonInRangeDiPeso() {
		assertFalse(borsa1.addAttrezzo(martello));
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoAttrezziStessoPeso() {
		borsa1.addAttrezzo(laptop);
		borsa1.addAttrezzo(lanterna);
		Set<Attrezzo> expected = new TreeSet<>(new ComparatoreAttrezziPerPeso());
		expected.add(lanterna);
		expected.add(laptop);
		assertArrayEquals(expected.toArray(), borsa1.getSortedSetOrdinatoPerPeso().toArray());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoAttrezziDiversiPesoDiverso() {
		borsa2.addAttrezzo(laptop);
		borsa2.addAttrezzo(piedeDiPorco);
		Set<Attrezzo> e = new TreeSet<>();
		e.add(laptop);
		e.add(piedeDiPorco);
		assertArrayEquals(e.toArray(), borsa2.getSortedSetOrdinatoPerPeso().toArray());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoStessoPeso() {
		borsa2.addAttrezzo(laptop);
		borsa2.addAttrezzo(lanterna);
		List<Attrezzo> exp = new ArrayList<>();
		exp.add(lanterna);
		exp.add(laptop);
		assertTrue(this.controllaList(exp, borsa2.getContenutoOrdinatoPerPeso()));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPesoDiverso() {
		borsa2.addAttrezzo(laptop);
		borsa2.addAttrezzo(piedeDiPorco);
		List<Attrezzo> exp = new ArrayList<>();
		exp.add(laptop);
		exp.add(piedeDiPorco);
		assertTrue(this.controllaList(exp, borsa2.getContenutoOrdinatoPerPeso()));
	}
	
	@Test
	public void testgetContenutoOrdinatoPerNomeStessoPeso() {
		borsa2.addAttrezzo(laptop);
		borsa2.addAttrezzo(lanterna);

		Set<Attrezzo> e = new TreeSet<>();
		e.add(lanterna);
		e.add(laptop);
		assertTrue(this.controllaSet(e, borsa2.getSortedSetOrdinatoPerPeso()));
	}
	
	@Test
	public void testgetContenutoOrdinatoPerNomePesoDiverso() {
		borsa2.addAttrezzo(laptop);
		borsa2.addAttrezzo(piedeDiPorco);

		Set<Attrezzo> e = new TreeSet<>();
		e.add(laptop);
		e.add(piedeDiPorco);
		
		assertTrue(this.controllaSet(e, borsa2.getSortedSetOrdinatoPerPeso()));
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoPesiDiversiSingleton() {
		borsa2.addAttrezzo(laptop);
		borsa2.addAttrezzo(piedeDiPorco);

		Map<Integer, Set<Attrezzo>> e = new TreeMap<>();
		Set<Attrezzo> sing1 = new TreeSet<>();
		Set<Attrezzo> sing2 = new TreeSet<>();
		
		sing1.add(laptop);
		sing2.add(piedeDiPorco);
		
		e.put(1, sing1);
		e.put(2, sing2);
		
		assertTrue(this.controllaMap(e, borsa2.getContenutoRaggruppatoPerPeso()));
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPesoPesiDiversiGruppi() {
		borsa2.addAttrezzo(laptop);
		borsa2.addAttrezzo(lanterna);
		borsa2.addAttrezzo(osso);
		borsa2.addAttrezzo(cacciaVite);

		Map<Integer, Set<Attrezzo>> e = new TreeMap<>();
		Set<Attrezzo> group1 = new HashSet<>();
		Set<Attrezzo> group2 = new HashSet<>();
		
		group1.add(laptop);
		group2.add(osso);
		group2.add(cacciaVite);
		group1.add(lanterna);
		
		e.put(2, group1);
		e.put(1, group2);
		
		assertTrue(this.controllaMap(e, borsa2.getContenutoRaggruppatoPerPeso()));
	}
	
	public boolean controllaList(List<?> c1, List<?> c2) {
		if(c1.size()!=c2.size())
			return false;
		for(int i = 0; i<c1.size(); i++ ) {
			if(!c1.get(i).equals(c2.get(i)) )
				return false;
		}
		return true;
	}
	
	public boolean controllaSet(Set<Attrezzo> m1, Set<Attrezzo> m2) {
		if(m1.size()!=m2.size())
			return false;
		Iterator<Attrezzo> iter1 = m1.iterator();
		Iterator<Attrezzo> iter2 = m2.iterator();
		while(iter1.hasNext() && iter2.hasNext()) {
			if(!iter1.next().equals(iter2.next()))
				return false;
		}
		return true;
	}
	
	public boolean controllaMap(Map<Integer, Set<Attrezzo>> m1, Map<Integer, Set<Attrezzo>> m2) {
		if(m1.size()!=m2.size())
			return false;
		
		Iterator<Integer> iter1 = m1.keySet().iterator();
		Iterator<Integer> iter2 = m2.keySet().iterator();
		while(iter1.hasNext() && iter2.hasNext()) {
			if(!this.controllaSet(m1.get(iter1.next()), m2.get(iter2.next()))) {
				return false;
			}
		}
		return true;
	}
}
