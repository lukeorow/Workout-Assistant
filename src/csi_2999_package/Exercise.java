package csi_2999_package;

import javax.swing.JButton;
import javax.swing.JCheckBox;

public class Exercise {
	private JButton button;
	private JCheckBox check;

    private String name;
    private String steps;

    private boolean back, arms, shoulders, chest, legs;

    public Exercise(String name, String steps, boolean back, boolean arms, boolean shoulders, boolean chest, boolean legs) {
        this.name = name;
        this.steps = steps;
        this.back = back;
        this.arms = arms;
        this.shoulders = shoulders;
        this.chest = chest;
        this.legs = legs;

        button = null;
        check = null;
    }

    public JCheckBox getCheckButton() {
		return check;
	}

	public void setCheckButton(JCheckBox check) {
		this.check = check;
	}

	public Exercise() {

    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public String getName() {
        return name;
    }

    public String getSteps() {
        return steps;
    }

    public boolean getBack() {
        return back;
    }

    public boolean getArms() {
        return arms;
    }

    public boolean getShoulders() {
        return shoulders;
    }

    public boolean getChest() {
        return chest;
    }

    public boolean getLegs() {
        return legs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public void setBack(boolean back) {
        this.back = back;
    }

    public void setArms(boolean arms) {
        this.arms = arms;
    }

    public void setShoulders(boolean shoulders) {
        this.shoulders = shoulders;
    }

    public void setChest(boolean chest) {
        this.chest = chest;
    }

    public void setLegs(boolean legs) {
        this.legs = legs;
    }

}