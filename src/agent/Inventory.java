package agent;

public class Inventory {
	private int food;
	private int painkiller;
	private int tool;
	private int hunger;
	private int health;
	private int toolHealth;
	private int finance;

	public Inventory() {
		food = 0;
		painkiller = 0;
		tool = 0;
		hunger = 100;
		health = 100;
		toolHealth = 100;
		finance = 10;
	}

	public Inventory(int food, int painkiller, int tool, int hunger,
			int health, int toolHealth, int finance) {
		this.food = food;
		this.painkiller = painkiller;
		this.tool = tool;
		this.hunger = hunger;
		this.health = health;
	}

	public Inventory rest() {
		double r = Math.random() * 100;
		Inventory inv;
		if (r < 80)
			inv = new Inventory(this.food, this.painkiller, this.tool,
					this.hunger - 2, this.health - 5, this.toolHealth,
					this.finance);
		else
			inv = new Inventory(this.food, this.painkiller, this.tool,
					this.hunger - 4, this.health - 10, this.toolHealth,
					this.finance);
		return inv;
	}

	public Inventory workFood() {
		double r = Math.random() * 100;
		int wFood;
		if (r < 80)
			wFood = this.food++;
		else
			wFood = this.food;

		Inventory inv = new Inventory(wFood, this.painkiller, this.tool,
				this.hunger - 2, this.health - 5, this.toolHealth - 2,
				this.finance);

		return inv;
	}

	public Inventory workPainkiller() {

		double r = Math.random() * 100;
		int wPainkiller;
		if (r < 30)
			wPainkiller = this.painkiller++;
		else
			wPainkiller = this.painkiller;

		Inventory inv = new Inventory(this.food, wPainkiller, this.tool,
				this.hunger - 2, this.health - 5, this.toolHealth - 2,
				this.finance);
		return inv;
	}

	public Inventory workTool() {

		double r = Math.random() * 100;
		int wTool;
		if (r < 10)
			wTool = this.tool++;
		else
			wTool = this.tool;

		Inventory inv = new Inventory(this.food, this.painkiller, wTool,
				this.hunger - 2, this.health - 5, this.toolHealth - 2,
				this.finance);
		return inv;
	}

	public Inventory buyFood() {
		Inventory inv = new Inventory(this.food + 1, this.painkiller,
				this.tool, this.hunger, this.health, this.toolHealth,
				this.finance-1);
		return inv;
	}

	public Inventory buyPainkiller() {
		Inventory inv = new Inventory(this.food, this.painkiller + 1,
				this.tool, this.hunger, this.health, this.toolHealth,
				this.finance-10);
		return inv;
	}

	public Inventory buyTool() {
		Inventory inv = new Inventory(this.food, this.painkiller,
				this.tool + 1, this.hunger, this.health, this.toolHealth,
				this.finance-50);
		return inv;
	}

	public Inventory sellFood() {
		Inventory inv = new Inventory(this.food - 1, this.painkiller,
				this.tool, this.hunger, this.health, this.toolHealth,
				this.finance+1);
		return inv;
	}

	public Inventory sellPainkiller() {
		Inventory inv = new Inventory(this.food, this.painkiller - 1,
				this.tool, this.hunger, this.health, this.toolHealth,
				this.finance+10);
		return inv;
	}

	public Inventory sellTool() {
		Inventory inv = new Inventory(this.food, this.painkiller,
				this.tool - 1, this.hunger, this.health, this.toolHealth,
				this.finance+50);
		return inv;
	}

	public Inventory useFood() {
		Inventory inv = new Inventory(this.food - 1, this.painkiller,
				this.tool, this.hunger + 3, this.health, this.toolHealth,
				this.finance);
		return inv;
	}

	public Inventory usePainkiller() {
		Inventory inv = new Inventory(this.food, this.painkiller - 1,
				this.tool, this.hunger, this.health + 10, this.toolHealth,
				this.finance);
		return inv;
	}

	public Inventory useTool() {
		Inventory inv = new Inventory(this.food, this.painkiller,
				this.tool - 1, this.hunger, this.health, 100, this.finance);
		return inv;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public int getPainkiller() {
		return painkiller;
	}

	public void setPainkiller(int painkiller) {
		this.painkiller = painkiller;
	}

	public int getTool() {
		return tool;
	}

	public void setTool(int tool) {
		this.tool = tool;
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getToolHealth() {
		return toolHealth;
	}

	public void setToolHealth(int toolHealth) {
		this.toolHealth = toolHealth;
	}

	public int getFinance() {
		return finance;
	}

	public void setFinance(int finance) {
		this.finance = finance;
	}

}
