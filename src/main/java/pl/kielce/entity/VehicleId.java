package pl.kielce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class VehicleId {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int vehicleId;
	
	public int getVehicleId() {
		return vehicleId;
	}

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

}
