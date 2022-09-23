
public class Monkey extends RescueAnimal {
	private String speciesValue;
	private String lengthTail;
	private String heightBody;
	private String lengthBody;

	public String getSpecies() {
		return speciesValue;
	}

	public void setSpecies(String speciesValue) {
		this.speciesValue = speciesValue;
	}

	public String getLengthTail() {
		return lengthTail;
	}

	public void setLengthTail(String lengthTail2) {
		this.lengthTail = lengthTail2;
	}

	public String getHeight() {
		return heightBody;
	}

	public void setHeight(String heightBody) {
		this.heightBody = heightBody;
	}

	public String getLengthBody() {
		return lengthBody;
	}

	public void setLengthBody(String lengthBody) {
		this.lengthBody = lengthBody;
	}

	public Monkey(String name, String gender, String age, String weight, String speciesValue, String lengthTail,
			String heightBody, String lengthBody) {
		super(name, gender, age, weight);
		setSpecies(speciesValue);
		setLengthTail(lengthTail);
		setHeight(heightBody);
		setLengthBody(lengthBody);
	}
}
