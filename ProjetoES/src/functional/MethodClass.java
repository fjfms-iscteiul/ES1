package functional;

public class MethodClass {
	
	private String methodID;
	private String packageName;
	private String className;
	private String methodName;
	private String loc;
	private String cyclo;
	private String aftd;
	private String laa;
	private String isLongMethod;
	private String iplasma;
	private String pmd;
	private String isFeatureEnvy;
	
	/** Constructor of a MethodClass that will be represented in the esTable table
	 * 
	 * @param method_id Method ID column value
	 * @param package_name Package name column value
	 * @param class_name Class name column value
	 * @param method_name Method name column value
	 * @param loc LOC column value
	 * @param cyclo CYCLO column value
	 * @param aftd ATFD column value
	 * @param laa LAA column value
	 * @param is_long_method is_long_method column value
	 * @param iplasma iPlasma column value
	 * @param pmd PMD column value
	 * @param is_feature_envy is_feature_envy column value
	 * 
	 * @return Returns a MethodClass */
	
	public MethodClass(String method_id, String package_name, String class_name, String method_name, String loc, String cyclo,
			String aftd, String laa, String is_long_method, String iplasma, String pmd, String is_feature_envy) {
		
		this.setMethodID(method_id);
		this.setPackageName(package_name);
		this.setClassName(class_name);
		this.setMethodName(method_name);
		this.setLoc(loc);
		this.setCyclo(cyclo);
		this.setAftd(aftd);
		this.setLaa(laa);
		this.setIsLongMethod(is_long_method);
		this.setIplasma(iplasma);
		this.setPmd(pmd);
		this.setIsFeatureEnvy(is_feature_envy);
	
	}

	/** Constructor of a MethodClass that will be represented in the esTable table
	 * 
	 * Returns a MethodClass */
	
	public MethodClass() {
		// TODO Auto-generated constructor stub
	}

	public String getMethodID() {
		return methodID;
	}

	public void setMethodID(String method_id) {
		this.methodID = method_id;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String package_name) {
		this.packageName = package_name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String class_name) {
		this.className = class_name;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String method_name) {
		this.methodName = method_name;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getCyclo() {
		return cyclo;
	}

	public void setCyclo(String cyclo) {
		this.cyclo = cyclo;
	}

	public String getAftd() {
		return aftd;
	}

	public void setAftd(String aftd) {
		this.aftd = aftd;
	}

	public String getLaa() {
		return laa;
	}

	public void setLaa(String laa) {
		this.laa = laa;
	}

	public String getIsLongMethod() {
		return isLongMethod;
	}

	public void setIsLongMethod(String is_long_method) {
		this.isLongMethod = is_long_method;
	}

	public String getIplasma() {
		return iplasma;
	}

	public void setIplasma(String iplasma) {
		this.iplasma = iplasma;
	}

	public String getPmd() {
		return pmd;
	}

	public void setPmd(String pmd) {
		this.pmd = pmd;
	}

	public String getIsFeatureEnvy() {
		return isFeatureEnvy;
	}

	public void setIsFeatureEnvy(String is_feature_envy) {
		this.isFeatureEnvy = is_feature_envy;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("(" + methodID + ";" + packageName + ";" + className + ";" + methodName + ";" + loc + ";" + cyclo + 
				";" + aftd + ";" + laa + ";" + isLongMethod + ";" + iplasma + ";" + pmd + ";" + isFeatureEnvy + ")");
				
	}
	
}
