
package Bai_3;

public class Guns {
    
    private String weaponName;
    private int ammoNumber;
    
    public Guns() {}
    
    public Guns(String weaponName, int ammoNumber) {
        this.weaponName = weaponName;
        this.ammoNumber = ammoNumber;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }
    public String getWeaponName() {
        return weaponName;
    }

    public void setAmmoNumber(int ammoNumber) {
        this.ammoNumber = ammoNumber;
    }
    public int getAmmoNumber() {
        return ammoNumber;
    }
    
    public void Load(int x) {
        this.ammoNumber += x;
    }
    public int Shoot(int x) {
        if(this.ammoNumber - x >= 0) {
            this.ammoNumber -= x;
        }
        return this.ammoNumber;
    }
}
