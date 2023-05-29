package pl.kielce.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
