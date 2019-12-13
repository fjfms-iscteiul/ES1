package Testes;

import functional.Defects;
import junit.framework.TestCase;

public class DefectsTest extends TestCase {

	public void testDefects1() {
		Defects defeitos = new Defects("3", "4", "5", "7", "8", "9", "10", "11", "12");
		assertNotNull(defeitos);
	}

	public void testDefects() {
		Defects defeitos = new Defects();
		assertNotNull(defeitos);
	}

	public void testToString() {
		Defects defeitos = new Defects();
		assertNotNull(defeitos.toString());
	}

	public void testGetMethodDefectsColumn() {
		Defects defeitos = new Defects();
		defeitos.setMethodDefectsColumn("5");
		assertEquals(defeitos.getMethodDefectsColumn(), "5");
	}

	public void testGetDciPlasmaColumn() {
		Defects defeitos = new Defects();
		defeitos.setDciPlasmaColumn("4");
		assertEquals(defeitos.getDciPlasmaColumn(), "4");
	}


	public void testGetDiiPlasmaColumn() {
		Defects defeitos = new Defects();
		defeitos.setDiiPlasmaColumn("9");
		assertEquals(defeitos.getDiiPlasmaColumn(), "9");
	}

	public void testGetAdciPlasmaColumn() {
		Defects defeitos = new Defects();
		defeitos.setAdciPlasmaColumn("10");
		assertEquals(defeitos.getAdciPlasmaColumn(), "10");
	}


	public void testGetAdiiPlasmaColumn() {
		Defects defeitos = new Defects();
		defeitos.setAdiiPlasmaColumn("11");
		assertEquals(defeitos.getAdiiPlasmaColumn(), "11");
	}

	
	public void testGetDciPMDColumn() {
		Defects defeitos = new Defects();
		defeitos.setDciPMDColumn("12");
		assertEquals(defeitos.getDciPMDColumn(), "12");
	}

	

	public void testGetDiiPMDColumn() {
		Defects defeitos = new Defects();
		defeitos.setDiiPMDColumn("3");
		assertEquals(defeitos.getDiiPMDColumn(), "3");
	}

	

	public void testGetAdciPMDColumn() {
		Defects defeitos = new Defects();
		defeitos.setAdciPMDColumn("4");
		assertEquals(defeitos.getAdciPMDColumn(), "4");
	}

	

	public void testGetAdiiPMDColumn() {
		Defects defeitos = new Defects();
		defeitos.setAdiiPMDColumn("5");
		assertEquals(defeitos.getAdiiPMDColumn(), "5");
	}



}
