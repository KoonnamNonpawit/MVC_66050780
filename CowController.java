public class CowController {
    private Cow model;
    private int milk;
    
    public CowController (Cow model) {
        this.model = model;

        switch (model.getColor()) {
            case "W":
                milkW();
                break;
            case "B":
                milkB();
                break;
            case "P":
                milkP();
                break;
            default:
                break;
        }
    }

    public Cow getModel() {
        return model;
    }

    public void setModel(Cow model) {
        this.model = model;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void milkW() {
        milk = 120 - ((model.getYear()*12) + model.getMonth());
    }

    public void milkB() {
        milk = 40 - model.getYear();
    }

    public void milkP() {
        milk = 30 - model.getMonth();
    }
}
