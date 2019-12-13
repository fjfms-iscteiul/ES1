package functional;

public class Defects {
	
	private String methodDefectsColumn;
	private String dciPlasmaColumn;
	private String diiPlasmaColumn;
	private String adciPlasmaColumn;
	private String adiiPlasmaColumn;
	private String dciPMDColumn;
	private String diiPMDColumn;
	private String adciPMDColumn;
	private String adiiPMDColumn;
	
	
	public Defects(String methodDefectsColumn, String dciPlasmaColumn, String diiPlasmaColumn, String adciPlasmaColumn, String adiiPlasmaColumn,
			String dciPMDColumn, String diiPMDColumn, String adciPMDColumn, String adiiPMDColumn) {
		this.methodDefectsColumn = methodDefectsColumn;
		this.dciPlasmaColumn = dciPlasmaColumn;
		this.diiPlasmaColumn = diiPlasmaColumn;
		this.adciPlasmaColumn = adciPlasmaColumn;
		this.adiiPlasmaColumn = adiiPlasmaColumn;
		this.dciPMDColumn = dciPMDColumn;
		this.diiPMDColumn = diiPMDColumn;
		this.adciPMDColumn = adciPMDColumn;
		this.adiiPMDColumn = adiiPMDColumn;
	}
	
	public Defects() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Defects [methodDefectsColumn=" + methodDefectsColumn + ", dciPlasmaColumn=" + dciPlasmaColumn + ", diiPlasmaColumn=" + diiPlasmaColumn
				+ ", adciPlasmaColumn=" + adciPlasmaColumn + ", adiiPlasmaColumn=" + adiiPlasmaColumn + ", dciPMDColumn=" + dciPMDColumn + ", diiPMDColumn="
				+ diiPMDColumn + ", adciPMDColumn=" + adciPMDColumn + ", adiiPMDColumn=" + adiiPMDColumn + "]";
	}

	public String getMethodDefectsColumn() {
		return methodDefectsColumn;
	}


	public void setMethodDefectsColumn(String methodDefectsColumn) {
		this.methodDefectsColumn = methodDefectsColumn;
	}


	public String getDciPlasmaColumn() {
		return dciPlasmaColumn;
	}


	public void setDciPlasmaColumn(String dciPlasmaColumn) {
		this.dciPlasmaColumn = dciPlasmaColumn;
	}


	public String getDiiPlasmaColumn() {
		return diiPlasmaColumn;
	}


	public void setDiiPlasmaColumn(String diiPlasmaColumn) {
		this.diiPlasmaColumn = diiPlasmaColumn;
	}


	public String getAdciPlasmaColumn() {
		return adciPlasmaColumn;
	}


	public void setAdciPlasmaColumn(String adciPlasmaColumn) {
		this.adciPlasmaColumn = adciPlasmaColumn;
	}


	public String getAdiiPlasmaColumn() {
		return adiiPlasmaColumn;
	}


	public void setAdiiPlasmaColumn(String adiiPlasmaColumn) {
		this.adiiPlasmaColumn = adiiPlasmaColumn;
	}


	public String getDciPMDColumn() {
		return dciPMDColumn;
	}


	public void setDciPMDColumn(String dciPMDColumn) {
		this.dciPMDColumn = dciPMDColumn;
	}


	public String getDiiPMDColumn() {
		return diiPMDColumn;
	}


	public void setDiiPMDColumn(String diiPMDColumn) {
		this.diiPMDColumn = diiPMDColumn;
	}


	public String getAdciPMDColumn() {
		return adciPMDColumn;
	}


	public void setAdciPMDColumn(String adciPMDColumn) {
		this.adciPMDColumn = adciPMDColumn;
	}


	public String getAdiiPMDColumn() {
		return adiiPMDColumn;
	}


	public void setAdiiPMDColumn(String adiiPMDColumn) {
		this.adiiPMDColumn = adiiPMDColumn;
	}
	
}
